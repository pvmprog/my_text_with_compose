package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.service.SliderSimple
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme


@Composable
fun CircularIndicator(
    isExpanded: Boolean = false,
    progress: String = "prog"
) {
    val sliderPosition = remember {
        mutableFloatStateOf(30f)
    }

    if (isExpanded) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IndicatorArc(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxHeight()
                    .weight(1f),
                sliderPosition = sliderPosition.floatValue
            )
            Column(
                modifier = Modifier.weight(0.7f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                SliderSimple(progress, sliderPosition, 0f, 100f)
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            IndicatorArc(
                modifier = Modifier
                    .padding(16.dp)
                    .aspectRatio(1f),
//                    .fillMaxWidth()
//                    .weight(1f),
                sliderPosition = sliderPosition.floatValue
            )
            SliderSimple(progress, sliderPosition, 0f, 100f)

        }

    }


}



@Composable
private fun IndicatorArc(
    modifier: Modifier = Modifier,
    sliderPosition: Float = 50f,
    background:Color = MaterialTheme.colorScheme.tertiaryContainer,
    circleColor:Color = MaterialTheme.colorScheme.onPrimaryContainer,
    arcColor:Color = MaterialTheme.colorScheme.primary,
    thickness: Dp = 8.dp,
    style: TextStyle = TextStyle(
        //LocalTextStyle.current,
        textAlign = TextAlign.Center,
        fontFamily = Alice,
        fontSize = 55.sp,
        color = MaterialTheme.colorScheme.onTertiaryContainer,
    )

) {
    val startAngle = 270f
    val sweepAngle = 360 * sliderPosition / 100

    val textPosition = sliderPosition.toInt().toString() + "%"

    val textMeasurer = rememberTextMeasurer()
    val textLayoutResult = remember(textPosition) {
        textMeasurer.measure(textPosition, style)
    }

    Canvas(
        modifier = modifier.background(background)
    ) {
/*
        val widthIndicator = if (size.width < size.height)
            size.width - 16.dp.toPx()
        else size.height - 16.dp.toPx()


 */
        val widthIndicator = size.minDimension - 16.dp.toPx()

        drawCircle(
            color = circleColor,
            center = center,
            radius = widthIndicator / 2,
            style = Stroke(width = 2.dp.toPx())
        )

        drawArc(
            color = arcColor,
            startAngle = startAngle,
            sweepAngle = sweepAngle,
            style = Stroke(
                width = thickness.toPx(),
                cap = StrokeCap.Round,
            ),
            useCenter = false,
            topLeft = Offset(
                (size.width - widthIndicator) / 2,
                (size.height - widthIndicator) / 2
            ),
            size = Size(
                widthIndicator, widthIndicator
            )
        )

        //размещение текста по цетру
        drawText(
            textMeasurer = textMeasurer,
            text = textPosition,
            style = style,
            topLeft = Offset(
                x = center.x - textLayoutResult.size.width / 2,
                y = center.y - textLayoutResult.size.height / 2,
            ),
        )


    }
}

@Preview("Light Theme", showBackground = true)
@Composable
fun CircularIndicatorPreview() {
    MyTextWithComposeTheme {
        CircularIndicator(false)
    }
}

@Preview("Light Theme", showBackground = true,widthDp = 1000,heightDp = 400)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES,widthDp = 1000,heightDp = 400)
@Composable
fun CircularIndicatorPreviewExpanded() {
    MyTextWithComposeTheme {
        CircularIndicator(true)
    }
}

