package com.pvmprog.mytextwithcompose.ui.examples

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AnimatedCounter(
    counter: Int,
    modifier: Modifier = Modifier,
) {
    var oldCounter by remember { mutableIntStateOf(counter) }

    SideEffect {
        oldCounter = counter
    }
    Row(modifier = modifier) {
        val counterStr = counter.toString()
        val oldCounterStr = oldCounter.toString()
        for (i in counterStr.indices) {
            val oldChar = oldCounterStr.getOrNull(i)
            val newChar = counterStr[i]
            val char = if (oldChar == newChar) oldCounterStr[i]
            else counterStr[i]

            AnimatedContent(
                targetState = char,
                transitionSpec = {
// Сравните входящее число с предыдущим числом.
                    if (targetState > initialState) {
// Если целевое число больше, оно скользит вверх и постепенно исчезает.
// в то время как начальное (меньшее) число скользит вверх и исчезает.
                        slideInVertically { height -> height } + fadeIn() togetherWith
                                slideOutVertically { height -> -height } + fadeOut()
                    } else {
// Если целевое число меньше, оно опускается вниз и постепенно увеличивается.
// в то время как начальное число скользит вниз и исчезает.
                        slideInVertically { height -> -height } + fadeIn() togetherWith
                                slideOutVertically { height -> height } + fadeOut()
                    }.using(
// Отключите обрезку, так как плавное появление/исчезновение должно
// отображаться вне границ.
                        SizeTransform(clip = false)
                    )
                }, label = "animated content"
            ) { str ->
                Text(
                    text = str.toString(),
                    softWrap = false
                )

            }
        }


    }


}
