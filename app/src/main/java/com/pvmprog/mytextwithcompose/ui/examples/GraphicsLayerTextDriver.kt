package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.service.SliderSimple
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme


@Composable
fun GraphicsLayerTextDriver(){
    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val layerRotationX = remember {
        mutableFloatStateOf(15f)
    }
    val layerRotationY = remember {
        mutableFloatStateOf(52f)
    }
    val layerRotationZ = remember {
        mutableFloatStateOf(0f)
    }
    val layerOriginX = remember {
        mutableFloatStateOf(0.5f)
    }
    val layerOriginY = remember {
        mutableFloatStateOf(0.5f)
    }

    val layerTranslationX = remember {
        mutableFloatStateOf(40f)
    }

    val layerTranslationY = remember {
        mutableFloatStateOf(20f)
    }



    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.White)
                .background(Color(0xff0000ff))
                .heightIn(min = 150.dp)
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {

            MessageShadow(
                message = stringResource(R.string.hello_world),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontFamily = Alice,
                    fontSize = 45.sp,
                    lineHeight = 55.sp,
                    color = Color(0xfffcce36),
                    shadow = Shadow(
                        color = Color(0xffff0000),
                        offset = Offset(2f, 6f), //смещение тени
                        blurRadius = 2f  //размытие
                    )
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .graphicsLayer {
                        this.transformOrigin = TransformOrigin(
                            layerOriginX.floatValue,
                            layerOriginY.floatValue
                        )
                        this.rotationX = layerRotationX.floatValue
                        this.rotationY = layerRotationY.floatValue
                        this.rotationZ = layerRotationZ.floatValue

                        this.translationX = layerTranslationX.value.dp.toPx()
                        this.translationY = layerTranslationY.value.dp.toPx()

                    }
                    .fillMaxWidth(),
            )

        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(padding)
        ) {
            SliderSimple("rotat.X ", layerRotationX, 0f, 360f)
            SliderSimple("rotat.Y ", layerRotationY, 0f, 360f)
            SliderSimple("rotat.Z ", layerRotationZ, 0f, 360f)
            SliderSimple("OriginX ", layerOriginX, 0f, 1f)
            SliderSimple("OriginY ", layerOriginY, 0f, 1f)
            SliderSimple("trans.X ", layerTranslationX, 0f, 100f)
            SliderSimple("trans.Y ", layerTranslationY, 0f, 100f)
        }
    }


}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RotationTextDriverPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            GraphicsLayerTextDriver()
        }

    }
}
