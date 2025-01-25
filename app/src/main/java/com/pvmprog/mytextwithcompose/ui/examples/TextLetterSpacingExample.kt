package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun TextLetterSpacingExample() {

    val outText = "Text in jetpack Compose."

    val modifierText = Modifier
        .padding(top = 16.dp)

    val style = MaterialTheme.typography.bodyMedium

    Column {

        Text(
            text = outText,
            modifier = modifierText,
            style = style,
        )

        Text(
            text = outText,
            modifier = modifierText,
            style = style,
            letterSpacing = 1.3.sp
        )

        Text(
            text = outText,
            modifier = modifierText,
            style = style,
            letterSpacing = 0.3.em
        )

    }

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextLetterSpacingExamplePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TextLetterSpacingExample()
        }

    }
}
