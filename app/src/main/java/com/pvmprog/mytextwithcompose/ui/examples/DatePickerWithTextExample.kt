package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.ui.examples.data.DataItemMessageType.statesMes
import com.pvmprog.mytextwithcompose.ui.examples.data.DataItemMessageType.typesOfMessages
import com.pvmprog.mytextwithcompose.ui.examples.data.DataItemReceivedMessages.receivedMessages
import com.pvmprog.mytextwithcompose.ui.examples.data.DataItemReceivedMessages.receivedMessages2
import com.pvmprog.mytextwithcompose.ui.examples.data.ItemMessageType
import com.pvmprog.mytextwithcompose.ui.examples.data.ItemReceivedMessage
import com.pvmprog.mytextwithcompose.ui.examples.data.ItemStateMes
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme
import java.text.DateFormat.getDateInstance
import java.text.DateFormat.getTimeInstance
import java.text.SimpleDateFormat
import java.util.Calendar

@Composable
fun DatePickerWithTextExample(
//    receptionList:List<ItemReceivedMessage> = receivedMessages,
    dateReception:String = "06 мая 2025 г."    //"06/05/2025"
){
    var isDateChange by remember {
        mutableStateOf(false)
    }

    val reception = if (isDateChange) receivedMessages2
        else receivedMessages


    var dateSelected by remember {
        mutableStateOf(dateReception)
    }
    var isDateDialog by remember {
        mutableStateOf(false)
    }
    var selectedDateMillis by remember {
        mutableStateOf(0L)
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
/*
        Text(
            text = dateSelected,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .clickable { isDateDialog = !isDateDialog },
            fontSize = 25.sp
            )

 */

        ButtonWithIconSample(
            text = dateSelected,
            onClick = { isDateDialog = !isDateDialog }
            )


        if (isDateDialog) DatePickerDialogSample(
            isDateDialog,
            {isDateDialog = it},
            {
                selectedDateMillis = it
                isDateChange = !isDateChange
                dateSelected =  getDate(selectedDateMillis) //"dd/MM/yyyy"
            })
        LazyColumn {
            items(reception){
                TextMessage(it)
            }
        }
    }

}

@Composable
fun ButtonWithIconSample(
    text:String = "Выберите дату",
    description:String = "Выбор даты",
    onClick: () -> Unit = {}
) {
    Button(
        onClick = {
            /* Do something! */
            onClick()
        },
        modifier = Modifier
            .padding(top = 8.dp),
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
    ) {
        Icon(
            Icons.Filled.DateRange,
            contentDescription = description,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text)
    }
}

@Composable
fun TextMessage(
    itemReceived: ItemReceivedMessage
    ) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 4.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        val timeMes = itemReceived.hour.toStr2() +":" + itemReceived.minute.toStr2() +":" + itemReceived.second.toStr2()

        val itemMes = if (itemReceived.codeMes < typesOfMessages.size) typesOfMessages[itemReceived.codeMes]
        else ItemMessageType()

        val itemState = if (itemMes.code < statesMes.size) statesMes[itemMes.code]
        else ItemStateMes("","")

        val designation = if (itemReceived.value == 0) itemState.off
        else itemState.on

//0 🟢 ⚪ in:on/off
//1 ➕ ➖ out:вкл/выкл
//2  ❗ 🆗 avar     ❕
//3 ⚠️ 🆗 predupr
//4 ✅ ◽ info


        val type = when(itemMes.code){
            0 -> ""
            1 -> ""
            2 -> "*"
            3 -> "*"
             else -> ""
        }

        var avarPred = when(itemMes.code){
            2 -> 1
            3 -> 2
            else -> 0
        }

        if (itemReceived.value == 0) avarPred = 0


//        val annoteted = buildAnnotatedString {
//            append(" ")
//        }

        Text(timeMes)
        Checkbox(
            checked = itemReceived.value == 1,
            onCheckedChange = null
        )
        Text(
            text = if (type=="*") designation else type
        )
        Text(
            text = itemMes.message,
            color =  when(avarPred) {
                1 -> MaterialTheme.colorScheme.error
                2 -> MaterialTheme.colorScheme.outlineVariant
                else -> MaterialTheme.colorScheme.onBackground
            }
        )
    }
}

fun Int.toStr2():String{
    var s = this.toString()
    if (s.length == 1) s = "0"+s
    return s
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialogSample(
    isOpenDialog:Boolean = false,
    onClick :(Boolean) -> Unit ={},
    onSelected :(Long) -> Unit ={}
) {
// Decoupled snackbar host state from scaffold state for demo purposes.
//    val snackState = remember { SnackbarHostState() }
//    val snackScope = rememberCoroutineScope()
//    SnackbarHost(hostState = snackState, Modifier)

    val openDialog = remember { mutableStateOf(isOpenDialog) }
    // TODO demo how to read the selected date from the state.
    if (openDialog.value) {
        val datePickerState = rememberDatePickerState()
        val confirmEnabled = remember {
            derivedStateOf { datePickerState.selectedDateMillis != null }
        }
        DatePickerDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onDismissRequest.
                openDialog.value = false
                onClick(false)
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        onClick(false)
                        val ml = datePickerState.selectedDateMillis
                        if (ml != null) {
                            onSelected(ml)
                        }
/*
                        snackScope.launch {
                            snackState.showSnackbar(
                                "Selected date timestamp: ${datePickerState.selectedDateMillis}"
                            )
                        }

 */

                    },
                    enabled = confirmEnabled.value
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { openDialog.value = false }) { Text("Cancel") }
            }
        ) {
            // The verticalScroll will allow scrolling to show the entire month in case there is not
            // enough horizontal space (for example, when in landscape mode).
            // Note that it's still currently recommended to use a DisplayMode.Input at the state in
            // those cases.
            DatePicker(
                state = datePickerState,
                modifier = Modifier.verticalScroll(rememberScrollState())
            )
        }
    }
}


fun getDate(
    milliSeconds: Long,
//    dateFormat: String? = "dd/MM/yyyy hh:mm:ss.SSS"
): String {
    // Create a DateFormatter object for displaying date in specified format.
//    val formatter = SimpleDateFormat(dateFormat)
    val formatter = getDateInstance()
//    val timeformated = getTimeInstance()

    // Create a calendar object that will convert the date and time value in milliseconds to date.
    val calendar: Calendar = Calendar.getInstance()
    calendar.setTimeInMillis(milliSeconds)
    return formatter.format(calendar.getTime())
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DatePickerWithTextExamplePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            DatePickerWithTextExample()
        }

    }
}
