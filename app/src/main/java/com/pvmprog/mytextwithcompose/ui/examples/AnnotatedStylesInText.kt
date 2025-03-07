package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun AnnotatedStylesInText(
    fontSize:Int = 32,
    style:SpanStyle = SpanStyle(
        fontSize = fontSize.sp,
        fontFamily = Alice,
        fontStyle = FontStyle.Italic,
    ),
    modifier: Modifier = Modifier.padding(16.dp)
) {

    Text(
        text = buildAnnotatedString {
            withStyle(
                style = style.merge(
                    SpanStyle(
                        color = Color.Cyan,
                    )
                )
            ) {
                append("T")
            }

            withStyle(
                style = style
            ){
                append("ext in jetpack ")
            }

            withStyle(
                style = style.merge(
                    SpanStyle(
                        color = Color.Red,
                    )
                )
            ) {
                append("C")
            }
            withStyle(
                style = style
            ){
                append("ompose")
            }


        },
        modifier = modifier,
        lineHeight = (fontSize+10).sp,
        textAlign = TextAlign.Center
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
            AnnotatedStylesInText()

        }

    }
}

