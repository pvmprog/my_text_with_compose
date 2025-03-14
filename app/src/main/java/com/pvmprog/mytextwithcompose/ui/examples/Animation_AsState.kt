package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
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
fun Animation_AsState(){

    var expanded by remember { mutableStateOf(false) }

    val maxLines: Int by animateIntAsState(
        targetValue = if (expanded) 50 else 2,
        animationSpec = tween(durationMillis = 800, easing = FastOutSlowInEasing),
        label = "maxLines"
    )

    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.secondary
        else MaterialTheme.colorScheme.background,
        label = "",
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
 Функции animate*AsState — это простейшие API-интерфейсы анимации в Compose для анимации одного значения. Вы указываете только целевое значение (или конечное значение), и API запускает анимацию от текущего значения до указанного значения.
 
 Не нужно создавать экземпляр какого-либо класса анимации или обрабатывать прерывания. Под капотом объект анимации (а именно, экземпляр Animatable ) будет создан и запомнен в месте вызова с первым целевым значением в качестве начального значения. С этого момента каждый раз, когда вы указываете этому составному элементу другое целевое значение, автоматически запускается анимация для достижения этого значения. Если в полете уже есть анимация, она начинается с текущего значения (и скорости) и анимируется в направлении целевого значения. Во время анимации этот составной объект перекомпоновывается и возвращает обновленное значение анимации каждый кадр.
                          
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
fun Animation_AsStatePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Animation_AsState()
        }

    }
}
