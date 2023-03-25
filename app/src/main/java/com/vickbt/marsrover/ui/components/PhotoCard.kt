@file:OptIn(ExperimentalMaterialApi::class)

package com.vickbt.marsrover.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
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
import com.vickbt.domain.utils.toDateFormat

@Composable
fun PhotoCard(modifier: Modifier = Modifier, photo: Photo, onClickPhoto: (Photo) -> Unit) {
    Card(
        modifier = modifier,
        onClick = { onClickPhoto(photo) },
        shape = RoundedCornerShape(4.dp),
        elevation = 8.dp
    ) {
        val imageUrl = photo.imgSrc?.replace("http", "https")

        val painter = rememberImagePainter(data = imageUrl) {
            crossfade(true)
        }

        /*if (painter.state is ImagePainter.State.Success) {
            LaunchedEffect(key1 = painter) {
                val imageDrawable = painter.imageLoader.execute(painter.request).drawable
                imageDrawable?.let {
                    it.generateImagePalette().vibrantSwatch?.titleTextColor?.let { color ->
                        dominantTextColor = Color(color)
                    }
                }
            }
        }*/

        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                painter = painter,
                contentScale = ContentScale.Crop,
                contentDescription = "Mars Photo By ${photo.rover?.name} rover"
            )

            photo.rover?.name?.let {
                Text(
                    modifier = Modifier.padding(2.dp).align(Alignment.TopStart),
                    text = it,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Black,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
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

                photo.earthDate?.let {
                    Text(
                        text = it.toDateFormat(),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Black,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                    )
                }

                photo.camera?.fullName?.let {
                    Text(
                        text = it,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                        lineHeight = 16.sp
                    )
                }

            }
        }

    }
}