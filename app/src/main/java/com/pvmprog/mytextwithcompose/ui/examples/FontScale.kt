package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun FontScale(
    fontSizeSp:Int = 20  //non scaled font size
) {
    Text(
        text = "Масштаб текущего размера шрифта: ${LocalDensity.current.fontScale}",
        fontSize = fontSizeSp. scaledSp()
    )
}

@Composable
fun Int.scaledSp(): TextUnit {
    val value: Int = this
    return with(LocalDensity.current) {
        val fontScale = this.fontScale
        val textSize = value * fontScale
        textSize.sp
    }
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FontScalePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            FontScale()
        }

    }
}
