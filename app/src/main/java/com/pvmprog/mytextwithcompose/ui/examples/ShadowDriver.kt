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
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.service.ColorSelect
import com.pvmprog.mytextwithcompose.ui.service.SliderSimple
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun ShadowDriver(){
    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val offsetX = remember {
        mutableFloatStateOf(2f)
    }
    val offsetY = remember {
        mutableFloatStateOf(6f)
    }

    val blur = remember {
        mutableFloatStateOf(2f)
    }

    val fontSize = remember {
        mutableFloatStateOf(45f)
    }

    var indexColor by remember { mutableIntStateOf(-1) }

    var colorTxt by remember {
        mutableStateOf(Color(0xfffcce36))
    }
    var colorSh by remember {
        mutableStateOf(Color(0xffff0000))
    }
    var colorBg by remember {
        mutableStateOf(Color(0xff0000ff))
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.White)
                .background(colorBg)
                .heightIn(min = 150.dp)
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {

            MessageShadow(
                message = stringResource(R.string.hello_world),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontFamily = Alice,
                    fontSize = fontSize.floatValue.sp,
                    lineHeight = (fontSize.floatValue + 10).sp,
                    color = colorTxt,
                    shadow = Shadow(
                        color = colorSh,
                        offset = Offset(offsetX.floatValue, offsetY.floatValue), //смещение тени
                        blurRadius = blur.floatValue  //размытие
                    )
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
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

                        SliderSimple("size",fontSize,12f,80f)

                        SliderSimple("offsetX",offsetX,-20f,20f)

                        SliderSimple("offsetY",offsetY,-20f,20f)

                        SliderSimple("blur...",blur,0f,20f)

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
                                    .background(colorTxt)
                                    .size(40.dp)
                                    .clickable {
                                        indexColor = 0
                                    }
                            )
                            Box(
                                modifier = Modifier
                                    .padding(padding)
                                    .background(colorSh)
                                    .size(40.dp)
                                    .clickable {
                                        indexColor = 1
                                    }
                            )
                            Box(
                                modifier = Modifier
                                    .padding(padding)
                                    .background(colorBg)
                                    .size(40.dp)
                                    .clickable {
                                        indexColor = 2
                                    }
                            )
                        }

                    } else{
                        ColorSelect(
                            colorCurrent = when(indexColor){
                                0 -> colorTxt
                                1 -> colorSh
                                else -> colorBg
                            },
                            onColorSelect ={
                                when(indexColor){
                                    0 -> colorTxt = it
                                    1 -> colorSh = it
                                    else -> colorBg = it
                                }
                                indexColor = -1
                            },
                            title = when(indexColor){
                                0 -> "Выберите цвет текста"
                                1 -> "Выберите цвет тени"
                                else -> "Выберите цвет фона"
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
fun ShadowDriverPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ShadowDriver()
        }

    }
}
