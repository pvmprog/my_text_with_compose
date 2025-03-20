package com.pvmprog.mytextwithcompose.data.model

import androidx.compose.runtime.Composable
import com.pvmprog.mytextwithcompose.ui.service.tranlate_new.HighlightColor
import com.pvmprog.mytextwithcompose.ui.service.translate_old.HighlightCode

data class ExampleCode(
    val id: Int = -1,
    val title: String = "",
    val nameFun: String = "",
    val lambdaFun: @Composable (Boolean) -> Unit = @Composable{},
    val highlightCode: List<HighlightCode> = listOf(), //фрагмент кода программы, выделенный цветом
    val highlightName: List<HighlightColor> = listOf(),
    val code: String = "",
    val comment: String = "",
    val links: List<TextClickLink> = listOf(),  //список ссылок
)
