package com.pvmprog.mytextwithcompose.ui.examples.data

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

data class ItemParam(
    val name: String = "",
    val value:Float = 0f,
    val min:Float = 0f,
    val max:Float = 100f,
    val avar:Float = 0f,
    val quantity:Int = 8,
    val isOutAvar:Boolean = false,
    val type:Int = 0
)

object DataItemParam {

    val sliders: List<AnnotatedString> = listOf(
        //0
        buildAnnotatedString { append(" ") },
        //1
        buildAnnotatedString { append("°C") },
        //2
        buildAnnotatedString { append("мм.в.ст") },
        //3
        buildAnnotatedString { append("КПа") },
        //4 м3/ч
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal,
                )
            ) {
                append("м")
            }
            withStyle(style = SpanStyle(
                baselineShift = BaselineShift.Superscript,
                fontSize = 12.sp
            )
            ) {
                append("3")
            }
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal,
                )
            ) {
                append("/ч")
            }
        },

        )

    val listGaz: List<ItemParam> = listOf(
        ItemParam(
            name = "Расход газа в рабочих условиях",
            value = 539f,
            min = 0f,
            max = 1200f,
            quantity = 8,
            avar = 900f,
            isOutAvar = true,
            type = 4
        ),
        ItemParam(
            name = "Расход газа в нормальных условиях",
            value = 603f,
            min = 0f,
            max = 1200f,
            quantity = 8,
            avar = 900f,
            isOutAvar = true,
            type = 4
        ),
        ItemParam(
            name = "Температура газа",
            value = 3.1f,
            min = -40f,
            max = 120f,
            quantity = 8,
            avar = 60f,
            isOutAvar = true,
            type = 1      //
        ),
        ItemParam(
            name = "Давление газа",
            value = 104.6f,
            min = 100f,
            max = 120f,
            quantity = 10,
            avar = 118f,
            isOutAvar = true,
            type = 3      //KPa
        ),
    )


    val listUnderpressure: List<ItemParam> = listOf(
        ItemParam(
            name = "Пересыпная камера",
            value = -2.3f,
            min = -5f,
            max = 5f,
            avar = 4f,
            isOutAvar = true,
            quantity = 10,
            type = 2
        ),
        ItemParam(
            name = "Пылевая камера",
            value = -4.1f,
            min = -16f,
            max = 0f,    //15
            avar = -1f,
            isOutAvar = true,
            type = 2
        ),
        ItemParam(
            name = "Перед утилизатором",
            value = -15.1f,
            quantity = 5,
            min = -25f,
            max = 0f,    //25
            type = 2
        ),
        ItemParam(
            name = "Перед электрофильтром",
            value = -92.5f,
            min = -160f,
            max = 0f,
            type = 2

        ),
        ItemParam(
            name = "Перед дымососом",
            value = -144.3f,
            min = -400f,
            max = 0f,
            type = 2

        ),
    )

    val listTemperature: List<ItemParam> = listOf(
        ItemParam(
            name = "Пересыпная камера",
            value = 234.1f,
            min = 0f,
            max = 1200f,
            avar = 600f,
            isOutAvar = true,
            type = 1
        ),
        ItemParam(
            name = "Свод печи",
            value = 1376.1f,
            min = 600f,
            max = 1800f,
            avar = 1500f,
            isOutAvar = true,
            quantity = 8,
            type = 1
        ),
        ItemParam(
            name = "Пылевая камера",
            value = 456.5f,
            min = 0f,
            max = 1200f,
            avar = 450f,
            isOutAvar = true,
            type = 1

        ),
        ItemParam(
            name = "Перед утилизатором",
            value = 269.7f,
            min = 0f,
            max = 600f,
            avar = 500f,
            isOutAvar = true,
            type = 1

        ),
        ItemParam(
            name = "Перед электрофильтром",
            value = 180.5f,
            min = 0f,
            max = 600f,
            avar = 300f,
            isOutAvar = true,
            type = 1

        ),
        ItemParam(
            name = "Перед дымососом",
            value = 124.3f,
            min = 0f,
            max = 600f,
            avar = 300f,
            isOutAvar = true,
            type = 1

        ),
    )
}

