package com.pvmprog.mytextwithcompose.ui.examples.data

data class ItemMessageType(
    val message:String ="",
    val code:Int = 0
)

data class ItemStateMes(
    val on:String ="❗",
    val off:String = "❕"
)


object DataItemMessageType {
// 🔁 - повтор
// 🛜  - налилие интернет
// 🚫 - запрет
    val statesMes:List<ItemStateMes> = listOf(
        ItemStateMes("\uD83D\uDFE2","⚪"),     //0 🟢 ⚪ in:on/off
        ItemStateMes("➕","➖"),               //1 ➕ ➖ out:вкл/выкл
        ItemStateMes("❗","\uD83C\uDD97"),       //2  ❗ 🆗 avar     ❕
        ItemStateMes("⚠\uFE0F","\uD83C\uDD97"), //3 ⚠️ 🆗 predupr
        ItemStateMes("✅","◽"),                 //4 ✅ ◽ info
    )

    val typesOfMessages: List<ItemMessageType> = listOf(
//Входы КБ
        ItemMessageType("BДГ",2),            //0
        ItemMessageType("НДГ",2),            //1
        ItemMessageType("НРП",2),            //2
        ItemMessageType("НДВ",2),            //3
        ItemMessageType("Дымосос не включен",3),        //4
        ItemMessageType("Пламя в печи",0),   //5
        ItemMessageType("Кнопка: STOP",3),   //6
        ItemMessageType("Кнопка: Поджиг",0), //7
//выходы КБ
        ItemMessageType("Продувка",4),              //8
        ItemMessageType("Поджиг разрешен",4),       //9
        ItemMessageType("Защита печи включена",4),  //10
        ItemMessageType("Запрет подачи АТ",3),      //11
        ItemMessageType("Отсеченой клапан",1),      //12
        ItemMessageType("Запрет работы",4),         //13
        ItemMessageType("Температура КУ > 500°C",2),//14
        ItemMessageType("Ошибка наличия пламени",3),//15

//status 2
        ItemMessageType("Обрыв Т КУ",3),           //16
        ItemMessageType("Обрыв Весы выгр.1",3),    //17
        ItemMessageType("Обрыв Весы выгр.2",3),    //18
        ItemMessageType("Обрыв Весы выгр.3",3),    //19
        ItemMessageType("Обрыв Ток дв.холод.",3),  //20
        ItemMessageType("Регул.пар>допус",3),      //21
        ItemMessageType("Регул.пар<допус",3),      //22
        ItemMessageType("Ручной режим",4),         //23
        ItemMessageType("Измер:Весы выгр.1",4),    //24
        ItemMessageType("Измер:Весы выгр.2",4),    //25
        ItemMessageType("Измер:Весы выгр.3",4),    //26
        ItemMessageType("Измер:Ток холодил",4),    //27
        ItemMessageType("Обрыв Т наруж.воз",3),    //28
        ItemMessageType("Оптимиз:Автомат  ",4),    //29
        ItemMessageType("Оптимиз:ПолуАвт. ",4),    //30
        ItemMessageType("Оптимиз:Нет",4),          //31


//
        ItemMessageType("K1: Ролик внизу",4),//32    0
        ItemMessageType("K2: Ролик вверху",4),//33    1
        ItemMessageType("K3: Ролик-ОЧЕНЬ верх",3),//34    2
        ItemMessageType("K4: Ролик-ОЧ.ОЧ.верх",2),//35    3
        ItemMessageType("",4),//36    4
        ItemMessageType("",4),//37    5
        ItemMessageType("",4),//38    6
        ItemMessageType("",4),//39    7
        ItemMessageType("",4),//40    8
        ItemMessageType("",4),//41    9
        ItemMessageType("",4),//42   10
        ItemMessageType("",4),//43   11
        ItemMessageType("",4),//44   12
        ItemMessageType("",4),//45   13
        ItemMessageType("",4),//46   14
        ItemMessageType("",4),//47   15

        )


}