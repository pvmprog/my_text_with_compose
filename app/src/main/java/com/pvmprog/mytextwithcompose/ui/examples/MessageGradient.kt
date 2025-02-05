package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun MessageGradient(
    isExpanded: Boolean = false,
    message: String = stringResource(R.string.text_compose),
    brushColors: List<Color> = listOf(
        Color.Cyan,
        Color.Yellow,
        Color.Green,
    ),
    StartDp:Int = 0,
    endDp:Int = 300,
    tileMode: TileMode = TileMode.Clamp,
    style: TextStyle = LocalTextStyle.current,
    modifier: Modifier = Modifier

) {
    val context = LocalContext.current

    val startPx = (StartDp.dp * context.resources.displayMetrics.density).value
    val endPx = (endDp.dp * context.resources.displayMetrics.density).value

    val brush = Brush.horizontalGradient(
        colors = brushColors,
        startX = startPx,
        endX = endPx,
        tileMode = tileMode
    )
    Text(
        text = message,
        modifier = modifier,
        style = style.merge(
            TextStyle(
                fontFamily = FontFamily.Cursive,
                brush = brush
            )
        )
    )

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MessageGradientPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            MessageGradient(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.Black)
                    .padding(16.dp),
                    style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontFamily = Alice,
                    fontSize = 35.sp,
                    lineHeight = 46.sp,
                ),
                brushColors = listOf(
                    Color.Cyan,
                    Color.Yellow,
                    Color.Green,
                ),
                StartDp = 0,
                endDp = 100,
                tileMode = TileMode.Mirror
                )
        }

    }
}
