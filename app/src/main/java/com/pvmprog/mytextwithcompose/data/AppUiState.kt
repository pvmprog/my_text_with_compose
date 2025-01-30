package com.pvmprog.mytextwithcompose.data

import com.pvmprog.mytextwithcompose.data.model.ExampleCode

data class AppUiState(
    var itemList: List<ExampleCode> = listOf(),
    val selectedIndex: Int = -2,
    val currentItemBottomNavigation: Int = 1
)
