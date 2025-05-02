package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.ui.examples.data.DataItemParam.listTemperature
import com.pvmprog.mytextwithcompose.ui.examples.data.ItemParam
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme



@Composable
fun VertikalOrientationText(
    isExpanded: Boolean = false,
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
/*
        Text(text = title)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onBackground)
                .height(1.dp)
        )
 */
//        GroupoutParam(isExpanded =isExpanded, title = "Разрежение,мм.вод.ст",list = listUnderpressure )

        GroupoutVertParam(isExpanded =isExpanded, title = "Температура,°C", list = listTemperature, labelSlider = "°C")

    }

}

@Composable
fun GroupoutVertParam(
    isExpanded: Boolean = false,
    title:String = "Разрежение,мм.вод.с ",
    labelSlider: String = "",
    list: List<ItemParam>
){
    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            modifier = Modifier
                .centervertical()
                .rotate(-90f)
                .padding(5.dp),
            )
        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.onBackground)
                .width(1.dp)
        )
        LazyColumn(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val modifier = Modifier
                .fillMaxWidth(if (isExpanded) 0.8f else 1f)

            items(list){
                IndicatorLine(
                    modifier = modifier,
                    title = it.name,
                    value = it.value,
                    minValue = it.min,
                    maxValue = it.max,
                    alarmValue = it.avar,
                    unitOfMeasurement = labelSlider
                )

            }

        }
    }

}

fun Modifier.centervertical() =
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        layout(placeable.height, placeable.width) {
            placeable.place(
                x = -(placeable.width / 2 - placeable.height / 2),
                y = -(placeable.height / 2 - placeable.width / 2)
            )
        }
    }

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun VertikalOrientationTextPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            VertikalOrientationText()
        }

    }
}

/*
https://developer.android.com/reference/kotlin/androidx/compose/foundation/lazy/package-summary#LazyColumn(androidx.compose.ui.Modifier,androidx.compose.foundation.lazy.LazyListState,androidx.compose.foundation.layout.PaddingValues,kotlin.Boolean,androidx.compose.foundation.layout.Arrangement.Vertical,androidx.compose.ui.Alignment.Horizontal,androidx.compose.foundation.gestures.FlingBehavior,kotlin.Boolean,kotlin.Function1)

LazyColumn {
    items(itemsList) { Text("Item is $it") }

    item { Text("Single item") }

    itemsIndexed(itemsIndexedList) { index, item -> Text("Item at index $index is $item") }
}
 */

