package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun BorderExampleText(
) {
    val outText = "Border for Text in jetpack Compose."

    val corner = 8.dp

    val style = LocalTextStyle.current.merge(
        TextStyle(
            fontSize = 20.sp,
            color = Color.White,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif,
        )
    )

    val modifier = Modifier
        .background(Color(0xFF9C27B0))

    Column(
        modifier = Modifier
            .padding(8.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .background(Color.DarkGray)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        Text(
            text = "1.$outText",
            modifier = modifier
                .border(
                    width = 2.dp,
                    color = Color.Cyan,
                )
                .padding(8.dp),
            style = style,
        )

        Text(
            text = "2.$outText",
            modifier = modifier
                .border(
                    width = 2.dp,
                    color = Color.Cyan,
                    shape = CutCornerShape(corner) //углы срезаны
                )
                .padding(8.dp),
            style = style,
        )

        Text(
            text = "3.$outText",
            modifier = Modifier
                .graphicsLayer {
                    shadowElevation = 8.dp.toPx()
                    shape = CutCornerShape(corner) //углы срезаны
                    clip = true //!!! обрезание всего, что вне формы
                }
                .border(
                    width = 2.dp,
                    color = Color.Cyan,
                    shape = CutCornerShape(corner) //углы срезаны
                )
                .background(Color(0xFF9C27B0))
                .padding(8.dp),
            style = style,
        )
        Text(
            text = "4.$outText",
            modifier = modifier
                .border(
                    width = 2.dp,
                    color = Color.Cyan,
                    shape = RoundedCornerShape(corner) //углы закруглены
                )
                .padding(8.dp),
            style = style,
        )

        Text(
            text = "5.$outText",
            modifier = Modifier
                .graphicsLayer {
                    shadowElevation = 8.dp.toPx()
                    shape = RoundedCornerShape(corner)
                    clip = true //!!! обрезание всего, что вне формы
                }
                .border(
                    width = 2.dp,
                    color = Color.Cyan,
                    shape = RoundedCornerShape(corner) //углы закруглены
                )
                .background(Color(0xFF9C27B0))
                .padding(8.dp),
            style = style,
        )

        Text(
            text = "6.$outText",
            modifier = Modifier
                .drawBehind {
                    drawRoundRect(
                        Color(0xFF9C27B0),
                        cornerRadius = CornerRadius(corner.toPx()),
                    )
                }
                .border(
                    width = 2.dp,
                    color = Color.Cyan,
                    shape = RoundedCornerShape(corner) //углы закруглены
                )
                .padding(8.dp),
            style = style,
        )

        Text(
            text = "7.$outText",
            modifier = Modifier
                .graphicsLayer {
                    shadowElevation = 8.dp.toPx()
                    shape = RoundedCornerShape(corner)
                    clip = true //!!! обрезание всего, что вне формы
                }
                .background(Color(0xFF9C27B0))
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
                .padding(8.dp),
            style = style,
        )

    }
}
@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BorderExampleTextPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            BorderExampleText()
        }

    }
}

