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
import com.pvmprog.mytextwithcompose.ui.service.OutTextMessage
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun MessageScreen(
    message: String = "",
    sizeFontText: Int = 18,     //: TextUnit = 18.sp
    isNormalStyle: Boolean = true,
    isColorBackground: Boolean = false,
    isColorBorder: Boolean = false,
    isShapeLarge: Boolean = false,
    isTextCenter: Boolean = false,
    maxLines:Int = Int.MAX_VALUE,
    modifier:Modifier = Modifier
) {
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
        Text(stringResource(R.string.a_bit_of_theory))
        Spacer(modifier = spacerModifier)
        OutTextMessage(
            message = message,
            sizeFontText = sizeFontText,
            isNormalStyle = isNormalStyle,
            isColorBackground = isColorBackground,
            isColorBorder = isColorBorder,
            isShapeLarge = isShapeLarge,
            isTextCenter = isTextCenter,
            maxLines = maxLines,
        )

    }
}

@Preview("Light Theme", showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MessageScreenPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            MessageScreen(
                message = """
|Ресурсы| — это дополнительные файлы и |!статический| контент, который использует приложение.
                   
                    """.trimIndent(),
                sizeFontText = 18,
                isNormalStyle = true,
                isColorBackground = false,
                isColorBorder = true,
                isShapeLarge = false,
                isTextCenter = false
            )

        }

    }
}
