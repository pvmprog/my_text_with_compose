package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.ui.examples.data.DataItemParam
import com.pvmprog.mytextwithcompose.ui.examples.data.DataItemParam.listGaz
import com.pvmprog.mytextwithcompose.ui.examples.data.DataItemParam.listUnderpressure
import com.pvmprog.mytextwithcompose.ui.examples.data.ItemParam
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun SegmentedButtonExample(
    isExpanded: Boolean = false,
) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("Температура", "Давление","Газ")
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SegmentedButtonSelect(selectedIndex,options,{selectedIndex = it})

        when (selectedIndex){
            0 -> GroupoutParam(isExpanded =isExpanded, list = DataItemParam.listTemperature)
            1 -> GroupoutParam(isExpanded =isExpanded, list = listUnderpressure)
            2 -> GroupoutParam(isExpanded =isExpanded, list = listGaz)
            else -> GroupoutParam(isExpanded =isExpanded,  list = DataItemParam.listTemperature)
        }




    }


}

@Composable
fun SegmentedButtonSelect(
    selectedIndex: Int = 0,
    options: List<String> = listOf("Day", "Month", "Week"),
    onClick :(Int) -> Unit ={}
) {
    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                onClick = { onClick(index) },
                selected = index == selectedIndex
            ) {
                Text(label)
            }
        }
    }
}

@Composable
fun GroupoutParam(
    isExpanded: Boolean = false,
    list: List<ItemParam>
){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val modifier = Modifier
            .fillMaxWidth(if (isExpanded) 0.8f else 1f)

        items(list){
            val unitOfVal = if (it.type < DataItemParam.sliders.size) DataItemParam.sliders[it.type]
            else buildAnnotatedString { append(" ") }

            IndicatorPMLine(
                modifier = modifier,
                title = it.name,
                value = it.value,
                minValue = it.min,
                maxValue = it.max,
                alarmValue = it.avar,
                unitOfMeasurement = unitOfVal,
                quantity = it.quantity,
                isOutAvar = it.isOutAvar
            )

        }

    }

}



@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SegmentedButtonExamplePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            SegmentedButtonExample()
        }

    }
}
