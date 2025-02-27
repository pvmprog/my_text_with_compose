package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun BoxCenterLambdaFun(
    text: String = "Text in jetpack Compose",
    lambdaFun: @Composable (String) -> Unit = @Composable{},
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        lambdaFun(text)
    }

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BoxCenterLambdaFunPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            BoxCenterLambdaFun(
                lambdaFun = {
                    TextAnnotatedParagraph()
//                    MultipleStylesInText(fontSize = 40)
                            },
                modifier = Modifier
                    .fillMaxSize()
            )
        }

    }
}
