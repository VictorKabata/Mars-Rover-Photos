package com.vickbt.marsrover.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.vickbt.domain.repositories.MarsPhotosRepository
import com.vickbt.domain.utils.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val marsPhotosRepository: MarsPhotosRepository) :
    ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()

    private val roverName = MutableStateFlow<String>("curiosity")


    init {
        fetchMarsPhotos()
    }

    private fun fetchMarsPhotos() = viewModelScope.launch {
        roverName.collect {
            val response = marsPhotosRepository.fetchMarsPhotos(roverName = roverName.value)
                .cachedIn(viewModelScope)

            _homeUiState.update { it.copy(data = response, isLoading = false) }
        }
    }

    fun filterRover(roverName: String) {
        this.roverName.value = roverName
    }

}