package com.pvmprog.mytextwithcompose.ui.examples

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

@Composable
@Preview(showBackground = true)
fun TextClickableText() {

    val applicationContext = LocalContext.current

    val annotatedString = AnnotatedString(
        text = "Нажмите на текст в любом месте",
        spanStyles = listOf(
            AnnotatedString.Range(
                SpanStyle(
                    color = Color.Yellow,
                    fontStyle = FontStyle.Italic,
                    fontSize = 22.sp
                ),
                0, 7 //Нажмите
            ),
            AnnotatedString.Range(
                SpanStyle(
                    color = Color.Cyan,
                    fontSize = 22.sp
                ),
                8, 16 //на текст
            ),
            AnnotatedString.Range(
                SpanStyle(
                    color = Color.Green,
                    fontSize = 20.sp
                ),
                17, 24 //в любом
            ),
            AnnotatedString.Range(
                SpanStyle(
                    color = Color.Blue,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 22.sp
                ),
                25, 30 //месте
            ),
        ),

        // создаем три абзаца
        paragraphStyles = listOf(
            AnnotatedString.Range(
                ParagraphStyle(
                    textAlign = TextAlign.Center
                ),
                0, 7 //Нажмите
            ),
            AnnotatedString.Range(
                ParagraphStyle(
                    textAlign = TextAlign.Center
                ),
                8, 16 //на текст
            ),
            AnnotatedString.Range(
                ParagraphStyle(
                    textAlign = TextAlign.Center
                ),
                17, 24 //в любом
            ),
            AnnotatedString.Range(
                ParagraphStyle(
                    textAlign = TextAlign.Center
                ),
                25, 30 //месте
            )
        )
    )


    ClickableText(
        text = annotatedString,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(color = Color.Black),

        onClick = { offset ->
            Toast.makeText(
                applicationContext,
                "$offset -th character is clicked.",
                Toast.LENGTH_SHORT
            )
                .show()

        }
    )

}