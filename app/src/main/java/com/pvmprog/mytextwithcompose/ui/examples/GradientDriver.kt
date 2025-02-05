package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.service.RadioButtonRow
import com.pvmprog.mytextwithcompose.ui.service.SliderSimple
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun GradientDriver(
    isExpanded: Boolean = false,
){

    val startX = remember {
        mutableFloatStateOf(0f)
    }
    val endX = remember {
        mutableFloatStateOf(100f)
    }

    var indexSelect by remember { mutableIntStateOf(1) }

    val items: List<String> = remember {
        listOf(
            "Clamp",
            "Mirror",
            "Decal",
            "Repeated"
        )
    }

    if (isExpanded) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(0.7f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                SliderSimple("startX",startX,0f,400f)

                SliderSimple("endX",endX,0f,400f)

                RadioButtonRow(indexSelect,items,{indexSelect = it})
            }
            Column(
                modifier = Modifier.weight(1f),
            ) {
                MessageGradient(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color.Black)
                        .padding(16.dp),
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontFamily = Alice,
                        fontSize = 35.sp,
                        lineHeight = 46.sp,
                    ),
                    brushColors = listOf(
                        Color.Cyan,
                        Color.Yellow,
                        Color.Green,
                    ),
                    StartDp = startX.floatValue.toInt(),
                    endDp = endX.floatValue.toInt(),
                    tileMode = when(indexSelect){
                        1 -> TileMode.Mirror
                        2 -> TileMode.Decal
                        3 -> TileMode.Repeated
                        else -> TileMode.Mirror

                    }
                )

            }

        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
        ) {
            item{
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    SliderSimple("startX",startX,0f,400f)

                    SliderSimple("endX",endX,0f,400f)

                    RadioButtonRow(indexSelect,items,{indexSelect = it})
                }
                MessageGradient(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color.Black)
                        .padding(16.dp),
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontFamily = Alice,
                        fontSize = 35.sp,
                        lineHeight = 46.sp,
                    ),
                    brushColors = listOf(
                        Color.Cyan,
                        Color.Yellow,
                        Color.Green,
                    ),
                    StartDp = startX.floatValue.toInt(),
                    endDp = endX.floatValue.toInt(),
                    tileMode = when(indexSelect){
                        1 -> TileMode.Mirror
                        2 -> TileMode.Decal
                        3 -> TileMode.Repeated
                        else -> TileMode.Mirror

                    }
                )

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
