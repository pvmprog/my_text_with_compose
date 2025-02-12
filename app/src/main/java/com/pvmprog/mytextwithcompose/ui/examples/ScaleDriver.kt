package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.service.ColorSelect
import com.pvmprog.mytextwithcompose.ui.service.RadioButtonRow
import com.pvmprog.mytextwithcompose.ui.service.SliderSimple
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun ScaleDraver(){
    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val scaleX = remember {
        mutableFloatStateOf(0.5f)
    }
    val scaleY = remember {
        mutableFloatStateOf(0.5f)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        ScaleText(scaleX.floatValue,scaleY.floatValue)
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(padding)
                ) {
                    SliderSimple("scaleX", scaleX, 0.1f, 3f)

                    SliderSimple("scaleY", scaleY, 0.1f, 3f)

                }

            }

        }
    }
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ScaleDraverPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ScaleDraver()
        }

    }
}
