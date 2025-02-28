package com.pvmprog.mytextwithcompose.ui.examples

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview

/*
Важно: известна проблема с liveRegion, которая предотвращает речевые объявления при изменении параметра text. Текущий способ решения проблемы — назначить тот же текст contentDescription
 */
@Composable
@Preview
fun SemanticsText(){

    var changingText by remember {
        mutableStateOf("Измененный текст")
    }
//...
    Text(
        text = changingText,
        modifier = Modifier.semantics {
            liveRegion = LiveRegionMode.Polite
            contentDescription = changingText
        }
    )
}