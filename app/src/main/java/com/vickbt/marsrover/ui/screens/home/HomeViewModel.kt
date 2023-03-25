package com.vickbt.marsrover.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.vickbt.domain.repositories.MarsPhotosRepository
import com.vickbt.domain.utils.HomeUiState
import com.vickbt.domain.utils.isLoading
import com.vickbt.domain.utils.onFailure
import com.vickbt.domain.utils.onSuccess
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
            marsPhotosRepository.fetchMarsPhotos(roverName = filterParam ?: "curiosity")
                .collect { result ->
                    result.isLoading { isLoading ->
                        _homeUiState.update { it.copy(isLoading = isLoading) }
                    }.onSuccess { pagedPhotos ->
                        val photos = pagedPhotos.flow.cachedIn(viewModelScope)
                        _homeUiState.update { it.copy(data = photos) }
                    }.onFailure { error ->
                        _homeUiState.update { it.copy(error = error.localizedMessage) }
                    }
                }
        }
    }

    fun filterRover(roverName: String) {
        this._roverName.value = roverName
    }
}
