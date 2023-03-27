package com.vickbt.marsrover.utils

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.palette.graphics.Palette
import java.text.SimpleDateFormat
import java.util.Locale

/**Generate image color palette from image drawable*/
fun Drawable.generateImagePalette(): Palette {
    val bitmap = (this as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
    return Palette.from(bitmap).maximumColorCount(16).generate()
}

/**Format date returned from data source to UI format*/
fun String?.toDateFormat(): String? {
    return if (this.isNullOrEmpty()) null
    else if (this.matches(Regex("^\\d{4}-\\d{2}-\\d{2}\$"))) {
        val inputDateTimeFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val formattedDate = inputDateTimeFormat.parse(this)

        val outputDateTimeFormat = SimpleDateFormat("dd MMM, yyyy", Locale.getDefault())

        outputDateTimeFormat.format(formattedDate)
    } else this
}

/**Capitalize the first letter of each word
 * & set letters after first word first string to lowercase*/
fun String?.capitalizeEachWord(): String? {
    return if (!this.isNullOrEmpty()) {
        lowercase().split(" ").joinToString(" ") { firstCharacter ->
            firstCharacter.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase() else it.toString()
            }
        }
    } else null
}
