package com.pvmprog.mytextwithcompose.ui.examples

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.math.PI

@OptIn(ExperimentalStdlibApi::class)
@SuppressLint("SimpleDateFormat")
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FormatString(){
    val date = Date()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
//***************
        Text(
            text = "1. Строковая интерполяция",
            fontWeight = FontWeight.Bold
        )
        var name = "Павел"
        val age = 30

        var message = "Меня зовут $name, мне $age лет"
        OutTextInfo(
            formatStr = "\"Меня зовут ${'$'}name, мне ${'$'}age лет\"",
            message = message,
        )

//***************
        Text(
            text = "2. Шаблоны",
            fontWeight = FontWeight.Bold
        )

        val quantity = 10
        val price = 1.23
        val total = price * quantity

        message = "Итого: $quantity тетрадей \nстоят ${"$%.2f".format(total)}"
        OutTextInfo(
            formatStr = "\"Итого: ${'$'}quantity тетрадей \nстоят ${'$'}{\"${'$'}%.2f\".format(total)}\"",
            message = message,

        )

//***************
        Text(
            text = "3. String.format()",
            fontWeight = FontWeight.Bold
        )

        val boolValue = true
        OutTextInfo(
            formatStr = "\"%b\".format(boolValue),\nboolValue=$boolValue",
            message = "%b".format(boolValue)
        )
        val charValue = 'A'
        OutTextInfo(
            formatStr = "\"%c\".format(charValue),\ncharValue='A'",
            message = "%c".format(charValue)
        )
        val intValue = 25
        OutTextInfo(
            formatStr = "\"%d\".format(intValue),\nintValue=$intValue",
            message = "%d".format(intValue)
        )
        OutTextInfo(
            formatStr = "\"%4d\".format(intValue)",
            message = "%4d".format(intValue)
        )
        OutTextInfo(
            formatStr = "\"%04d\".format(intValue)",
            message = "%04d".format(intValue)
        )
        val floatValue = 33.3449f
        OutTextInfo(
            formatStr = "\"%f\".format(floatValue),\nfloatValue=33.3449f",
            message = "%f".format(floatValue)
        )
        OutTextInfo(
            formatStr = "\"%.2f\".format(floatValue)",
            message = "%.2f".format(floatValue)
        )


        val doubleValue = 32.44
        OutTextInfo(
            formatStr = "\"%.1f\".format(doubleValue),\ndoubleValue=32.44",
            message = "%.1f".format(doubleValue)
        )
        val hexValue = 255
        OutTextInfo(
            formatStr = "\"%x\".format(hexValue),\nhexValue = 255",
            message = "%x".format(hexValue)
        )

        OutTextInfo(
            formatStr = "\"%04x\".format(hexValue).uppercase()",
            message = "%04x".format(hexValue).uppercase()
        )

        OutTextInfo(
            formatStr = "hexValue.toHexString()",
            message = hexValue.toHexString()
        )


        OutTextInfo(
            formatStr = "String.format(\"%.2f\", PI)",
            message = String.format("%.2f", PI)
        )
        message = "Пи = $PI"
        OutTextInfo(
            formatStr = "Пи = ${'$'}PI",
            message = message
        )
        OutTextInfo(
            formatStr = "String.format(\"%+.4f\", 3.141592)",
            message = String.format("%+.4f", 3.141592)
        )



//***************
        Text(
            text = "4. Заполнение (padding)",
            fontWeight = FontWeight.Bold
        )
        OutTextInfo(
            formatStr = "\"\".padStart(22,'-')",
            message = "".padStart(22,'-'),
            fontFamily = FontFamily.Monospace

        )
        name = "Иван Иванович"
        OutTextInfo(
            formatStr = "| \${String.format(\"%-20s\", name)} |",
            message = "|${String.format("%-20s", name)}|",
            fontFamily = FontFamily.Monospace

        )
        name = "Семен Семенович"
        OutTextInfo(
            formatStr = "|\${String.format(\"%-20s\", name)}|",
            message = "|${String.format("%-20s", name)}|",
            fontFamily = FontFamily.Monospace

        )
        name = "Петр Петрович"
        OutTextInfo(
            formatStr = "|\${name.padEnd(20,' ')}|",
            message = "|${name.padEnd(20,' ')}|",
            fontFamily = FontFamily.Monospace
        )
        name = "Иван Иванович"
        OutTextInfo(
            formatStr = "|\${name.padStart(20,' ')}|",
            message = "|${name.padStart(20,' ')}|",
            fontFamily = FontFamily.Monospace
        )


        OutTextInfo(
            formatStr = "hexValue.toString(16).toUpperCase().padStart(4,'0')",
            message = hexValue.toString(16).toUpperCase().padStart(4,'0')
        )

        Text(
            text = "5. Дата и время",
            fontWeight = FontWeight.Bold
        )
        message = date.toString()
        OutTextInfo(
            formatStr = "date.toString()",
            message = message
        )

        message = SimpleDateFormat("dd-MM-yyyy").format(date)
        OutTextInfo(
            formatStr = "SimpleDateFormat(\"dd-MM-yyyy\").format(date)",
            message = message
        )

        message = SimpleDateFormat("hh:mm:ss").format(date)
        OutTextInfo(
            formatStr = "SimpleDateFormat(\"hh:mm:ss\").format(date)",
            message = message
        )

        val time = 12567  //длительность в секундах
        message = timeSecondsToStr(time)
        OutTextInfo(
            formatStr = "String.format(\"%02d:%02d:%02d\", hour, minute, second)",
            message = message
        )

        val seconds = timeStrToSeconds(message)
        OutTextInfo(
            formatStr = "seconds.toString()",
            message = seconds.toString()
        )


    }
}

@Composable
fun OutTextInfo(
    formatStr:String = "",
    message:String = "",
    fontFamily:FontFamily = FontFamily.SansSerif
){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formatStr,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 12.sp
        )
        Text(
            text = message,
            textAlign = TextAlign.Center,
            fontFamily = fontFamily
            )

    }

}

// convert int value (seconds) -> "hh:mm:ss"
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

// convert "hh:mm:ss" -> int value (seconds)
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    return try {
        for (part in parts) {
            val number = part.toInt()
            result = result * 60 + number
        }
        result
    }
    catch (e: NumberFormatException) {
        -1
    }
}