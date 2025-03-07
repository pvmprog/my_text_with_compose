package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.text.Spanned
import android.text.TextUtils.htmlEncode
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import androidx.core.text.toHtml
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun AnnotatedHtmlString(
    modifier: Modifier = Modifier,
    htmlText: String = """
<h2>Здравствуй, друг!</h2>

<p>
 Создавайте  <big><b>отличные</b></big> приложения <br>  
 <small>с помощью</small> <br> 
 <a href="https://developer.android.com/compose">Jetpack Compose</a>
</p>

<p >
 Поднимите свою повседневную жизнь <br> 
 <big><font face="monospace" color="#3CEE0A"> на новый уровень</font></big> <br> 
 <small>с помощью</small> <br> 
 искусственного интеллекта <br> 
  <a href="https://www.android.com/ai/#gemini"> 
    <font face="cursive">Google</font>
  </a>
</p>
           """.trimIndent(),
) {

    val welcome = stringResource(R.string.welcome_html,"Pavel",12)

    val textFromHtml = AnnotatedString.fromHtml(
        htmlString = htmlText,
        linkStyles = TextLinkStyles(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline,
                fontStyle = FontStyle.Italic,
                fontSize = 30.sp,
                color = Color.Cyan,
                letterSpacing = 2.sp,
            )
        )
    )
    LazyColumn {
        item {
            Text(
                text = textFromHtml,
                color = Color.Yellow,
                textAlign = TextAlign.Center,
                lineHeight = 48.sp,
                modifier = modifier
                    .background(Color.Black)
                    .padding(16.dp)
            )

        }
    }
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnnotatedHtmlStringWithLinkPreview() {
    MyTextWithComposeTheme {

        BoxCenterLambdaFun(
            lambdaFun = { AnnotatedHtmlString() },
            modifier = Modifier
                .fillMaxSize()
        )

    }
}
