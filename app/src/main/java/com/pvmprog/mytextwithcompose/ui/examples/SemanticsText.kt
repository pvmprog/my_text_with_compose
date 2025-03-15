package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

/*
Важно: известна проблема с liveRegion, которая предотвращает речевые объявления при изменении параметра text. Текущий способ решения проблемы — назначить тот же текст contentDescription
 */
@Composable
fun SemanticsText(){

    var expanded by remember { mutableStateOf(false) }

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

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.onBackground)
                .padding(16.dp),
            onClick = { expanded = !expanded }
        ) {
            Crossfade(
                targetState = expanded,
                label = "cross fade"
            ) { state ->
                when (state) {
                    true -> ExpandedText()
                    else -> ContentIcon()
                }
            }

        }

    }

}

@Composable
private fun ContentIcon(
    text: String = "Комментарий ...",
    expanded: Boolean = false
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Text(
            text = text,
            modifier = Modifier
                .weight(1f),
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = "",
            modifier = Modifier.rotate(if (expanded) 180F else 0f)
        )
    }
}

@Composable
private fun ExpandedText(){
    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        ContentIcon("Комментарий к примеру",true)

        Text(
            text = stringResource(R.string.talkback_generation),
            textAlign = TextAlign.Justify,
            letterSpacing = 1.3.sp,
            fontSize = 16.sp

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
