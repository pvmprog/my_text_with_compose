package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun FontScale(
    fontSizeSp:Int = 20
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Масштаб шрифта : ${LocalDensity.current.fontScale}",
            textDecoration = TextDecoration.Underline,
            fontSize = fontSizeSp.sp
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Text [fontSize = 20sp]\n зависит от маштаба",
            textAlign = TextAlign.Center,
            fontSize = fontSizeSp.sp
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Text [fontSize = 20nonScaledSp()]\n не зависит от маштаба",
            textAlign = TextAlign.Center,
            fontSize = fontSizeSp.nonScaledSp()
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Text [fontSize = 4.6em]\n не зависит от маштаба",
            textAlign = TextAlign.Center,
            fontSize = 4.6.em
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(R.string.comment_font_scale),
            textAlign = TextAlign.Justify,
        )

    }
}

@Composable
fun Int.nonScaledSp(): TextUnit {
    val value: Int = this
    return with(LocalDensity.current) {
        val fontScale = this.fontScale
        val textSize = value / fontScale
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
