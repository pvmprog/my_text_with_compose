package com.pvmprog.mytextwithcompose.ui.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BootomItem(
    val index: Int,
    val title: String,
    val icon: ImageVector
) {

    object BootomItem1 : BootomItem(
        index = 0,
        title = "Home",
        icon = Icons.Filled.Home,
    )

    object BootomItem2 : BootomItem(
        index = 1,
        title = "Result",
        icon = Icons.Filled.PlayArrow,
    )

    object BootomItem3 : BootomItem(
        index = 2,
        title = "Code",
        icon = Icons.Filled.Settings,
    )

    object BootomItem4 : BootomItem(
        index = 3,
        title = "Theory",
        icon = Icons.Filled.List,
    )


}
