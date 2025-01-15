package com.pvmprog.mytextwithcompose.data.model

data class ExampleCode(
    val id: Int = -1,
    val title: String = "",
    val nameFun: String = "",
    val highlightCode: List<HighlightCode> = listOf(), //фрагмент кода программы, выделенный цветом
    val code: String = "",
    val comment: String = "",
)
