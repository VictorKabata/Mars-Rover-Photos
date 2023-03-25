package com.vickbt.marsrover.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vickbt.domain.models.Photo
import com.vickbt.marsrover.ui.screens.details.DetailsScreen
import com.vickbt.marsrover.ui.screens.home.HomeScreen


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {

        composable(route = NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = NavigationItem.Details.route) {
            val photo = navController.previousBackStackEntry?.savedStateHandle?.get<Photo>("photo")
            photo?.let {
                DetailsScreen(navController = navController, photo = photo)
            }

        }
    }
}
