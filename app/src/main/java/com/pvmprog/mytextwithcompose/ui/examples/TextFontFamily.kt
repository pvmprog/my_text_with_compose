package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun TextFontFamily() {

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val style = MaterialTheme.typography.bodyMedium.merge(
        TextStyle(
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            //шрифт с засечками
            fontFamily = FontFamily.Serif
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.onBackground)
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(padding)
            ) {
                Text(
                    text = "Text in jetpack Compose\n(Serif)",
                    //шрифт с засечками
                    style = style,
                )

                Text(
                    text = "Text in jetpack Compose\n(SansSerif)",
                    style = style.merge(
                        TextStyle(
                            //шрифт без засечек
                            fontFamily = FontFamily.SansSerif
                        )
                    )
                )

                Text(
                    text = "Text in jetpack Compose\n(Cursive)",
                    style = style.merge(
                        TextStyle(
                            //курсивный, рукописный шрифт
                            fontFamily = FontFamily.Cursive
                        )
                    )
                )

                Text(
                    text = "Text in jetpack Compose\n(Monospace)",
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
                    style = style.merge(
                        TextStyle(
                            //шрифт по умолчанию на текущей платформе
                            fontFamily = FontFamily.Default
                        )
                    )
                )

            }

        }

    }

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextFontFamilyPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TextFontFamily()
        }

    }
}
