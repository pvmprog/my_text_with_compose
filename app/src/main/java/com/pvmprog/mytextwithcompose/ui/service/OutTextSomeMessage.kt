package com.pvmprog.mytextwithcompose.ui.service

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun OutTextSomeMessage(
    message: String,
    sizeFontText: Int = 18,
    isNormalStyle: Boolean = true,
    isColorBackground: Boolean = false,
    isColorBorder: Boolean = false,
    isShapeLarge: Boolean = false,
    isTextCenter: Boolean = false,
    onClick: (Int) -> Unit = {},
) {
    val messageArrayList = message.split("#")

    if (messageArrayList.size < 2) {
        OutTextMessage(
            message = message,
            sizeFontText = sizeFontText,
            isNormalStyle = isNormalStyle,
            isColorBackground = isColorBackground,
            isColorBorder = isColorBorder,
            isShapeLarge = isShapeLarge,
            isTextCenter = isTextCenter,
            onClick = onClick,
        )
    } else {
        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = when {
                        isColorBackground -> MaterialTheme.colorScheme.background
                        else -> MaterialTheme.colorScheme.tertiaryContainer  //fon
                    }
                )

        ) {
            var indexItem = 0
            messageArrayList.forEachIndexed { index, subStr ->
                if (index % 2 != 0) {
                    indexItem += 1

                    OutTextTitleMessage(
                        title = subStr,
                        indexItem = indexItem,
                        sizeFontText = sizeFontText,
                        isNormalStyle = isNormalStyle,
                        onClick = onClick,
                        isAppendIcon = true
                    )
                } else {
                    if (subStr.isNotBlank())
                        OutTextMessage(
                            message = subStr,
                            sizeFontText = sizeFontText,
                            isNormalStyle = isNormalStyle,
                            isColorBackground = isColorBackground,
                            isColorBorder = isColorBorder,
                            isShapeLarge = isShapeLarge,
                            isTextCenter = isTextCenter,
                            indexItem = indexItem - 1,
                            maxLines = 2,
                            onClick = onClick,
                        )

                }
            }

        }

    }


}


@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OutTextSomeMessagePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            OutTextSomeMessage(
                message = """
|Ресурсы| — это дополнительные файлы и статический контент, который использует приложение.

   #Фильтрация строки#
|filter|{ predicate } - возвращает строку, содержащую только те символы исходной строки, которые соответствуют заданному предикату.

|filterNot|{ predicate } - возвращает строку, содержащую только те символы исходной строки, которые |не| соответствуют заданному предикату.


   #Контроль строки на NULL#
|isBlank|(): |Boolean| - возвращает true, если строка пуста или состоит только из пробелов.

                    """.trimIndent(),
                sizeFontText = 18,
                isNormalStyle = true,
                isColorBackground = true,
                isColorBorder = true,
                isShapeLarge = false,
                isTextCenter = false
            )

        }

    }
}


