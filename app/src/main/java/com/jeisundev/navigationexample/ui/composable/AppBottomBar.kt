package com.jeisundev.navigationexample.ui.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun AppBottomBar(onItemClick: (BottomBarItem) -> Unit) {
    val items = listOf(
        BottomBarItem.Audit,
        BottomBarItem.Rectify,
        BottomBarItem.Tags,
        BottomBarItem.Support
    )
    val selectedItem: MutableState<BottomBarItem> = remember { mutableStateOf(BottomBarItem.Audit) }

    NavigationBar {
        items.forEach { item ->
            val icon = if (item == selectedItem.value) item.selectedIcon else item.unselectedIcon

            NavigationBarItem(
                label = { Text(item.name) },
                icon = { Icon(imageVector = icon, contentDescription = null) },
                onClick = {
                    onItemClick(item)
                    selectedItem.value = item
                },
                selected = item == selectedItem.value
            )
        }
    }
}

sealed class BottomBarItem(
    val name: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    data object Audit : BottomBarItem(
        name = "Audit",
        selectedIcon = Icons.Default.AddCircle,
        unselectedIcon = Icons.Outlined.AddCircle
    )

    data object Rectify : BottomBarItem(
        name = "Rectify",
        selectedIcon = Icons.Default.Build,
        unselectedIcon = Icons.Outlined.Build
    )

    data object Tags : BottomBarItem(
        name = "Tags",
        selectedIcon = Icons.Default.Star,
        unselectedIcon = Icons.Outlined.Star
    )

    data object Support : BottomBarItem(
        name = "Support",
        selectedIcon = Icons.Default.Call,
        unselectedIcon = Icons.Outlined.Call
    )
}