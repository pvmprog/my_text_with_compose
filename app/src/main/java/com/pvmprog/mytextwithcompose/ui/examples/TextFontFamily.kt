package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun TextFontFamily() {

    val modifier = Modifier
        .padding(top = 16.dp)
        .fillMaxWidth()

    val style = MaterialTheme.typography.bodyMedium.merge(
        TextStyle(
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            //шрифт с засечками
            fontFamily = FontFamily.Serif
        )
    )

    Column()
    {
        Text(
            text = "Text in jetpack Compose\n(Serif)",
            modifier = modifier,
            //шрифт с засечками
            style = style,
        )

        Text(
            text = "Text in jetpack Compose\n(SansSerif)",
            modifier = modifier,
            style = style.merge(
                TextStyle(
                    //шрифт без засечек
                    fontFamily = FontFamily.SansSerif
                )
            )
        )

        Text(
            text = "Text in jetpack Compose\n(Cursive)",
            modifier = modifier,
            style = style.merge(
                TextStyle(
                    //курсивный, рукописный шрифт
                    fontFamily = FontFamily.Cursive
                )
            )
        )

        Text(
            text = "Text in jetpack Compose\n(Monospace)",
            modifier = modifier,
            style = style.merge(
                TextStyle(
                    //моноширинный шрифт
                    //(все знаки имеют одинаковую ширину)
                    fontFamily = FontFamily.Monospace
                )
            )
        )

        Text(
            text = "Text in jetpack Compose\n(Default)",
            modifier = modifier,
            style = style.merge(
                TextStyle(
                    //шрифт по умолчанию на текущей платформе
                    fontFamily = FontFamily.Default
                )
            )
        )

    }

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextWithLinkPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TextFontFamily()
        }

    }
}
