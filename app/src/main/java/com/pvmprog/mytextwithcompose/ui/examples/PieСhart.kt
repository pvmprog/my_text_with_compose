package com.pvmprog.mytextwithcompose.ui.examples

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.examples.data.DataItemArc
import com.pvmprog.mytextwithcompose.ui.examples.data.ItemArc
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun PieChart(
    isExpanded: Boolean = false,
    listArc: List<ItemArc> = DataItemArc.listArc,
    textStyle: TextStyle = TextStyle(
        textAlign = TextAlign.Center,
        fontSize = 25.sp,
        color = Color.Cyan,
    )
) {

    if (isExpanded) {
        Column(
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Продажи легких закусок",
                modifier = Modifier
                    .padding(top = 16.dp),
                style = textStyle,
                textAlign = TextAlign.Center
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ChartArc(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    title = "",
                    stylePercent = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = Alice,
                        color = Color.White,
                    ),
                    listArc = listArc,

                    )
                ListLegend(
                    listArc = listArc,
                    modifier = Modifier
                        .weight(0.7f)
                        .verticalScroll(rememberScrollState()),

                    )

            }

        }


    } else {
        Column(
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Продажи легких закусок",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                style = textStyle,
                textAlign = TextAlign.Center
            )
            ChartArc(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                title = "",
                stylePercent = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = Alice,
                    color = Color.White,
                ),
                listArc = listArc,
            )

            ListLegend(
                listArc = listArc,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .verticalScroll(rememberScrollState()),

            )


        }

    }


}

@Composable
private fun ChartArc(
    modifier: Modifier = Modifier,
    listArc: List<ItemArc> = DataItemArc.listArc,
    paddingPercent: Dp = 30.dp,
    stylePercent: TextStyle = TextStyle(
        fontSize = 30.sp,
        color = Color.White,
    ),
    title: String = "",
    color: Color = Color.Cyan,
    fontSize: TextUnit = 25.sp,
    fontWeight: FontWeight? = null,
    textAlign: TextAlign? = null,
    fontFamily: FontFamily? = null,
    textDecoration: TextDecoration? = null,
    styleTitle: TextStyle = LocalTextStyle.current,

    ) {
    var startAngle = -90f
    val textMeasurer = rememberTextMeasurer()
    val mergedStyle = styleTitle.merge(
        textAlign?.let {
            TextStyle(
                color = color,
                fontSize = fontSize,
                fontWeight = fontWeight,
                textAlign = it,
                fontFamily = fontFamily,
                textDecoration = textDecoration,
                platformStyle = PlatformTextStyle(includeFontPadding = false),
            )
        }
    )
    val textTitleLayout = remember(title) {
        textMeasurer.measure(title, mergedStyle)
    }


    Canvas(
        modifier = modifier
            .background(Color.Black)
    ) {

        drawText(
            textMeasurer = textMeasurer,
            text = title,
            style = mergedStyle,
            topLeft = Offset(
                x = center.x - textTitleLayout.size.width / 2,
                y = textTitleLayout.size.height.toFloat(),
            ),
        )


        val widthIndicator = size.minDimension - 120.dp.toPx()

        val topLeft = Offset(
            (size.width - widthIndicator) / 2,
            (size.height - widthIndicator) / 2
        )

        val size = Size(
            widthIndicator,
            widthIndicator
        )
        val radius = widthIndicator / 2

        drawCircle(
            color = Color.Black,
            center = center,
            radius = radius,
            style = Stroke(width = 2.dp.toPx())
        )

        listArc.forEach {
            val sweepAngle = 360 * it.percent / 100

            drawArc(
                color = it.color,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                style = Fill,
                useCenter = true,
                topLeft = topLeft,
                size = size
            )

            val radiusPadding = radius + paddingPercent.toPx()
            val angle = startAngle + it.percent * 3.6 / 2
            val topLeftX = center.x + radiusPadding * cos(angle * Math.PI / 180)
            val topLeftY = center.y + radiusPadding * sin(angle * Math.PI / 180)


            val offsetTopLeft = Offset(topLeftX.toFloat(), topLeftY.toFloat())
            val outValue = it.percent.toInt().toString() + "%"
            val textLayout = textMeasurer.measure(outValue, stylePercent)


            drawText(
                textMeasurer = textMeasurer,
                text = outValue,
                style = stylePercent,
                topLeft = Offset(
                    x = offsetTopLeft.x - textLayout.size.width / 2,
                    y = offsetTopLeft.y - textLayout.size.height / 2,
                ),
            )


            startAngle += sweepAngle


        }

        drawPoints(
            points = listOf(
                Offset(center.x, center.y),
            ),
            pointMode = PointMode.Points,
            cap = StrokeCap.Round,
            color = Color.White,
            strokeWidth = 10.dp.toPx()
        )


    }
}



@Composable
fun ListLegend(
    listArc: List<ItemArc> = DataItemArc.listArc,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        listArc.forEach {
            Row(
                modifier = Modifier
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .background(it.color)
                    .size(20.dp)
                )
                Text(
                    text = it.name,
                    modifier = Modifier
                        .padding(start = 16.dp),
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Left
                )
            }
        }

    }

}

@Preview("Light Theme", showBackground = true)
@Composable
fun PieChartPreview() {
    MyTextWithComposeTheme {
        PieChart(false)
    }
}

@Preview("Light Theme", showBackground = true,widthDp = 1000,heightDp = 400)
@Composable
fun PieChartPreviewExpanded() {
    MyTextWithComposeTheme {
        PieChart(
            isExpanded = true
        )
    }
}
