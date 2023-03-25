package com.vickbt.marsrover.utils

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.palette.graphics.Palette
import java.text.SimpleDateFormat
import java.util.Locale

fun Drawable.generateImagePalette(): Palette {
    val bitmap = (this as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
    return Palette.from(bitmap).maximumColorCount(16).generate()
}

fun String.toDateFormat(): String {
    val inputDateTimeFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val formattedDate=inputDateTimeFormat.parse(this)

    val outputDateTimeFormat = SimpleDateFormat("dd MMM, yyyy", Locale.getDefault())

    return outputDateTimeFormat.format(formattedDate)
}

fun String.capitalizeEachWord(): String {
    return lowercase().split(" ").joinToString(" ") { firstCharacter ->
        firstCharacter.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase() else it.toString()
        }
    }
}