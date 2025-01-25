package com.pvmprog.mytextwithcompose.ui.service

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun TextLink(
    text: String = "Создавайте лучшие приложения быстрее с помощью",
    textUrl: String = "Jetpack Compose" ,
    url: String = "https://developer.android.com/jetpack/compose",
    sizeFontText: Int = 18,
    isColorBackground: Boolean = true,
    isColorBorder: Boolean = false,
){
    val uriHandler = LocalUriHandler.current
    val isDarkTheme: Boolean = isSystemInDarkTheme()

    val colorLink = if (isDarkTheme) Color.Cyan
    else Color.Blue

    val colorText = when {
        isColorBackground -> MaterialTheme.colorScheme.onBackground
        else -> MaterialTheme.colorScheme.onTertiaryContainer
    }

    val colorBackground = when {
        isColorBackground -> MaterialTheme.colorScheme.background
        else -> MaterialTheme.colorScheme.tertiaryContainer
    }

    val colorBorder = when {
        isColorBorder -> MaterialTheme.colorScheme.primary
        else -> colorBackground
    }


    val annotatedLinkString = buildAnnotatedString {

        pushStringAnnotation(
            tag = "URL",
            annotation = url
        )

        //Переход на новую строку с выравниванием по центру
        withStyle(
            style = ParagraphStyle(
                textAlign = TextAlign.Left
            )
        ) {

            withStyle(
                style = SpanStyle(
                    color = colorText,
                    fontSize =(sizeFontText-2).sp,
                    fontFamily = FontFamily.SansSerif,
                )
            ) {
                append("$text ")
            }
            withStyle(
                style = SpanStyle(
                    color = colorLink,
                    fontSize =sizeFontText.sp,
                    fontFamily = FontFamily.SansSerif,
                    textDecoration = TextDecoration.Underline,
                )
            ) {
                append("$textUrl...")
            }
        }

        pop()


    }


    ClickableText(
        text = annotatedLinkString,
        modifier = Modifier
            .fillMaxWidth()
//            .alpha(0.8f)
            .background(colorBackground)
            .border(
                width = 1.dp,
                color = colorBorder,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(all = dimensionResource(id = R.dimen.padding_small)),
        onClick = {
            annotatedLinkString
                .getStringAnnotations("URL", it, it)
                .firstOrNull()?.let { stringAnnotation ->
                    uriHandler.openUri(stringAnnotation.item)
                }
        }
    )



}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextLinkPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TextLink(
            isColorBackground = false,
            isColorBorder = true,
            )
        }

    }
}
