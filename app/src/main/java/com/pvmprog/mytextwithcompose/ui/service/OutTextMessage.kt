package com.pvmprog.mytextwithcompose.ui.service

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.Cormorantinfant
import com.pvmprog.mytextwithcompose.ui.theme.HighColorLight
import com.pvmprog.mytextwithcompose.ui.theme.HighColorDark
import com.pvmprog.mytextwithcompose.ui.theme.HighColorLight2
import com.pvmprog.mytextwithcompose.ui.theme.HighColorDark2
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun OutTextMessage(
    message: String,
    sizeFontText: Int = 18,     //: TextUnit = 18.sp
    isNormalStyle: Boolean = true,
    isColorBackground: Boolean = false,
    isColorBorder: Boolean = false,
    isShapeLarge: Boolean = false,
    isTextCenter: Boolean = false,
    maxLines:Int = Int.MAX_VALUE,
//    indexItem: Int = 0,
//    onClick: (Int) -> Unit = {},

    ) {
    val darkTheme: Boolean = isSystemInDarkTheme()

    val colorText = MaterialTheme.colorScheme.onTertiaryContainer

    val highLightedColor = MaterialTheme.colorScheme.outline

    val highLightedColor2 = MaterialTheme.colorScheme.outlineVariant

    val messageArrayList = message.split("|")

    val annotatedString = buildAnnotatedString {

        withStyle(style = ParagraphStyle(lineHeight = sizeFontText.sp)) {

            if (messageArrayList.size < 2) append(message)
            else {
                messageArrayList.forEachIndexed { index, s ->
                    if (index % 2 != 0) {
                        val isColorTwo = (s[0] == '!')
                        withStyle(
                            style = SpanStyle(
                                fontSize = (sizeFontText+2).sp,
                                fontFamily = Alice,
                                color = if (isColorTwo)  highLightedColor2
                                else  highLightedColor,
                            )
                        ) {
                            if (isColorTwo) append(s.substring(1))
                            else append(s)
                        }

                    } else {
                        withStyle(
                            style = SpanStyle(
//                                fontSize = (sizeFontText+2).sp,
//                                fontFamily = Cormorantinfant,
                                color = when {
                                    isColorBackground -> Color.Unspecified
                                    else -> colorText
                                },
                                fontWeight = FontWeight.Normal,
                            )
                        ) {
                            append(s)
                        }
                    }
                }

            }

        }
    }

    var style = if (isNormalStyle) MaterialTheme.typography.bodyMedium   //labelLarge  bodyLarge
    else MaterialTheme.typography.bodySmall

    style = style.merge(
        TextStyle(
            fontSize =sizeFontText.sp,
            textAlign = if (isTextCenter) {
                TextAlign.Center
            } else {
                TextAlign.Left
            },
           fontFamily = FontFamily.SansSerif
        )
    )

    Text(
        text = annotatedString,
        style = style,
        modifier = Modifier  //суб,воск   занят
//            .padding(top = dimensionResource(id = R.dimen.padding_small))
            .fillMaxWidth()
//            .alpha(if (isNormalStyle) 1.0f else 0.6f)
//            .clickable { onClick(indexItem) }
            .clip(
                shape = when {
                    isShapeLarge -> RoundedCornerShape(dimensionResource(id = R.dimen.roundedCornerCicle))
                    else -> RoundedCornerShape(5.dp)
                }
            )
            .background(
                color = when {
                    isColorBackground -> MaterialTheme.colorScheme.background
                    else -> MaterialTheme.colorScheme.tertiaryContainer
                }
            )
            //  .border(BorderStroke(2.dp, Color.Blue))
            .border(
                width = 1.dp,
                color = when {
                    isColorBorder -> MaterialTheme.colorScheme.primary
                    else -> MaterialTheme.colorScheme.tertiaryContainer
                },
                shape = when {
                    isShapeLarge -> RoundedCornerShape(dimensionResource(id = R.dimen.roundedCornerCicle))
                    else -> RoundedCornerShape(5.dp)
                }
            )
            .padding(all = dimensionResource(id = R.dimen.padding_small)),
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,


    )
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OutTextMessagePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.tertiaryContainer
        ) {
            OutTextMessage(
                message = """
|Ресурсы| — это дополнительные файлы и |!статический| контент, который использует приложение.
                   
                    """.trimIndent(),
                sizeFontText = 18,
                isNormalStyle = true,
                isColorBackground = false,
                isColorBorder = true,
                isShapeLarge = false,
                isTextCenter = false
            )

        }

    }
}
