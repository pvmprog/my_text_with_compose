package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.Cabin
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun DrawAnimeScaleAText(
    modifier: Modifier = Modifier,
    duration: Int = 10000,   //10 sek
    textToCenter: String = "А",
    color: Color = Color.White,
    fontFamily: FontFamily = Cabin  //Alice
) {
    val textMeasurer = rememberTextMeasurer()

    val styleCenter = TextStyle(
        fontSize = 18.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        color = color,
    )
    val textLayoutCenter = remember(textToCenter) {
        textMeasurer.measure(textToCenter, styleCenter)
    }

    val infiniteTransition = rememberInfiniteTransition(
        label = "infinite"
    )

    val scale by infiniteTransition.animateFloat(
        initialValue = 33f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = duration,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale text"
    )

    Canvas (
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black),
    ) {
        withTransform({
            scale(scaleX = scale, scaleY = scale)
        }) {
//размещение по цетру текста
            drawText(
                textMeasurer = textMeasurer,
                text = textToCenter,
                style = styleCenter,
                topLeft = Offset(
                    x = center.x - textLayoutCenter.size.width / 2,
                    y = center.y - textLayoutCenter.size.height / 2,
                ),
            )

        }

    }
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DrawAnimeScaleATextPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            DrawAnimeScaleAText()
        }

    }
}

