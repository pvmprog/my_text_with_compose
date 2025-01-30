package com.pvmprog.mytextwithcompose.ui

import android.annotation.SuppressLint
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pvmprog.mytextwithcompose.ui.bottomnavigation.getListBottomItem
import com.pvmprog.mytextwithcompose.ui.screens.GreetingScreen
import com.pvmprog.mytextwithcompose.ui.screens.GreetingScreen2
import com.pvmprog.mytextwithcompose.ui.screens.ListExamplesScreen

/*
Screen width sizes
 Compact  0..599
 Medium   600..839
 Expanded 840..
 */

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun MainScreen(
    isExpanded:Boolean = false,
    minSizeScreenDp: Int = 300,
    modifier: Modifier = Modifier
){

    val viewModel: AppViewModel = hiltViewModel()
    val productListUiState by viewModel.appUiState.collectAsState()
    val indexExample = productListUiState.selectedIndex
    val itemList = productListUiState.itemList

    when (indexExample){
        -2 -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                GreetingScreen2(
                    sizeImage = minSizeScreenDp.dp,
                    onExit = { viewModel.updateSelectedIndex(-1) }
                )
            } else {
                GreetingScreen(
                    onExit = { viewModel.updateSelectedIndex(-1) }
                )
            }

        }
        -1 -> ListExamplesScreen(
            onExit = { viewModel.updateSelectedIndex(it) }
        )
        else -> MainNavigationScreen(
            selectedDestination = productListUiState.currentItemBottomNavigation,
            onTabPressed = { currentItemBottomNavigation: Int ->
                viewModel.updateCurrentBottomNavigation(currentItemBottomNavigation)
            },
            navigationItemContentList = getListBottomItem(),
            isExpanded = isExpanded,
            indexExample = indexExample,
            itemList = itemList,
            onNext = { selectedIndexExample:Int ->
                viewModel.updateSelectedIndex(selectedIndexExample)
            },
            modifier = modifier
            )
    }
}
