package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import android.graphics.ColorSpace
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun TextColorAny() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
    ) {
        val text = "Text in jetpack Compose"
        val modifier = Modifier.padding(16.dp)

        Text(
            text = text,
            fontSize = 20.sp,
            color = Color.Red,
            modifier = modifier,
        )

        Text(
            text = text,
            fontSize = 20.sp,
            color = colorResource(id = R.color.red700),
            modifier = modifier,
        )

        Text(
            text = text,
            fontSize = 20.sp,
//Из целочисленных значений компонентов SRGB. Альфа необязательна
            color = Color(
                red = 0x44,   //between 0 and 255
                green = 0x55, //between 0 and 255
                blue = 0x88,  //between 0 and 255
                alpha = 0xFF
            ),//between 0 and 255
            modifier = modifier,
        )

        Text(
            text = text,
            fontSize = 20.sp,
//32-bit ARGB color
            color = Color(0xFF993399),
            modifier = modifier,
        )

//Установка цвета с использованием TextStyle
        Text(
            text = text,
            modifier = modifier,
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Green
            )
        )

        Text(
            text = text,
            modifier = modifier,
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Yellow,
                background = Color.Blue
            )
        )

        Text(
            text = text,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = modifier,
        )


    }
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextColorAnyPreview() {
    MyTextWithComposeTheme {
        TextColorAny()
    }
}
