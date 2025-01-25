package com.pvmprog.mytextwithcompose.ui.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.AbrilFatface
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.Cabin
import com.pvmprog.mytextwithcompose.ui.theme.Cormorantinfant
import com.pvmprog.mytextwithcompose.ui.theme.Poppins

/*
                 Альтернативные шрифты

 ui/theme/Type.kt

    val Cabin = FontFamily(
        Font(R.font.cabin_regular, FontWeight.Normal),
        Font(R.font.cabin_bold, FontWeight.Bold)
    )

    val Poppins = FontFamily(
        Font(R.font.poppins_medium, FontWeight.Medium),
        Font(R.font.poppins_regular, FontWeight.Normal),
        Font(R.font.poppins_bold, FontWeight.Bold)
    )

    val AbrilFatface = FontFamily(
        Font(R.font.abril_fatface_regular)
    )

    val Alice = FontFamily(
        Font(R.font.alice_regular)
    )

//шрифт курсивный для кириллицы
    val Cormorantinfant = FontFamily(
        Font(R.font.cormorantinfant_regular, FontWeight.Normal),
        Font(R.font.cormorantinfant_medium, FontWeight.Medium),
        Font(R.font.cormorantinfant_bold, FontWeight.Bold),
        Font(R.font.cormorantinfant_light, FontWeight.Light),
        Font(R.font.cormorantinfant_italic, FontWeight.Normal,FontStyle.Italic),
        Font(R.font.cormorantinfant_mediumitalic, FontWeight.Medium,FontStyle.Italic),
        Font(R.font.cormorantinfant_bolditalic, FontWeight.Bold,FontStyle.Italic),
        Font(R.font.cormorantinfant_lightitalic, FontWeight.Light,FontStyle.Italic),
    )

 */

data class FontExample(
    val nameFont: String = "",
    val style: TextStyle = TextStyle()
)

@Composable
fun TextFontFamalyAlternate() {

    var style = MaterialTheme.typography.bodyMedium.merge(
        TextStyle(
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
            fontFamily = Cabin,
            fontStyle = FontStyle.Normal
        )
    )

    val fonts = listOf(
        FontExample(
            nameFont = "Serif",
            style = style.merge(
                TextStyle(
                    fontFamily = FontFamily.Serif
                )
            )
        ),
        FontExample(
            nameFont = "Cabin",
            style = style.merge(
                TextStyle(
                    fontFamily = Cabin
                )
            )
        ),
        FontExample(
            nameFont = "Poppins",
            style = style.merge(
                TextStyle(
                    fontFamily = Poppins
                )
            )
        ),
        FontExample(
            nameFont = "AbrilFatface",
            style = style.merge(
                TextStyle(
                    fontFamily = AbrilFatface
                )
            )
        ),
        FontExample(
            nameFont = "Alice",
            style = style.merge(
                TextStyle(
                    fontFamily = Alice
                )
            )
        ),
        FontExample(
            nameFont = "Cormorantinfant",
            style = style.merge(
                TextStyle(
                    fontFamily = Cormorantinfant
                )
            )
        ),
    )


    var nameFont: String
    val text = "Альтернативные шрифты."

    Column {
        for (item in fonts) {
            nameFont = item.nameFont
            style = item.style

            Text(
                text = "$text ($nameFont)",
                style = style
            )

            Text(
                text = "$text - Italic",
                style = style.merge(
                    TextStyle(
                        fontStyle = FontStyle.Italic
                    )
                )
            )

            Text(
                text = "$text - Bold",
                style = style.merge(
                    TextStyle(
                        fontWeight = FontWeight.Bold,
                    )
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
        }


    }

}
