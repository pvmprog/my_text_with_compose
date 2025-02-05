package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun ExampleFontSize() {
    val text = stringResource(
        id = R.string.hello_world
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.onBackground)
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(padding)
            ) {
                Text(
                    text = text + "(default)",
                    fontSize = TextUnit.Unspecified
                )
                Text(
                    text = text + "(20.sp)",
                    fontSize = 20.sp
                )
                Text(
                    text = text + "(3.em)",
                    fontSize = 3.em
                )
                Text(
                    text = text + "(15.sp)",
                    style = TextStyle(
                        fontSize = 15.sp,
                    )
                )

            }

        }
    }


}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ExampleFontSizePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ExampleFontSize()
        }

    }
}

