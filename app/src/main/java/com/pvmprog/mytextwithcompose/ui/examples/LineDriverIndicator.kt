package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.service.SliderSimple
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme


@Composable
fun LineDriverIndicator(
    isExpanded: Boolean = false,
    labelSlider: String = "kV",
    mivValue:Float = 0f,
    maxValue:Float = 120f,
    alarmValue:Float = 105f
) {
    val sliderPosition = remember {
        mutableFloatStateOf(43f)
    }

    val modifier = Modifier
        .fillMaxWidth(if (isExpanded) 0.8f else 1f)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .padding(top = 32.dp)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        IndicatorLine(
            modifier = modifier,
            value = sliderPosition.floatValue,
            minValue = mivValue,
            maxValue = maxValue,
            alarmValue = alarmValue,
            unitOfMeasurement = labelSlider
        )
        SliderSimple(labelSlider+":", sliderPosition, mivValue, maxValue,modifier)
    }
}

@Composable
private fun IndicatorLine(
    title: String = "Напряжение электрофильтра",
    modifier: Modifier = Modifier,
    value: Float = 0f,
    minValue: Float = 0f,
    maxValue: Float = 120f,
    alarmValue: Float = maxValue - 25f,
    indentDp: Int = 16,
    strokeWidth: Float = 15f, //Ширина ползунка
    quantity: Int = 8,    //кол-во сегментов
    background: Color = MaterialTheme.colorScheme.background,
    colorArrow: Color = MaterialTheme.colorScheme.onBackground,
    colorValue: Color = MaterialTheme.colorScheme.secondary,
    colorAlarm: Color = MaterialTheme.colorScheme.error,
    height: Int = 80,
    unitOfMeasurement: String = "kV",
    styleScaleValues: TextStyle = TextStyle(
        textAlign = TextAlign.Center,
        fontSize = 18.sp,
        color = MaterialTheme.colorScheme.onTertiaryContainer,
    ),
    styleRealValue: TextStyle = TextStyle(
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.SansSerif,
        fontSize = 25.sp,
        color = colorValue,
    )

) {
    val textMeasurer = rememberTextMeasurer()

    Card {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(title)
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(background),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                LineIndicator(
                    modifier = Modifier
                        .height(height.dp)
                        .weight(1f),
                    textMeasurer = textMeasurer,
                    color = colorArrow,
                    minValue = minValue,
                    maxValue = maxValue,
                    quantity = quantity * 2,
                    strokeWidth = if (strokeWidth > 2f) strokeWidth / 2 else 2f,
                    indentDp = indentDp,
                    style = styleScaleValues,
                    alarmValue = alarmValue,
                    alarmColor = colorAlarm,
                    realValue = value
                )
                Spacer(
                    modifier = Modifier
                        .width(2.dp)
                        .background(styleRealValue.color)
                        .height(height.dp)
                )
                Column(
                    modifier = Modifier
                        .background(background)
                        .padding(horizontal = 8.dp)
                        .widthIn(min = 70.dp)
                        .height(height.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "%.1f".format(value), style = styleRealValue.merge(
                            color = if (value >= alarmValue) colorAlarm else colorValue
                        )
                    )
                    Text(unitOfMeasurement, style = styleRealValue)

                }

            }

        }

    }

}

@Composable
fun LineIndicator(
    modifier: Modifier = Modifier,
    textMeasurer: TextMeasurer,
    color: Color,
    minValue: Float,
    maxValue: Float,
    quantity: Int,       //кол-во сегментов
    strokeWidth: Float,
    sliderHeightDp: Int = 30,
    divisionHeight: Int = 10,
    indentDp: Int = 0,
    style: TextStyle,
    alarmValue: Float = 0f,
    alarmColor: Color,
    realValue: Float = 70f
) {
    //Контроль на корректность выводимого значения
    val outValue = if (realValue > maxValue) maxValue
    else if (realValue < minValue) minValue
    else realValue

    Canvas(modifier) {
        val indentPx = indentDp.dp.toPx()
        val widthIndicator = size.width - 2 * indentPx

//рисуем бегунок (прямоугольник),размеры которого будем изменять
        val sliderWidth = outValue * widthIndicator / maxValue
        drawRect(
            topLeft = Offset(
                x = indentPx,
                y = size.height - sliderHeightDp.dp.toPx()
            ),

            size = Size(
                width = sliderWidth,
                height = sliderHeightDp.dp.toPx()
            ),

//градиент цвета заливки
            brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xff2962ff),
                    Color(0xffffeb3b),
                    Color(0xffff5722),
                )
            ),
        )

//нижняя линия индикатора
        drawLine(
            start = Offset(indentPx, size.height),
            end = Offset(size.width - indentPx, size.height),
            strokeWidth = strokeWidth,
            color = color
        )

//приращение величин
        val increment = (maxValue - minValue) / quantity
        val dx = widthIndicator / quantity
        var inc = 0
        var isSmoll = false

        for (i in 0..quantity) {
            val value = minValue + i * increment
            val x = indentPx + i * dx
            val y1 = size.height - sliderHeightDp.dp.toPx()

            val y2 = if (isSmoll) y1 - divisionHeight
            else y1 - 2 * divisionHeight

            val isBorder = if ((i == 0) || (i == quantity)) true
            else false
            //рисуем деление
            drawLine(
                start = Offset(x, y = if (isBorder) size.height else y1),
                end = Offset(x, y = y2),
                strokeWidth = strokeWidth,
                color = color
            )

            if (inc == 0) {
                //Выводим значения над делениями
                val textValue = "${value.toInt()}"
                val valueLayout = textMeasurer.measure(textValue, style)
                val xx = when (i) {
                    0 -> x - 6.dp.toPx()
                    quantity -> x - valueLayout.size.width + 6.dp.toPx()
                    else -> x - valueLayout.size.width / 2
                }
                drawText(
                    textMeasurer = textMeasurer,
                    text = textValue,
                    style = style,
                    topLeft = Offset(
                        x = xx,
                        y = y2 - valueLayout.size.height - 8.dp.toPx()
                    ),
                )
            }

            inc++
            if (inc >= 4) inc = 0
            isSmoll = !isSmoll

        }


//рисуем указатель предельного допустимого значения
        val alarmX = alarmValue * widthIndicator / (maxValue - minValue) + indentPx
        val alarmY = size.height - sliderHeightDp.dp.toPx() + 3.dp.toPx()
        val alarmdWidth = 6.dp.toPx()
        val alarmTop = alarmY - 5 * divisionHeight
        val path = Path().apply {
            moveTo(alarmX, alarmY)
            lineTo(alarmX - alarmdWidth, alarmTop)
            lineTo(alarmX + alarmdWidth, alarmTop)
        }
        drawPath(path, alarmColor)

    }

}


@Preview("Light Theme", showBackground = true)
@Composable
fun LineDriverIndicatorPreview() {
    MyTextWithComposeTheme {
        LineDriverIndicator(false)
    }
}

@Preview("Light Theme", showBackground = true, widthDp = 1000, heightDp = 400)
@Preview(
    "Dark Theme",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 1000,
    heightDp = 400
)
@Composable
fun LineDriverIndicatorPreviewExpanded() {
    MyTextWithComposeTheme {
        LineDriverIndicator(true)
    }
}

