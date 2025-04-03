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
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.service.SliderSimple
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ArrowIndicator(
    isExpanded: Boolean = false,
    progress: String = "mA",
    mivValue:Float = 0f,
    maxValue:Float = 1200f
) {
    val sliderPosition = remember {
        mutableFloatStateOf(500f)
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
                value = sliderPosition.floatValue
            )
            Column(
                modifier = Modifier.weight(0.7f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                SliderSimple(progress, sliderPosition, mivValue, maxValue)
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
                value = sliderPosition.floatValue,
                minValue = mivValue,
                maxValue = maxValue,
            )
            SliderSimple(progress, sliderPosition, mivValue, maxValue)

        }

    }


}



@Composable
private fun IndicatorArc(
    modifier: Modifier = Modifier,
    value: Float = 600f,
    minValue: Float = 0f,
    maxValue: Float = 1200f,
    startAngle:Float = 45f,
    sweepAngle:Float = -180f - 2 * startAngle,
    indentDp:Int = 16,
    strokeWidth:Float = 15f, //Ширина стрелки
    quantity:Int = 6,    //кол-во сегментов
    background: Color = MaterialTheme.colorScheme.tertiaryContainer,
    colorArrow: Color = MaterialTheme.colorScheme.onTertiaryContainer,
    arcColor: Color = MaterialTheme.colorScheme.primary,
    thickness: Dp = 8.dp,
    unitOfMeasurement: String  = "mA",
    styleUnitOfMeasurement: TextStyle = TextStyle(
        //LocalTextStyle.current,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontFamily = Alice,
        fontSize = 40.sp,
        color = MaterialTheme.colorScheme.onTertiaryContainer,
    ),
    styleScaleValues: TextStyle = TextStyle(
        textAlign = TextAlign.Center,
        fontSize = 35.sp,
        color = MaterialTheme.colorScheme.onTertiaryContainer,
    ),
    styleRealValue: TextStyle = TextStyle(
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.SansSerif,
        fontSize = 45.sp,
        color = MaterialTheme.colorScheme.secondary,
    )

) {

    val textPosition = unitOfMeasurement //sliderPosition.toInt().toString()

    val textMeasurer = rememberTextMeasurer()

    val textLayoutResult = remember(textPosition) {
        textMeasurer.measure(textPosition, styleUnitOfMeasurement)
    }

    //Контроль на корректность выводимого значения
    val delta = 0.02f * maxValue
    val outValue = if (value > maxValue) maxValue + delta
    else if (value < minValue) minValue - delta
    else value


    Canvas(
        modifier = modifier.background(background)
    ) {
        // ширина индикатора
        val widthIndicator = size.minDimension - 16.dp.toPx()
        val radius = widthIndicator/2
        val minAngle = sweepAngle + startAngle
        val maxAngle = startAngle

        //каркас индикатора
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

        //рисуем деления индикатора со значениями
        writeDivisionsIndicator(
            textMeasurer = textMeasurer,
            drawScope = this,
            color = colorArrow,
            radius = radius,
            minAngle = minAngle,
            maxAngle = maxAngle,
            minValue = minValue,
            maxValue = maxValue,
            quantity = quantity,
            widthDp = if (indentDp>2) indentDp-2 else 2,
            strokeWidth = if (strokeWidth>2f) strokeWidth/2 else 2f,
            isOutValue = true,
            style = styleScaleValues,
            indentTextDp = 60

        )

        //рисуем деления с меньшим шагом
        writeDivisionsIndicator(
            textMeasurer = textMeasurer,
            drawScope = this,
            color = colorArrow,
            radius = radius,
            minAngle = minAngle,
            maxAngle = maxAngle,
            minValue = minValue,
            maxValue = maxValue,
            quantity = quantity*2,
            widthDp = indentDp/2,
            strokeWidth = if (strokeWidth>2f) strokeWidth/2 else 2f,
            isOutValue = false,
            style = styleScaleValues

        )

        //рисуем стрелку индикатора
        writeIndicatorArrow(
            this,
            colorArrow,
            radius,
            sweepAngle + startAngle,
            startAngle,
            minValue,
            maxValue,
            outValue,
            indentDp,
            strokeWidth
        )

        //размещение текста по цетру

        drawText(
            textMeasurer = textMeasurer,
            text = textPosition,
            style = styleUnitOfMeasurement,
            topLeft = Offset(
                x = center.x - textLayoutResult.size.width / 2,
                y = center.y +  20.dp.toPx() ,
            ),
        )

        val textValue = "${value.toInt()} ($unitOfMeasurement)"

        val valueLayout = textMeasurer.measure(textValue,styleRealValue)
        drawText(
            textMeasurer = textMeasurer,
            text = textValue,
            style = styleRealValue,
            topLeft = Offset(
                x = center.x - valueLayout.size.width / 2,
                y = size.height - valueLayout.size.height ,
            ),
        )


        writePointInCenter(this,colorArrow)


    }


}

private fun writeTexttoCanvas(
    textMeasurer: TextMeasurer,
    drawScope: DrawScope,
    outValue: String,
    style: TextStyle,
    x: Float,
    y: Float,

    ) {
    val textLayout = textMeasurer.measure(outValue, style)
    with(drawScope) {
        drawText(
            textMeasurer = textMeasurer,
            text = outValue,
            style = style,
            topLeft = Offset(
                x = x - textLayout.size.width / 2,
                y = y - textLayout.size.height / 2,
            ),
        )

    }
}


//Стрелка индикатора
private fun writeIndicatorArrow(
    drawScope : DrawScope,
    color:Color,
    radius:Float,
    minAngle:Float, //угол при min value
    maxAngle:Float, //угол при max value
    minValue:Float,
    maxValue:Float,
    realValue:Float,    //real value
    indentDp:Int,
    strokeWidth:Float
    ) {
    with(drawScope) {
        //центр индикатора (окружности)
        val x0 = center.x
        val y0 = center.y

        val degrees = valueIntoDegrees(minValue,maxValue,minAngle,maxAngle,realValue)
        val angle = degreesToRadians(degrees)
        val x1 = getPointX(radius - indentDp.dp.toPx(),x0,angle)
        val y1 = getPointY(radius - indentDp.dp.toPx(),y0,angle)
        //рисуем линию
        drawLine(
            start = Offset(x = x0, y = y0),
            end = Offset(x = x1, y = y1),
            strokeWidth = strokeWidth,
            color = color
        )

    }
}

//Центр индикатора
private fun writePointInCenter(drawScope : DrawScope, color:Color){
    with(drawScope){
        drawPoints(
            points = listOf(
                Offset(center.x, center.y),
            ),
            pointMode = PointMode.Points,
            cap = StrokeCap.Round,
            color = color,
            strokeWidth = 30.dp.toPx()
        )

    }
}

//Деления и значения циферблата
private fun writeDivisionsIndicator(
    textMeasurer:TextMeasurer,
    drawScope : DrawScope,
    color:Color,
    radius:Float,
    minAngle:Float, //угол при min value
    maxAngle:Float, //угол при max value
    minValue:Float,
    maxValue:Float,
    quantity:Int,    //кол-во сегментов
    widthDp:Int,
    strokeWidth:Float,
    isOutValue:Boolean,
    style: TextStyle,
    indentTextDp:Int = 50,
) {
    with(drawScope) {
//центр индикатора (окружности)
        val x0 = center.x
        val y0 = center.y

//приращение величины
        val increment = (maxValue - minValue) / quantity

        for (i in 0..quantity){
            val value = minValue + i * increment

            val degrees = valueIntoDegrees(minValue,maxValue,minAngle,maxAngle,value)
            val angle = degreesToRadians(degrees)
            val x1 = getPointX(radius,x0,angle)
            val y1 = getPointY(radius,y0,angle)
            val x2 = getPointX(radius - widthDp.dp.toPx(),x0,angle)
            val y2 = getPointY(radius - widthDp.dp.toPx(),y0,angle)
            //рисуем линию
            drawLine(
                start = Offset(x = x1, y = y1),
                end = Offset(x = x2, y = y2),
                strokeWidth = strokeWidth,
                color = color
            )

            if (isOutValue){
                val xx = getPointX(radius - indentTextDp.dp.toPx(),x0,angle)
                val yy = getPointY(radius - indentTextDp.dp.toPx(),y0,angle)
                writeTexttoCanvas(textMeasurer,drawScope,value.toInt().toString(),style,xx,yy)

            }


        }
    }
}


//пересчет величины в угол(в градусах)
//используем уровнение прямой, проходящей через две точки (x1,y1) (x2,y2)
private fun valueIntoDegrees(
    x1:Float = 0f,        //0 mA     min value
    x2:Float = 1200f,     //1200 mA  max value
    y1:Float = -225f,     //угол при min -225°
    y2:Float = 45f,       //угол при max  45°
    x:Float = 0f,  //физическая лтображаемая величина
):Float = y1 + (y2-y1)/(x2-x1)*(x - x1)

//пересчет градусов в радианы
private fun degreesToRadians(degrees:Float = 0f):Double = degrees * Math.PI / 180

//определение координаты точки Х на окружности с радиусом R с цетром в точке х0
private fun getPointX(
    r:Float = 100f,       //radius
    x0:Float = 0f,        //center
    angle:Double = 100.0, //angle in radians
):Float = (x0 + r * cos(angle)).toFloat()

//определение координаты точки Х на окружности с радиусом R с цетром в точке х0
private fun getPointY(
    r:Float = 100f,       //radius
    y0:Float = 0f,        //center
    angle:Double = 100.0, //angle in radians
):Float = (y0 + r * sin(angle)).toFloat()


@Preview("Light Theme", showBackground = true)
@Composable
fun  ArrowIndicatorPreview() {
    MyTextWithComposeTheme {
        ArrowIndicator(false)
    }
}

@Preview("Light Theme", showBackground = true,widthDp = 1000,heightDp = 400)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES,widthDp = 1000,heightDp = 400)
@Composable
fun  ArrowIndicatorPreviewExpanded() {
    MyTextWithComposeTheme {
        ArrowIndicator(true)
    }
}
