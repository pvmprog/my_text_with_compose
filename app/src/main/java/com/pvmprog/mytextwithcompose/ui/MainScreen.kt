package com.pvmprog.mytextwithcompose.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import com.pvmprog.mytextwithcompose.ui.screens.Examplescreen
import com.pvmprog.mytextwithcompose.ui.screens.GreetingScreen
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
    isExpanded:Boolean = false
){

    val viewModel: AppViewModel = hiltViewModel()
    val productListUiState by viewModel.appUiState.collectAsState()
    val indexExample = productListUiState.selectedIndex
    val itemList = productListUiState.itemList

    when (indexExample){
        -2 -> GreetingScreen(
            onExit = { viewModel.updateSelectedIndex(-1) }
        )
        -1 -> ListExamplesScreen(
            onExit = { viewModel.updateSelectedIndex(it) }
        )
        else -> Examplescreen(
            isExpanded = isExpanded,
            indexExample = indexExample,
            itemList = itemList,
            onNext = { viewModel.updateSelectedIndex(it) }
            )
    }
}
