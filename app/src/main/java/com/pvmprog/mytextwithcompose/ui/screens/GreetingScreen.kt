package com.pvmprog.mytextwithcompose.ui.screens

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme


@Composable
fun GreetingScreen(
    message: String = stringResource(R.string.text_in_jetpack_compose),
    comment: String = stringResource(R.string.in_examples),
    image: Painter = painterResource(id = R.drawable.bg),
    onExit: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val styleButton = TextStyle(
        fontSize = 36.sp,
        fontWeight = FontWeight.Normal
    )


// A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.8f

            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GreetingText(
                    message = message,
                    comment = comment,
                    modifier = Modifier
                        .weight(1f)
                        .padding(dimensionResource(id = R.dimen.padding_small))
                )
                Button(
                    modifier = Modifier
                        .padding(all = dimensionResource(id = R.dimen.padding_medium)),
                    onClick = { onExit() },
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        text = stringResource(R.string.let_s_begin),
                        style = styleButton,
                        textAlign = TextAlign.Center
                    )

                }

            }


        }

    }
}

@Composable
fun GreetingText(
    message: String = "",
    comment: String = "",
    sizeMes: Int = 80,
    sizeCom: Int = 30,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = sizeMes.sp,
            lineHeight = (sizeMes + 16).sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = comment,
            fontSize = sizeCom.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingScreenPreview() {
    MyTextWithComposeTheme {
        GreetingScreen()

    }
}
