package com.pvmprog.mytextwithcompose.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.data.Constants.defaultFontSizeCode
import com.pvmprog.mytextwithcompose.data.Constants.githubExamples
import com.pvmprog.mytextwithcompose.data.locale.DataCodeUI
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import com.pvmprog.mytextwithcompose.ui.service.tranlate_new.HighlightColor
import com.pvmprog.mytextwithcompose.ui.service.tranlate_new.OutTextCodeNew
import com.pvmprog.mytextwithcompose.ui.service.translate_old.OutTextCodeOld
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun CodeScreen(
    modifier: Modifier = Modifier,
    item: ExampleCode = DataCodeUI.codeUI[0],
    fontSizeCode : Int = defaultFontSizeCode,
    onIntentClicked: (String) -> Unit ={}
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
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Text(
                text = stringResource(R.string.source_code),
                modifier = modifier
                    .weight(1f),
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(R.drawable.github),
                contentDescription = "View code program on github",
                modifier = Modifier
                    .size(30.dp)
                    .border(
                        BorderStroke(1.dp, Color.White),
                        CircleShape
                    )
                    .clip(CircleShape)
//                    .clip(RoundedCornerShape(6.dp))
                    .clickable {
                        if (item.nameFun != "")
                            onIntentClicked(githubExamples + item.nameFun)
                    }
            )
        }
        Spacer(modifier = spacerModifier)
/*
        OutTextCodeOld(
            message = item.code,
            highlight = item.highlightCode,
            fontSizeCode = fontSizeCode.sp
        )

 */
        OutTextCodeNew(
            message = item.code,
            fontSizeCode = fontSizeCode,
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
