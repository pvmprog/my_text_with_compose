package com.pvmprog.mytextwithcompose.ui.bottomnavigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BottomNavigationBar(
    currentTab: Int,
    onTabPressed: (Int) -> Unit = {},
    navigationItemContentList: List<BootomItem>,
    modifier: Modifier = Modifier
) {

    NavigationBar(
        modifier = modifier
    ) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab == navItem.index,
                onClick = { onTabPressed(navItem.index) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.title,
                    )
                }
            )
        }
    }
}
