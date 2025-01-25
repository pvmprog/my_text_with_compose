package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
@Preview("Light Theme",showBackground = true)
fun TextBuildAnnotatedString() {

    val annotatedString = buildAnnotatedString {

        append("Text in jetpack Compose")

        addStyle(
            style = SpanStyle(
                color = Color.Red,
                fontFamily = FontFamily.Cursive,
                fontSize = 24.sp
            ),
            start = 0,
            end = 1
        )

        addStyle(
            style = SpanStyle(
                color = Color.Blue
            ),
            start = 1,
            end = 4
        )

        addStyle(
            style = SpanStyle(
                color = Color.Black
            ),
            start = 5,
            end = 15
        )

        addStyle(
            style = SpanStyle(
                color = Color.Magenta,
                fontFamily = FontFamily.Cursive,
                fontSize = 25.sp
            ),
            start = 16,
            end = 23
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            annotatedString,
            modifier = Modifier
                .padding(16.dp)
        )
    }

}


