package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

/*
Важно: известна проблема с liveRegion, которая предотвращает речевые объявления при изменении параметра text. Текущий способ решения проблемы — назначить тот же текст contentDescription
 */
@Composable
fun SemanticsText(){

    var changingText by remember {
        mutableStateOf("Измененный текст")
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = changingText,
            textAlign = TextAlign.Center,
            modifier = Modifier.semantics {
                liveRegion = LiveRegionMode.Polite
                contentDescription = changingText
            }
        )

        Button(
            modifier = Modifier
                .padding(all = 16.dp),
            onClick = {},
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                modifier = Modifier
                    .clickable(
                        onClickLabel = "Генерация числа случайным образом",
                        onClick = {
                            val num = (1..50).random()
                            changingText = num.toString()
                        }
                    ),
                text = "Generation",
                style = MaterialTheme.typography.bodySmall,
            )

        }

        Text(
            text = stringResource(R.string.talkback_generation),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Justify,
        )

    }

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SemanticsTextPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            SemanticsText()
        }

    }
}
