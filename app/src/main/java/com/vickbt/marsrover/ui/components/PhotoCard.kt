@file:OptIn(ExperimentalMaterial3Api::class)

package com.vickbt.marsrover.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.vickbt.domain.models.Photo

@Composable
fun PhotoCard(modifier: Modifier = Modifier, photo: Photo, onClickPhoto: (Photo) -> Unit) {
    Card(
        modifier = modifier,
        onClick = { onClickPhoto(photo) },
        shape = RoundedCornerShape(2.dp)
    ) {

        val imageUrl = photo.imgSrc?.replace("http", "https")

        val painter = rememberImagePainter(data = imageUrl) {
            crossfade(true)
        }

        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                painter = painter,
                contentDescription = "Mars Photo By ${photo.rover?.name} rover"
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(2.dp)
                    .align(Alignment.BottomStart),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {

                Text(text = "Rover: ${photo.rover?.name}")

                Text(text = "Date: ${photo.earthDate}")

            }
        }

    }
}