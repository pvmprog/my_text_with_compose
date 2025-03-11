package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.ui.service.RadioButtonColumn
import com.pvmprog.mytextwithcompose.ui.service.RadioButtonRow
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme


@Composable
fun AnimationVisibilitySlade(
    isScreenExpanded: Boolean = false,
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    var variantSlade by remember {
        mutableIntStateOf(0)
    }
    val nameVariant: List<String> = remember {
        listOf(
            "Slade",
            "Horiz",
            "Vert",
        )
    }
    val enter: EnterTransition = when (variantSlade) {
        0 ->
            slideIn(tween(100, easing = LinearOutSlowInEasing)) { fullSize ->
// Задает начальное смещение слайда, равное 1/4 ширины вправо,
// на 100 (пикселей) ниже позиции содержимого, что приводит к одновременному скольжению вверх
// и влево.
                IntOffset(fullSize.width / 4, 100)
            }

        1 ->
            slideInHorizontally(
                animationSpec = tween(durationMillis = 200)
            ) { fullWidth ->
// Смещает содержимое на 1/3 его ширины влево и сдвигает вправо
                -fullWidth / 3
            } +
                    fadeIn(
                        animationSpec = tween(durationMillis = 200)
                    )

        2 ->
            slideInVertically(
// Начало слайда с 40 (пикселей) выше, где должен быть контент,
// чтобы создать эффект параллакса
                initialOffsetY = { -40 }
            ) +
                    expandVertically(expandFrom = Alignment.Top) +
                    scaleIn(
// Анимируем масштаб от 0f до 1f, используя верхний центр в качестве точки поворота.
                        transformOrigin = TransformOrigin(0.5f, 0f)
                    ) +
                    fadeIn(initialAlpha = 0.3f)

        else -> fadeIn()

    }

    val exit: ExitTransition = when (variantSlade) {
        0 ->
// Смещение может быть полностью независимым от размера содержимого. Это задает
// целевое смещение на 180 пикселей влево от содержимого и на 50 пикселей вниз. Это
// создаст слайд-влево, совмещенный со слайд-вниз.
            slideOut(tween(100, easing = FastOutSlowInEasing)) {
                IntOffset(-180, 50)
            }

        1 ->
            slideOutHorizontally(
                animationSpec = spring(stiffness = Spring.StiffnessHigh)
            ) {
// Перезаписывает конечную позицию слайдера на 200 (пикселей) вправо.
                200
            } + fadeOut()

        2 ->
            slideOutVertically() +
                    shrinkVertically() +
                    fadeOut() +
                    scaleOut(targetScale = 1.2f)

        else -> fadeOut()
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
                    indexSelect = variantSlade,
                    items = nameVariant,
                    onClick = {
                        variantSlade = it
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
                    color = Color.Cyan,
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
                color = Color.Cyan,
                onClick = { expanded = !expanded },
                modifier = Modifier.weight(1f)
            )
            RadioButtonRow(
                variantSlade,
                nameVariant,
                {
                    variantSlade = it
                    expanded = !expanded
                }
            )
        }
    }

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnimationVisibilitySladePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AnimationVisibilitySlade()
        }

    }
}
@Preview("Light Theme",showBackground = true, widthDp = 1200)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, widthDp = 1200)
@Composable
fun AnimationVisibilitySladePreview2() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AnimationVisibilitySlade(isScreenExpanded = true)
        }

    }
}

