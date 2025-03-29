package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme


@Composable
fun ClickableMyText(
    identification:String = "Филин",
    comment:String = "\"Угукающая\" ночная птица",
    char:Char = '*'
) {
    val identLen = identification.length
    val comLen = comment.length
    val corner = 8.dp


    var expanded by remember { mutableStateOf(false) }

    val letters = remember { Array(identLen,{ _ -> char}) }

    var text by remember {
        mutableStateOf(letters.toStr())
    }

    val applicationContext = LocalContext.current

    val annotatedString = AnnotatedString(
        text = text+ " " +comment,
        spanStyles = listOf(
            AnnotatedString.Range(
                SpanStyle(
                    color = Color.Yellow,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 40.sp,
                    letterSpacing = 25.sp
                ),
                0, identLen //Филин
            ),
            AnnotatedString.Range(
                SpanStyle(
                    color = Color.Cyan,
                    fontSize = 15.sp
                ),
                identLen + 1, identLen + 1 + comLen  //Угукающая ночная птица
            ),
        ),

        // создаем два абзаца
        paragraphStyles = listOf(
            AnnotatedString.Range(
                ParagraphStyle(
                    textAlign = TextAlign.Center
                ),
                0, identLen //Филин
            ),
            AnnotatedString.Range(
                ParagraphStyle(
                    textAlign = TextAlign.Center
                ),
                identLen + 1, identLen + 1 + comLen  //Угукающая ночная птица
            ),
        )
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ClickableText(
            text = annotatedString,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .graphicsLayer {
                    shadowElevation = 8.dp.toPx()
                    shape = RoundedCornerShape(corner)
                    clip = true //!!! обрезание всего, что вне формы
                }
                .background(color = Color.Black)
                .drawBehind {
//рисует границы прямоугольника с закруглёнными углами
                    drawRoundRect(
                        color = Color.Cyan,
                        cornerRadius = CornerRadius(corner.toPx()),
                        style = Stroke(
                            width = 4.dp.toPx(),
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
                        )
                    )

                }
                .padding(top = 32.dp,bottom = 32.dp),
            onClick = { ind ->
                if (ind < identLen){
                    letters[ ind ] = identification[ ind ].uppercaseChar()
                    text = letters.toStr()
                    Toast.makeText(
                        applicationContext,
                        "${ind+1} -th character is clicked",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

            }
        )

        Card(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.onBackground)
                .padding(16.dp),
            onClick = { expanded = !expanded }
        ) {
            Crossfade(
                targetState = expanded,
                label = "cross fade"
            ) { state ->
                when (state) {
                    true -> ExpandedText()
                    else -> ContentIcon()
                }
            }

        }

    }


}

@Composable
private fun ContentIcon(
    text: String = "Комментарий ...",
    expanded: Boolean = false
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Text(
            text = text,
            modifier = Modifier
                .weight(1f),
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = "",
            modifier = Modifier.rotate(if (expanded) 180F else 0f)
        )
    }
}

@Composable
private fun ExpandedText(){
    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        ContentIcon("Комментарий к примеру",true)

        Text(
            text = "Для подсказки коснитесь на любой символ '*' для отображения буквы",
            textAlign = TextAlign.Justify,
            letterSpacing = 1.3.sp,
            fontSize = 16.sp

        )
    }
}

fun Array<Char>.toStr(): String {
    val array: Array<Char> = this
    var result = ""
    array.forEach { result += it }
    return result
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ClickableMyTextPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ClickableMyText()
        }

    }
}

