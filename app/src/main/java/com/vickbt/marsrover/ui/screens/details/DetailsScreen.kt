package com.vickbt.marsrover.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.vickbt.domain.models.Photo
import com.vickbt.domain.utils.toDateFormat
import com.vickbt.marsrover.R
import com.vickbt.marsrover.ui.components.DrawableText
import com.vickbt.marsrover.utils.generateImagePalette

@Composable
fun DetailsScreen(navController: NavController, photo: Photo) {

    val imageUrl = photo.imgSrc?.replace("http", "https")

    val defaultDominantTextColor = MaterialTheme.colors.onSurface
    var dominantColor by remember { mutableStateOf(Color.Transparent) }
    var dominantTextColor by remember { mutableStateOf(defaultDominantTextColor) }
    var dominantSubTextColor by remember { mutableStateOf(defaultDominantTextColor) }

    val painter = rememberImagePainter(data = imageUrl) {
        crossfade(true)
    }

    if (painter.state is ImagePainter.State.Success) {
        LaunchedEffect(key1 = painter) {
            val imageDrawable = painter.imageLoader.execute(painter.request).drawable
            imageDrawable?.let {
                it.generateImagePalette().vibrantSwatch?.let { color ->
                    dominantColor = Color(color.rgb)
                    dominantTextColor = Color(color.titleTextColor)
                    dominantSubTextColor = Color(color.bodyTextColor)
                }
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {

        //region Photo image
        Image(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            painter = painter,
            contentScale = ContentScale.Crop,
            contentDescription = "Mars Photo By ${photo.rover?.name} rover"
        )
        //endregion

        //region TopAppBar
        TopAppBar(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.TopCenter), title = {
            /*photo.rover?.name?.let {
                Text(
                    text = it,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = dominantTextColor,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 28.sp
                )
            }*/
        }, navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Back",
                    tint = dominantTextColor
                )
            }
        }, backgroundColor = Color.Transparent, elevation = 0.dp
        )
        //endregion

        //region Fading Edge
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent, dominantColor
                        )
                    )
                )
                .align(Alignment.BottomCenter)
        )
        //endregion


        //region
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.BottomStart),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            photo.rover?.name?.let {
                DrawableText(
                    imageResource = R.drawable.ic_rover,
                    text = "Rover Name: $it",
                    color = dominantTextColor,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 28.sp
                )
            }

            photo.rover?.launchDate?.let {
                Text(
                    text = "Launch Date: ${it.toDateFormat()}",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = dominantTextColor,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 28.sp
                )
            }

            photo.rover?.landingDate?.let {
                Text(
                    text = "Landing Date: ${it.toDateFormat()}",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = dominantTextColor,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 28.sp
                )
            }


            photo.rover?.status?.let {
                Text(
                    text = "Status: $it",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = dominantTextColor,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 28.sp
                )
            }

        }
        //endregion

    }


}