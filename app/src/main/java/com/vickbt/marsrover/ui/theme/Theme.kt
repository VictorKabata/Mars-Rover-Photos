package com.vickbt.marsrover.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple80,
    secondary = PurpleGrey80,
    onSurface = Color(0xFFFFFFFF)
)

private val LightColorPalette = lightColors(
    primary = Purple40,
    secondary = PurpleGrey40,
    onSurface = Color(0xFF000000)
)

@Composable
fun MarsRoverTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    /*val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            if (darkTheme) {
                systemUiController.setStatusBarColor(color = DarkSurface)
            } else {
                systemUiController.setStatusBarColor(color = Surface)
            }
        }
    }*/

    MaterialTheme(
        colors = colors,
        typography = Typography,
        content = content
    )
}