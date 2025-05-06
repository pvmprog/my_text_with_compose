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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.ui.examples.data.DataItemMessageType.typesOfMessages
import com.pvmprog.mytextwithcompose.ui.examples.data.DataItemStates
import com.pvmprog.mytextwithcompose.ui.examples.data.ItemState
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme




@Composable
fun CheckboxWithTextExample(
    isExpanded: Boolean = false,
    ) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("КБ (входы)", "КБ (выходы)")
    val listIn: List<ItemState> = DataItemStates.kbStatesIn
    val listOut: List<ItemState> = DataItemStates.kbStatesOut
    val dateTime: String = "05/05/2025 15:23:45"
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(dateTime)
        SegmentedButtonSelect(selectedIndex,options,{ selectedIndex = it } )
        when (selectedIndex){
            0 -> GroupoutCheckbox(listIn)
            else -> GroupoutCheckbox(listOut)
        }
    }


}

@Composable
fun GroupoutCheckbox(
    list: List<ItemState>  = DataItemStates.kbStatesIn
){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        items(list){
            CheckboxWithTextSample(it.idMes,it.checkedState)
        }
    }


}

@Composable
fun CheckboxWithTextSample(
    codeOption: Int = 0,
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

        var avarPred = 0
        val text = if (codeOption < typesOfMessages.size) {
            if (typesOfMessages[codeOption].code == 2) avarPred = 1
            if (typesOfMessages[codeOption].code == 3) avarPred = 2
            if (!checkedState) avarPred = 0
            typesOfMessages[codeOption].message
        } else ""

        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color =  when(avarPred) {
                1 -> MaterialTheme.colorScheme.error
                2 -> MaterialTheme.colorScheme.outlineVariant
                else -> MaterialTheme.colorScheme.onBackground
            },
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
