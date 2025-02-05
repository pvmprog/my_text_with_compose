package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.service.OutTextTitleMessage
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun MessageShodow(
    message:String = stringResource(R.string.text_compose),
    style: TextStyle = TextStyle(
        textAlign = TextAlign.Center,
        fontFamily = Alice,
        fontSize = 35.sp,
        lineHeight = 46.sp,
        color = Color(0xfffcce36),
        shadow = Shadow(
            color = Color.Blue,
            offset = Offset(2.0f, -5.0f), //смещение тени
            blurRadius = 0f  //размытие
        )
    ),
    modifier: Modifier = Modifier
        .padding(16.dp)
        .background(Color.Black)
        .fillMaxWidth(),
){
    Text(
        text = message,
        modifier = modifier,
        style =style,
    )

}
@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MessageShodowPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            MessageShodow()
        }

    }
}
