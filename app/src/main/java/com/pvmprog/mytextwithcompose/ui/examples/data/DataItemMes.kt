package com.pvmprog.mytextwithcompose.ui.examples.data

data class ItemMes(
    val message:String ="",
    val code:Int = 1
)

data class ItemTypeMes(
    val on:String ="❗",
    val off:String = "❕"
)


object DataItemMes {

    val types:List<ItemTypeMes> = listOf(
        ItemTypeMes("\uD83D\uDFE2","⚪"),     //0 🟢 ⚪ in:on/off
        ItemTypeMes("➕","➖"),               //1 ➕ ➖ out:вкл/выкл
        ItemTypeMes("❗","\uD83C\uDD97"),       //2  ❗ 🆗 avar     ❕
        ItemTypeMes("⚠\uFE0F","\uD83C\uDD97"), //3 ⚠️ 🆗 predupr
    )

    val messages: List<ItemMes> = listOf(
//Входы КБ
        ItemMes("BДГ",2),            //0
        ItemMes("НДГ",2),            //1
        ItemMes("НРП",2),            //2
        ItemMes("НДВ",2),            //3
        ItemMes("Дымосос",0),        //4
        ItemMes("Пламя в печи",0),   //5
        ItemMes("Кнопка: STOP",0),   //6
        ItemMes("Кнопка: Поджиг",0), //7
//выходы КБ
        ItemMes("Продувка",1),              //8
        ItemMes("Поджиг разрешен",1),       //9
        ItemMes("Защита печи включена",1),  //10
        ItemMes("Отсечение газа",1),        //11
        ItemMes("Запрет работы",1),         //12
        ItemMes("Температура КУ > 500°C",2),//13
        ItemMes("Ошибка наличия пламени",3),//14
        )


}