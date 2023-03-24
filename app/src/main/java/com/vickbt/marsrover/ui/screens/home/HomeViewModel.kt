package com.vickbt.marsrover.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vickbt.domain.repositories.MarsPhotosRepository
import com.vickbt.domain.utils.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val marsPhotosRepository: MarsPhotosRepository) :
    ViewModel() {

    private val _homeUiState = MutableStateFlow<HomeUiState>(HomeUiState(isLoading = true))
    val homeUiState = _homeUiState.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    init {
        fetchMarsPhotos()
    }

    private fun fetchMarsPhotos() = viewModelScope.launch {
        try {
            marsPhotosRepository.fetchMarsPhotos().collect { marsPhotos ->
                _homeUiState.update { it.copy(data = marsPhotos, isLoading = false) }
            }
        } catch (e: Exception) {
            _homeUiState.update { it.copy(error = e.localizedMessage, isLoading = false) }
        }
    }

}