package com.pvmprog.mytextwithcompose.data.model

import androidx.compose.runtime.Composable

data class ExampleCode(
    val id: Int = -1,
    val title: String = "",
    val nameFun: String = "",
    val lambdaFun: @Composable (Boolean) -> Unit = @Composable{},
    val highlightCode: List<HighlightCode> = listOf(), //фрагмент кода программы, выделенный цветом
    val code: String = "",
    val comment: String = "",
    val links: List<TextClickLink> = listOf(),  //список ссылок
)
