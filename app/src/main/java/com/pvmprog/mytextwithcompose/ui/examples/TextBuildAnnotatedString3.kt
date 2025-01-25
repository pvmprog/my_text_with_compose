package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun TextBuildAnnotatedString3() {
    val colorHour = MaterialTheme.colorScheme.primary
    val colorMin = MaterialTheme.colorScheme.outline
    val annotatedString = buildAnnotatedString {

        withStyle(
            style = ParagraphStyle(
                textAlign = TextAlign.Center
            )
        ) {
            withStyle(
                style = SpanStyle(
                    color = colorHour,
                    fontWeight = FontWeight.Bold,
                    fontSize = 60.sp,
                )
            ) {
                append("18")
            }
            append(" часов")
        }

        withStyle(
            style = ParagraphStyle(
                textAlign = TextAlign.Center
            )
        ) {
            withStyle(
                style = SpanStyle(
                    color = colorMin,
                    fontWeight = FontWeight.Bold,
                    fontSize = 50.sp,
                )
            ) {
                append("30")
            }
            withStyle(
                style = SpanStyle(
                    baselineShift = BaselineShift(+0.70f)
                )
            ) {
                append(" минут ")
            }
        }

        withStyle(
            style = ParagraphStyle(
                textAlign = TextAlign.Center,

            )
        ) {
            withStyle(
                style = SpanStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
            ) {
                append("$")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                )
            ) {
                append("0.99")
            }
        }

    }

    Text(
        text = annotatedString,
        modifier = Modifier
            .padding(16.dp)
    )

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextBuildAnnotatedString3Preview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TextBuildAnnotatedString3()

        }

    }
}
