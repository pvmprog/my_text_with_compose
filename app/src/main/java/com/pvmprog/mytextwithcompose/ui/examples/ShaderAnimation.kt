package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.service.RadioButtonRow
import com.pvmprog.mytextwithcompose.ui.shader.SHADER_CLOUD
import com.pvmprog.mytextwithcompose.ui.shader.SHADER_DISCOTEQ
import com.pvmprog.mytextwithcompose.ui.shader.SHADER_GRADIENT
import com.pvmprog.mytextwithcompose.ui.shader.SHADER_RADAR
import com.pvmprog.mytextwithcompose.ui.shader.SHADER_SILEXARS
import com.pvmprog.mytextwithcompose.ui.shader.SHADER_TETRASKELION
import com.pvmprog.mytextwithcompose.ui.shader.SHADER_WATER
import com.pvmprog.mytextwithcompose.ui.shader.shaderAGSL
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun ShaderAnimation(
    message: String = "Shader in Jetpack Compose",

    ){

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    var indexShaders by remember { mutableIntStateOf(1) }

    val shaders: List<String> = remember {
        listOf(
            "Grad",
            "Water",
            "Disco",
            "Silex",
            "Radar"
        )
    }

    val initialValue = 0f
    var targetValue = 10f


    val shaderStr = when(indexShaders){
        1 -> SHADER_WATER
        2 -> SHADER_DISCOTEQ
        3 -> SHADER_SILEXARS
        4 -> {
            targetValue = -1f
            SHADER_RADAR   //SHADER_RADAR  SHADER_CLOUD
        }
        else -> SHADER_GRADIENT

    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(padding)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.White)
//                .height(200.dp)
                .weight(1f)
                .shaderAGSL(shaderStr,initialValue,targetValue),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = message,
                modifier = Modifier
                    .padding(16.dp),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontFamily = Alice,
                    fontSize = 40.sp,
                    lineHeight = 55.sp,
                ),
            )
        }
        RadioButtonRow(indexShaders,shaders,{indexShaders = it})

    }
}


@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ShaderAnimationPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ShaderAnimation()
        }

    }
}
