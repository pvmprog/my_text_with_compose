package com.pvmprog.mytextwithcompose.ui.shader

import android.graphics.RuntimeShader
import android.os.Build
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.ShaderBrush

/*
 Функция-расширение, применяющая шейдер

 Можно использовать как фон к любому Composable UI-элементу

 */

fun Modifier.shaderAGSL(
    shaderSrc: String = SHADER_GRADIENT
) = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) this.composed {
/*
    val time by produceState(0f) {
        while (true) {
//бесконечня покадровая анимация
            withInfiniteAnimationFrameMillis {
                value = it / 1000f
            }
        }
    }

 */

    val infiniteTransition = rememberInfiniteTransition(
        label = "infinite"
    )

    val time by infiniteTransition.animateValue(
        initialValue = 0f,
        targetValue = 10f,
        typeConverter = Float.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(
                5000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

//drawWithCache позволяет не только рисовать что-либо,
// но и кэшировать значения переменных внутри функции.
// Это дает нам возможность оптимизировать выделение памяти
    Modifier.drawWithCache {
        val shader =
            RuntimeShader(shaderSrc)  //SHADER_WATER SHADER_Discoteq SHADER_SILEXARS SHADER_CLOUDS FRACTAL_PYRAMID
        val shaderBrush = ShaderBrush(shader)
//передача параметров в шейдер при помощи setFloatUniform
// в float2 — два ключа
        shader.setFloatUniform(
            "iResolution", size.width, size.height
        )

        onDrawBehind {

            shader.setFloatUniform(
                "iTime", time
            )

            drawRect(shaderBrush)
        }

    }
} else Modifier
