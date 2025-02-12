package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun TextColorAny() {

    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(Color(0xFF201B16))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text (
                    text = "Контраст:13.08 (Отличный)",
                    color = Color(0xFFEBE0D9),
                    fontSize = 18.sp
                )

                Text (
                    text = "Контраст:5.44 (Хороший)",
                    color = Color.Red,
                    fontSize = 18.sp
                )

                Text (
                    text = "Контраст:4.16 (Плохой)",
                    color = colorResource(id = R.color.red700),
                    fontSize = 18.sp
                )

                Text (
                    text = "Контраст:2.14 (Плохой)",
//Из целочисленных значений компонентов SRGB. Альфа необязательна
                    color = Color(
                        red = 0x44,   //between 0 and 255
                        green = 0x55,
                        blue = 0x88,
                        alpha = 0xFF
                    ),
                    fontSize = 18.sp
                )

                Text (
                    text = "Контраст:2.67 (Плохой)", //32-bit ARGB color
                    color = Color(0xFF993399),
                    fontSize = 18.sp
                )

                Text (
                    text = "Контраст:12.44 (Отличный)",
                    fontSize = 18.sp,
                    style = TextStyle(
                        color = Color.Green,
                    )
                )

                Text (
                    text = "Контраст:8.59 (Хороший)",
                    style = TextStyle(
                        color = Color.Yellow,
                        background = Color.Blue
                    ),
                    fontSize = 18.sp,
                )

                Text (
                    text = "Контраст:16.40 (Отличный)",
                    modifier = Modifier
                        .background(Color(0xff22200d)),
                    color = Color(0xffffff00),
                    fontSize = 18.sp,
                )

                Text (
                    text = "Контраст:7.41 (Хороший)",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondary),
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontSize = 18.sp,
                )

                Text (
                    text = "Контраст:7.55 (Хороший)",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondaryContainer),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontSize = 18.sp,
                )

                Text (
                    text = "Контраст:9.31 (Хороший)",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.tertiaryContainer),
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    fontSize = 18.sp,
                )

                Text (
                    text = "Контраст:21.00 (Отличный)",
                    modifier = Modifier
                        .background(Color(0xff000000)),
                    color = Color(0xffffffff),
                    fontSize = 18.sp,
                )

            }
        }


    }
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextColorAnyPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TextColorAny()
        }
    }
}
