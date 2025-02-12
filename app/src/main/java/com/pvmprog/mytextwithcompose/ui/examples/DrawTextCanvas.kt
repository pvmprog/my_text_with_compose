package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun DrawTextCanvas(
    textToCenter: String = "Hello, World!"
) {
    val styleCenter = TextStyle(
        color = Color.White,
        fontSize = 24.sp,
        fontFamily = Alice,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline
    )

    val textMeasurer = rememberTextMeasurer()

    val textLayoutCenter = remember(textToCenter) {
        textMeasurer.measure(textToCenter, styleCenter)
    }

    Canvas(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.Black)
    ) {
        val height = size.height
        val width = size.width

        val startX = 0f
        val endX = width
        val startY = height / 2 + 50.dp.toPx()
        val endY = startY


        drawLine(
            start = Offset(x = startX, y = startY),
            end = Offset(x = endX, y = endY),
            color = Color.Yellow,
            strokeWidth = 10f,
            pathEffect = PathEffect.dashPathEffect(
                intervals = floatArrayOf(
                    10f.dp.toPx(),
                    10f.dp.toPx()
                ),
                phase = 10f.dp.toPx()
            )
        )

//размещение по центру
        drawText(
            textMeasurer = textMeasurer,
            text = textToCenter,
            style = styleCenter,
//            topLeft = Offset(50.dp.toPx(),50.dp.toPx()),
            topLeft = Offset(
                x = center.x - textLayoutCenter.size.width / 2,
                y = center.y - textLayoutCenter.size.height / 2,
            ),
        )

    }
}



@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DrawTextCanvasPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            DrawTextCanvas()
        }

    }
}

