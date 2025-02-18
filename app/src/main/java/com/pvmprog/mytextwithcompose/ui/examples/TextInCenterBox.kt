package com.pvmprog.mytextwithcompose.ui.examples

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
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
import com.pvmprog.mytextwithcompose.ui.shader.SHADER_SILEXARS
import com.pvmprog.mytextwithcompose.ui.shader.shaderAGSL
import com.pvmprog.mytextwithcompose.ui.theme.Alice

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
@Preview
fun TextInCenterBox(
//SHADER_GRADIENT SHADER_WATER SHADER_DISCOTEQ SHADER_SILEXARS
    nameShaderStr: String = SHADER_SILEXARS, //SHADER_GRADIENT //SHADER_WATER
    text: String = "Shader in Jetpack Compose",
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle(
        color = Color.Red,
        fontFamily = Alice,
        fontSize = 40.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
    ),

) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .shaderAGSL(nameShaderStr),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = style,
        )
    }
}


