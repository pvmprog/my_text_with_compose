package com.pvmprog.mytextwithcompose.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pvmprog.mytextwithcompose.data.locale.DataCodeUI
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import com.pvmprog.mytextwithcompose.ui.bottomnavigation.BootomItem
import com.pvmprog.mytextwithcompose.ui.bottomnavigation.BottomNavigationContent
import com.pvmprog.mytextwithcompose.ui.bottomnavigation.LeftNavigationContent
import com.pvmprog.mytextwithcompose.ui.bottomnavigation.getListBottomItem
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun MainNavigationScreen(
    selectedDestination: Int = 1,
    onTabPressed: (Int) -> Unit = {},
    navigationItemContentList: List<BootomItem> = getListBottomItem(),
    isExpanded: Boolean = false,
    indexExample: Int = 0,
    itemList: List<ExampleCode> = DataCodeUI.codeUI,
    onNext: (Int) -> Unit = {},
    modifier: Modifier = Modifier,
    ){
   if (isExpanded){
       LeftNavigationContent(
           selectedDestination = selectedDestination,
           onTabPressed = onTabPressed,
           navigationItemContentList = navigationItemContentList,
           isExpanded = isExpanded,
           indexExample = indexExample,
           itemList = itemList,
           onNext = onNext,
           modifier= modifier
       )
   } else{
       BottomNavigationContent(
           selectedDestination = selectedDestination,
           onTabPressed = onTabPressed,
           navigationItemContentList = navigationItemContentList,
           isExpanded = isExpanded,
           indexExample = indexExample,
           itemList = itemList,
           onNext = onNext,
           modifier= modifier
           )
   }

}

@Preview("Light Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewMainNavigationScreen() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            MainNavigationScreen(
                isExpanded = false,
                modifier = Modifier.fillMaxSize()
            )
        }

    }
}
@Preview("Light Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO,widthDp = 1000)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES,widthDp = 1000)
@Composable
fun PreviewMainNavigationExpandedScreen() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            MainNavigationScreen(
                isExpanded = true,
                modifier = Modifier.fillMaxSize()
            )
        }

    }
}
