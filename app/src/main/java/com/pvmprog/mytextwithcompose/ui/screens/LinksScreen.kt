package com.pvmprog.mytextwithcompose.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.data.locale.DataCodeUI
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import com.pvmprog.mytextwithcompose.ui.service.TextWithLink
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun LinksScreen(
    modifier:Modifier = Modifier,
    example: ExampleCode = DataCodeUI.codeUI[3],
    sizeFontText: Int = 18,     //: TextUnit = 18.sp

){
    val spacerModifier = Modifier
        .padding(horizontal = dimensionResource(id = R.dimen.padding_small))
        .height(2.dp)
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.primary)
        .padding(dimensionResource(id = R.dimen.padding_medium))


    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.recommended_links))

        Spacer(modifier = spacerModifier)

        for (link in example.links){
            if (link.url!=""){
                TextWithLink(
                    text = link.text,
                    textUrl = link.textUrl,
                    url = link.url,
                    sizeFontText = sizeFontText
                )
            }
        }
        Spacer(modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_spacer)))
    }

}

@Preview("Light Theme", showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LinksScreenPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            LinksScreen()
        }

    }
}
