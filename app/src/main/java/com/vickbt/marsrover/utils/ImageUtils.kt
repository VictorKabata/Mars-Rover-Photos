package com.vickbt.marsrover.utils

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.palette.graphics.Palette

fun Drawable.generateImagePalette(): Palette {
    val bitmap = (this as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
    return Palette.from(bitmap).maximumColorCount(16).generate()
}