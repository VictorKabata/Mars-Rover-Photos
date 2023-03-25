package com.vickbt.marsrover.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DrawableText(modifier: Modifier = Modifier, @DrawableRes imageResource: Int, text: String) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(2.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = imageResource),
            contentDescription = "Rover Icon"
        )

        Text(
            modifier = Modifier,
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Black,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
    }
}