package com.vickbt.marsrover.ui.navigation

import androidx.annotation.StringRes
import com.vickbt.marsrover.R

sealed class NavigationItem(val route: String, @StringRes val title: Int) {
    object Home : NavigationItem("home", R.string.title_home)
    object Details : NavigationItem("details/{photoId}", R.string.title_details)
}
