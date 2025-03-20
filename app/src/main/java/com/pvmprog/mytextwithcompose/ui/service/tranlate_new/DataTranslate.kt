package com.pvmprog.mytextwithcompose.ui.service.tranlate_new

import androidx.compose.ui.graphics.Color

object DataTranslate {
    val listKeyWords = listOf(
        HighlightColor("fun ", 7),
        HighlightColor("val ", 7),
        HighlightColor("var ", 7),
        HighlightColor(" by ", 7),
        HighlightColor("if ", 7),
        HighlightColor("else ", 7),
        HighlightColor("false", 7),
        HighlightColor("true", 7),
        HighlightColor("while", 7),
        HighlightColor("do ", 7),
        HighlightColor("@Composable", 8),
        HighlightColor("remember", 4),
        HighlightColor("colorScheme", 4),
        HighlightColor("LazyColumn", 4),
        )

    val listWhile = listOf(
        "listOf",
        "spacedBy"
    )


    val highColors = listOf(
        Color.Yellow,           //0 комментарии
        Color(0xFF30cbff),//1 number value
        Color(0xFF53b23a),//2 string value " ... "
        Color(0xFF02a9ff),//3 параметры функции "text ="
        Color(0xFF66b284),//4 название функции Text()
        Color(0xFFceb76b),//5 свойства .padding()
        Color(0xFFe48def),//6 .dp .Center
        Color(0xFFed864a),//7 KeyWords: val var if else fun ... 0xFFed864a
        Color(0xFFb2c231),//8  @Composable
        Color(0xFF3CEE0A),//9
        Color(0xFFFFFFFF),//10
        Color(0xFFffc530),//11 name my fun

    )

}