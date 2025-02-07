package com.pvmprog.mytextwithcompose.ui.screens

import android.content.res.Configuration
import android.graphics.RuntimeShader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.examples.MessageShadow
import com.pvmprog.mytextwithcompose.ui.service.PrintDateTime
import com.pvmprog.mytextwithcompose.ui.shader.SHADER_GRADIENT
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

//https://ru.pngtree.com/element/down?id=MzcwNDMxOQ==&type=1&time=1738242536&token=NWZjYWRhODEyOGMzZmJmZjk3NzFjZjNiNzY1OTcxNTU=&t=0
//https://developer.android.com/develop/ui/compose/animation/customize?hl=ru
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun GreetingScreen2(
    message: String = stringResource(R.string.text_compose),
    comment: String = stringResource(R.string.in_examples),
    image: Painter = painterResource(id = R.drawable.earth),
    backgroundBox: Painter = painterResource(id = R.drawable.bg2),
    onExit: () -> Unit = {},
    sizeImage: Dp = 300.dp,
    modifier: Modifier = Modifier
) {
    val styleButton = TextStyle(
        fontSize = 36.sp,
        fontWeight = FontWeight.Normal
    )

    // Creates an [InfiniteTransition] instance for managing child animations.
    val infiniteTransition = rememberInfiniteTransition()

    // Создает дочернюю анимацию типа float как часть [InfiniteTransition].
    val angle by
    infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec =
        infiniteRepeatable(
            // Бесконечное повторение анимации длительностью 5000 мс с использованием кривой замедления LinearOutSlowInEasing
            animation = tween(20000, easing = LinearEasing),
            // После каждой итерации анимации (т. е. каждые 5000 мс) анимация будет начинаться снова с [initialValue]
            repeatMode = RepeatMode.Restart
        )
    )


// A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = modifier
                .background(Color(0xFF000000)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = backgroundBox,
                contentDescription = null,
                modifier = Modifier
                    .alpha(0.9f)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .size(sizeImage)
                    .clip(CircleShape)
            ){
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .graphicsLayer {
                            this.transformOrigin =
                                TransformOrigin.Center //TransformOrigin(0.5f, 0.5f) - вращение относительно центра
                            this.rotationX = 0f
                            this.rotationY = 0f
                            this.rotationZ = angle
                        }
                        .alpha(0.9f)
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {
                PrintDateTime(
                    style = TextStyle(
                        fontFamily = Alice,
                        fontSize = 23.sp,
                        color = Color(0xFFFFB873)
                    ),
                    modifier = Modifier
                        .background(Color.Black)
                )
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround

                ) {
                    MessageShadow(
                        message = message,
                        modifier = Modifier
                            .padding(16.dp),
                        style = TextStyle(
                            textAlign = TextAlign.Center,
                            fontFamily = Alice,
                            fontSize = 50.sp,
                            lineHeight = 46.sp,
                            color = Color(0xfffcce36),
                            shadow = Shadow(
                                color = Color.Blue,
                                offset = Offset(3.0f, -10.0f), //смещение тени
                                blurRadius = 0f  //размытие
                            )
                        ),
                    )
                    MessageShaderBrush(
                        message = comment,
                        modifier = Modifier
                            .padding(16.dp),
                        angle = angle,
                        style = TextStyle(
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily.Cursive,
                            fontSize = 50.sp,
                            fontWeight = FontWeight.Bold
                        ),
                    )
/*
                    MessageGradient(
                        message = comment,
                        modifier = Modifier
                            .padding(16.dp),
                        style = TextStyle(
                            textAlign = TextAlign.Center,
                            fontFamily = Alice,
                            fontSize = 35.sp,
                        ),
                    )

 */

                }
                Button(
                    modifier = Modifier
                        .padding(all = dimensionResource(id = R.dimen.padding_medium)),
                    onClick = { onExit() },
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        text = stringResource(R.string.let_s_begin),
                        style = styleButton,
                        textAlign = TextAlign.Center
                    )

                }

            }


        }

    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun MessageShaderBrush(
    message: String = "",
    angle: Float = 0f,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current
) {
    var scaleTime by remember {
        mutableFloatStateOf(0f)
    }
    val startScaleTime = 1f
    val endScaleTime = 25f

    /*
      scaleTime      angle
         1             0
         8            360
     */
    scaleTime = startScaleTime + (endScaleTime - startScaleTime) / 360 * angle

    val shader = RuntimeShader(SHADER_GRADIENT)
    val shaderBrush = ShaderBrush(shader)
    shader.setFloatUniform(
        "iResolution", 300.dp.value, 300.dp.value
    )
    shader.setFloatUniform(
        "iTime", scaleTime
    )

    Text(
        text = message,
        modifier = modifier,
        style = style.merge(
            TextStyle(
                brush = shaderBrush
            )
        ),
    )
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingScreen2Preview() {
    MyTextWithComposeTheme {
        GreetingScreen2()

    }
}
