package com.pvmprog.mytextwithcompose.ui.service

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date

fun getDate(date: Date):String = SimpleDateFormat("dd-MM-yyyy").format(date)

fun getTime(date: Date):String = SimpleDateFormat("hh:mm:ss aa").format(date)

@Composable
fun PrintDateTime(
    style: TextStyle = LocalTextStyle.current,
    modifier:Modifier = Modifier
){
    var dateStr by remember {
        mutableStateOf(getDate(Date()))
    }
    var timeStr by remember {
        mutableStateOf(getTime(Date()))
    }

    LaunchedEffect(Unit) {
        while (true) {
            //задержка 1000 мсек
            delay(1000)
            val date = Date()
            dateStr = getDate(date)
            timeStr = getTime(date)
        }
    }


    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = dateStr,
            modifier = modifier,
            style =style,
        )
        Text(
            text = timeStr,
            modifier = modifier,
            style =style,
            )
    }

}
