package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme
import kotlin.math.roundToInt

@Composable
fun DrawBoxText(
    onExit: (Int) -> Unit = {},
) {
    BackHandler(
        enabled = true
    ) { onExit(-1) }

// Можно отключить неявное кэширование, поскольку мы будем кэшировать в DrawWithCache
    val textMeasurer = rememberTextMeasurer(cacheSize = 0)

// Применяем текущий стиль текста из темы, иначе будет использоваться TextStyle.Default.
    val materialTextStyle = LocalTextStyle.current

// Повторная анимация цвета
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val color by infiniteTransition.animateColor(
        initialValue = Color.Yellow,
        targetValue = Color.Cyan,
        animationSpec = infiniteRepeatable(tween(1000)),
        label = ""
    )
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.Black)
            .drawWithCache {
                // Расположение текста будет измерено только один раз,
                // пока не будет достигнут размер области рисования или
                // materialTextStyle изменится.
                val textLayoutResult = textMeasurer.measure(
                    text = "Hello, World!",
                    style = materialTextStyle,
                    constraints = Constraints.fixed(
                        width = (size.width / 2).roundToInt(),
                        height = (size.height / 2).roundToInt()
                    ),
                    overflow = TextOverflow.Ellipsis
                )
                // изменение цвета только аннулирует фазу рисования
                onDrawWithContent {
                    drawContent()
                    drawText(
                        textLayoutResult,
                        color = color,
                        topLeft = Offset(
                            (size.width - textLayoutResult.size.width) / 2,
                            (size.height - textLayoutResult.size.height) / 2,
                        )
                    )
                }
            }
    )

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DrawBoxTextPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            DrawBoxText()
        }

    }
}
