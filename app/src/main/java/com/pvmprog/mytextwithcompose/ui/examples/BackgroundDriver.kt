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
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.data.locale.DataColor
import com.pvmprog.mytextwithcompose.ui.service.ColorSelect
import com.pvmprog.mytextwithcompose.ui.service.SliderSimple
import com.pvmprog.mytextwithcompose.ui.service.contrast_ratio_calculation
import com.pvmprog.mytextwithcompose.ui.service.contrast_ratio_comment
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun BackgroundDriver(
    message: String = stringResource(R.string.text_compose),

    ){

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val fontSize = remember {
        mutableFloatStateOf(35f)
    }


    var indexColor by remember { mutableIntStateOf(-1) }

    var colorBg by remember {
        mutableStateOf(DataColor.colors[8])
    }
    var colorTx by remember {
        mutableStateOf(DataColor.colors[12])
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(padding)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.White)
                .background(colorBg)
                .widthIn(min = 150.dp)
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = message,
                modifier = Modifier
                    .padding(16.dp),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontFamily = Alice,
                    fontSize = fontSize.floatValue.sp,
                    lineHeight = fontSize.floatValue.sp,
                    color = colorTx
                ),
            )
        }
        val k = contrast_ratio_calculation(colorTx,colorBg)
        val status = stringResource(id = R.string.сontrast,k) + contrast_ratio_comment(k)
        Text(
            text = status,
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
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

                        SliderSimple("size",fontSize,10f,50f)

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
                                    .border(1.dp, MaterialTheme.colorScheme.onBackground)
                                    .background(colorBg)
                                    .size(40.dp)
                                    .clickable {
                                        indexColor = 0
                                    }
                            )
                            Box(
                                modifier = Modifier
                                    .padding(padding)
                                    .border(1.dp, MaterialTheme.colorScheme.onBackground)
                                    .background(colorTx)
                                    .size(40.dp)
                                    .clickable {
                                        indexColor = 1
                                    }
                            )
                        }
                    } else{
                        ColorSelect(
                            colorCurrent = when(indexColor){
                                0 -> colorBg
                                else -> colorTx
                            },
                            onColorSelect ={
                                when(indexColor){
                                    0 -> colorBg = it
                                    else -> colorTx = it
                                }
                                indexColor = -1
                            },
                            title = when(indexColor){
                                0 -> "Выберите цвет фона"
                                else -> "Выберите цвет текста"
                            },

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
fun BackgroundDriverPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            BackgroundDriver()
        }

    }
}
