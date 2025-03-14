package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun Animation_AsStateRepeatable(){

    var expanded by remember { mutableStateOf(false) }

    val maxLines: Int by animateIntAsState(
        targetValue = if (expanded) 50 else 2,
        animationSpec = tween(durationMillis = 800, easing = FastOutSlowInEasing),
        label = "maxLines"
    )

    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.secondary
        else MaterialTheme.colorScheme.background,
        animationSpec = repeatable(
            iterations = 3,
            animation = tween(durationMillis = 300),
            repeatMode = RepeatMode.Reverse
        ),
        label = "repeatable spec"
    )

    LazyColumn {
        item {
            Card(
                modifier = Modifier
                    .border(1.dp, MaterialTheme.colorScheme.onBackground)
                    .background(color)
                    .padding(16.dp),
                onClick = { expanded = !expanded }
            ) {
                Text(
                    text = """
 repeatable многократно запускает анимацию на основе продолжительности (например, tween или keyframes ), пока не достигнет указанного количества итераций. Вы можете передать параметр repeatMode , чтобы указать, должна ли анимация повторяться, начиная с начала ( RepeatMode.Restart ) или с конца ( RepeatMode.Reverse ).                          
                    """.trimIndent(),
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    maxLines = maxLines,
                    overflow = TextOverflow.Ellipsis,

                    )
            }
        }
    }
}
@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Animation_AsStateRepeatablePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Animation_AsStateRepeatable()
        }

    }
}
