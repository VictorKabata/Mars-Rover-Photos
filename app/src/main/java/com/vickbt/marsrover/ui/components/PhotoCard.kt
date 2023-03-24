@file:OptIn(ExperimentalMaterial3Api::class)

package com.vickbt.marsrover.ui.components

import androidx.appcompat.widget.TooltipCompat
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.vickbt.domain.models.Photo

@Composable
fun PhotoCard(modifier: Modifier = Modifier, photo: Photo, onClickPhoto: (Photo) -> Unit) {
    Card(
        modifier = modifier,
        onClick = { onClickPhoto(photo) },
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(8.dp)
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
                contentScale = ContentScale.Crop,
                contentDescription = "Mars Photo By ${photo.rover?.name} rover"
            )

            photo.earthDate?.let {
                Text(modifier = Modifier.align(Alignment.TopStart), text = it)
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(2.dp)
                    .align(Alignment.BottomStart),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {

                photo.rover?.name?.let {
                    Text(
                        text = it,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Black,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }

                photo.camera?.fullName?.let {
                    Text(
                        text = it,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                        lineHeight = 14.sp
                    )
                }

            }
        }

    }
}