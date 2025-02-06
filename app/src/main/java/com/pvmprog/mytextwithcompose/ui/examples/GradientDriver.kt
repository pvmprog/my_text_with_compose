package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.service.RadioButtonRow
import com.pvmprog.mytextwithcompose.ui.service.SliderSimple
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme
import com.pvmprog.mytextwithcompose.ui.service.ColorSelect as ColorSelect

@Composable
fun GradientDriver(
    isExpanded: Boolean = false,
){
    val padding = dimensionResource(
        id = R.dimen.padding_medium
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
        mutableStateOf(Color.Cyan)
    }
    var color2 by remember {
        mutableStateOf(Color.Yellow)
    }
    var color3 by remember {
        mutableStateOf(Color.Green)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.White)
                .background(Color.Black)
                .widthIn(min = 150.dp)
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            MessageGradient(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.Black)
                    .padding(16.dp),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontFamily = Alice,
                    fontSize = fontSize.floatValue.sp,
                    lineHeight = fontSize.floatValue.sp,
                ),
                brushColors = listOf(
                    color1,
                    color2,
                    color3,
                ),
                StartDp = startX.floatValue.toInt(),
                endDp = endX.floatValue.toInt(),
                tileMode = when(indexTileModes){
                    1 -> TileMode.Mirror
                    2 -> TileMode.Decal
                    3 -> TileMode.Repeated
                    else -> TileMode.Mirror

                }
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(padding)
                ) {
                    if (indexColor == -1){

                        SliderSimple("size",fontSize,20f,100f)

                        SliderSimple("startX",startX,0f,400f)

                        SliderSimple("endX",endX,0f,400f)

                        RadioButtonRow(indexTileModes,tileModes,{indexTileModes = it})


                        Row(
                            modifier = Modifier
                                .padding(padding)
                                .widthIn(max = 250.dp),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(padding)
                                    .background(color1)
                                    .size(40.dp)
                                    .clickable {
                                        indexColor = 0
                                    }
                            )
                            Box(
                                modifier = Modifier
                                    .padding(padding)
                                    .background(color2)
                                    .size(40.dp)
                                    .clickable {
                                        indexColor = 1
                                    }
                            )
                            Box(
                                modifier = Modifier
                                    .padding(padding)
                                    .background(color3)
                                    .size(40.dp)
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
                            }
                        )

                    }


                }

            }

        }
    }
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GradientDriverPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            GradientDriver()
        }

    }
}
@Preview("Light Theme",showBackground = true, widthDp = 1000)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, widthDp = 1000)
@Composable
fun GradientDriverPreview2() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            GradientDriver(isExpanded = true)
        }

    }
}
