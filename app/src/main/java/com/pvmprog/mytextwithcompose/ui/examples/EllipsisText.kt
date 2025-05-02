package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun EllipsisText(){

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )
    val text = "С чего начинается Родина? С картинки в твоем букваре.  С хороших и верных товарищей живущих в соседнем дворе. "
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .width(300.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(padding)
        ) {
            Text(text)
            Spacer(
                modifier = Modifier
                    .width(200.dp)
                    .padding(bottom = padding)
                    .background(MaterialTheme.colorScheme.onBackground)
                    .height(2.dp),
            )
            Text(
                text = text,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Text(
                text = text,
//                overflow = TextOverflow.StartEllipsis,
                maxLines = 1,
            )
            Text(
                text = text,
//                overflow = TextOverflow.MiddleEllipsis,
                maxLines = 1,
            )

        }

    }
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EllipsisTextPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            EllipsisText()
        }

    }
}
