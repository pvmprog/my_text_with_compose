package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.service.SliderSimple
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun StyleDraver(){
    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val lineHeight = remember {
        mutableFloatStateOf(20f)
    }
    val baselineShift = remember {
        mutableFloatStateOf(0f)
    }
    val firstLine = remember {
        mutableFloatStateOf(24f)
    }
    val restLine = remember {
        mutableFloatStateOf(0.5f)
    }
    val letterSpacing = remember {
        mutableFloatStateOf(0f)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        TextStyleIndent(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.tertiaryContainer)
                .padding(8.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.Justify,
                lineHeight = lineHeight.floatValue.sp,
                letterSpacing = letterSpacing.floatValue.sp,
                baselineShift = BaselineShift(baselineShift.floatValue),
                textIndent = TextIndent(
                    firstLine = firstLine.floatValue.sp,
                    restLine = restLine.floatValue.sp
                )
            )
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(padding)
        ) {
            SliderSimple("firstLine", firstLine, 0f, 40f)
            SliderSimple("restLine", restLine, 0f, 40f)
            SliderSimple("lineHeig", lineHeight, 20f, 40f)
            SliderSimple("baseline", baselineShift, 0.1f, 5f)
            SliderSimple("letterSp", letterSpacing, 0f, 5f)

        }

    }

}
@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun StyleDraverPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            StyleDraver()
        }

    }
}
