package com.vickbt.marsrover.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vickbt.marsrover.ui.screens.home.HomeScreen


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {

        composable(route = NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }

        /*composable(
            route = NavigationItem.Details.route,
            arguments = listOf(
                navArgument("movieId") {
                    type = NavType.IntType
                },
                navArgument("cacheId") {
                    type = NavType.IntType
                }
            )
        ) {
            val movieID = it.arguments?.getInt("movieId")
            val cacheId = it.arguments?.getInt("cacheId")
            if (movieID != null && cacheId != null) {
                DetailsScreen(navController = navController, movieId = movieID)
            }
        }*/
    }
}
