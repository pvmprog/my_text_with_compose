package com.pvmprog.mytextwithcompose.ui.service

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun RadioButtonOptionsColumn(
    selectedOption: String,
    listOptions: List<String>,
    onClick: (String) -> Unit,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .selectableGroup()
    )
    {
        listOptions.forEach { element ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RadioButton(
                    selected = element == selectedOption,
                    onClick = { onClick(element) },
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = element,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onClick(element) },
                    fontSize = 22.sp
                )
            }
        }
    }
}
@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RadioButtonOptionsColumnPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            val listToChooseFrom = listOf(
                "linearGradient",
                "horizontalGradient",
                "verticalGradient",
                "sweepGradient",
                "radialGradient",
            )
            val (selectedOption, onOptionSelected) = remember { mutableStateOf(listToChooseFrom[0]) }

            RadioButtonOptionsColumn(
                selectedOption = selectedOption,
                listOptions = listToChooseFrom,
                onClick = { onOptionSelected(it) }

            )
        }

    }
}

