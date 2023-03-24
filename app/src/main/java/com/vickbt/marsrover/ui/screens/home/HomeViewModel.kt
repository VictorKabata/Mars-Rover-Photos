package com.vickbt.marsrover.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vickbt.domain.repositories.MarsPhotosRepository
import com.vickbt.domain.utils.HomeUiState
import com.vickbt.domain.utils.isLoading
import com.vickbt.domain.utils.onFailure
import com.vickbt.domain.utils.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val marsPhotosRepository: MarsPhotosRepository) :
    ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()

    init {
        fetchMarsPhotos()
    }

    private fun fetchMarsPhotos() = viewModelScope.launch {
        marsPhotosRepository.fetchMarsPhotos().collect { marsPhotos ->
            marsPhotos.isLoading { isLoading ->
                _homeUiState.update { it.copy(isLoading = isLoading) }
            }.onSuccess { photos ->
                _homeUiState.update { it.copy(data = photos) }
            }.onFailure { error ->
                _homeUiState.update { it.copy(error = error.localizedMessage) }
            }
        }
    }

}