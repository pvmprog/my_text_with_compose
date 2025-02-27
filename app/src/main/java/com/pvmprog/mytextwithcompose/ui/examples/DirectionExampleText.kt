package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun DirectionExampleText(){
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        val text = "TextDirection in jetpack Compose"
        val modifier = Modifier.fillMaxWidth()
        val style = TextStyle(
            fontSize = 25.sp,
            fontFamily = FontFamily.Serif,
        )

        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text (
                    text = text+" (Unspecified)",
                    modifier = modifier,
                    style = style.merge(
                        textDirection = TextDirection.Unspecified
                    )
                )
                Text (
                    text = text+" (Content)",
                    modifier = modifier,
                    style = style.merge(
                        textDirection = TextDirection.Content
                    )
                )
                Text (
                    text = text+" (ContentOrLtr)",
                    modifier = modifier,
                    style = style.merge(
                        textDirection = TextDirection.ContentOrLtr
                    )
                )
                Text (
                    text = text+" (ContentOrRtl)",
                    modifier = modifier,
                    style = style.merge(
                        textDirection = TextDirection.ContentOrRtl
                    )
                )
                Text (
                    text = text+" (Rtl)",
                    modifier = modifier,
                    style = style.merge(
                        textDirection = TextDirection.Rtl
                    )
                )
                Text (
                    text = text+" (Ltr)",
                    modifier = modifier,
                    style = style.merge(
                        textDirection = TextDirection.Ltr
                    )
                )

            }
        }
    }

}
@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DirectionExampleTextPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            DirectionExampleText()
        }

    }
}
