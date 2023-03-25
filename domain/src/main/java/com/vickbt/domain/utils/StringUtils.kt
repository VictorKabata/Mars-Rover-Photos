package com.vickbt.domain.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun String.toDateFormat(): String {
    val inputDateTimeFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val formattedDate=inputDateTimeFormat.parse(this)

    val outputDateTimeFormat = SimpleDateFormat("dd MMM, yyyy", Locale.getDefault())

    return outputDateTimeFormat.format(formattedDate)
}