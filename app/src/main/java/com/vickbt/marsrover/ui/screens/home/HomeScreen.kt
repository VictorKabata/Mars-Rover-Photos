package com.vickbt.marsrover.ui.screens.home

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = getViewModel()) {

    val homeUiState = viewModel.homeUiState.collectAsState().value
    val error = viewModel.error.collectAsState().value

    Log.e("VicKbt", "HomeUiState: $homeUiState")

    homeUiState.data?.let {
        Text(text = "$it")
    }

    error?.let {
        Text(text = "Error: $it")
    }


}