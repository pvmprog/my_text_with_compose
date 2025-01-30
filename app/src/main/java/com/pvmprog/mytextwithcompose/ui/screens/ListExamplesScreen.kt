package com.pvmprog.mytextwithcompose.ui.screens

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.data.locale.DataCodeUI
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import com.pvmprog.mytextwithcompose.ui.service.OutTextMessage
import com.pvmprog.mytextwithcompose.ui.service.OutTextSomeMessage
import com.pvmprog.mytextwithcompose.ui.theme.Cormorantinfant
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun ListExamplesScreen(
    itemList: List<ExampleCode> = DataCodeUI.codeUI,
    onExit: (Int) -> Unit = {},
    ) {

    BackHandler(
        // your condition to enable handler
        enabled = true
    ) { onExit(-2) }


    val darkTheme: Boolean = isSystemInDarkTheme()

    val colorTitle = if (darkTheme) colorResource(id = R.color.gradient0401)
    else colorResource(id = R.color.gradient0501)


    var message = ""
    message += "\n"
    for (i in 0..itemList.size-1){
        val item = itemList[i]
        message += "\n"
        message += "#${item.title} #"
        message += item.comment
    }
    LazyColumn {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.background
                    )
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "",
                        tint = colorTitle,
                        modifier = Modifier
                            .clickable { onExit(-2) }
                        )

                    Text(
                        text = stringResource(R.string.examples_jetpack_compose),
                        fontSize = 30.sp,
                        lineHeight = 30.sp,
                        color = colorTitle,
                        textAlign = TextAlign.Center,
                        fontFamily = Cormorantinfant,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(dimensionResource(id = R.dimen.padding_medium))
                    )
                }

                OutTextSomeMessage(
                    message = message,
                    sizeFontText = 17,
                    isNormalStyle = true,
                    isColorBackground = true,
                    isColorBorder = true,
                    isShapeLarge = false,
                    isTextCenter = false,
                    onClick = onExit
                )
            }
        }
    }


}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ListExamplesScreenPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ListExamplesScreen()
        }

    }
}
