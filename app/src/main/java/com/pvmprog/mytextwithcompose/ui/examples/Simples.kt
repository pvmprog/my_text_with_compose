package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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

@Composable
fun SimpleText() {
    Text("Text in jetpack Compose")
}

@Composable
fun SimplePaddingText() {
    Text(
        text = "Text in jetpack Compose",
        modifier = Modifier
            .padding(16.dp)
    )
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
fun StringResourceText() {
    val text = stringResource(
        id = R.string.text_in_jetpack_compose
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    Column(
        modifier = Modifier
            .padding(padding)
    ){
        Text(text = text)
//позиционное форматирование
        Text(
            text = stringResource(R.string.day_of_month, "January", 31),
            modifier = Modifier
                .padding(bottom = padding)

        )
    }
}

@Composable
fun ColorText() {
    val text = stringResource(
        id = R.string.text_in_jetpack_compose
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    Text(
        text = text,
        modifier = Modifier
            .padding(padding)
            .background(Color.Black)
            .padding(padding),
        color =  Color.Cyan

    )
}

@Composable
fun TextFontSize() {
    val text = stringResource(
        id = R.string.text_in_jetpack_compose
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text + "(default)",
            fontSize = TextUnit.Unspecified
        )
        Text(
            text = text + "(20.sp)",
            fontSize = 20.sp
        )
        Text(
            text = text + "(3.em)",
            fontSize = 3.em
        )
        Text(
            text = text,
            style = TextStyle(
                fontSize = 15.sp,
            )
        )

        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall
        )

    }

}

@Composable
fun ItalicText() {
    val text = stringResource(
        id = R.string.text_in_jetpack_compose
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val modifier = Modifier
        .padding(top = 16.dp)

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = text,
            modifier = modifier,
            fontStyle = FontStyle.Italic
        )

        Text(
            text = text,
            modifier = modifier,
            fontStyle = FontStyle.Normal
        )

    }

}

@Composable
fun TextFontWeight() {
    val text = stringResource(
        id = R.string.text_in_jetpack_compose
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val modifier = Modifier
        .padding(top = 16.dp)

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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

@Composable
fun AlignText() {
    val modifier = Modifier
        .padding(top = 16.dp)
        .fillMaxWidth()

    Column {
        Text(
            text = "Text in jetpack Compose",
            fontSize = 15.sp,
            textAlign = TextAlign.Left,
            modifier = modifier
        )
        Text(
            text = "Text in jetpack Compose",
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
        Text(
            text = "Text in jetpack Compose",
            fontSize = 15.sp,
            textAlign = TextAlign.Right,
            modifier = modifier
        )

    }
}

@Composable
fun TextAlignJustify() {

    val text = "Text in jetpack Compose. ".repeat(10)

    val modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()

    Column {

        //Без выравнивания
        Text(
            text = text,
            modifier = modifier,
            style = MaterialTheme.typography.bodyMedium,
        )

        //выравнивание строк по всей ширине контейнера, кроме последней
        Text(
            text = text + "(Justify)",
            modifier = modifier,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Justify,
        )

    }

}

@Composable
fun TextAlignedHeight() {
    val text = "Text in jetpack Compose. ".repeat(5)
    val modifier = Modifier
        .padding(16.dp)

    Column {
        //без выравнивания
        Text(
            text = text,
            modifier = modifier,
            style = MaterialTheme.typography.bodyMedium,
        )

        //выравнивание строки по заданной высоте
        Text(
            text = text,
            modifier = modifier,
            style = LocalTextStyle.current.merge(
                TextStyle(
                    lineHeight = 2.0.em,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    ),
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        //обрезка низа последней строки
                        trim = LineHeightStyle.Trim.LastLineBottom
                    )
                )
            )
        )
    }

}


//Тень
@Composable
fun TextShadow() {

    val offset = Offset(3.0f, 5.0f)
    Text(
        text = "Text in jetpack Compose",
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Blue,
                offset = offset, //смещение тени
                blurRadius = 3f  //размытие
            )
        )
    )
}

@Composable
fun LongText() {
    Text(
        text = "Text in Jetpack Compose.".repeat(10),
        modifier = Modifier
            .padding(16.dp),
        style = MaterialTheme.typography.bodyMedium,
        overflow = TextOverflow.Ellipsis,
        maxLines = 2,
    )
}


@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SimpleTextPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            StringResourceText()
        }

    }
}


