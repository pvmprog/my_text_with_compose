package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

/*
Коэффициент контраста, согласно стандарту WCAG, высчитывается по формуле: (L1 + 0,05) / (L2 + 0,05), в которой: L1 — относительная яркость самого светлого цвета. L2 — относительная яркость самого тёмного цвета
 */

@Composable
fun Simple() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.onBackground)
        ) {
            Text("Hello, World!")
        }

    }
}

@Composable
fun SimpleWithPadding() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.onBackground)
        ) {
            Text(
                text = "Hello, World!",
                modifier = Modifier
                    .padding(16.dp)
            )
        }

    }

}

/*
In the res/values/strings.xml file

<resources>
...
 <string name="text_in_jetpack_compose">Text in Jetpack Compose</string>

 <string name="day_of_month">There are %2$d days in %1$s</string>
...
</resources>

*/
@Composable
fun SimpleStringResource() {

    val text1 = stringResource(
        id = R.string.hello_world
    )

//позиционное форматирование
    val text2 = stringResource(
        id = R.string.day_of_month, "January", 31
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.onBackground)
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = text1)
            Text(text = text2)
        }
    }


}



@Composable
fun ItalicText() {

    val text = stringResource(
        id = R.string.hello_world
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.onBackground)
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = text + " (Italic)",
                fontStyle = FontStyle.Italic
            )
            Text(
                text = text + " (Normal)",
                fontStyle = FontStyle.Normal
            )
        }
    }


}

@Composable
fun TextFontWeight() {

    val text = stringResource(
        id = R.string.hello_world
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val modifier = Modifier
        .padding(8.dp)


    LazyColumn(
        modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.onBackground)
            .fillMaxWidth()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "$text (Normal)",
                modifier = modifier,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "$text (Bold)",
                modifier = modifier,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$text (ExtraBold)",
                modifier = modifier,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = "$text (Light)",
                modifier = modifier,
                fontWeight = FontWeight.Light
            )
            Text(
                text = "$text (W100)",
                modifier = modifier,
                fontWeight = FontWeight.W100
            )
            Text(
                text = "$text (W300)",
                modifier = modifier,
                fontWeight = FontWeight.W300
            )
            Text(
                text = "$text (W900)",
                modifier = modifier,
                fontWeight = FontWeight.W900
            )

        }
    }


}

@Composable
fun SimpleAlign() {
    val text = stringResource(
        id = R.string.hello_world
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val modifier = Modifier
        .padding(top = 16.dp)
        .fillMaxWidth() // !!!

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.onBackground)
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = text + " (Left)",
                    textAlign = TextAlign.Left,
                    modifier = modifier
                )
                Text(
                    text = text + " (Center)",
                    textAlign = TextAlign.Center,
                    modifier = modifier
                )
                Text(
                    text = text + " (Right)",
                    textAlign = TextAlign.Right,
                    modifier = modifier
                )

            }
        }
    }

}

@Composable
fun SimpleAlignJustify() {

    val text = "Без выравнивания. ".repeat(10)

    val text2 = "Выравнивание строк по всей ширине контейнера. ".repeat(10)

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )


    LazyColumn(
        modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.onBackground)
            .padding(padding),
    ) {
        item {
            //Без выравнивания
            Text(text = text)
            
            Spacer(modifier = Modifier.padding(padding))

            //выравнивание по всей ширине контейнера, кроме последней
            Text(
                text = text2,
                textAlign = TextAlign.Justify,
            )

        }
    }


}

@Composable
fun TextAlignedHeight() {

    val text = "Без выравнивания. ".repeat(5)

    val text2 = "Выравнивание строки по заданной высоте строки. ".repeat(5)

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.onBackground)
            .padding(padding),
    ) {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(padding)
            ) {
                //без выравнивания
                Text(
                    text = text,
                )

                //выравнивание строки по заданной высоте
                Text(
                    text = text2,
                    lineHeight = 2.0.em,
                )

                //выравнивание строки по заданной высоте
                Text(
                    text = text2,
                    style = LocalTextStyle.current.merge(
                        TextStyle(
                            lineHeight = 2.0.em,
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            ),
                            lineHeightStyle = LineHeightStyle(
                                alignment = LineHeightStyle.Alignment.Center,
                                //обрезка низа последней строки
                                trim = LineHeightStyle.Trim.Both
                            )
                        )
                    )
                )

            }

        }

    }

}



@Composable
fun SimpleLimit() {

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    LazyColumn(
        modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.onBackground)
            .padding(padding),
    ) {
        item {
            Text(
                text = "Очень длинный-длинный текст ".repeat(20),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
            )

        }

    }

}


@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SimpleTextPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TextAlignedHeight()
        }

    }
}


