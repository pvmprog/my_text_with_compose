package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun TextAnnotatedStringClickLink() {
    val annotatedLinkString = buildAnnotatedString {

        withStyle(
            style = SpanStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
            )
        ) {
            pushStyle(
                SpanStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                )
            )
            // append new text red style
            append("Text ")
            // pop the red style
            pop()

            // append new text
            append("in jetpack ")

        }

        withStyle(
            style = SpanStyle(
                color = Color.Magenta,
                fontFamily = FontFamily.Cursive,
                fontSize = 30.sp
            )
        ) {
            append("Compose")
        }

        pushStringAnnotation(
            tag = "URL",
            annotation = "https://developer.android.com/jetpack/compose"
        )

        //Переход на новую строку с выравниванием по центру
        withStyle(
            style = ParagraphStyle(
                textAlign = TextAlign.Center
            )
        ) {
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontFamily = FontFamily.SansSerif,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 18.sp
                )
            ) {
                append("Детальнее здесь...")
            }
        }

        pop()


    }

    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ClickableText(
            text = annotatedLinkString,
            modifier = Modifier
                .padding(16.dp),
            onClick = {
                annotatedLinkString
                    .getStringAnnotations("URL", it, it)
                    .firstOrNull()?.let { stringAnnotation ->
                        uriHandler.openUri(stringAnnotation.item)
                    }
            }
        )

    }

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextAnnotatedStringClickLinkPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TextAnnotatedStringClickLink()

        }

    }
}
