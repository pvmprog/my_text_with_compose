package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun AnimationSizeText(
    text: String ="Ш Б",
){

    // Создает экземпляр [InfiniteTransition] для управления дочерними анимациями
    val infiniteTransition = rememberInfiniteTransition()

    // Создает дочернюю анимацию типа float как часть [InfiniteTransition].
    val size by
    infiniteTransition.animateFloat(
        initialValue = 10f,
        targetValue = 170f,
        animationSpec =
        infiniteRepeatable(
            // Бесконечное повторение анимации длительностью 5000 мс с использованием кривой замедления LinearOutSlowInEasing
            animation = tween(20000, easing = LinearEasing),
            // После каждой итерации анимации (т. е. каждые 20000 мс) анимация будет начинаться с [targetValue]
            repeatMode = RepeatMode.Reverse
        )
    )


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = size.sp,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold
            )
    }

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnimationSizeTextPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AnimationSizeText()
        }

    }
}
