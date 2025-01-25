package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun AnnotatedHtmlString(
    modifier: Modifier = Modifier,
    htmlText: String = """
 <h1>Text in Jetpack Compose</h1>

 <p>
  Simple <b>MVVM</b> 
  <a href="https://www.android.com">App</a> 
  to demonstrate text output in Jetpack Compose.
 </p>

Examples:
<ul>
 <li> Sizes and padding;</li>
 <li> Text and background color;</li>
 <li> Text alignment;</li>
 <li> Font usage;</li>
 <li> Text annotation;</li>
 <li> Text frame, underline and borders;</li>
 <li> Text animation.</li>
</ul>
           """.trimIndent(),
) {

//AnnotatedString.fromHtml() преобразует строку htmlText в AnnotatedString

    val textFromHtml = AnnotatedString.fromHtml(
        htmlString = htmlText,
        linkStyles = TextLinkStyles(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline,
                fontStyle = FontStyle.Italic,
                color = Color.Blue
            )
        )
    )
    Text(
        text = textFromHtml,
        modifier = modifier
    )
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnnotatedHtmlStringWithLinkPreview() {
    MyTextWithComposeTheme {
        AnnotatedHtmlString()
    }
}
