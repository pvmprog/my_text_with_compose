package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun FontScale(
    fontSizeSp:Int = 18
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Масштабный коэф. : ${LocalDensity.current.fontScale}",
            textDecoration = TextDecoration.Underline,
            fontSize = fontSizeSp.sp
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Text [fontSize = 18.sp]\n зависит от маштаба",
            textAlign = TextAlign.Center,
            fontSize = fontSizeSp.sp
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Text [fontSize = 18.nonScaledSp()]\n не зависит от маштаба",
            textAlign = TextAlign.Center,
            fontSize = fontSizeSp.nonScaledSp()
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Text [fontSize = 4.6.em]\n не зависит от маштаба",
            textAlign = TextAlign.Center,
            fontSize = 4.6.em
        )

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
            text = stringResource(R.string.comment_font_scale),
            textAlign = TextAlign.Justify,
            letterSpacing = 1.3.sp,
            fontSize = 16.sp

        )
    }
}

@Composable
fun Int.nonScaledSp(): TextUnit {
    val value: Int = this
    return with(LocalDensity.current) {
        val fontScale = this.fontScale
        val textSize = value / fontScale
        textSize.sp
    }
}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FontScalePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            FontScale()
        }

    }
}
