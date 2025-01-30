package com.pvmprog.mytextwithcompose.ui.service

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun OutTextTitleMessage(
    title: String = "",
    indexItem: Int = 0,
    sizeFontText: Int = 18,
    isNormalStyle: Boolean = true,
    onClick: (Int) -> Unit = {},
    isAppendIcon: Boolean = true
) {
// градиент цвета https://mybrandnewlogo.com/ru/generator-gradienta-cveta
    val darkTheme: Boolean = isSystemInDarkTheme()

    val gradientColors = if (darkTheme) listOf(
        colorResource(id = R.color.gradient0401),
        colorResource(id = R.color.gradient0402),
        colorResource(id = R.color.gradient0403),
    ) else listOf(
        colorResource(id = R.color.gradient0501),
        colorResource(id = R.color.gradient0502),
        colorResource(id = R.color.gradient0503),
    )

    val brush = Brush.linearGradient(colors = gradientColors)

    Text(
        text = buildAnnotatedString {
/*
            withStyle(
                SpanStyle(
                    brush = brush,
                    fontWeight = FontWeight.Bold,
                    alpha = .9f
                )
            ) {
                if (indexItem>0) {
                    val indStr = (indexItem.toString()).padStart(2)
                    append("$indStr. ")
                }
            }

 */

            withStyle(
                SpanStyle(
                    brush = brush, alpha = 1f
                )
            ) {
                append(title)
                if (isAppendIcon) append("✨")  //⤵️ 🎯
            }
        },
        style = if (isNormalStyle) MaterialTheme.typography.bodyMedium
        else MaterialTheme.typography.bodySmall,
        fontSize = (sizeFontText+4).sp,
        modifier = Modifier
            .padding(top = dimensionResource(id = R.dimen.padding_small))
            .clickable { onClick(indexItem-1) },
        textAlign = TextAlign.Center
    )

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OutTextTitleMessagePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.tertiaryContainer
        ) {
            OutTextTitleMessage(
                title = "Text in Jetpack Compose",
                indexItem = 1,
                isNormalStyle = true,
                isAppendIcon = true
            )

        }

    }
}
