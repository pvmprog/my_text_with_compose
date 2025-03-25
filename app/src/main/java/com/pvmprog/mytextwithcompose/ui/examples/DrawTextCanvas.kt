package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun DrawTextCanvas(
    textTitle: String = "You have a letter!",
    textMessage: String = "Happy Birthday to You!",
) {
    var isOpen by remember {
        mutableStateOf(false)
    }


    val styleCenter = TextStyle(
        color = Color.White,
        fontSize = 30.sp,
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline
    )

    val styleMessage = TextStyle(
        color = Color.Yellow,
        fontSize = 24.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
    )

    val corner = 8.dp


// get local density from composable
    val density = LocalDensity.current

//initial height set at 100
    var boxHeight by remember { mutableStateOf(100.dp) }
//initial width set at 100
    var boxWidth by remember { mutableStateOf(100.dp) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned {
                boxHeight = with(density) {
                    it.size.height.toDp()
                }
                boxWidth = with(density) {
                    it.size.width.toDp()
                }
            }
            .padding(8.dp)
            .graphicsLayer {
                shadowElevation = corner.toPx()
                shape = RoundedCornerShape(corner)
                clip = true //!!! обрезание всего, что вне формы
            }
            .background(color = Color.Black)
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
        contentAlignment = Alignment.Center
    ){
        var ratio = 1f

        val maxBias = if (boxHeight>boxWidth) boxWidth/2
        else {
            ratio = 1.2f
            boxHeight/2
        }

        val bias: Dp by animateDpAsState(
            targetValue = if (isOpen) maxBias - 10.dp else 0.dp,
            animationSpec = tween(durationMillis = 800, easing = FastOutSlowInEasing),
            label = "bias"
        )

        val modifier = Modifier
            .aspectRatio(ratio)
            .padding(16.dp)
            .background(color = Color.Black)


        Crossfade(
            targetState = isOpen,
            label = "cross fade"
        ) { state ->
            when (state) {
                true -> DrawOnCanvas(modifier,textMessage,styleMessage,{isOpen = !isOpen},bias,state)
                else -> DrawOnCanvas(modifier,textTitle,styleCenter,{isOpen = !isOpen},bias,state)
            }
        }

        val enter = slideInVertically(animationSpec = tween(durationMillis = 2000)) { fullWidth ->
            -fullWidth / 3
        } + fadeIn(animationSpec = tween(durationMillis = 2000))

        val exit = slideOutVertically() + shrinkVertically() + fadeOut() + scaleOut(targetScale = 1.2f)

        val borderWidth = 4.dp

        AnimatedVisibility(
            visible = isOpen,
            enter = enter,
            exit = exit,
        ) {
        Image(
            painter = painterResource(id = R.drawable.kotik2),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            alignment = Alignment.BottomCenter,
            modifier = Modifier
                .widthIn(max = maxBias)
                .border(
                    BorderStroke(borderWidth, Color.Green),
                    RoundedCornerShape(16.dp)
                )
                .background(Color.Yellow)
                .clip(RoundedCornerShape(16.dp))        )
    }


    }



}


@Composable
fun DrawOnCanvas(
    modifier:Modifier = Modifier,
    text:String,
    style:TextStyle = TextStyle.Default,
    onClick: () -> Unit = {},
    bias:Dp = 100.dp,
    state:Boolean = false
){
    val textMeasurer = rememberTextMeasurer()

    val textLayoutCenter = remember(text) {
        textMeasurer.measure(text, style)
    }

    Canvas(
        modifier = modifier
            .clickable { onClick() }
    ) {

        fun drawMyLine(
            start: Offset = Offset(0f,0f),
            end: Offset = Offset(0f,0f),
            color: Color = Color.Yellow,
            strokeWidth:Float = 10f,
            intervals:Float = 10f,
            phase:Float = 10f,
        ){
            drawLine(
                start = start,
                end = end,
                color = color,
                strokeWidth = strokeWidth,
                pathEffect = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(
                        intervals.dp.toPx(),
                        intervals.dp.toPx()
                    ),
                    phase = phase.dp.toPx()
                )
            )
        }


        drawRoundRect(
            color = Color.Green,
            size = size,
            style = Stroke(
                width = 2f.dp.toPx(),
//пунктирная линия
                pathEffect = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(
                        10f.dp.toPx(),
                        10f.dp.toPx()
                    ),
                    phase = 0f
                )
            ),
//закругление углов
            cornerRadius = CornerRadius(
                x = 30.dp.toPx(),
                y = 30.dp.toPx()
            )
        )

        val direct = if (state) -1.5f
        else 1f

//размещение по центру
        drawText(
            textMeasurer = textMeasurer,
            text = text,
            style = style,
            topLeft = Offset(
                x = center.x - textLayoutCenter.size.width / 2,
                y = center.y - (40*direct).dp.toPx() - textLayoutCenter.size.height / 2,
            ),
        )

        //Перенос системы координат в позицию (offsetX,offsetY)
        inset(
            10.dp.toPx()
        ) {
            //Размер области DrawScope автоматически
            //уменьшается по горизонтали и по вертикали

            inset(
                left = 0f,
                top = size.height / 2,
                right = 0f,
                bottom = 0f
            ) {
//рисуем прямоугольник по краям
//всей области DrawScope
                drawRect(
                    color = Color.Cyan,
                    size = size,
                    style = Stroke(
                        width = 2f.dp.toPx(),
                    )
                )

                val point1 = Offset(x = 0f, y = 0f)

                val point2 = Offset(
                    x = size.width/2,
                    y = size.height/2 - bias.toPx()
                )

                drawMyLine(
                    start = point1,
                    end =  point2,
                    color = Color.Cyan,
                    intervals = 5f
                )

                val point3 = Offset(
                    x = size.width,
                    y = 0f
                )

                drawMyLine(
                    start = point2,
                    end =  point3,
                    color = Color.Cyan,
                    intervals = 5f
                )

            }

        }

    }

}


@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("Dark Theme",showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, widthDp = 1000, heightDp = 700)
@Composable
fun DrawTextCanvasPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            DrawTextCanvas()
        }

    }
}

