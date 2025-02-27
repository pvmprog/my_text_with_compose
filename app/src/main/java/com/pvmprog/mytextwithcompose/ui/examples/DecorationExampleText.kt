package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun DecorationExampleText(){
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        var outText = "TextDecoration in jetpack Compose."

        Text(
            text = "1.$outText (None)",
            textDecoration = TextDecoration.None
        )

        Text(
            text = "2.$outText (LineThrough)",
            textDecoration = TextDecoration.LineThrough
        )

        Text(
            text = "3.$outText (Underline)",
            textDecoration = TextDecoration.Underline
        )

//одновременное подчеркивание и зачеркивание текста
        Text(
            text = "4.$outText (Underline + LineThrough)",
            textDecoration = TextDecoration.Underline +
                    TextDecoration.LineThrough,
//  можно и так:
//            textDecoration = TextDecoration.combine(
//                listOf(
//                    TextDecoration.Underline,
//                    TextDecoration.LineThrough
//                )
//            )
        )


        outText = "Decoration for Text in jetpack Compose."
        val modifierUnderline = Modifier.drawBehind {
            val strokeWidthPx = 1.dp.toPx()
            val verticalOffset = size.height - 3.sp.toPx()
            drawLine(
                color = Color.Red,
                strokeWidth = strokeWidthPx,
                start = Offset(0f, verticalOffset),
                end = Offset(size.width, verticalOffset)
            )
        }
        Text(
            text = "5.$outText ",
            modifier = modifierUnderline,
        )

        var modifierLineThrough = Modifier.drawBehind {
            val strokeWidthPx = 1.dp.toPx()
            val verticalOffset = size.height/2
            drawLine(
                color = Color.Red,
                strokeWidth = strokeWidthPx,
                start = Offset(0f, verticalOffset),
                end = Offset(size.width - 5.dp.toPx(), verticalOffset)
            )
        }
        Text(
            text = "6.$outText ",
            modifier = modifierLineThrough,
        )

        modifierLineThrough = Modifier
            .drawBehind {
                val strokeWidthPx = 1.dp.toPx()
                drawLine(
                    color = Color.Yellow,
                    strokeWidth = strokeWidthPx,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, size.height)
                )
            }
            .drawBehind {
                val strokeWidthPx = 1.dp.toPx()
                drawLine(
                    color = Color.Yellow,
                    strokeWidth = strokeWidthPx,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, 0f)
                )
            }
        Text(
            text = "7.$outText ",
            modifier = modifierLineThrough,
        )

        val modifierDashline = Modifier.drawBehind {
            val strokeWidthPx = 1.dp.toPx()
            val verticalOffset = size.height - 3.sp.toPx()
            drawLine(
                color = Color.Red,
                strokeWidth = strokeWidthPx,
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f)),
                start = Offset(0f, verticalOffset),
                end = Offset(size.width - 5.dp.toPx(), verticalOffset)
            )
        }

        Text(
            text = "8.$outText ",
            modifier = modifierDashline,
        )

        val modifierIntervalsline = Modifier.drawBehind {
            val strokeWidthPx = 1.dp.toPx()
            val verticalOffset = size.height - 3.sp.toPx()
            drawLine(
                color = Color.Cyan,
                strokeWidth = strokeWidthPx,
                start = Offset(0f, verticalOffset),
                end = Offset(size.width - 5.dp.toPx(), verticalOffset),
                pathEffect = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(
                        10f.dp.toPx(),
                        2f.dp.toPx(),
                        2f.dp.toPx(),
                        2f.dp.toPx()
                    ),
                    phase = 0f
                )

            )
        }

        Text(
            text = "9.$outText ",
            modifier = modifierIntervalsline,
        )

    }

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DecorationExampleTextPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            DecorationExampleText()
        }

    }
}
