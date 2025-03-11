package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.ui.service.RadioButtonColumn
import com.pvmprog.mytextwithcompose.ui.service.RadioButtonRow
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun AnimationVisibilityExpend(
    isScreenExpanded: Boolean = false,
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    val density = LocalDensity.current

    var variantExpend by remember {
        mutableIntStateOf(0)
    }

    val nameVariant: List<String> = remember {
        listOf(
            "Expend",
            "Horiz",
            "Vertic",
            "Common",
        )
    }
    val enter: EnterTransition = when (variantExpend) {
        0 ->
            expandIn(
// Перезаписывает стандартную пружинную анимацию с помощью tween
                animationSpec = tween(1000, easing = LinearOutSlowInEasing),
// Перезаписывает угол содержимого, который был показан первым
                expandFrom = Alignment.BottomStart
            ) {
// Изменяет начальный размер на width=50 , height=50 пикселей
                IntSize(50, 50)
            }

        1 ->
// Устанавливаем начальную ширину 20 (пикселей), по умолчанию 0
            expandHorizontally(
                animationSpec = tween(1000, easing = LinearEasing),
            ) { 10 }

        2 ->
// Устанавливает начальную высоту содержимого 20, показывая только
// верхнюю часть содержимого в начале расширяющейся анимации.
            expandVertically(
                animationSpec = tween(500, easing = LinearEasing),
                expandFrom = Alignment.Top
            ) { 20 }

        3 ->
            slideInVertically {
// Сдвиг на 40 dp сверху
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
// Развернуть сверху
                expandFrom = Alignment.Top
            ) + fadeIn(
// Постепенное появление с начальной альфой 0,3f.
                initialAlpha = 0.3f
            )

        else -> fadeIn()

    }

    val exit: ExitTransition = when (variantExpend) {
        0 ->
            shrinkOut(
                tween(1000, easing = FastOutSlowInEasing),
// Перезаписывает область содержимого, на которой закончится анимация сжатия.
// Следующие параметры сожмут границы клипа содержимого с полного размера
// содержимого до 1/10 ширины и 1/5 высоты. Границы клипа сжатия
// будут всегда выровнены по CenterStart границ полного содержимого.
                shrinkTowards = Alignment.CenterStart
            ) { fullSize ->
// Перезаписывает целевой размер анимации уменьшения.
                IntSize(fullSize.width / 10, fullSize.height / 5)
            }

        1 ->
            shrinkHorizontally(
// Заменяет анимацию по умолчанию на анимацию сжатия.
                animationSpec = tween(500,easing = FastOutSlowInEasing),
// Сжимать к концу (т. е. правый край для LTR, левый край для RTL). По умолчанию
// направление сжатия — к [Alignment.Start]
                shrinkTowards = Alignment.End,
            ) { fullWidth ->
// Установите конечную ширину для анимации сжатия на четверть полной ширины.
                fullWidth / 5
            } + fadeOut(tween(1000, easing = FastOutSlowInEasing))

        2 ->
// Уменьшает содержимое до половины его полной высоты с помощью анимации
            shrinkVertically(animationSpec = tween())
            { fullHeight -> fullHeight / 2 } +
                    fadeOut(tween(1000, easing = FastOutSlowInEasing))

        3 ->
            slideOutVertically() + shrinkVertically() + fadeOut()

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
                    .width(180.dp)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                RadioButtonColumn(
                    indexSelect = variantExpend,
                    items = nameVariant,
                    onClick = {
                        variantExpend = it
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
                    color = Color.Green,
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
                color = Color.Green,
                onClick = { expanded = !expanded },
                modifier = Modifier.weight(1f)
            )
            RadioButtonRow(
                variantExpend,
                nameVariant,
                {
                    variantExpend = it
                    expanded = !expanded
                }
            )
        }
    }

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnimationVisibilityExpendPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AnimationVisibilityExpend()
        }

    }
}
@Preview("Light Theme",showBackground = true, widthDp = 1200)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, widthDp = 1200)
@Composable
fun AnimationVisibilityExpendPreview2() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AnimationVisibilityExpend(isScreenExpanded = true)
        }

    }
}
