package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun AnimationCrossfade() {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {

        var temp by remember { mutableIntStateOf(10) }

        var currentState by remember { mutableStateOf("fine") }

        var expanded by remember { mutableStateOf(false) }

        currentState = when{
            temp >= 40 -> "hot"
            temp <  0 -> "сold"
            else -> "fine"
        }

        val colorTxt = when (currentState) {
            "hot" -> Color.White
            "сold" -> Color.White
            else -> MaterialTheme.colorScheme.tertiaryContainer
        }

        val colorBg = when (currentState) {
            "hot" -> Color.Red
            "сold" -> Color.Blue
            else -> MaterialTheme.colorScheme.onTertiaryContainer
        }

        val modifier = Modifier
            .background(colorBg)
            .padding(8.dp)


        val text = stringResource(id = R.string.temperature,temp)

        Text(
            text = text,
            modifier = modifier,
            color = colorTxt
        )

        AnimatedContent(
            targetState = temp,
            label = "animated content"
        ) {
            Text(
                stringResource(id = R.string.temperature,it),
                modifier = modifier,
                color = colorTxt
                )
        }

        Crossfade(
            targetState = currentState,
            label = "cross fade"
        ) { state ->
            when (state) {
                "hot" -> Text(text,modifier,colorTxt)
                "fine" -> Text(text,modifier,colorTxt)
                "сold" -> Text(text,modifier,colorTxt)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { temp += 10 }
            ) {
                Text("Add")
            }

            Button(
                onClick = { temp -= 10 }
            ) {
                Text("Subb")
            }

        }

        Surface(
            color = MaterialTheme.colorScheme.primary,
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
){
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Text(
            text = "Комментарий ...",
            textAlign = TextAlign.Start,
            fontSize = 20.sp
        )
        Icon(
            Icons.Default.ArrowDropDown, "",
        )
    }
}

@Composable
private fun ExpandedText(){
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.outlineVariant)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Text(
                text = "Комментарий к примеру",
                modifier = Modifier
                    .fillMaxWidth(0.9F),
                fontSize = 20.sp
            )
            Icon(
                Icons.Default.ArrowDropDown, "",
                modifier = Modifier.rotate(180F)
            )
        }
        Text(
            text = """
В примере представлены 3-и варианта отображения текста:                 

Первая строка:  отображение по умолчанию;

Вторая строка: использование анимации AnimatedContent;
                        
Третья строка: использование анимации Crossfade.

                    """.trimIndent(),
            fontSize = 18.sp

        )
    }
}


@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnimationCrossfadePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AnimationCrossfade()
        }

    }
}
