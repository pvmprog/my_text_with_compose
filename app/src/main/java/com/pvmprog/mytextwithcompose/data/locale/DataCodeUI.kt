package com.pvmprog.mytextwithcompose.data.locale

import androidx.compose.ui.graphics.Color
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import com.pvmprog.mytextwithcompose.data.model.HighlightCode

object DataCodeUI {
    val codeUI: List<ExampleCode> = listOf(
        ExampleCode(
            id =  2,
            title = "Размер текста",
            nameFun = "",
            highlightCode = listOf(
                HighlightCode(".sp", Color(0xFFFFEB3B)),
                HighlightCode(".em", Color(0xFFFFEB3B)),
                HighlightCode("fontSize", Color(0xFF3CEE0A)),
                HighlightCode("Column(", Color(0xFF3CEE0A)),
                HighlightCode("Text(", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            code = """
    val text = stringResource(
        id = R.string.text_in_jetpack_compose
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    Column(Modifier.padding(padding)) {
        Text(
            text = text,
            fontSize = TextUnit.Unspecified
        )
        Text(
            text = text + "(20.sp)",
            fontSize = 20.sp
        )
        Text(
            text = text + "(10.sp)",
            fontSize = 10.sp
        )
        Text(
            text = text + "(5.em)",
            fontSize = 5.em
        )
        Text(
            text = text + "(1.em)",
            fontSize = 1.em
        )
    }
            """.trimIndent()
        ),
    )
}
