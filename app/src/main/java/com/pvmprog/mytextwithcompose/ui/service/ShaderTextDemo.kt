package com.pvmprog.mytextwithcompose.ui.service

import android.graphics.RuntimeShader
import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.shader.SHADER_GRADIENT
import com.pvmprog.mytextwithcompose.ui.theme.Alice

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
@Preview
fun ShaderTextDemo(
) {
    val scaleTime = remember {
        mutableFloatStateOf(0.3f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {


        val shader = RuntimeShader(SHADER_GRADIENT)
        val shaderBrush = ShaderBrush(shader)
        shader.setFloatUniform(
            "iResolution", 300.dp.value, 300.dp.value
        )
        shader.setFloatUniform(
            "iTime", scaleTime.value
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = "Shader in Jetpack Compose",
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontFamily = Alice,
                    fontSize = 34.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    brush = shaderBrush
                ),
            )
        }

    }


}
