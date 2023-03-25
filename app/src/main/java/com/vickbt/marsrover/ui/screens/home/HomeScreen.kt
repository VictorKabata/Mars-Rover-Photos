@file:OptIn(ExperimentalLayoutApi::class)

package com.vickbt.marsrover.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.vickbt.marsrover.ui.components.HomeTopAppBar
import com.vickbt.marsrover.ui.components.PhotoCard
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = getViewModel()) {

    val homeUiState = viewModel.homeUiState.collectAsState().value

    val pagedPhotos = homeUiState.data?.collectAsLazyPagingItems()
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            HomeTopAppBar(
                onFilterClicked = {
                    viewModel.filterRover(roverName = it)
                    Toast.makeText(context, "Clicked: $it", Toast.LENGTH_LONG).show()
                }
            )
        },
    ) { scaffoldPadding ->

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(PaddingValues(vertical = 8.dp, horizontal = 16.dp)),
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
                            onClickPhoto = {}
                        )
                    }
                }
            }

        }

    }

}
