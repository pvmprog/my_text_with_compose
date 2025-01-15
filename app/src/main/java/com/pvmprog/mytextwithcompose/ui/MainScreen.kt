package com.pvmprog.mytextwithcompose.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun MainScreen(){
    val viewModel: AppViewModel = hiltViewModel()
    val productListUiState by viewModel.appUiState.collectAsState()
    val indexExample = productListUiState.selectedIndex

    when (indexExample){
        -1 -> GreetingScreen()

        else -> GreetingScreen()
    }
}
