package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun MultipleStylesInText() {
    val Alice = FontFamily(
        Font(R.font.alice_regular)
    )
    val style = SpanStyle(
        color = Color.Cyan,
        fontSize = 22.sp,
        fontFamily = Alice,
        fontStyle = FontStyle.Italic,
    )

    Text(
        text = buildAnnotatedString {
            withStyle(
                style = style
            ) {
                append("T")
            }
            append("ext in jetpack ")

            withStyle(
                style = style.merge(
                    SpanStyle(
                        color = Color.Red,
                    )
                )
            ) {
                append("C")
            }
            append("ompose")
        },
        modifier = Modifier.padding(16.dp)
    )
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MultipleStylesInTextPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            MultipleStylesInText()

        }

    }
}

