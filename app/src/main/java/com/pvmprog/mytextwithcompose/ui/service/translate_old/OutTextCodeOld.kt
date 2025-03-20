package com.pvmprog.mytextwithcompose.ui.service.translate_old

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.Cabin
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun OutTextCodeOld(
    message: String,
    highlight: List<HighlightCode> = listOf(),
    style: TextStyle = MaterialTheme.typography.labelSmall,
    fontSizeCode: TextUnit = 18.sp,
) {
    val color = Color.Cyan  //MaterialTheme.colorScheme.outline
    val color2 = colorResource(id = R.color.yellow700)
    val color3 = colorResource(id = R.color.yellow)

    val annotatedString = buildAnnotatedString {
        var str = message
        var str1: String

        val keyStr = "import "
        val endKey = "\n"

        val keyComments = "/*"
        val endComments = "*/"

        val size = fontSizeCode.value - 4

        withStyle(style = ParagraphStyle(lineHeight = fontSizeCode)) {
// import
            do {
                val index = str.indexOf(keyStr)
                if (index == -1) break
                if (index == 0) {
                    str1 = str.substring(index, keyStr.length) //
                    if (str1 == "") break
                    withStyle(
                        style = SpanStyle(
                            color = color,
                            fontWeight = FontWeight.Normal,
                            fontSize = size.sp
                        )
                    ) {
                        append(str1)
                    }
                    str = str.removePrefix(str1)
                    str1 = str.substringBefore(endKey)
                    if (str1 == "") break
                    withStyle(
                        style = SpanStyle(
                            color = color2,
                            fontWeight = FontWeight.Normal,
                            fontSize = size.sp
                        )
                    ) {
                        str1 += endKey
                        append(str1)
                    }
                    str = str.removePrefix(str1)
                } else {
                    str1 = str.substring(0, index)
                    append(str1)
                    str = str.removeRange(0, index)
                }

            } while (true)

//  /*   */
            val ind = str.indexOf(keyComments)

            if (ind >= 0) {
                if (ind != 0) {
                    str1 = str.substring(0, ind)
                    append(str1)
                    str = str.removeRange(0, ind)
                }

                val ind2 = str.indexOf(endComments)
                if (ind2 > 0) {
                    str1 = str.substring(0, ind2 + endComments.length) //
                    withStyle(
                        style = SpanStyle(
                            color = color3,
                            fontWeight = FontWeight.Normal,
                            fontSize = size.sp
                        )
                    ) {
                        append(str1)
                    }
                    str = str.removeRange(0, ind2 + endComments.length)

                }

            }


            var findIndex = 0
            var minIndex = 9999

            do {

                highlight.forEachIndexed { index, highlightCode ->
                    val indStr = str.indexOf(highlightCode.code)
                    if ((indStr != -1) && (indStr <= minIndex)) {
                        findIndex = index
                        minIndex = indStr
                    }
                }

                if (minIndex == 9999) break // фрагментов больше не найдено

                // берем строку до найденого фрагмента
                str1 = str.substring(0, minIndex)
                if (str1 != "") {
                    withStyle(
                        style = SpanStyle(
                            fontFamily = Cabin,
                            fontWeight = FontWeight.Normal,
                            fontSize = fontSizeCode
                        )
                    ) {
                        append(str1)
                    }
                    str = str.removePrefix(str1)
                }
                // найденный фрагмент выделяем цветом
                if (highlight[findIndex].code == "//") {
                    str1 = str.substringBefore(endKey)
                    if (str1 != "") {
                        withStyle(
                            style = SpanStyle(
                                color = color3,
                                fontWeight = FontWeight.Normal,
                                fontSize = size.sp
                            )
                        ) {
                            str1 += endKey
                            append(str1)
                        }
                        str = str.removePrefix(str1)
                        minIndex = 9999
                        continue

                    } else break
                }
                str1 = str.substring(0, highlight[findIndex].code.length)
                if (str1 == "") break
                withStyle(
                    style = SpanStyle(
                        fontFamily = Cabin,
                        fontWeight = FontWeight.Normal,
                        fontSize = fontSizeCode,
                        color = highlight[findIndex].color,
                    )
                ) {
                    append(str1)
                }
                str = str.removePrefix(str1)
                minIndex = 9999

            } while (true)

            withStyle(
                style = SpanStyle(
                    fontFamily = Cabin,
                    fontWeight = FontWeight.Normal,
                    fontSize = fontSizeCode
                )
            ) {
                append(str)
            }

        }
    }
    Box(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState())
    ) {
        SelectionContainer {
            Text(
                text = annotatedString,
                modifier = Modifier
                    .padding(top = dimensionResource(id = R.dimen.padding_small))
                    .fillMaxWidth()
                    .alpha(1.0f)
                    .drawBehind {
                        drawRoundRect(
                            Color.Black,
                            cornerRadius = CornerRadius(16.dp.toPx())
                        )
                    }
                    .border(
                        width = 1.dp,
                        color = Color.Yellow,
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.roundedCornerSmall))
                    )
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                style = style,
                color = colorResource(id = R.color.code_text),   //MaterialTheme.colorScheme.onTertiaryContainer,
            )

        }

    }


}

@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OutTextCodePreview() {
    MyTextWithComposeTheme {
        OutTextCodeOld(
            message = """
import java.text.SimpleDateFormat
import java.util.*                

/*

  Во многих случаях нет необходимости 
 явно указывать тип для переменной.
 
  Kotlin автоматически определяет тип переменной
  в зависимости от присваиваемого ей значения.
 
*/                
                         
   val a = 10
   val b = 25
   var c:Boolean
   
   c = a == b    //false  
   c = a == 10   //true
   
                       """.trimIndent(),
            highlight = listOf(
                HighlightCode(
                    code = "==",
                    color = Color(0xFF3CEE0A)
                ),
                HighlightCode(
                    code = "Boolean",
                    color = Color(0xFF3CEE0A)
                ),
                HighlightCode(
                    code = "//",
                    color = Color(0xFF3CEE0A)
                ),
            ),
            fontSizeCode = 16.sp,
        )
    }
}