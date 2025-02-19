package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import android.graphics.RuntimeShader
import androidx.compose.foundation.background
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
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.service.SliderSimple
import com.pvmprog.mytextwithcompose.ui.shader.SHADER_GRADIENT
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme


@Composable
fun ShaderDriver(
    message: String = "Shader in Jetpack Compose",

    ){

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val iTime = remember {
        mutableFloatStateOf(2f)
    }

//создание объекта RuntimeShader, инициализированного строкой шейдера.
    val shader = RuntimeShader(SHADER_GRADIENT)

    val shaderBrush = ShaderBrush(shader)
//передача параметров в шейдер при помощи setFloatUniform

// в iResolution (float2) — два ключа
    shader.setFloatUniform(
        "iResolution", 500.dp.value, 600.dp.value
    )

// в iTime (float) — один ключ
    shader.setFloatUniform(
        "iTime", iTime.floatValue
    )

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
                .background(Color(0xFF690005))
                .weight(1f)
                .padding(padding),
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
                    brush = shaderBrush
                ),
            )
        }
        SliderSimple("iTime",iTime,0f,10f)
    }
}


@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ShaderDriverPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ShaderDriver()
        }

    }
}
