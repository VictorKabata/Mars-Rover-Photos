package com.vickbt.marsrover.ui.screens.details

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.vickbt.domain.models.Photo

@Composable
fun DetailsScreen(navController: NavController, photo: Photo) {

    Log.e("VicKbt", "Photo transferred: $photo")

}