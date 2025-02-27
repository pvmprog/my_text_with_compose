package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun TextLineHeight() {

    val text = "Text in jetpack Compose."

    val padding = 16.dp

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .border(1 .dp, MaterialTheme.colorScheme.onBackground)
            .padding(padding),
    ) {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(padding)
            ) {
                Text(
                    text = (text + " (default) ").repeat(5),
                )

                Text(
                    text = (text + " (lineHeight = 2.0em) ").repeat(5),
                    lineHeight = 2.0 .em,
                )

                Text(
                    text = (text + " (lineHeight = 1.0em) ").repeat(5),
                    lineHeight = 1.0 .em,
                )
            }

        }

    }

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextLineHeightPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TextLineHeight()
        }

    }
}

