@file:OptIn(ExperimentalLayoutApi::class)

package com.vickbt.marsrover.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.vickbt.marsrover.ui.components.HomeTopAppBar
import com.vickbt.marsrover.ui.components.PhotoCard
import com.vickbt.marsrover.ui.navigation.NavigationItem
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = getViewModel()) {
    val homeUiState = viewModel.homeUiState.collectAsState().value

    val pagedPhotos = homeUiState.data?.collectAsLazyPagingItems()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { HomeTopAppBar(onFilterClicked = { viewModel.filterRover(roverName = it) }) },
    ) { scaffoldPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(scaffoldPadding)
        ) {
            if (homeUiState.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else if (!homeUiState.error.isNullOrEmpty()) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Error\n${homeUiState.error}",
                    textAlign = TextAlign.Center
                )
            } else {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(PaddingValues(vertical = 8.dp, horizontal = 16.dp))
                        .align(Alignment.Center),
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
                                    onClickPhoto = { clickedPhoto ->
                                        navController.currentBackStackEntry?.savedStateHandle?.set(
                                            key = "photo",
                                            value = clickedPhoto
                                        )

                                        navController.navigate(NavigationItem.Details.route)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
