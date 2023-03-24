package com.vickbt.marsrover.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vickbt.marsrover.ui.components.PhotoCard
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = getViewModel()) {

    val homeUiState = viewModel.homeUiState.collectAsState().value

    if (homeUiState.isLoading) {
        CircularProgressIndicator()
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            homeUiState.data?.let {
                items(items = it) { photo ->
                    PhotoCard(
                        modifier = Modifier.height(200.dp),
                        photo = photo,
                        onClickPhoto = {})
                }
            }
        }
    }


}