package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun ScaleText(
    scaleX: Float = 1f,
    scaleY: Float = 1f,
){
    val text = stringResource(
        id = R.string.hello_world
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )
    Box(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.onBackground)
            .widthIn(min = 150.dp)
            .padding(padding),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text + "\n (${scaleX},${scaleY})",
            modifier = Modifier
                .padding(padding)
                .graphicsLayer {
                    this.scaleX = scaleX
                    this.scaleY = scaleY
                },
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
        )

    }



}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ModifierScaleTextPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ScaleText(2f,2f)
        }

    }
}

