package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.service.ColorSelect
import com.pvmprog.mytextwithcompose.ui.service.RadioButtonColumn
import com.pvmprog.mytextwithcompose.ui.service.RadioButtonRow
import com.pvmprog.mytextwithcompose.ui.service.SliderSimple
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme


@Composable
fun GradientOverview(
    isExpanded: Boolean = false,
){
    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    var indexSelect by remember { mutableIntStateOf(4) }

    val gradients = listOf(
        "linearGradient",
        "horizontalGradient",
        "verticalGradient",
        "sweepGradient",
        "radialGradient",
    )

    val startX = remember {
        mutableFloatStateOf(0f)
    }
    val endX = remember {
        mutableFloatStateOf(100f)
    }

    val fontSize = remember {
        mutableFloatStateOf(35f)
    }

    var indexTileModes by remember { mutableIntStateOf(1) }

    val tileModes: List<String> = remember {
        listOf(
            "Clamp",
            "Mirror",
            "Decal",
            "Repeated"
        )
    }

    var indexColor by remember { mutableIntStateOf(-1) }

    var color1 by remember {
        mutableStateOf(Color.Red)
    }
    var color2 by remember {
        mutableStateOf(Color.Blue)
    }
    var color3 by remember {
        mutableStateOf(Color.White)
    }

@Composable
fun ControlComponents(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(padding)
    ) {
        if (indexColor == -1){
            var titleSlider1 = "startX"
            var titleSlider2 = "endX"

            when(indexSelect){
                0,3 -> {
                    titleSlider1 = "OffsetX"
                    titleSlider2 = "Offsety"
                }
                2 -> {
                    titleSlider1 = "startY"
                    titleSlider2 = "endY"
                }
                4 -> {
                    titleSlider2 = "radius"
                }

            }

            SliderSimple("size",fontSize,20f,50f)

            if (indexSelect != 4) {
                SliderSimple(titleSlider1, startX, 0f, 400f)
            }

            SliderSimple(titleSlider2,endX,0f,400f)

            if (indexSelect != 3){
                RadioButtonRow(indexTileModes,tileModes,{indexTileModes = it})
            }


            Row(
                modifier = Modifier
                    .padding(padding)
                    .widthIn(max = 250.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val modifierBox = Modifier
                    .padding(padding)
                    .border(1.dp, MaterialTheme.colorScheme.onBackground)
                    .size(40.dp)

                Box(
                    modifier = modifierBox
                        .background(color1)
                        .clickable {
                            indexColor = 0
                        }
                )
                Box(
                    modifier = modifierBox
                        .background(color2)
                        .clickable {
                            indexColor = 1
                        }
                )
                Box(
                    modifier = modifierBox
                        .background(color3)
                        .clickable {
                            indexColor = 2
                        }
                )
            }
        } else{
            ColorSelect(
                colorCurrent = when(indexColor){
                    0 -> color1
                    1 -> color2
                    else -> color3
                },
                onColorSelect ={
                    when(indexColor){
                        0 -> color1 = it
                        1 -> color2 = it
                        else -> color3 = it
                    }
                    indexColor = -1
                },
                title = when(indexColor){
                    0 -> "Выберите цвет 1 фона"
                    1 -> "Выберите цвет 2 фона"
                    else -> "Выберите цвет текста"
                },

            )

        }


    }

}

    if (isExpanded) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .width(100.dp)
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                RadioButtonColumn(
                    indexSelect = indexSelect,
                    items = listOf(
                        "l",
                        "h",
                        "v",
                        "s",
                        "r",
                    ),
                    onClick = { indexSelect = it },
                    modifier = Modifier
                        .fillMaxHeight()

                )
            }
            Column(
                modifier = Modifier
                    .weight(1f),
            ) {
                BackgroundWithBrush(
                    indexSelect = indexSelect,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth(),
                    colors = listOf(color1,color2),
                    StartDp = startX.floatValue.toInt(),
                    endDp = endX.floatValue.toInt(),
                    tileMode = when(indexTileModes){
                        1 -> TileMode.Mirror
                        2 -> TileMode.Decal
                        3 -> TileMode.Repeated
                        else -> TileMode.Mirror
                    },
                    style = MaterialTheme.typography.bodyMedium.merge(
                        TextStyle(
                            fontSize = fontSize.floatValue.sp,
                            textAlign = TextAlign.Center,
                            color = color3,
                            fontFamily = FontFamily.Serif //шрифт с засечками
                        )
                    ),

                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    item {
                        ControlComponents()
                    }
                }

            }

        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BackgroundWithBrush(
                indexSelect = indexSelect,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                colors = listOf(color1,color2),
                StartDp = startX.floatValue.toInt(),
                endDp = endX.floatValue.toInt(),
                tileMode = when(indexTileModes){
                    1 -> TileMode.Mirror
                    2 -> TileMode.Decal
                    3 -> TileMode.Repeated
                    else -> TileMode.Mirror
                },
                style = MaterialTheme.typography.bodyMedium.merge(
                    TextStyle(
                        fontSize = fontSize.floatValue.sp,
                        textAlign = TextAlign.Center,
                        color = color3,
                        fontFamily = FontFamily.Serif //шрифт с засечками
                    )
                ),

            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                    ) {
                        RadioButtonColumn(
                            indexSelect = indexSelect,
                            items = gradients,
                            onClick = { indexSelect = it },
                        )
                    }
                    ControlComponents()
                }
            }

        }

    }


}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GradientOverviewPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            GradientOverview()
        }

    }
}
@Preview("Light Theme",showBackground = true, widthDp = 1000)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, widthDp = 1000)
@Composable
fun GradientOverviewPreview2() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            GradientOverview(isExpanded = true)
        }

    }
}
