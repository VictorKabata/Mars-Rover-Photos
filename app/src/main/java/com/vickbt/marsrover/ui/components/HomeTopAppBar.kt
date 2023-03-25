package com.vickbt.marsrover.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.vickbt.domain.utils.RoversEnum
import com.vickbt.marsrover.R
import java.util.Locale

@Composable
fun HomeTopAppBar(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.app_name),
    roversEnumLists: List<RoversEnum> = RoversEnum.values().toList(),
    onFilterClicked: (String) -> Unit
) {

    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            Text(
                text = title,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        },
        actions = {
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    imageVector = Icons.Rounded.List,
                    contentDescription = "Filter",
                    tint = MaterialTheme.colors.onSurface
                )
            }

            DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                roversEnumLists.forEach {
                    DropdownMenuItem(
                        onClick = {
                            showMenu = false
                            onFilterClicked(it.name.lowercase(Locale.getDefault()))
                        }) {
                        Text(text = it.name)
                    }
                }
            }
        }
    )

}