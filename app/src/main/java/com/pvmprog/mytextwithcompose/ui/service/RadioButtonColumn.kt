package com.pvmprog.mytextwithcompose.ui.service

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
fun RadioButtonColumn(
    indexSelect: Int = 0,
    items: List<String> = listOf(
        "linearGradient",
        "horizontalGradient",
        "verticalGradient",
        "sweepGradient",
        "radialGradient",
    ),
    onClick: (Int) -> Unit = {},
    modifier:Modifier = Modifier
) {
    Column(
        modifier = modifier
            .selectableGroup(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        items.forEachIndexed { index, element ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {onClick(index)  },
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = indexSelect == index,
                    onClick = { onClick(index) },
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(
                    text = element,
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontSize = 20.sp
                )
            }
        }

    }
}
@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RadioButtonColumnPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            RadioButtonColumn()
        }

    }
}
