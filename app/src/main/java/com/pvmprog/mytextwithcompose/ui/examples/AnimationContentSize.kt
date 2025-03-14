package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
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
fun AnimationContentSize(){

    var expanded by remember { mutableStateOf(false) }

    LazyColumn {
        item {
            Card(
                modifier = Modifier
                    .border(1.dp, MaterialTheme.colorScheme.onBackground)
                    .padding(16.dp),
                onClick = { expanded = !expanded }
            ) {
                Text(
                    text = """
Достоинства Jetpack Compose:
    Декларативный UI: Jetpack Compose использует декларативный синтаксис, который легко читать и понимать. Это напрямую влияет на скорость и качество разработки.

    Прост в освоении: фреймворк имеет низкий порог вхождения, потому что упрощает разработку пользовательских интерфейсов и помогает сократить объем кода.

    Тестирование UI: Jetpack Compose облегчает написание тестов пользовательского интерфейса на Kotlin. За счет этого жизнь программиста становится проще. Он может убедиться, что интерфейс работает корректно и без ошибок.

    Интерактивный UI: Jetpack Compose обеспечивает обновления в режиме реального времени при взаимодействии пользователя с интерфейсом. Таким образом, приложение выглядит более привлекательно в глазах юзера и его пользовательский опыт улучшается.

    Повторное использование: с помощью Jetpack Compose можно создавать многократно используемые компоненты UI, а затем использовать их на нескольких экранах и даже в разных приложениях. Это особенно важно при создании сложных пользовательских интерфейсов.

    Типобезопасность: Jetpack Compose построен на базе языка Kotlin, который обеспечивает строгую типизацию и помогает выявлять ошибки на этапе компиляции, а не во время выполнения программы. Это благоприятно сказывается на стабильности и надежности приложений.

    Простая отладка: Jetpack Compose поставляется с набором инструментов отладки, которые могут помочь разработчикам быстро идентифицировать и исправить проблемы в своем коде пользовательского интерфейса

    Гибкость: Jetpack Compose предлагает множество возможностей для проектирования UI. Программисты могут легко настраивать макеты, добавлять анимации и кастомизировать внешний вид приложения, не прибегая к написанию большого количества кода.

    Симпатии сообщества: Jetpack Compose – это относительно новый тулкит, но он уже получил много внимания среди разработчиков Android. Специалисты вносят свой вклад в развитие фреймворка, сообщество растет, а значит, инструмент может рассчитывать на поддержку и ресурсы.

Недостатки Jetpack Compose:

    Поддерживает только Kotlin. Это может быть недостатком для разработчиков, которые уже уверенно владеют другими языками программирования, например, Java, C++ или Swift. Они могут не захотеть вкладывать время и силы в изучение нового языка. Это также может быть проблемой для команд разработчиков с разными языковыми предпочтениями или уровнями навыков. Кроме того, не все сторонние библиотеки или инструменты, которые разработчики пожелают использовать в своих проектах, могут быть написаны на Kotlin. Поэтому возникают проблемы совместимости или дополнительная работа, необходимая для их интеграции с Jetpack Compose.

    Проблемы с отрисовкой UI‑компонентов. Во время рендеринга могут возникать лаги и задержки. Это связано с тем, что Compose предназначен для динамического рендеринга представлений, в отличие от традиционного подхода с использованием предварительно нарисованных XML‑макетов. Это означает, что процесс рендеринга может занять больше времени, особенно при работе с анимацией. Однако проблемы с производительностью часто можно смягчить, оптимизировав расположение UI‑компонентов и минимизировав количество рекомпозиций, происходящих в процессе рендеринга.

    Миграция. Если у вас есть готовое приложение на XML-макетах, то переход на Jetpack Compose может потребовать больших изменений кода. А это займет время.
                        
                    """.trimIndent(),
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .animateContentSize(),
                    maxLines = if (expanded) Int.MAX_VALUE
                    else 2,
                    overflow = TextOverflow.Ellipsis,

                )
            }
        }
    }
}
@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnimationContentSizePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AnimationContentSize()
        }

    }
}
