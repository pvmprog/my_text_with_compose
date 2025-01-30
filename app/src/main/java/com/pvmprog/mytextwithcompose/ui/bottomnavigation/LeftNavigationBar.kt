package com.pvmprog.mytextwithcompose.ui.bottomnavigation

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme


@Composable
fun LeftNavigationBar(
    selectedDestination: Int = 0,
    onTabPressed: (Int) -> Unit = {},
    navigationItemContentList: List<BootomItem> = getListBottomItem(),
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        NavigationDrawerHeader(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
        )
        for (navItem in navigationItemContentList) {
            NavigationDrawerItem(
                selected = selectedDestination == navItem.index,
                label = {
                    Text(
                        text = navItem.title,
                        modifier = Modifier
                            .padding(horizontal = dimensionResource(R.dimen.padding_medium))
                    )
                },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.title
                    )
                },
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent
                ),
                onClick = { onTabPressed(navItem.index) }
            )
        }
    }
}

@Composable
private fun NavigationDrawerHeader(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.text_in_jetpack_compose),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Cursive,
            fontSize = 26.sp,

        )
/*
        AppLogo(
            modifier = Modifier
                .size(dimensionResource(R.dimen.app_logo_size))
        )

 */
    }
}

@Composable
fun AppLogo(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(R.drawable.logo_text),
        contentDescription = stringResource(R.string.logo_app),
        modifier = modifier
    )
}


