package com.pvmprog.mytextwithcompose.ui.bottomnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.data.locale.DataCodeUI
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import com.pvmprog.mytextwithcompose.ui.screens.Examplescreen

@Composable
fun LeftNavigationContent(
    selectedDestination: Int,
    onTabPressed: ((Int) -> Unit),
    navigationItemContentList: List<BootomItem>,
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    indexExample: Int = 0,
    itemList: List<ExampleCode> = DataCodeUI.codeUI,
    onNext: (Int) -> Unit = {},
    heightMinDp:Int = 200,
    onIntentClicked: (String) -> Unit = {{}}

    ) {
    PermanentNavigationDrawer(
        drawerContent = {
            PermanentDrawerSheet(Modifier.width(dimensionResource(R.dimen.drawer_width))) {
                LeftNavigationBar(
                    selectedDestination = selectedDestination,
                    onTabPressed = onTabPressed,
                    navigationItemContentList = navigationItemContentList,
                    modifier = Modifier
                        .wrapContentWidth()
                        .fillMaxHeight()
                        .background(MaterialTheme.colorScheme.inverseOnSurface)
                        .padding(dimensionResource(R.dimen.drawer_padding_content))
                )

            }

        },
        modifier = modifier
    ) {
        Examplescreen(
            selectedDestination = selectedDestination,
            isExpanded = isExpanded,
            indexExample = indexExample,
            itemList = itemList,
            onNext = onNext,
            heightMinDp = heightMinDp - 50,
            onIntentClicked = onIntentClicked

        )
    }
}


