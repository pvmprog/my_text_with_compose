package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

data class ItemState( // use val instead of var, so you cannot change it
    val title: String = "",
    val checkedState: Boolean = false,
)


object DataItemStates {
    val kbStatesIn: List<ItemState> = listOf(
        ItemState("Авария: BДГ",false),
        ItemState("Авария: НДГ",false),
        ItemState("Авария: НРП",false),
        ItemState("Авария: НДВ",false),
        ItemState("Дымосос выключен",false),
        ItemState("Наличие пламени",true),
        ItemState("Кнопка: Аварийный STOP",false),
        ItemState("Кнопка: Ручной поджиг",false),
    )
    val kbStatesOut: List<ItemState> = listOf(
        ItemState("Продувка",false),
        ItemState("Поджиг разрешен",true),
        ItemState("Защита печи включена",false),
        ItemState("Отсечение газа",false),
        ItemState("Запрет работы",false),
        ItemState("Температура КУ > 500°C",false),
        ItemState("Ошибка наличия пламени",false),
    )
}


@Composable
fun CheckboxWithTextExample(
    isExpanded: Boolean = false,
    ) {
    var selectedIndex by remember { mutableStateOf(0) }
    val options = listOf("КБ (входы)", "КБ (выходы)")
    val listIn: List<ItemState> = DataItemStates.kbStatesIn
    val listOut: List<ItemState> = DataItemStates.kbStatesOut
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SegmentedButtonSelect(selectedIndex,options,{selectedIndex = it})

        when (selectedIndex){
            0 -> GroupoutCheckbox(listIn)
            else -> GroupoutCheckbox(listOut)
        }
    }


}

@Composable
fun GroupoutCheckbox(
    list: List<ItemState> = DataItemStates.kbStatesIn
){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        items(list) {
            CheckboxWithTextSample(it.title,it.checkedState)
        }
    }
}

@Composable
fun CheckboxWithTextSample(
    nameOption: String = "Option selection",
    checkedState:Boolean = false,
    onStateChange:(Boolean) -> Unit = {}
) {
//    val (checkedState, onStateChange) = remember { mutableStateOf(true) }
    Row(
        Modifier
//            .fillMaxWidth()
//            .height(56.dp)
            .toggleable(
                value = checkedState,
                onValueChange = { onStateChange(!checkedState) },
                role = Role.Checkbox
            )
            .padding(top = 4.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = null // null recommended for accessibility with screenreaders
        )
        Text(
            text = nameOption,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CheckboxWithTextExamplePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            CheckboxWithTextExample()
        }

    }
}

/*
options.forEachIndexed { index, task ->
    Checkbox(
        checked = task.completed,
        onCheckedChange = { checked ->
            tasks[index] = task.copy(completed = checked)
        }
    )
}
*/
