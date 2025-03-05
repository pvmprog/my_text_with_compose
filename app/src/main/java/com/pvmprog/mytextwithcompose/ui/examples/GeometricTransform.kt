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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.service.SliderSimple
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun GeometricTransform(){
    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val scaleX = remember {
        mutableFloatStateOf(2f)
    }
    val skewX = remember {
        mutableFloatStateOf(1.2f)
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ) {
        Text (
            text = "Text in jetpack Compose",
            modifier = Modifier
                .background(MaterialTheme.colorScheme.tertiaryContainer)
                .fillMaxWidth()
                .padding(16.dp),
            style = TextStyle(
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Cursive,
                textGeometricTransform = TextGeometricTransform(
                    scaleX = scaleX.floatValue,
                    skewX = skewX.floatValue
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
            SliderSimple("scaleX", scaleX, 0f, 5f)
            SliderSimple("skewX", skewX, -2f, 2f)
        }


    }


}
@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GeometricTransformPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            GeometricTransform()
        }

    }
}
