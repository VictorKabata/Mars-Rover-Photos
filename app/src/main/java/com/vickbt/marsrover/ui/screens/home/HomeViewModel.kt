package com.vickbt.marsrover.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.vickbt.domain.repositories.MarsPhotosRepository
import com.vickbt.domain.utils.HomeUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val marsPhotosRepository: MarsPhotosRepository) :
    ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()

    private val _roverName = MutableStateFlow<String?>(null)

    private var filterJob: Job? = null

    init {
        fetchMarsPhotos()
    }

    private fun fetchMarsPhotos(filterParam: String? = null) {
        filterJob?.cancel()

        filterJob = viewModelScope.launch {
            try {
                val photos =
                    marsPhotosRepository.fetchMarsPhotos(roverName = filterParam ?: "curiosity")
                        .cachedIn(viewModelScope)
                _homeUiState.update { it.copy(data = photos) }
            } catch (e: Exception) {
                _homeUiState.update { it.copy(error = e.message) }
            }

        }
    }

    fun filterRover(roverName: String) {
        this._roverName.value = roverName
    }
}
