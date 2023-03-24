package com.vickbt.marsrover.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.vickbt.marsrover.ui.components.PhotoCard
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = getViewModel()) {

    val homeUiState = viewModel.homeUiState.collectAsState().value

    val pagedPhotos = homeUiState.data?.collectAsLazyPagingItems()

    if (homeUiState.isLoading) {
        CircularProgressIndicator()
    } else if (!homeUiState.error.isNullOrEmpty()) {
        Text(text = "Error: ${homeUiState.error}")
    } else {
        LazyVerticalGrid(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            pagedPhotos?.let {
                items(it.itemCount) { index ->
                    pagedPhotos[index]?.let { photo ->
                        PhotoCard(
                            modifier = Modifier.height(250.dp),
                            photo = photo,
                            onClickPhoto = {})
                    }
                }
            }
        }
    }


}