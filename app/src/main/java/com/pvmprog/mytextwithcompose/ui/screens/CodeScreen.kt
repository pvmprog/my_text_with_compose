package com.pvmprog.mytextwithcompose.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.data.Constants.defaultFontSizeCode
import com.pvmprog.mytextwithcompose.data.locale.DataCodeUI
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import com.pvmprog.mytextwithcompose.ui.service.OutTextCode
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun CodeScreen(
    modifier: Modifier = Modifier,
    item: ExampleCode = DataCodeUI.codeUI[0],
    fontSizeCode : Int = defaultFontSizeCode
){
    Column(
        modifier = modifier
    ) {
        OutTextCode(
            message = item.code,
            highlight = item.highlightCode,
            fontSizeCode = fontSizeCode.sp
        )
    }
}
@Preview("Light Theme", showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OutTextCodePreview() {
    MyTextWithComposeTheme {
        CodeScreen(
            modifier = Modifier.fillMaxWidth(),
            item = DataCodeUI.codeUI[19],

        )
    }
}
