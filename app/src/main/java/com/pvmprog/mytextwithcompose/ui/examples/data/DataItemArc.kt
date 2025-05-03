package com.pvmprog.mytextwithcompose.ui.examples.data

import androidx.compose.ui.graphics.Color

data class ItemArc(
    val name: String = "",
    val percent:Float = 50f,
    val color: Color = Color.Red,
)


//Продажи легких закусок
object DataItemArc {
    val listArc: List<ItemArc> = listOf(
        ItemArc(
            name = "Сэндвичи",
            color = Color(0xFF05BDEB),
            percent = 40f
        ),
        ItemArc(
            name = "Салаты",
            color = Color(0xFF3BF71A),
            percent = 21f
        ),
        ItemArc(
            name = "Десерты",
            color = Color(0xFFBE10DB),
            percent = 17f
        ),
        ItemArc(
            name = "Супы",
            color = Color(0xFFFFEB3B),
            percent = 13f
        ),
        ItemArc(
            name = "Напитки",
            color = Color(0xFFF80939),
            percent = 9f
        ),
    )
}