package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

//https://alexzh.com/jetpack-compose-styling-text/
/*
TextGeometricTransform
https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextGeometricTransform

TextMotion
https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextMotion

TextDirection
https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextDirection

 */
@Composable
fun TextStyleIndent(
    text: String = "Абзац - малоисследованный компонент литературной формы, имеющий композиционное, сюжетное и тематическое значение.\n" +
            "Выделение фразы в особый абзац усиливает падающий на неё смысловой акцент и способствует правильному и быстрому восприятию текста.",
    textStyle: TextStyle = TextStyle(
        textAlign = TextAlign.Justify,
        lineHeight = 20.sp,
    )
){
    Text(
        text = text,
        style = textStyle.merge(
            textIndent = TextIndent(
                firstLine = 24.sp,
                restLine = 5.sp
            )
        )
    )
}
@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextStyleIndentPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TextStyleIndent()        }

    }
}
