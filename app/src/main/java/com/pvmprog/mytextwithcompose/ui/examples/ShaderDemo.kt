package com.pvmprog.mytextwithcompose.ui.examples

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.shader.ART_CODDING
import com.pvmprog.mytextwithcompose.ui.shader.FRACTAL_PYRAMID
import com.pvmprog.mytextwithcompose.ui.shader.SHADER_CLEAN_PORTAL
import com.pvmprog.mytextwithcompose.ui.shader.SHADER_GRADIENT
import com.pvmprog.mytextwithcompose.ui.shader.SHADER_WATER
import com.pvmprog.mytextwithcompose.ui.shader.shaderAGSL
import com.pvmprog.mytextwithcompose.ui.theme.Alice

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
@Preview
fun ShaderDemo(
    nameShaderStr: String = SHADER_WATER //SHADER_CLEAN_PORTAL  //SHADER_GRADIENT,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .shaderAGSL(nameShaderStr),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = "Shader in Jetpack Compose",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontFamily = Alice,
            fontSize = 40.sp,
            style = TextStyle(
                color = Color.Blue,
            ),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,

            )
    }
}


