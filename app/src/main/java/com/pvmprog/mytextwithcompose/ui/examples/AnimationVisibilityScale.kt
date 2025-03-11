package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.ui.service.RadioButtonColumn
import com.pvmprog.mytextwithcompose.ui.service.RadioButtonRow
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun AnimationVisibilityScale(
    isScreenExpanded: Boolean = false,
) {
    var expanded by remember {
        mutableStateOf(true)
    }
    var variantScale by remember {
        mutableIntStateOf(0)
    }
    val nameVariant: List<String> = remember {
        listOf(
            "V1",
            "V2",
            "V3",
            "V4"
        )
    }
    val enter: EnterTransition = when (variantScale) {
        0 ->
// По умолчанию `scaleIn` использует центр в качестве точки поворота.
// При использовании с expandVertically от вертикального центра содержимое будет расти от центра
// вертикально расширяющегося макета.
            scaleIn() + expandVertically(expandFrom = Alignment.CenterVertically)

        1 ->
// Масштабируем от TopLeft, установив TransformOrigin на (0f, 0f), одновременно расширяя
// размер макета от начала Top и постепенного затухания.
// Это создаст согласованный вид, как будто масштаб влияет на размер
            scaleIn(
                animationSpec = tween(durationMillis = 1000),
                transformOrigin = TransformOrigin(0f, 0f)) +
                    fadeIn() +
                    expandIn(expandFrom = Alignment.TopStart)
        2 ->
            scaleIn(
                animationSpec = tween(durationMillis = 1000),
                transformOrigin = TransformOrigin(1f, 0f)) +
                    fadeIn() +
                    expandIn(expandFrom = Alignment.TopEnd)
        3 ->
            scaleIn(
                animationSpec = tween(durationMillis = 1000),
                transformOrigin = TransformOrigin(1f, 1f)
            ) +
                    fadeIn() +
                    expandIn(expandFrom = Alignment.BottomEnd)

        else -> scaleIn() + expandVertically(expandFrom = Alignment.CenterVertically)
    }

    val exit: ExitTransition = when (variantScale) {
        0 ->
// По умолчанию `scaleOut` использует центр в качестве точки поворота.
// При использовании с ExitTransition, который сжимается к центру, содержимое будет сжиматься как
// по масштабу, так и по размеру макета к центру.
            scaleOut() + shrinkVertically(shrinkTowards = Alignment.CenterVertically)

        1 ->
// Уменьшите масштаб от TopLeft, установив TransformOrigin на (0f, 0f),
// одновременно сжимая макет к началу Top и затухая.
// Это создаст согласованный вид, как будто масштаб влияет на размер макета.
            scaleOut(transformOrigin = TransformOrigin(0f, 0f)) +
                    fadeOut() +
                    shrinkOut(shrinkTowards = Alignment.TopStart)

        2 ->
            scaleOut(
                animationSpec = tween(durationMillis = 1000),
            ) +
                    shrinkVertically(shrinkTowards = Alignment.Bottom)

        3 ->
            scaleOut(
                animationSpec = tween(durationMillis = 1000),
                transformOrigin = TransformOrigin(1f, 0f)
            ) +
                    shrinkOut(
                        animationSpec = tween(durationMillis = 1000),
                        shrinkTowards = Alignment.BottomEnd
                    )

        else -> scaleOut()
    }

    if (isScreenExpanded) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .width(150.dp)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                RadioButtonColumn(
                    indexSelect = variantScale,
                    items = nameVariant,
                    onClick = {
                        variantScale = it
                        expanded = !expanded
                    },
                    modifier = Modifier
                        .fillMaxHeight()
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f),
            ) {
                AnimationVisibilityContent(
                    enter=enter,
                    exit = exit,
                    expanded = expanded,
                    color = Color.Yellow,
                    onClick = { expanded = !expanded },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AnimationVisibilityContent(
                enter=enter,
                exit = exit,
                expanded = expanded,
                color = Color.Yellow,
                onClick = { expanded = !expanded },
                modifier = Modifier.weight(1f)
            )
            RadioButtonRow(
                variantScale,
                nameVariant,
                {
                    variantScale = it
                    expanded = !expanded
                }
            )
        }
    }

}


@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnimationVisibilityScalePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AnimationVisibilityScale()
        }

    }
}
@Preview("Light Theme",showBackground = true, widthDp = 1200)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, widthDp = 1200)
@Composable
fun AnimationVisibilityScalePreview2() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AnimationVisibilityScale(isScreenExpanded = true)
        }

    }
}

