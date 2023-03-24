package com.vickbt.marsrover.ui.screens.home

import android.util.Log
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = getViewModel()) {

    val homeUiState = viewModel.homeUiState.collectAsState().value

    Log.e("VicKbt", "HomeUiState: $homeUiState")

    if (homeUiState.isLoading) {
        CircularProgressIndicator()
    } else {
        homeUiState.data?.let {
            Text(text = "Mars Photos:\n$it")
        }

        homeUiState.error?.let {
            Text(text = "Error:\n$it")
        }
    }


}