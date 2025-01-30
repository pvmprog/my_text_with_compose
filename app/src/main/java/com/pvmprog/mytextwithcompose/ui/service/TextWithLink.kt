package com.pvmprog.mytextwithcompose.ui.service

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun TextWithLink(
    text: String = "Создавайте лучшие приложения быстрее с помощью",
    textUrl: String = "Jetpack Compose",
    url: String = "https://developer.android.com/jetpack/compose",
    sizeFontText: Int = 18,
    isColorBackground: Boolean = true,
    isColorBorder: Boolean = false,

) {
    // Display a link in the text
    val isDarkTheme: Boolean = isSystemInDarkTheme()


    val colorLink = if (isDarkTheme) Color.Cyan
    else Color.Blue

    val colorBackground = when {
        isColorBackground -> MaterialTheme.colorScheme.background
        else -> MaterialTheme.colorScheme.tertiaryContainer
    }

    val colorBorder = when {
        isColorBorder -> MaterialTheme.colorScheme.primary
        else -> colorBackground
    }


    val textAnnotation = buildAnnotatedString {
        //Переход на новую строку с выравниванием по центру
        withStyle(
            style = ParagraphStyle(
                textAlign = TextAlign.Center
            )
        ) {
            withStyle(
                style = SpanStyle(
                    fontSize =(sizeFontText-2).sp,
                    fontFamily = FontFamily.SansSerif,
                )
            ) {
                append("$text ")
            }

        }

        //Переход на новую строку с выравниванием по центру
        withStyle(
            style = ParagraphStyle(
                textAlign = TextAlign.Center
            )
        ) {
            withLink(
                LinkAnnotation.Url(
                    url = url,
                    styles = TextLinkStyles(
                        style = SpanStyle(
                            color = colorLink,
                            fontSize =sizeFontText.sp,
                            textDecoration = TextDecoration.Underline,

                            )
                    )
                )
            ) {
                append(textUrl)
            }

        }

    }

    Text(
        text = textAnnotation,
        lineHeight = 32.sp,
        modifier = Modifier
            .padding(top = dimensionResource(id = R.dimen.padding_small))
            .fillMaxWidth()
            .background(
                color = colorBackground
            )
            .border(
                width = 1.dp,
                color = colorBorder,
                shape = RoundedCornerShape(5.dp)
           )
            .padding(all = dimensionResource(id = R.dimen.padding_small)),
    )
}
@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextWithLinkPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TextWithLink(
                isColorBackground = true,
                isColorBorder = false,
            )
        }

    }
}
