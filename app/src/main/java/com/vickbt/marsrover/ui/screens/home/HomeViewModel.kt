package com.vickbt.marsrover.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vickbt.domain.models.Photo
import com.vickbt.domain.repositories.MarsPhotosRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val marsPhotosRepository: MarsPhotosRepository) :
    ViewModel() {

    private val _homeUiState = MutableStateFlow<List<Photo>?>(emptyList())
    val homeUiState = _homeUiState.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    init {
        fetchMarsPhotos()
    }

    private fun fetchMarsPhotos() = viewModelScope.launch {
        try {
            marsPhotosRepository.fetchMarsPhotos().collect {
                _homeUiState.value = it
            }
        } catch (e: Exception) {
            _error.value=e.localizedMessage
        }
    }

}