package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun AnimationContent() {

    Column(
        modifier = Modifier
//            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {

        var count by remember { mutableIntStateOf(0) }

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {


            Text(text = "$count")

            AnimatedContent(
                targetState = count,
                label = "animated content"
            ) { targetCount ->
                // Make sure to use `targetCount`, not `count`.
                Text(text = "$targetCount")
            }

            AnimatedContent(
                targetState = count,
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
                }, label = "animated counter"
            ) { targetCount ->
                Text(text = "$targetCount")
            }

            AnimatedCounter(count)


        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = { count++ }) {
                Text("Add")
            }

            Button(onClick = { count-- }) {
                Text("Subb")
            }

        }


        var expanded by remember { mutableStateOf(false) }

        LazyColumn {
            item {
                Surface(
                    color = MaterialTheme.colorScheme.primary,
                    onClick = { expanded = !expanded }
                ) {
                    val color by animateColorAsState(
                        targetValue = if (expanded) MaterialTheme.colorScheme.outlineVariant
                        else MaterialTheme.colorScheme.primary,
                        label = "",
                    )

                    AnimatedContent(
                        targetState = expanded,
                        transitionSpec = {
                            fadeIn(animationSpec = tween(150, 150)) togetherWith
                                    fadeOut(animationSpec = tween(150)) using
                                    SizeTransform { initialSize, targetSize ->
                                        if (targetState) {
                                            keyframes {
                                                // Expand horizontally first.
                                                IntSize(targetSize.width, initialSize.height) at 150
                                                durationMillis = 800
                                            }
                                        } else {
                                            keyframes {
                                                // Shrink vertically first.
                                                IntSize(initialSize.width, targetSize.height) at 150
                                                durationMillis = 300
                                            }
                                        }
                                    }
                        }, label = "size transform"
                    ) { targetExpanded ->
                        if (targetExpanded) {
                            ExpandedText()
                        } else {
                            ContentIcon()
                        }
                    }
                }

            }
        }


    }
}
@Composable
private fun ContentIcon(
    color: Color = MaterialTheme.colorScheme.primary
){
    Row(
        modifier = Modifier
            .background(color)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Text(
            text = "Комментарий ...",
            textAlign = TextAlign.Start,
            fontSize = 20.sp
        )
        Icon(
            Icons.Default.ArrowDropDown, "",
        )
    }
}

@Composable
private fun ExpandedText(
    color: Color = MaterialTheme.colorScheme.outlineVariant
){
    Column(
        modifier = Modifier
            .background(color)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Text(
                text = "Комментарий к примеру",
                modifier = Modifier
                    .fillMaxWidth(0.9F),
                fontSize = 20.sp
            )
            Icon(
                Icons.Default.ArrowDropDown, "",
                modifier = Modifier.rotate(180F)
            )
        }
        Text(
            text = """
В верхней строке представлены черыри варианта отображения значения счетчика:                 

Первое значение:  без анимации;

Все осталые значения отображаются с использованием AnimatedContent

Второе значение: AnimatedContent по умолчанию ;
                        
Третье значение: AnimatedContent с использованием fadeIn/fadeOut b SizeTransform;

Четвертое значение: модификация третьего варианта.
                    """.trimIndent(),
            fontSize = 18.sp

        )
    }
}


@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnimationContentPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AnimationContent()
        }

    }
}
