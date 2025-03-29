package com.pvmprog.mytextwithcompose.ui.examples

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun SelectableText() {

    SelectionContainer {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = "Этот текст доступен для выбора.",
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                text = "Этот текст доступен для выбора.",
                style = MaterialTheme.typography.bodyMedium,
            )
            DisableSelection {
                Text(
                    text = "Этот текст не доступен для выбора.",
                    color = Color.Yellow,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            Text(
                text = "Этот текст доступен для выбора.",
                style = MaterialTheme.typography.bodyMedium,
            )


        }


    }
}
