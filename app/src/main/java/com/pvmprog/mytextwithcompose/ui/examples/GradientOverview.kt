package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.service.RadioButtonColumn
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme


@Composable
fun GradientOverview(
    isExpanded: Boolean = false,
){
    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    var indexSelect by remember { mutableIntStateOf(4) }

    val gradients = listOf(
        "linearGradient",
        "horizontalGradient",
        "verticalGradient",
        "sweepGradient",
        "radialGradient",
    )
    if (isExpanded) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(0.7f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                RadioButtonColumn(
                    indexSelect = indexSelect,
                    items = listOf(
                        "linear",
                        "horizontal",
                        "vertical",
                        "sweep",
                        "radial",
                    ),
                    onClick = { indexSelect = it }
                )
            }

            BackgroundWithBrush(
                indexSelect = indexSelect,
                modifier = Modifier
                    .fillMaxHeight()
                    .background(color = Color.Black)
                    .padding(padding)
                    .weight(1f),
            )
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            RadioButtonColumn(
                indexSelect = indexSelect,
                items = gradients,
                onClick = { indexSelect = it }
            )

            BackgroundWithBrush(
                indexSelect = indexSelect,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Black)
                    .padding(padding)
                    .weight(1f),
            )

        }

    }


}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GradientOverviewPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            GradientOverview()
        }

    }
}
@Preview("Light Theme",showBackground = true, widthDp = 1000)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, widthDp = 1000)
@Composable
fun GradientOverviewPreview2() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            GradientOverview(isExpanded = true)
        }

    }
}
