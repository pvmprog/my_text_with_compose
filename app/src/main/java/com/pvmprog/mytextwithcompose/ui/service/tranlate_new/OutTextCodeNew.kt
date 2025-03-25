package com.pvmprog.mytextwithcompose.ui.service.tranlate_new

import android.content.res.Configuration
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.data.locale.DataCodeUI
import com.pvmprog.mytextwithcompose.ui.screens.CodeText
import com.pvmprog.mytextwithcompose.ui.service.tranlate_new.DataTranslate.highColors
import com.pvmprog.mytextwithcompose.ui.theme.Cormorantinfant
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun OutTextCodeNew(
    message: String,
    fontSizeCode: Int = 18,
) {
    val listCode = annotationKotlin(message)

    val annotatedString = buildAnnotatedString {
        append(message)
        listCode.forEach{
            val start = it.startInd
            val end = it.endInd
            val nColor = it.highCodeInd

            val color = if ((nColor >= 0) && (nColor < highColors.size)) highColors[nColor]
            else Color(0xFFFFFFFF)

            addStyle(
                style = SpanStyle(
                    color = color,
                    fontSize = if (nColor != 0) (fontSizeCode - 2).sp
                    else (fontSizeCode - 4).sp,
                    fontFamily = if (nColor != 0) FontFamily.Default
                    else Cormorantinfant
                ),
                start = start,
                end = end
            )
        }
    }

    CodeText(annotatedString)


}

@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OutTextCodePreview() {
    MyTextWithComposeTheme {
        OutTextCodeNew(
            message = DataCodeUI.codeUI[23].code,
            fontSizeCode = 16,
        )
    }
}