package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun BackgroundWithBrush(
    indexSelect: Int = 0,
    modifier: Modifier = Modifier,
    colors: List<Color> = listOf(Color.Red,Color.Blue),
    text: String = "Hello, World!",
    style: TextStyle = MaterialTheme.typography.bodyMedium.merge(
        TextStyle(
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontFamily = FontFamily.Serif //шрифт с засечками
        )
    ),
    ) {
    val gradientBrush = when (indexSelect) {
        0 -> Brush.linearGradient(colors)
        1 -> Brush.horizontalGradient(colors)
        2 -> Brush.verticalGradient(colors)
        3 -> Brush.sweepGradient(colors)
        else -> Brush.radialGradient(colors)
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush = gradientBrush),
        contentAlignment = Alignment.Center
    ) {
        Text(
           text = text,
           style = style
        )
    }
}
@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BackgroundWithShaderColorsPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            BackgroundWithBrush(4)
        }

    }
}
