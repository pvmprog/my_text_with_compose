package com.pvmprog.mytextwithcompose.ui.bottomnavigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pvmprog.mytextwithcompose.data.locale.DataCodeUI
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import com.pvmprog.mytextwithcompose.ui.screens.Examplescreen

@Composable
fun BottomNavigationContent(
    selectedDestination: Int,
    onTabPressed: ((Int) -> Unit),
    navigationItemContentList: List<BootomItem>,
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    indexExample: Int = 0,
    itemList: List<ExampleCode> = DataCodeUI.codeUI,
    onNext: (Int) -> Unit = {},

    ) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            Box(
                modifier = modifier
                    .weight(1f)
            ) {
                Examplescreen(
                    selectedDestination = selectedDestination,
                    isExpanded = isExpanded,
                    indexExample = indexExample,
                    itemList = itemList,
                    onNext = onNext
                )
            }
            AnimatedVisibility(
                visible = !isExpanded
            ) {
                BottomNavigationBar(
                    currentTab = selectedDestination,
                    onTabPressed = onTabPressed,
                    navigationItemContentList = navigationItemContentList,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }

    }

}
