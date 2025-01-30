package com.pvmprog.mytextwithcompose.ui

import androidx.lifecycle.ViewModel
import com.pvmprog.mytextwithcompose.data.AppUiState
import com.pvmprog.mytextwithcompose.data.repository.AppRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class AppViewModel @Inject constructor(
    private val repository: AppRepositoryImpl,
) : ViewModel() {

    private val _appUiState = MutableStateFlow(AppUiState())
    val appUiState: StateFlow<AppUiState> = _appUiState

    init {
        getExamples()
    }

    fun getExamples(){
        _appUiState.update {
            it.copy(
                itemList = repository.getAllExamples()
            )
        }
    }

    fun updateSelectedIndex(newValue: Int) {
        _appUiState.update {
            it.copy(
                selectedIndex = newValue
            )
        }
    }

    fun updateCurrentBottomNavigation(newValue: Int) {
        _appUiState.update {
            if (newValue == 0){
                it.copy(
                    currentItemBottomNavigation = 1,
                    selectedIndex = -1
                )
            } else {
                it.copy(
                    currentItemBottomNavigation = newValue,
                )

            }

        }
    }



}
