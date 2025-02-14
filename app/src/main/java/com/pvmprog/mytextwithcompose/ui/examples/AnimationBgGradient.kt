package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun AnimationBgGradient(
    backgroundBox: Painter = painterResource(id = R.drawable.bg2),
){

    // Создает экземпляр [InfiniteTransition] для управления дочерними анимациями
    val infiniteTransition = rememberInfiniteTransition()

    // Создает дочернюю анимацию типа float как часть [InfiniteTransition].
    val endX by infiniteTransition.animateFloat(
        initialValue = 150f,
        targetValue = 200f,
        animationSpec = infiniteRepeatable(
            // Бесконечное повторение анимации длительностью 2000 мс с использованием кривой замедления LinearOutSlowInEasing
            animation = tween(2000, easing = LinearEasing),
            // После каждой итерации анимации (т. е. каждые 2000 мс) анимация будет начинаться снова с [initialValue]
            repeatMode = RepeatMode.Reverse
        ),
        label = "size"

    )

    val color by infiniteTransition.animateColor(
        initialValue = Color.Transparent,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(  //LinearOutSlowInEasing
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ){

        Image(
            painter = backgroundBox,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

        BackgroundWithBrush(
            indexSelect = 4,     //radialGradient
            modifier = Modifier
                .fillMaxSize(),
            colors = listOf(Color.Red,color),
            StartDp = 0,
            endDp = endX.toInt(),
            tileMode = TileMode.Decal,
            style = MaterialTheme.typography.bodyMedium.merge(
                TextStyle(
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontFamily = FontFamily.Serif
                )
            ),
        )

    }
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnimationBgGradientPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AnimationBgGradient()
        }

    }
}
