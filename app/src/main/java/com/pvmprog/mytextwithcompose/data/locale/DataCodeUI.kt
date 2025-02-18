package com.pvmprog.mytextwithcompose.data.locale

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.pvmprog.mytextwithcompose.data.locale.DataHighCode.highCodeList
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import com.pvmprog.mytextwithcompose.data.model.HighlightCode
import com.pvmprog.mytextwithcompose.data.model.TextClickLink
import com.pvmprog.mytextwithcompose.ui.examples.AnimationBgGradient
import com.pvmprog.mytextwithcompose.ui.examples.AnimationSizeText
import com.pvmprog.mytextwithcompose.ui.examples.SimpleAlign
import com.pvmprog.mytextwithcompose.ui.examples.AnnotatedHtmlString
import com.pvmprog.mytextwithcompose.ui.examples.BackgroundDriver
import com.pvmprog.mytextwithcompose.ui.examples.DrawAnimeScaleAText
import com.pvmprog.mytextwithcompose.ui.examples.DrawTextCanvas
import com.pvmprog.mytextwithcompose.ui.examples.ExampleFontSize
import com.pvmprog.mytextwithcompose.ui.examples.GradientDriver
import com.pvmprog.mytextwithcompose.ui.examples.GradientOverview
import com.pvmprog.mytextwithcompose.ui.examples.TextFontWeight
import com.pvmprog.mytextwithcompose.ui.examples.ItalicText
import com.pvmprog.mytextwithcompose.ui.examples.SimpleLimit
import com.pvmprog.mytextwithcompose.ui.examples.MultipleStylesInText
import com.pvmprog.mytextwithcompose.ui.examples.ScaleDraver
import com.pvmprog.mytextwithcompose.ui.examples.ShaderAnimation
import com.pvmprog.mytextwithcompose.ui.examples.TextInCenterBox
import com.pvmprog.mytextwithcompose.ui.examples.ShaderDriver
import com.pvmprog.mytextwithcompose.ui.examples.ShadowDriver
import com.pvmprog.mytextwithcompose.ui.examples.SimpleWithPadding
import com.pvmprog.mytextwithcompose.ui.examples.Simple
import com.pvmprog.mytextwithcompose.ui.examples.SimpleStringResource
import com.pvmprog.mytextwithcompose.ui.examples.SimpleAlignJustify
import com.pvmprog.mytextwithcompose.ui.examples.TextAlignedHeight
import com.pvmprog.mytextwithcompose.ui.examples.TextAnnotatedStringClickLink
import com.pvmprog.mytextwithcompose.ui.examples.TextBuildAnnotatedString
import com.pvmprog.mytextwithcompose.ui.examples.TextBuildAnnotatedString1
import com.pvmprog.mytextwithcompose.ui.examples.TextBuildAnnotatedString3
import com.pvmprog.mytextwithcompose.ui.examples.TextColorAny
import com.pvmprog.mytextwithcompose.ui.examples.TextFontFamalyAlternate
import com.pvmprog.mytextwithcompose.ui.examples.TextFontFamily
import com.pvmprog.mytextwithcompose.ui.examples.TypographyStyles

object DataCodeUI {
    val codeUI: List<ExampleCode> = listOf(
        ExampleCode(
            id = 0,
            title = "Простой текст",
            comment = """
Самый простой способ отображения текста — использовать компонент |Text| со |!String| в качестве аргумента.

|!Параметры компонента|:

|text|:String - выводимый текст
  или
|text|:AnnotatedString - текста с несколькими стилями. 

|modifier| - применяемые к компоненту модификаторы.

|color| - цвет текста. По умолчанию  |!Color.Unspecified| - наследуется от настроек родительного компонента

|fontSize| - размер шрифта.

|fontStyle| - стиль шрифта.

|fontWeight| - толщина шрифта.

|fontFamily| - тип шрифта.

|letterSpacing| - отступы между символами.

|textDecoration| - тип декораций (например, подчеркивание).

|textAlign| - выравнивание текста.

|lineHeight| - высота строки текста.

|overflow| - определяет поведение текста при его выходе за границы контейнера. 

|softWrap| - определяет, должен ли текст переносится при завершении строки. 

|maxLines| - максимальное количество строк. Если текст превысил установленное количество строк, то он усекается в соответствии с параметрами overflow и softWrap.

|onTextLayout| - представляет функцию, выполняемую при определении компоновки текста.

|style| - стиль текста.
                        
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации на",
                    textUrl = "\uD83D\uDCD6 Developers", //📗 📖
                    url = "https://developer.android.com/develop/ui/compose/text?hl=ru"
                ),
                TextClickLink(
                    text = "Шкала стилей",
                    textUrl = "\uD83D\uDCD6 Type scale",
                    url = "https://m3.material.io/styles/typography/type-scale-tokens"
                ),

                ),
            highlightCode = highCodeList +listOf(
                HighlightCode("Simple", Color(0xFFffc530)),
                HighlightCode("Text", Color(0xFF3CEE0A)),
            ),
            lambdaFun =  @Composable { Simple() },
            code ="""
                @Composable
                fun Simple() {
                    Text("Hello, World!")
                }
            """.trimIndent()
        ),
        ExampleCode(
            id = 1,
            title = "Текст с отступом",
            comment = """
Используйте Modifier.|padding| для установки отступов.
Варианты отступов:
1)|!от каждой стороны по отдельности|:
fun Modifier.|padding|(
   |start|: Dp = 0.dp, 
   |top|: Dp = 0.dp, 
   |end|: Dp = 0.dp, 
   |bottom|: Dp = 0.dp
): Modifier
2)|!по вертикали и по горизонтали|:
fun Modifier.|padding|(
    |horizontal|: Dp = 0.dp, 
    |vertical|: Dp = 0.dp
): Modifier
3)|!от всех четырех сторон|:
fun Modifier.|padding|(
    |all|: Dp
): Modifier
4)|!в виде объекта PaddingValues|:
fun Modifier.|padding|(
    |paddingValues|: PaddingValues
): Modifier
               
В модификаторе может быть несколько отступов, порядок их расположения имеет значение. Отступы, добавленные первыми, будут применены первыми.               

    val externalPadding = |PaddingValues|(
        |start| = 16.dp,
        |top| = 16.dp,
    )

    val innerPadding = |PaddingValues|(
        |all| = 16.dp,
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Text(
            text = "Hello, world!",
            modifier = Modifier
                .|padding|(externalPadding)
                .background(Color.Blue)
                .|padding|(innerPadding),
            color = Color.White
        )
    }|
               
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите в ",
                    textUrl = "\uD83D\uDCD6 Compose modifiers ",
                    url = "https://developer.android.com/develop/ui/compose/modifiers?hl=ru"
                ),
            ),
            highlightCode = highCodeList + listOf(
                HighlightCode("SimpleWithPadding", Color(0xFFffc530)),
                HighlightCode("16", Color(0xFF2DB8FF)),
                HighlightCode(".padding ", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { SimpleWithPadding() },

            code ="""
@Composable
fun SimpleWithPadding() {
    Text (
        text = "Hello, World!",
        modifier = Modifier
//одинаковый отступ со всех сторон        
            .padding (16.dp)                   

    )
}
            """.trimIndent()
        ),
        ExampleCode(
            id = 2,
            title = "Использование ресурсов",
            comment = """
Используйте API |stringResource| для получения строки, статически определенной в ваших |!XML| ресурсах.
                
Один раз определили и можно использовать много раз.

|!res/values/strings.xml|
  <|string| name="text_in_jetpack_compose">Text in jetpack Compose</string>

  <|string| name="day_of_month">There are %2${'$'}d days in %1${'$'}s</string>

|!res/values/dimens.xml|
  <|dimen| name="padding_medium">16dp</dimen>

                
            """.trimIndent(),

            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите в ",
                    textUrl = "\uD83D\uDCD6 Ресурсы в Compose",
                    url = "https://developer.android.com/develop/ui/compose/resources?hl=ru#strings"
                ),
            ),
            highlightCode = highCodeList + listOf(
                HighlightCode("SimpleStringResource", Color(0xFFffc530)),
                HighlightCode("31", Color(0xFF2DB8FF)),
                HighlightCode(".day_of_month", Color(0xFFe48def)),
                HighlightCode("January", Color(0xFFFFEB3B)),
                HighlightCode("stringResource", Color(0xFF3CEE0A)),
                HighlightCode("dimensionResource", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { SimpleStringResource() },
            code ="""
@Composable
fun SimpleStringResource() {
    val text1 = stringResource(
        id = R.string.hello_world
    )

//позиционное форматирование
    val text2 = stringResource(
        id = R.string.day_of_month, "January", 31
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    Column(
        modifier = Modifier
            .padding (padding)
    ){
        Text (text = text1)
        Text (
            text = text2,
            modifier = Modifier
                .padding (bottom = padding)

        )
    }
}
            """.trimIndent()
        ),
        ExampleCode(
            id = 3,
            title = "Размер шрифта",
            comment = """
Размер шрифта определяется параметром |fontSize|. 

В качестве параметру может передаваться значение типов |Int|, |Double| и |Float|, после которых указывается тип единиц: 
 1)|!sp| - масштабируемые пиксели (например, 28.sp); 
 2)|!em| - относительный размер шрифта (например, 18.em).
  
Значение |!TextUnit.Unspecified| указывает, что высота шрифта наследуется от настроек родительного компонента.
                
                
Рекомендации при установке размера текста:
 |Заголовки страниц|(|!22|sp)
 |Текст абзаца|(|!14|sp)
 |Заголовки списков|(|!14|sp)
 |Важные фрагменты текста|(|!16|sp)
 |Вторичный текст, подписи|(|!14|sp)
 |Кнопки, вкладки|(|!14|sp)
 |Ввод текста|(|!16|sp)
     
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите в ",
                    textUrl = "\uD83D\uDCD6 Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Material Design 3 в Compose",
                    textUrl = "\uD83D\uDCD6 MaterialTheme.typography",
                    url = "https://developer.android.com/develop/ui/compose/designsystems/material3?hl=ru"
                ),
            ),

            nameFun = "",
            highlightCode = highCodeList + listOf(
                HighlightCode("ExampleFontSize", Color(0xFFffc530)),
                HighlightCode("fontSize", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { ExampleFontSize() },
            code = """
@Composable
fun ExampleFontSize() {
    val text = stringResource(
        id = R.string.hello_world
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    Column(
        modifier = Modifier
            .padding (padding)
            .fillMaxWidth (),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text (
            text = text + "(default)",
            fontSize = TextUnit.Unspecified
        )
        Text (
            text = text + "(20.sp)",
            fontSize = 20.sp
        )
        Text (
            text = text + "(3.em)",
            fontSize = 3.em
        )
        Text (
            text = text + "(15.sp)",
            style = TextStyle(
                fontSize = 15.sp,
            )
        )


    }

}
            """.trimIndent()
        ),

        ExampleCode(
            id = 3,
            title = "Анимация размера",
            comment = """
Экземпляр |InfiniteTransition| используется для управления дочерними анимациями.

    val infiniteTransition = rememberInfiniteTransition()

Для анимации размера шрифта необходимо создать дочернюю анимацию типа |float|, как часть |InfiniteTransition|.

val size by
    infiniteTransition.animateFloat(
        |initialValue| = 10f, |! Начальный размер шрифта| 
        |targetValue| = 120f, |! Конечный размер шрифта|
        animationSpec =
        infiniteRepeatable(
            |!// Бесконечное повторение анимации длительностью 10000 мс с использованием кривой замедления LinearOutSlowInEasing|
            animation = tween(10000, easing = LinearEasing),
            |!// После каждой итерации анимации (т. е. каждые 10000 мс) анимация будет начинаться  реверсном порядке, т.е. с [targetValue]|
            repeatMode = RepeatMode.Reverse
        )
    )
     
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите в ",
                    textUrl = "\uD83D\uDCD6 Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Анимации в Compose",
                    textUrl = "\uD83D\uDCD6 Animations in Compose ",
                    url = "https://developer.android.com/develop/ui/compose/animation/introduction"
                ),
            ),

            nameFun = "",
            highlightCode = highCodeList + listOf(
                HighlightCode("AnimationSizeText", Color(0xFFffc530)),
                HighlightCode("fontSize", Color(0xFF3CEE0A)),
                HighlightCode("initialValue", Color(0xFF3CEE0A)),
                HighlightCode("targetValue", Color(0xFF3CEE0A)),
                HighlightCode("10f", Color(0xFF5EADD6)),
                HighlightCode("170f", Color(0xFF5EADD6)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { AnimationSizeText() },
            code = """
@Composable
fun AnimationSizeText(
    text: String ="Ш Б",
){

    // Создает экземпляр [InfiniteTransition] для управления дочерними анимациями
    val infiniteTransition = rememberInfiniteTransition()

    // Создает дочернюю анимацию типа float как часть [InfiniteTransition].
    val size by
    infiniteTransition.animateFloat(
        initialValue = 10f,
        targetValue = 170f,
        animationSpec =
        infiniteRepeatable(
            // Бесконечное повторение анимации длительностью 5000 мс с использованием кривой замедления LinearOutSlowInEasing
            animation = tween(20000, easing = LinearEasing),
            // После каждой итерации анимации (т. е. каждые 5000 мс) анимация будет начинаться снова с [initialValue]
            repeatMode = RepeatMode.Reverse
        )
    )


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = size.sp,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold
            )
    }

}
                
            """.trimIndent()
        ),

        ExampleCode(
            id = 4,
            title = "Типографика Material 3",
            comment = """
Набор стилей |Typography| можно использовать и для определения размера шрифта текста. 

|Typography|(

|!//Отображаемый текст|
    |displayLarge|: TextStyle,   
    |displayMedium|: TextStyle, 
    |displaySmall|: TextStyle,  

|!//Новости одной строкой 
Предназначен для короткого, важного текста или цифр.
Для headline можно выбрать выразительный, нетрадиционный шрифт, например рукописный,который помогают привлечь внимание.|
    |headlineLarge|: TextStyle,  
    |headlineMedium|: TextStyle, 
    |headlineSmall|: TextStyle,

|!//Заголовок 
Используется для текста со средним акцентом, короткими по длине. 
Шрифты с засечками или без засечек хорошо подходят для заголовкой.|
    |titleLarge|: TextStyle,     
    |titleMedium|: TextStyle,
    |titleSmall|: TextStyle,
    
|!//Основной текст 
Обычно используется для длинного письма.| 
    bodyLarge: TextStyle,      
    bodyMedium: TextStyle,
    bodySmall: TextStyle,
  
|!//Метка 
Это призыв к действию, используемый в различных типах кнопок, а также во вкладках, диалоговых окнах и карточках. 
Текст кнопки, как правило, без засечек, заглавными буквами.|
    |labelLarge|: TextStyle,   
    |labelMedium|: TextStyle,
    |labelSmall|: TextStyle    
    
  )
  
 |displayLarge| - самый большой отображаемый текст. 
 |labelSmall| - один из самых маленьких размеров шрифта. 
 
 Пример использования:
        Text(
            text = "Hello, World!",
            style = MaterialTheme.typography.|titleLarge|
        )

            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Типографика помогает сделать текст разборчивым и красивым.",
                    textUrl = "\uD83D\uDCD6 MaterialTheme.typography",
                    url = "https://m3.material.io/styles/typography/overview"
                ),
                TextClickLink(
                    text = "Шкала стилей",
                    textUrl = "\uD83D\uDCD6 Type scale",
                    url = "https://m3.material.io/styles/typography/type-scale-tokens"
                ),
                TextClickLink(
                    text = "Jetpack Compose предлагает реализацию",
                    textUrl = "\uD83D\uDCD6 Material Design 3 в Compose",
                    url = "https://developer.android.com/develop/ui/compose/designsystems/material3?hl=ru"
                ),
            ),

            nameFun = "",
            highlightCode = highCodeList + listOf(
                HighlightCode("TypographyStyles", Color(0xFFffc530)),
                HighlightCode(".displayLarge", Color(0xFF3CEE0A)),
                HighlightCode(".displayMedium", Color(0xFF3CEE0A)),
                HighlightCode(".displaySmall", Color(0xFF3CEE0A)),
                HighlightCode(".headlineLarge", Color(0xFF3CEE0A)),
                HighlightCode(".headlineMedium", Color(0xFF3CEE0A)),
                HighlightCode(".headlineSmall", Color(0xFF3CEE0A)),
                HighlightCode(".titleLarge", Color(0xFF3CEE0A)),
                HighlightCode(".titleMedium", Color(0xFF3CEE0A)),
                HighlightCode(".titleSmall", Color(0xFF3CEE0A)),
                HighlightCode(".bodyLarge", Color(0xFF3CEE0A)),
                HighlightCode(".bodyMedium", Color(0xFF3CEE0A)),
                HighlightCode(".bodySmall", Color(0xFF3CEE0A)),
                HighlightCode(".labelLarge", Color(0xFF3CEE0A)),
                HighlightCode(".labelMedium", Color(0xFF3CEE0A)),
                HighlightCode(".labelSmall", Color(0xFF3CEE0A)),
                HighlightCode("16", Color(0xFF2DB8FF)),
                HighlightCode(".name", Color(0xFFe48def)),
                HighlightCode(".style", Color(0xFFe48def)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { TypographyStyles() },
            code = """
data class TypographyStyle(
    val name: String,
    val style:TextStyle
)

@Composable
fun TypographyStyles() {
    val listStyle = listOf(
        TypographyStyle("displayLarge", MaterialTheme.typography.displayLarge),
        TypographyStyle("displayMedium", MaterialTheme.typography.displayMedium),
        TypographyStyle("displaySmall", MaterialTheme.typography.displaySmall),
        TypographyStyle("headlineLarge", MaterialTheme.typography.headlineLarge),
        TypographyStyle("headlineMedium", MaterialTheme.typography.headlineMedium),
        TypographyStyle("headlineSmall", MaterialTheme.typography.headlineSmall),
        TypographyStyle("titleLarge", MaterialTheme.typography.titleLarge),
        TypographyStyle("titleMedium", MaterialTheme.typography.titleMedium),
        TypographyStyle("titleSmall", MaterialTheme.typography.titleSmall),
        TypographyStyle("bodyLarge", MaterialTheme.typography.bodyLarge),
        TypographyStyle("bodyMedium", MaterialTheme.typography.bodyMedium),
        TypographyStyle("bodySmall", MaterialTheme.typography.bodySmall),
        TypographyStyle("labelLarge", MaterialTheme.typography.labelLarge),
        TypographyStyle("labelMedium", MaterialTheme.typography.labelMedium),
        TypographyStyle("labelSmall", MaterialTheme.typography.labelSmall),
    )

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(listStyle) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text (
                    text = it.name,
                    style = it.style
                )
                Text (
                    text = "(${'$'}{it.style.fontSize})",
                )
            }
        }

    }

}
            """.trimIndent()
        ),
        ExampleCode(
            id =  5,
            title = "Стиль шрифта",
            comment = """
Стиль шрифта определяется параметром |fontStyle|:
 
 FontStyle.|Italic| - наклоннный (курсивный) шрифт;
 
 FontStyle.|Normal|  - стандартный шрифт.
                
            """.trimIndent(),
            highlightCode = highCodeList + listOf(
                HighlightCode("ItalicText", Color(0xFFffc530)),
                HighlightCode("Normal", Color(0xFF00BCD4)),
                HighlightCode("Italic", Color(0xFF00BCD4)),
                HighlightCode("fontStyle", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { ItalicText() },
            code ="""
@Composable
fun ItalicText () {

    val text = stringResource(
        id = R.string.text_in_jetpack_compose
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val modifier = Modifier
        .padding(top = 16.dp)

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = text,
            modifier = modifier,
            fontStyle = FontStyle.Italic
        )

        Text(
            text = text,
            modifier = modifier,
            fontStyle = FontStyle.Normal
        )

    }

}
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
            ),

            ),
        ExampleCode(
            id =  6,
            title = "Насыщенность шрифта",
            comment = """
Толщина шрифта задается параметром |fontWeight|, который представляет класс |!FontWeight|.
                        
Два способа установки толщины шрифта:
 
 1)передача числового значения от 1 до 1000;
 
 2)константы |FontWeight|:
 
    |Black| (Эквивалентно значению W900)

    |Bold| (W700)

    |ExtraBold| (W800)

    |ExtraLight| (W200)

    |Light| (W300)

    |Medium| (W500)

    |Normal| (W400 - значение по умолчанию)

    |SemiBold| (W600)

    |Thin| (W100)
                          
                
            """.trimIndent(),
            highlightCode = highCodeList + listOf(
                HighlightCode("TextFontWeight", Color(0xFFffc530)),
                HighlightCode("fontWeight", Color(0xFF3CEE0A)),
                HighlightCode(".Bold", Color(0xFF00BCD4)),
                HighlightCode(".Normal", Color(0xFF00BCD4)),
                HighlightCode(".ExtraBold", Color(0xFF00BCD4)),
                HighlightCode(".Light", Color(0xFF00BCD4)),
                HighlightCode(".W100", Color(0xFF00BCD4)),
                HighlightCode(".W300", Color(0xFF00BCD4)),
                HighlightCode(".W900", Color(0xFF00BCD4)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { TextFontWeight() },
            code ="""
@Composable
fun TextFontWeight() {

    val text = stringResource(
        id = R.string.text_in_jetpack_compose
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val modifier = Modifier
        .padding(top = 16.dp)

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${'$'}text (Normal)",
            modifier = modifier,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = "${'$'}text (Bold)",
            modifier = modifier,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "${'$'}text (ExtraBold)",
            modifier = modifier,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "${'$'}text (Light)",
            modifier = modifier,
            fontWeight = FontWeight.Light
        )
        Text(
            text = "${'$'}text (W100)",
            modifier = modifier,
            fontWeight = FontWeight.W100
        )
        Text(
            text = "${'$'}text (W300)",
            modifier = modifier,
            fontWeight = FontWeight.W300
        )
        Text(
            text = "${'$'}text (W900)",
            modifier = modifier,
            fontWeight = FontWeight.W900
        )

    }

}
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
            ),

            ),

        ExampleCode(
            id = 19,
            title = "Ограничение строк",
            comment = """
|overflow| определяет, как будет обрабатываться текст при его выходе за границы контейнера. 

Этот параметр принимает значение класса |TextOverflow|:

|Clip|: текст усекается (по умолчанию)

|Ellipsis|: текст усекается, а в конце текста добавляется многоточие

|Visible|: весь текст может отображаться     
                   
Примечание. 
  Текст, который выходит за пределы своих границ с помощью |Visible|, может быть обрезан другими модификаторами, такими как Modifier.|clipToBounds|
                
            """.trimIndent(),
            highlightCode = highCodeList + listOf(
                HighlightCode("LongText", Color(0xFFffc530)),
                HighlightCode("overflow", Color(0xFF3CEE0A)),
                HighlightCode("maxLines", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { SimpleLimit() },
            code ="""
@Composable
fun SimpleLimit() {

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    LazyColumn(
        modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.onBackground)
            .padding(padding),
    ) {
        item {
            Text(
                text = "Очень длинный-длинный текст ".repeat(20),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
            )

        }

    }

}
            """.trimIndent()
        ),


        ExampleCode(
            id =  7,
            title = "Выравнивание по ширине",
            comment = """
Параметр |textAlign| управляет выравниванием текста и представляет объект класса |TextAlign|. 

В качестве значения этому параметру можно передать значение одного из свойств класса |TextAlign|:

 |!Center|: выравнивание текста по центру контейнера

 |!Justify|: текст равномерно растягивается по всей ширине контейнера

 |!End|: выравнивание текста по конечному краю контейнера (в зависимости от ориентации текста это может быть левый или правый край)

 |!Start|: выравнивание текста по началу контейнера (в зависимости от ориентации текста это может быть левый или правый край)

 |!Left|: выравнивание текста по левому краю контейнера

 |!Right|: выравнивание текста по правому краю контейнера                        
                
            """.trimIndent(),
            highlightCode = highCodeList + listOf(
                HighlightCode("LongText", Color(0xFFffc530)),
                HighlightCode(".Left", Color(0xFF00BCD4)),
                HighlightCode(".Center", Color(0xFF00BCD4)),
                HighlightCode(".Right", Color(0xFF00BCD4)),
                HighlightCode("textAlign", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { SimpleAlign() },
            code ="""
@Composable
fun SimpleAlign() {
    val text = stringResource(
        id = R.string.hello_world
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val modifier = Modifier
        .padding(top = 16.dp)
        .fillMaxWidth() // !!!

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.onBackground)
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = text + " (Left)",
                    textAlign = TextAlign.Left,
                    modifier = modifier
                )
                Text(
                    text = text + " (Center)",
                    textAlign = TextAlign.Center,
                    modifier = modifier
                )
                Text(
                    text = text + " (Right)",
                    textAlign = TextAlign.Right,
                    modifier = modifier
                )

            }
        }
    }

}
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Установить выравнивание текста. ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль абзаца",
                    url = "https://developer.android.com/develop/ui/compose/text/style-paragraph?hl=ru"
                ),
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. TextAlign",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextAlign"
                ),
            ),
        ),

        ExampleCode(
            id =  8,
            title = "Выравнивание по контейнеру",
            comment = """
Параметр |textAlign| управляет выравниванием текста. 

  TextAlign.|!Justify| равномерно растягивает текст по всей ширине контейнера.

                
            """.trimIndent(),
            highlightCode = highCodeList + listOf(
                HighlightCode("TextAlignJustify", Color(0xFFffc530)),
                HighlightCode(".Justify", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { SimpleAlignJustify() },
            code ="""
@Composable
fun SimpleAlignJustify() {

    val text = "Без выравнивания. ".repeat(10)

    val text2 = "Выравнивание строк по всей ширине контейнера. ".repeat(10)

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )


    LazyColumn(
        modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.onBackground)
            .padding(padding),
    ) {
        item {
            //Без выравнивания
            Text(text = text)
            
            Spacer(modifier = Modifier.padding(padding))

            //выравнивание по всей ширине контейнера, кроме последней
            Text(
                text = text2,
                textAlign = TextAlign.Justify,
            )

        }
    }


}
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. TextAlign",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextAlign"
                ),
            ),

            ),
        ExampleCode(
            id =  9,
            title = "Выравнивание по высоте",
            comment = """
Добавление дополнительного пространства в зависимости от высоты строки к верху первой строки, верху и низу последней строки.         
               
Конфигурация применяется только в том случае, если в тексте определена высота строки.
               
Функция обрезки доступна только в том случае, если |PlatformParagraphStyle.includeFontPadding| имеет значение |false|.
               
|trim| определяет, следует ли обрезать пространство, которое будет добавлено к верху первой строки и внизу последней строки.

Возможные значения |trim|: 
 |!Both| - Обрезает пространство, которое будет добавлено к верху первой строки и внизу последней строки из-за высоты строки.
                 
 |!FirstLineTop| - Обрезает пространство, которое будет добавлено к верхней части последней строки из-за высоты строки
                  
 |!LastLineBottom| - Обрезает пространство, которое будет добавлено к нижней части последней строки из-за высоты строки
                  
 |!None| - ет обрезки                
                
            """.trimIndent(),
            highlightCode = highCodeList + listOf(
                HighlightCode("TextAlignedHeight", Color(0xFFffc530)),
                HighlightCode("lineHeightStyle =", Color(0xFF3CEE0A)),
                HighlightCode("lineHeight =", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { TextAlignedHeight() },
            code ="""
@Composable
fun TextAlignedHeight() {

    val text = "Без выравнивания. ".repeat(10)

    val text2 = "Выравнивание строки по заданной высоте строки. ".repeat(10)

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.onBackground)
            .padding(padding),
    ) {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(padding)
            ) {
                //без выравнивания
                Text(
                    text = text,
                )

                //выравнивание строки по заданной высоте
                Text(
                    text = text2,
                    style = LocalTextStyle.current.merge(
                        TextStyle(
                            lineHeight = 2.0.em,
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            ),
                            lineHeightStyle = LineHeightStyle(
                                alignment = LineHeightStyle.Alignment.Center,
                                //обрезка низа последней строки
                                trim = LineHeightStyle.Trim.LastLineBottom
                            )
                        )
                    )
                )

            }

        }

    }

}

            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. LineHeightStyle",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/LineHeightStyle"
                ),
            ),

            ),

        ExampleCode(
            id = 11,
            title = "Типы шрифтов",
            comment = """
                      
 |Тип шрифта| определяется параметром |!fontFamily|
 
 |FontFamily| предоставляет ряд встроенных констант:
 
    |!Cursive| - курсивный, рукописный шрифт;
 
    |!Monospace| -  моноширинный шрифт, все знаки (точнее, кегельные площадки знаков) имеют одинаковую ширину;
 
    |!Serif| - шрифты с засечками;
 
    |!SansSerif| - шрифты без засечек;
 
    |!Default| - шрифт по умолчанию на текущей платформе.

 Примеры шрифтов без засечек (sans-serif):
 •|Arial|
 •|Verdana|

 Пример шрифта с засечками (serif):
 •|Times New Roman|


Шрифты |Serif| транслируют уверенность, устойчивость, надёжность, стабильность приверженность традициям.

Шрифты |Sans Serif| транслируют инновационность, динамичность и доступность. Часто эти шрифты ассоциируются с минимализмом и лёгкостью: они довольно просты и лаконичны, выглядят современно и аккуратно.

Преимущество |Sans Serif| заключается в |!адаптивности|: начертания без засечек проще масштабируются.

|!Некоторые правила|:

1.Не использовать более 3-4 шрифтов на одной странице.

2.Не изменяйте шрифт в середине предложения, пока у вас нет очень веских оснований.

3.Sans-serif шрифты являются основой приложения.

                
            """.trimIndent(),
            highlightCode = highCodeList +  listOf(
                HighlightCode("TextFontFamily", Color(0xFFffc530)),
                HighlightCode(".Serif", Color.Yellow),
                HighlightCode(".SansSerif", Color.Yellow),
                HighlightCode(".Cursive", Color.Yellow),
                HighlightCode(".Monospace", Color.Yellow),
                HighlightCode(".Default", Color.Yellow),
                HighlightCode("fontFamily =", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { TextFontFamily() },
            code ="""
@Composable
fun TextFontFamily() {

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val style = MaterialTheme.typography.bodyMedium.merge(
        TextStyle(
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            //шрифт с засечками
            fontFamily = FontFamily.Serif
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.onBackground)
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(padding)
            ) {
                Text(
                    text = "Text in jetpack Compose\n(Serif)",
                    //шрифт с засечками
                    style = style,
                )

                Text(
                    text = "Text in jetpack Compose\n(SansSerif)",
                    style = style.merge(
                        TextStyle(
                            //шрифт без засечек
                            fontFamily = FontFamily.SansSerif
                        )
                    )
                )

                Text(
                    text = "Text in jetpack Compose\n(Cursive)",
                    style = style.merge(
                        TextStyle(
                            //курсивный, рукописный шрифт
                            fontFamily = FontFamily.Cursive
                        )
                    )
                )

                Text(
                    text = "Text in jetpack Compose\n(Monospace)",
                    style = style.merge(
                        TextStyle(
                            //моноширинный шрифт
                            //(все знаки имеют одинаковую ширину)
                            fontFamily = FontFamily.Monospace
                        )
                    )
                )

                Text(
                    text = "Text in jetpack Compose\n(Default)",
                    style = style.merge(
                        TextStyle(
                            //шрифт по умолчанию на текущей платформе
                            fontFamily = FontFamily.Default
                        )
                    )
                )

            }

        }

    }

}
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Работа со шрифтами",
                    url = "https://developer.android.com/develop/ui/compose/text/fonts?hl=ru"
                ),
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. FontFamily",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily#summary"
                ),
            ),

            ),

        ExampleCode(
            id = 12,
            title = "Альтернативные шрифты",
            comment = """
Пользовательские шрифты с гарнитурами определяются в папке 
 |!res/font|
 
Выбрать и загрузить шрифт можно из сайта |!Google Fonts| и разместить в папку 
 |!res/font|, при необходимости заменив заглавные символы на прописные.

В файле |!ui/theme/Type.kt| 
подключить загруженный новый шрифт, например:

//шрифт курсивный для кириллицы    
|val Cormorantinfant = FontFamily(
    Font(R.font.cormorantinfant_regular, FontWeight.Normal),
    Font(R.font.cormorantinfant_medium, FontWeight.Medium),
    Font(R.font.cormorantinfant_bold, FontWeight.Bold),
    Font(R.font.cormorantinfant_light, FontWeight.Light),
    Font(R.font.cormorantinfant_italic, FontWeight.Normal,FontStyle.Italic),
    Font(R.font.cormorantinfant_mediumitalic, FontWeight.Medium,FontStyle.Italic),
    Font(R.font.cormorantinfant_bolditalic, FontWeight.Bold,FontStyle.Italic),
    Font(R.font.cormorantinfant_lightitalic, FontWeight.Light,FontStyle.Italic),
)|
                   
            """.trimIndent(),
            highlightCode = highCodeList + listOf(
                HighlightCode("TextFontFamalyAlternate", Color(0xFFffc530)),
                HighlightCode("fontFamily", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { TextFontFamalyAlternate() },
            code ="""
/*
                 Альтернативные шрифты

 ui/theme/Type.kt

    val Cabin = FontFamily(
        Font(R.font.cabin_regular, FontWeight.Normal),
        Font(R.font.cabin_bold, FontWeight.Bold)
    )

    val Poppins = FontFamily(
        Font(R.font.poppins_medium, FontWeight.Medium),
        Font(R.font.poppins_regular, FontWeight.Normal),
        Font(R.font.poppins_bold, FontWeight.Bold)
    )

    val AbrilFatface = FontFamily(
        Font(R.font.abril_fatface_regular)
    )

    val Alice = FontFamily(
        Font(R.font.alice_regular)
    )

//шрифт курсивный для кириллицы
    val Cormorantinfant = FontFamily(
        Font(R.font.cormorantinfant_regular, FontWeight.Normal),
        Font(R.font.cormorantinfant_medium, FontWeight.Medium),
        Font(R.font.cormorantinfant_bold, FontWeight.Bold),
        Font(R.font.cormorantinfant_light, FontWeight.Light),
        Font(R.font.cormorantinfant_italic, FontWeight.Normal,FontStyle.Italic),
        Font(R.font.cormorantinfant_mediumitalic, FontWeight.Medium,FontStyle.Italic),
        Font(R.font.cormorantinfant_bolditalic, FontWeight.Bold,FontStyle.Italic),
        Font(R.font.cormorantinfant_lightitalic, FontWeight.Light,FontStyle.Italic),
    )

 */

data class FontExample(
    val nameFont: String = "",
    val style: TextStyle = TextStyle()
)

@Composable
fun TextFontFamalyAlternate() {

    val style = MaterialTheme.typography.bodyMedium.merge(
        TextStyle(
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
            fontStyle = FontStyle.Normal
        )
    )

    val fonts = listOf(
        FontExample(
            nameFont = "Serif",
            style = style.merge(
                TextStyle(
                    fontFamily = FontFamily.Serif
                )
            )
        ),
        FontExample(
            nameFont = "Cabin",
            style = style.merge(
                TextStyle(
                    fontFamily = Cabin
                )
            )
        ),
        FontExample(
            nameFont = "Poppins",
            style = style.merge(
                TextStyle(
                    fontFamily = Poppins
                )
            )
        ),
        FontExample(
            nameFont = "AbrilFatface",
            style = style.merge(
                TextStyle(
                    fontFamily = AbrilFatface
                )
            )
        ),
        FontExample(
            nameFont = "Alice",
            style = style.merge(
                TextStyle(
                    fontFamily = Alice
                )
            )
        ),
        FontExample(
            nameFont = "Cormorantinfant",
            style = style.merge(
                TextStyle(
                    fontFamily = Cormorantinfant
                )
            )
        ),
    )


    val text = "Альтернативные шрифты."

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.onBackground)
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(padding)

    ) {
        items(fonts){
            val nameFont = it.nameFont
            val styleText = it.style
            Text(
                text = "${'$'}text (${'$'}nameFont)",
                style = styleText
            )

            Text(
                text = "${'$'}text - Italic",
                style = styleText.merge(
                    TextStyle(
                        fontStyle = FontStyle.Italic
                    )
                )
            )

            Text(
                text = "${'$'}text - Bold",
                style = styleText.merge(
                    TextStyle(
                        fontWeight = FontWeight.Bold,
                    )
                )
            )

            Spacer(modifier = Modifier.height(padding))

        }

    }

}
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Работа со шрифтами",
                    url = "https://developer.android.com/develop/ui/compose/text/fonts?hl=ru"
                ),
                TextClickLink(
                    text = "Выбрать и загрузить шрифт можно с ",
                    textUrl = "\uD83D\uDCD6 Google Fonts",
                    url = "https://fonts.google.com/?hl=ru"
                ),
                TextClickLink(
                    text = "Playwrite — это новое суперсемейство шрифтов, помогающее учащимся по всему миру изучать почерк.",
                    textUrl = "\uD83D\uDCD6 Google Fonts blog",
                    url = "https://fonts.googleblog.com/"
                ),
            ),

            ),


        ExampleCode(
            id = 5,
            title = "Цвет,контастность",
            comment = """
За определение цвета шрифта отвечает параметр |color|.

За определение цвета фона отвечает модификатор Modifier.|background|.
                        
Если |Color| не установлено, то значение наследуется от родительского компонента (|!Unspecified|).

Кроме того, если цвет не установлен и стиль не имеет цвета, будет использоваться |!LocalContentColor| с альфа-каналом |!LocalContentAlpha|. Это позволяет этому тексту или элементу, содержащему этот текст, адаптироваться |!к различным цветам фона| и при этом сохранять |!контраст| и |!доступность|.
                
Лучше использовать цвета |MaterialTheme|. Получить доступ к цветам можно через |!MaterialTheme.colorScheme|

При выборе цветов необходимо учитывать |контастность| цвета текста и цвета фона.

Контрастность выражается во взаимодействии предельной насыщенности чистых цветов. 

Как белый и чёрный являют самый сильный контраст светлого и тёмного, так и первичные цвета, жёлтый, синий и красный, наделены свойством наиболее сильного цветового контраста, создающего впечатление простоты, силы и решительности. 

Интенсивность цветового контраста ослабевает от первичных — к цветам третьего порядка.

(из книги Иттена).

            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Color",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color"
                ),
                TextClickLink(
                    text = "Material Design 3 в Compose",
                    textUrl = "\uD83D\uDCD6 Создание цветовых схем",
                    url = "https://developer.android.com/develop/ui/compose/designsystems/material3?hl=ru"
                ),
                TextClickLink(
                    text = "Визуализация динамического цвета в приложении ",
                    textUrl = "\uD83D\uDCD6 Developers.Codelabs",
                    url = "https://codelabs.developers.google.com/visualize-dynamic-color#0"
                ),
                TextClickLink(
                    text = "Проверка контрастности цветов ",
                    textUrl = "\uD83D\uDCD6 ImageColorPicker.com",
                    url = "https://imagecolorpicker.com/color-contrast-checker/000000-ef1515"
                ),
                TextClickLink(
                    text = "Цветная палитра ",
                    textUrl = "\uD83D\uDCD6 ImageColorPicker.com",
                    url = "https://imagecolorpicker.com/color-code/22200d"
                ),
                TextClickLink(
                    text = "Теория цвета, контраст ",
                    textUrl = "\uD83D\uDCD6 Datasakura. Хабр ",
                    url = "https://habr.com/ru/articles/494750/"
                ),
                TextClickLink(
                    text = "Полная версия стандарта по контрастности цвета ",
                    textUrl = "\uD83D\uDCD6 W3C Recommendation 11 December 2008 ",
                    url = "https://www.w3.org/TR/WCAG20/"
                ),
                TextClickLink(
                    text = "Что нужно знать о контрасте текста и как контролировать контраст с помощью SASS ",
                    textUrl = "\uD83D\uDCD6 Datasakura. Хабр ",
                    url = "https://ru.hexlet.io/blog/posts/chto-nuzhno-znat-o-kontraste-teksta-i-kak-kontrolirovat-kontrast-s-pomoschyu-sass#primer-vychisleniya-koeffitsient-kontrasta"
                ),
                TextClickLink(
                    text = "Конвертер цветов Онлайн",
                    textUrl = "\uD83D\uDCD6 Color Scheme ",
                    url = "https://colorscheme.ru/color-converter.html"
                ),
                TextClickLink(
                    text = "Расчет коэффициента контрастности по двум цветам. Kotlin программа. ",
                    textUrl = "\uD83D\uDCD6 play.kotlinlang.org ",
                    url = "https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS44LjIxIiwiY29kZSI6ImltcG9ydCBqYXZhLnV0aWwuKlxuaW1wb3J0IGphdmEubWF0aC4qXG5pbXBvcnQgamF2YS5hd3QuQ29sb3JcblxuLy9pbnB1dDogYzggPSAwLi4yNTVcbi8vb3V0cHV0OiBjID0gMC4uMVxuLy/QntC/0YDQtdC00LXQu9C10L3QuNC1INC70LjQvdC10LnQvdC+0LPQviDQt9C90LDRh9C10L3QuNGPINC60L7QvNC/0L7QvdC10L3RgtGLINGG0LLQtdGC0LBcbmZ1biBjb2xvcl9jb21wb25lbnRzKGM4OkludCk6RmxvYXQge1xuICAgIHZhciBjU3JnYjpGbG9hdCA9IGM4LnRvRmxvYXQoKS8yNTVcbiAgICBcbiAgICBpZiAoY1NyZ2IgPiAwLjAzOTI4KXtcbiAgICAgICAgdmFsIGMgPSAoY1NyZ2IrMC4wNTUpLzEuMDU1XG4gICAgICAgIGNTcmdiID0gTWF0aC5wb3coYywyLjQpLnRvRmxvYXQoKVxuICAgIH0gXG4gICAgIGVsc2UgY1NyZ2IgPSAoY1NyZ2IvMTIuOTIpLnRvRmxvYXQoKVxuICAgIFxuICAgIHJldHVybiBjU3JnYlxufVxuXG4vL9Cy0YvRh9C40YHQu9C10L3QuNGPINC+0YLQvdC+0YHQuNGC0LXQu9GM0L3QvtC5INGP0YDQutC+0YHRgtC4XG5mdW4gY2FsY3VsYXRfYnJpZ2h0bmVzcyhyOkZsb2F0LGc6RmxvYXQsYjpGbG9hdCkgPSAwLjIxMjYgKiByICsgMC43MTUyICogZyArIDAuMDcyMiAqIGJcblxuLy/QstGL0YfQuNGB0LvQtdC90LjRjyDQutC+0Y3RhNGE0LjRhtC40LXQvdGCINC60L7QvdGC0YDQsNGB0YLQsFxuZnVuIGNvbnRyYXN0X3JhdGlvX2NhbGN1bGF0aW9uKGNvbG9yMTpDb2xvcixjb2xvcjI6Q29sb3IpOkZsb2F0e1xuICAgIFxuICAgIHZhciByID0gY29sb3JfY29tcG9uZW50cyhjb2xvcjEucmVkKSBcbiAgICB2YXIgZyA9IGNvbG9yX2NvbXBvbmVudHMoY29sb3IxLmdyZWVuKVxuICAgIHZhciBiID0gY29sb3JfY29tcG9uZW50cyhjb2xvcjEuYmx1ZSlcbiAgICBcbiAgICB2YWwgbDEgPSBjYWxjdWxhdF9icmlnaHRuZXNzKHIsZyxiKVxuXG4gICAgciA9IGNvbG9yX2NvbXBvbmVudHMoY29sb3IyLmdldFJlZCgpKSBcbiAgICBnID0gY29sb3JfY29tcG9uZW50cyhjb2xvcjIuZ2V0R3JlZW4oKSlcbiAgICBiID0gY29sb3JfY29tcG9uZW50cyhjb2xvcjIuZ2V0Qmx1ZSgpKVxuICAgIFxuICAgIHZhbCBsMiA9IGNhbGN1bGF0X2JyaWdodG5lc3MocixnLGIpXG5cbiAgICBcbiAgICB2YWwgY29udHJhc3RfcmF0aW8gPSBpZiAobDE+bDIpICgobDEgKyAwLjA1KS8obDIgKyAwLjA1KSkudG9GbG9hdCgpXG4gICAgZWxzZSAoKGwyICsgMC4wNSkvKGwxICsgMC4wNSkpLnRvRmxvYXQoKVxuICAgIFxuICAgIHJldHVybiBjb250cmFzdF9yYXRpb1xufVxuXG5mdW4gbWFpbigpIHtcblxuLy8g0KbQstC10YIg0YTQvtC90LA6IENvbG9yKDB4RkYyMDFCMTYpICByZ2IoMzIsIDI3LCAyMikgIFxuICAgIHZhbCBoZXhDb2xvcjEgPSBcIiMyMDFCMTZcIlxuICAgIHZhbCBjb2xvcjEgPSBDb2xvci5kZWNvZGUoaGV4Q29sb3IxKVxuLy8g0KbQstC10YIg0YLQtdC60YHRgtCwOiBDb2xvcigweEZGRUJFMEQ5KSAgcmdiKDIzNSwgMjI0LCAyMTcpICBcbiAgICB2YWwgaGV4Q29sb3IyID0gXCIjRUJFMEQ5XCJcbiAgICB2YWwgY29sb3IyID0gQ29sb3IuZGVjb2RlKGhleENvbG9yMilcbiAgICBcbiAgICB2YWwgaz0gY29udHJhc3RfcmF0aW9fY2FsY3VsYXRpb24oY29sb3IxLGNvbG9yMilcbiAgICBwcmludGxuKFwi0KbQstC10YIg0YTQvtC90LA6ICAgJGhleENvbG9yMVwiKSAgXG4gICAgcHJpbnRsbihcItCm0LLQtdGCINGC0LXQutGB0YLQsDogJGhleENvbG9yMlwiKSAgXG4gICAgcHJpbnRsbihcIiDQmtC+0L3RgtGA0LDRgdGC0L3QvtGB0YLRjDogJGtcIikgIFxuICAgIFxufSIsInBsYXRmb3JtIjoiamF2YSIsImFyZ3MiOiIifQ=="
                ),
                TextClickLink(
                    text = "Вычисление относительной яркости и контрастности двух цветов ",
                    textUrl = "\uD83D\uDCD6 Онлайн калькулятор ",
                    url = "https://planetcalc.ru/7779/"
                ),
            ),

            highlightCode = highCodeList + listOf(
                HighlightCode("TextColorAny", Color(0xFFffc530)),
                HighlightCode("color = ", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { TextColorAny() },
            code ="""   
@Composable
fun TextColorAny() {

    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(Color(0xFF201B16))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text (
                    text = "Контраст:17.08 (Отличный)",
                    color = Color(0xFFEBE0D9),
                    fontSize = 18.sp
                )

                Text (
                    text = "Контраст:5.44 (Хороший)",
                    color = Color.Red,
                    fontSize = 18.sp
                )

                Text (
                    text = "Контраст:4.16 (Плохой)",
                    color = colorResource(id = R.color.red700),
                    fontSize = 18.sp
                )

                Text (
                    text = "Контраст:2.14 (Плохой)",
//Из целочисленных значений компонентов SRGB. Альфа необязательна
                    color = Color(
                        red = 0x44,   //between 0 and 255
                        green = 0x55,
                        blue = 0x88,
                        alpha = 0xFF
                    ),
                    fontSize = 18.sp
                )

                Text (
                    text = "Контраст:2.67 (Плохой)", //32-bit ARGB color
                    color = Color(0xFF993399),
                    fontSize = 18.sp
                )

                Text (
                    text = "Контраст:12.44 (Отличный)",
                    fontSize = 18.sp,
                    style = TextStyle(
                        color = Color.Green,
                    )
                )

                Text (
                    text = "Контраст:8.59 (Хороший)",
                    style = TextStyle(
                        color = Color.Yellow,
                        background = Color.Blue
                    ),
                    fontSize = 18.sp,
                )

                Text (
                    text = "Контраст:16.40 (Отличный)",
                    modifier = Modifier
                        .background(Color(0xff22200d)),
                    color = Color(0xffffff00),
                    fontSize = 18.sp,
                )

                Text (
                    text = "Контраст:7.41 (Хороший)",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondary),
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontSize = 18.sp,
                )

                Text (
                    text = "Контраст:7.55 (Хороший)",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondaryContainer),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontSize = 18.sp,
                )

                Text (
                    text = "Контраст:9.31 (Хороший)",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.tertiaryContainer),
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    fontSize = 18.sp,
                )

                Text (
                    text = "Контраст:21.00 (Отличный)",
                    modifier = Modifier
                        .background(Color(0xff000000)),
                    color = Color(0xffffffff),
                    fontSize = 18.sp,
                )

            }
        }


    }
}
            """.trimIndent()
        ),
        ExampleCode(
            id = 20,
            title = "Цвет фона ",
            comment = """
Модификатор Modifier.|background|(color) устанавливает цвет фона компонуемого элемента.

При установки цвета фона и текста важно учитывать контрастность цветов, чтобы выводимый текст был хорошо виден.

Лучше использовать сочитание цветов MaterialTheme.|colorScheme|, например:
  
  Для фона                   Для текста
    primary                onPrimary
    primaryContainer       onPrimaryContainer
    secondary              onSecondary
    secondaryContainer     onSecondaryContainer
    tertiary               onTertiary
    tertiaryContainer      onTertiaryContainer
  
  
      |Коэффициент контраста|

Коэффициент контраста, согласно стандарту |Web Content Accessibility Guidelines| (WCAG), высчитывается по формуле: 

    |(L1 + 0,05) / (L2 + 0,05)|, 
в которой: 
 |L1| — относительная яркость |самого светлого| цвета. 
 |L2| — относительная яркость |самого тёмного| цвета.


|!Требования к тексту относительно контрастности|:

1)Текст должен иметь коэффициент контраста не менее |4.5|. 
В идеале это значение должно быть не менее |7|.

2)Для увеличенного текста коэффициент контраста должен иметь значение не менее |3|. 
В идеале это значение должно быть не менее |4.5|. 

|!Примечание|:
Увеличенным считается текст размером в |18| пикселей, либо |14| пикселей с полужирным начертанием.


     |Вычисление относительной яркости|

 Относительной яркостью считается коэффициент от нуля до единицы, 
где 0 - чёрный цвет, 
    1 - белый цвет. 

 Каждая компонента цвета в шестнадцатеричном формате это целое число C8, находящееся в диапазоне от 0 до 255 
( C8 = {R8 - красный, G8 - зеленый, B8 - синий}).
  
 Переведем значения компоненты цвета из целых в вещественные значения в диапазоне 0..1:
 |Csrgb| = C8/255, где C8 = { R8, G8, B8 }

 Найдем для каждой компоненты цвета линейное значение C = { R,G,B }:
 |C = ((Csrgb+0.055)/1.055)^2.4| , 
    если |Csrgb > 0.03928|
или
 |C = Csrgb/12.92|, 
     если |Csrgb <= 0.03928|

Используя линейное значение компоненты цвета C={R, G, B} получаем относительную яркость цвета по формуле:
L = 0.2126R + 0.7152G + 0.0722B

Коэффициенты в формуле, отражают чувствительность человеческого глаза к отдельным компонентам света: зеленая компонента света воспринимается наиболее ярко, красная - менее и синяя меньше всего.


    |Пример расчета|
    
 Цвет фона:   .background(Color(0xFF201B16)) 
  rgb(32, 27, 22)
    
R_sRGB = 32 / 255 = 0,12
G_sRGB = 27 / 255 = 0,10
B_sRGB = 22 / 255 = 0,09   

 R_sRGB < 0,03928 , следовательно 
     |R| = 0,12 / 12,92 =  |!0,009|
 G_sRGB < 0,03928 , следовательно 
     |G| = 0,10 / 12,92 =  |!0,008|
 B_sRGB < 0,03928 , следовательно 
     |B| = 0,09 / 12,92 =  |!0,007|

Исходя из формулы
  L = 0,2126 * R + 0,7152 * G + 0,0722 * B

 |L1| = 0.2126 * |0,009| + 0.7152 * |0,008| + 0.0722 * |0,007| = 0.0081404     
   
 Цвет текста: color = Color(0xFFEBE0D9)
 rgb(235, 224, 217)
    
R_sRGB = 235 / 255 = 0,92
G_sRGB = 224 / 255 = 0,88
B_sRGB = 217 / 255 = 0,85  

 Все значения > 0,03928 ,следовательно
 r = ((0.92 + 0.055) / 1.055)
 g = ((0.88 + 0.055) / 1.055)
 b = ((0.85 + 0.055) / 1.055)

 R = Math.pow(r,2.4) = 0.8276
 G = Math.pow(g,2.4) = 0.7484
 B = Math.pow(b,2.4) = 0.6921
 
 L = 0,2126 * R + 0,7152 * G + 0,0722 * B
 
 |L2| = 0.2126 * |0.8276| + 0.7152 * |0.7484| + 0.0722 * |0.6921| = 0.76117306          

 k  = (L2+ 0,05) / (L1 + 0,05)
 
 k  = (0.76117306 + 0,05)/(0.0081404 + 0,05)=13.9604
 
"Контраст:17.08 (Отличный)"    


                
                
            """.trimIndent(),
            highlightCode = highCodeList +  listOf(
                HighlightCode("BackgroundDriver", Color(0xFFffc530)),
                HighlightCode("color = ", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { BackgroundDriver() },
            code ="""
@Composable
fun BackgroundDriver(
    message: String = stringResource(R.string.text_compose),

    ){

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val fontSize = remember {
        mutableFloatStateOf(35f)
    }

    var indexColor by remember { mutableIntStateOf(-1) }

    var colorBg by remember {
        mutableStateOf(DataColor.colors[8])
    }
    var colorTx by remember {
        mutableStateOf(DataColor.colors[12])
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(padding)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.White)
                .background(color = colorBg)
                .widthIn(min = 150.dp)
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = message,
                modifier = Modifier
                    .padding(16.dp),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontFamily = Alice,
                    fontSize = fontSize.floatValue.sp,
                    lineHeight = fontSize.floatValue.sp,
                    color = colorTx
                ),
            )
        }

        val k = contrast_ratio_calculation(colorTx,colorBg)

        val status = stringResource(id = R.string.сontrast,k) + contrast_ratio_comment(k)
    
        Text(
            text = status,
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(padding)
                ) {
                    if (indexColor == -1){

                        SliderSimple("size",fontSize,10f,50f)

                        Row(
                            modifier = Modifier
                                .padding(padding)
                                .widthIn(max = 250.dp),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(padding)
                                    .border(1.dp, MaterialTheme.colorScheme.onBackground)
                                    .background(colorBg)
                                    .size(40.dp)
                                    .clickable {
                                        indexColor = 0
                                    }
                            )
                            Box(
                                modifier = Modifier
                                    .padding(padding)
                                    .border(1.dp, MaterialTheme.colorScheme.onBackground)
                                    .background(colorTx)
                                    .size(40.dp)
                                    .clickable {
                                        indexColor = 1
                                    }
                            )
                        }
                    } else{
                        ColorSelect(
                            colorCurrent = when(indexColor){
                                0 -> colorBg
                                else -> colorTx
                            },
                            onColorSelect ={
                                when(indexColor){
                                    0 -> colorBg = it
                                    else -> colorTx= it
                                }
                                indexColor = -1
                            },
                            title = when(indexColor){
                                0 -> "Выберите цвет фона"
                                else -> "Выберите цвет текста"
                            },

                        )

                    }


                }

            }

        }
    }
}
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Теория цвета, контраст ",
                    textUrl = "\uD83D\uDCD6 Datasakura. Хабр ",
                    url = "https://habr.com/ru/articles/494750/"
                ),
                TextClickLink(
                    text = "Полная версия стандарта по контрастности цвета ",
                    textUrl = "\uD83D\uDCD6 W3C Recommendation 11 December 2008 ",
                    url = "https://www.w3.org/TR/WCAG20/"
                ),
                TextClickLink(
                    text = "Что нужно знать о контрасте текста и как контролировать контраст с помощью SASS ",
                    textUrl = "\uD83D\uDCD6 Datasakura. Хабр ",
                    url = "https://ru.hexlet.io/blog/posts/chto-nuzhno-znat-o-kontraste-teksta-i-kak-kontrolirovat-kontrast-s-pomoschyu-sass#primer-vychisleniya-koeffitsient-kontrasta"
                ),
                TextClickLink(
                    text = "Конвертер цветов Онлайн",
                    textUrl = "\uD83D\uDCD6 Color Scheme ",
                    url = "https://colorscheme.ru/color-converter.html"
                ),
                TextClickLink(
                    text = "Расчет коэффициента контрастности по двум цветам. Kotlin программа. ",
                    textUrl = "\uD83D\uDCD6 play.kotlinlang.org ",
                    url = "https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS44LjIxIiwiY29kZSI6ImltcG9ydCBqYXZhLnV0aWwuKlxuaW1wb3J0IGphdmEubWF0aC4qXG5pbXBvcnQgamF2YS5hd3QuQ29sb3JcblxuLy9pbnB1dDogYzggPSAwLi4yNTVcbi8vb3V0cHV0OiBjID0gMC4uMVxuLy/QntC/0YDQtdC00LXQu9C10L3QuNC1INC70LjQvdC10LnQvdC+0LPQviDQt9C90LDRh9C10L3QuNGPINC60L7QvNC/0L7QvdC10L3RgtGLINGG0LLQtdGC0LBcbmZ1biBjb2xvcl9jb21wb25lbnRzKGM4OkludCk6RmxvYXQge1xuICAgIHZhciBjU3JnYjpGbG9hdCA9IGM4LnRvRmxvYXQoKS8yNTVcbiAgICBcbiAgICBpZiAoY1NyZ2IgPiAwLjAzOTI4KXtcbiAgICAgICAgdmFsIGMgPSAoY1NyZ2IrMC4wNTUpLzEuMDU1XG4gICAgICAgIGNTcmdiID0gTWF0aC5wb3coYywyLjQpLnRvRmxvYXQoKVxuICAgIH0gXG4gICAgIGVsc2UgY1NyZ2IgPSAoY1NyZ2IvMTIuOTIpLnRvRmxvYXQoKVxuICAgIFxuICAgIHJldHVybiBjU3JnYlxufVxuXG4vL9Cy0YvRh9C40YHQu9C10L3QuNGPINC+0YLQvdC+0YHQuNGC0LXQu9GM0L3QvtC5INGP0YDQutC+0YHRgtC4XG5mdW4gY2FsY3VsYXRfYnJpZ2h0bmVzcyhyOkZsb2F0LGc6RmxvYXQsYjpGbG9hdCkgPSAwLjIxMjYgKiByICsgMC43MTUyICogZyArIDAuMDcyMiAqIGJcblxuLy/QstGL0YfQuNGB0LvQtdC90LjRjyDQutC+0Y3RhNGE0LjRhtC40LXQvdGCINC60L7QvdGC0YDQsNGB0YLQsFxuZnVuIGNvbnRyYXN0X3JhdGlvX2NhbGN1bGF0aW9uKGNvbG9yMTpDb2xvcixjb2xvcjI6Q29sb3IpOkZsb2F0e1xuICAgIFxuICAgIHZhciByID0gY29sb3JfY29tcG9uZW50cyhjb2xvcjEucmVkKSBcbiAgICB2YXIgZyA9IGNvbG9yX2NvbXBvbmVudHMoY29sb3IxLmdyZWVuKVxuICAgIHZhciBiID0gY29sb3JfY29tcG9uZW50cyhjb2xvcjEuYmx1ZSlcbiAgICBcbiAgICB2YWwgbDEgPSBjYWxjdWxhdF9icmlnaHRuZXNzKHIsZyxiKVxuXG4gICAgciA9IGNvbG9yX2NvbXBvbmVudHMoY29sb3IyLmdldFJlZCgpKSBcbiAgICBnID0gY29sb3JfY29tcG9uZW50cyhjb2xvcjIuZ2V0R3JlZW4oKSlcbiAgICBiID0gY29sb3JfY29tcG9uZW50cyhjb2xvcjIuZ2V0Qmx1ZSgpKVxuICAgIFxuICAgIHZhbCBsMiA9IGNhbGN1bGF0X2JyaWdodG5lc3MocixnLGIpXG5cbiAgICBcbiAgICB2YWwgY29udHJhc3RfcmF0aW8gPSBpZiAobDE+bDIpICgobDEgKyAwLjA1KS8obDIgKyAwLjA1KSkudG9GbG9hdCgpXG4gICAgZWxzZSAoKGwyICsgMC4wNSkvKGwxICsgMC4wNSkpLnRvRmxvYXQoKVxuICAgIFxuICAgIHJldHVybiBjb250cmFzdF9yYXRpb1xufVxuXG5mdW4gbWFpbigpIHtcblxuLy8g0KbQstC10YIg0YTQvtC90LA6IENvbG9yKDB4RkYyMDFCMTYpICByZ2IoMzIsIDI3LCAyMikgIFxuICAgIHZhbCBoZXhDb2xvcjEgPSBcIiMyMDFCMTZcIlxuICAgIHZhbCBjb2xvcjEgPSBDb2xvci5kZWNvZGUoaGV4Q29sb3IxKVxuLy8g0KbQstC10YIg0YLQtdC60YHRgtCwOiBDb2xvcigweEZGRUJFMEQ5KSAgcmdiKDIzNSwgMjI0LCAyMTcpICBcbiAgICB2YWwgaGV4Q29sb3IyID0gXCIjRUJFMEQ5XCJcbiAgICB2YWwgY29sb3IyID0gQ29sb3IuZGVjb2RlKGhleENvbG9yMilcbiAgICBcbiAgICB2YWwgaz0gY29udHJhc3RfcmF0aW9fY2FsY3VsYXRpb24oY29sb3IxLGNvbG9yMilcbiAgICBwcmludGxuKFwi0KbQstC10YIg0YTQvtC90LA6ICAgJGhleENvbG9yMVwiKSAgXG4gICAgcHJpbnRsbihcItCm0LLQtdGCINGC0LXQutGB0YLQsDogJGhleENvbG9yMlwiKSAgXG4gICAgcHJpbnRsbihcIiDQmtC+0L3RgtGA0LDRgdGC0L3QvtGB0YLRjDogJGtcIikgIFxuICAgIFxufSIsInBsYXRmb3JtIjoiamF2YSIsImFyZ3MiOiIifQ=="
                ),
                TextClickLink(
                    text = "Вычисление относительной яркости и контрастности двух цветов ",
                    textUrl = "\uD83D\uDCD6 Онлайн калькулятор ",
                    url = "https://planetcalc.ru/7779/"
                ),
            )

        ),

        ExampleCode(
            id = 5,
            title = "Градиент цвета",
            comment = """
|Brush| в Compose представляет кисть для рисования, которая используетсся вместо |color|.

Кисть может содержать несколько цветов, которые составляют градиент цвета.  

Кисть применяется к нескольким различным типам рисования: 
   |фону|, |тексту| и |холсту|.                        
 
Есть несколько встроенных кистей, которые полезны для рисования:
 
|horizontalGradient|(colors) 

|linearGradient|(colors) 

|verticalGradient|(colors) 

|sweepGradient|(colors) 

|radialGradient|(colors) 

  или обычная кисть |SolidColor|.

Кисти можно использовать с вызовами отрисовки 
 |Modifier.background|() 
 |TextStyle| 
 |DrawScope| 
  для применения стиля рисования к рисуемому содержимому.
 
 Вместо |colors| можно использовать |colorStops| для настройки |распределения цветов|.
 
 Например:
 val colorStops = arrayOf(
     0.0f to Color.Yellow, |!// меньше всего желтого|
     0.2f to Color.Red,    |!//красного больше чем жельтого|
     1f to Color.Blue      |!//синего больше всего|
 )
Значения указываются в виде дроби от 0 до 1. Значения больше 1 приведут к тому, что эти цвета не будут отображаться как часть градиента.


 |tileMode| определяет поведение шейдера при заполнении области за пределами его границ. 
  Возможные значения: 
   .|!Clamp| - край фиксируется по конечному цвету (по умолчанию);
   .|!Decal| - визуализация пикселей изображения шейдера только в пределах исходных границ;
   .|!Mirror| - фрагмент зеркально отображен от последнего цвета к первому;
   .|!Repeated| - фрагмент повторяется от первого цвета до последнего;

 Можно изменить размер кисти.

 Можно использовать изображение в качестве кисти.

 Можно использовать пользовательскую кисть |AGSL| RuntimeShader

            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Кисть: градиенты и шейдеры — ",
                    textUrl = "\uD83D\uDCD6 Developers. Brush",
                    url = "https://developer.android.com/develop/ui/compose/graphics/draw/brush?hl=ru"
                ),
                TextClickLink(
                    text = "Анимационная кисть. Раскраска текста в Compose — ",
                    textUrl = "\uD83D\uDCD6 Medium. Android Developers. Alejandra Stamato",
                    url = "https://medium.com/androiddevelopers/animating-brush-text-coloring-in-compose-%EF%B8%8F-26ae99d9b402"
                ),
                TextClickLink(
                    text = "Brush — кисть для рисования ",
                    textUrl = "\uD83D\uDCD6 Developers. Brush",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Brush"
                ),
                TextClickLink(
                    text = "Android Graphics Shading Language",
                    textUrl = "\uD83D\uDCD6 Developers.  AGSL",
                    url = "https://developer.android.com/reference/android/graphics/RuntimeShader"
                ),
            ),

            highlightCode = highCodeList + listOf(
                HighlightCode("GradientOverview", Color(0xFFffc530)),
                HighlightCode("BackgroundWithBrush ", Color(0xFFffc530)),
                HighlightCode("RadioButtonColumn ", Color(0xFFffc530)),
                HighlightCode("brush = ", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { GradientOverview(it) },
            code ="""   

//********************************

@Composable
fun GradientOverview(
    isExpanded: Boolean = false,
){
    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    var indexSelect by remember { mutableIntStateOf(4) }

    val gradients = listOf(
        "linearGradient",
        "horizontalGradient",
        "verticalGradient",
        "sweepGradient",
        "radialGradient",
    )
    if (isExpanded) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(0.7f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                RadioButtonColumn(
                    indexSelect = indexSelect,
                    items = listOf(
                        "linear",
                        "horizontal",
                        "vertical",
                        "sweep",
                        "radial",
                    ),
                    onClick = { indexSelect = it }
                )
            }

            BackgroundWithBrush(
                indexSelect = indexSelect,
                modifier = Modifier
                    .fillMaxHeight()
                    .background(color = Color.Black)
                    .padding(padding)
                    .weight(1f),
            )
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            RadioButtonColumn(
                indexSelect = indexSelect,
                items = gradients,
                onClick = { indexSelect = it }
            )

            BackgroundWithBrush(
                indexSelect = indexSelect,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Black)
                    .padding(padding)
                    .weight(1f),
            )
        }
    }
}

//********************************

@Composable
fun BackgroundWithBrush (
    indexSelect: Int = 0,
    modifier: Modifier = Modifier,
    colors: List<Color> = listOf(Color.Red,Color.Blue),
    text: String = "Hello, World!",
    style: TextStyle = MaterialTheme.typography.bodyMedium.merge(
        TextStyle(
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontFamily = FontFamily.Serif //шрифт с засечками
        )
    ),
    ) {
    val gradientBrush = when (indexSelect) {
        0 -> Brush.linearGradient(colors)
        1 -> Brush.horizontalGradient(colors)
        2 -> Brush.verticalGradient(colors)
        3 -> Brush.sweepGradient(colors)
        else -> Brush.radialGradient(colors)
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush = gradientBrush),
        contentAlignment = Alignment.Center
    ) {
        Text(
           text = text,
           style = style
        )
    }
}

//********************************

@Composable
fun RadioButtonColumn (
    indexSelect: Int = 0,
    items: List<String> = listOf(
        "linearGradient",
        "horizontalGradient",
        "verticalGradient",
        "sweepGradient",
        "radialGradient",
    ),
    onClick: (Int) -> Unit = {},
) {
    Column(
        Modifier
            .fillMaxWidth()
            .selectableGroup(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        items.forEachIndexed { index, element ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {onClick(index)  },
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = indexSelect == index,
                    onClick = { onClick(index) },
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = element,
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontSize = 22.sp
                )
            }
        }

    }
}
                
                
            """.trimIndent()
        ),
        ExampleCode(
            id = 20,
            title = "Анимация градиента",
            comment = """
|Конструктор функции tween|
@Stable
fun <T> tween(
    durationMillis: Int = DefaultDurationMillis,
    delayMillis: Int = 0,
    easing: Easing = FastOutSlowInEasing
): TweenSpec<T> = {...}                        

Три обязательных параметра:

    |durationMillis| — продолжительность анимации в миллисекундах;

    |delayMillis| — |задержка| в миллисекундах, которая будет выполняться |до запуска| анимации;

    |easing| — кривая смягчения, по которой будет выполняться анимация.

Easing — это характеристика, которая заставляет элементы двигаться так, будто естественные силы, такие как трение, гравитация и масса, работают. 

Easing позволяет анимированным элементам ускоряться и замедляться с разной скоростью.

В Jetpack Compose доступны следующие easing:

 |FastOutSlowInEasing| - медленное начало и медленное завершение

 |LinearOutSlowInEasing| - быстрое начало медленное завершение

 |FastOutLinearInEasing| - медленное начало быстрое завершение

 |LinearEasing| - начало и завершение с ускорением

 |CubicBezierEasing| - позволяет реализовать свою собственную кривую смягчения. Данный easing основан на кривой Безье, которая строится по четырём точкам.




   |Повтор анимации|

Используйте RememberInfiniteTransition с анимацией InfinRepeatable, чтобы постоянно повторять анимацию. 

Измените режимы повтора, чтобы указать, как он должен двигаться вперед и назад.

Используйте FinRepeatable для повторения заданного количества раз. 

            """.trimIndent(),
            highlightCode = highCodeList + listOf(
                HighlightCode("AnimationBgGradient", Color(0xFFffc530)),
                HighlightCode(".animateFloat", Color(0xFF3CEE0A)),
                HighlightCode(".animateColor", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { AnimationBgGradient() },
            code ="""
@Composable
fun AnimationBgGradient(
    backgroundBox: Painter = painterResource(id = R.drawable.bg2),
){

    // Создает экземпляр [InfiniteTransition] для управления дочерними анимациями
    val infiniteTransition = rememberInfiniteTransition()

    // Создает дочернюю анимацию типа float как часть [InfiniteTransition].
    val endX by infiniteTransition.animateFloat(
        initialValue = 150f,
        targetValue = 200f,
        animationSpec = infiniteRepeatable(
            // Бесконечное повторение анимации длительностью 2000 мс с использованием кривой замедления LinearOutSlowInEasing
            animation = tween(2000, easing = LinearEasing),
            // После каждой итерации анимации (т. е. каждые 2000 мс) анимация будет начинаться снова с [initialValue]
            repeatMode = RepeatMode.Reverse
        ),
        label = "size"
        
    )

    val color by infiniteTransition.animateColor(
        initialValue = Color.Transparent,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(  //LinearOutSlowInEasing
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ){

        Image(
            painter = backgroundBox,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

        BackgroundWithBrush(
            indexSelect = 4,     //radialGradient
            modifier = Modifier
                .fillMaxSize(),
            colors = listOf(Color.Red,color),
            StartDp = 0,
            endDp = endX.toInt(),
            tileMode = TileMode.Decal,
            style = MaterialTheme.typography.bodyMedium.merge(
                TextStyle(
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontFamily = FontFamily.Serif 
                )
            ),
        )

    }
}
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Краткое руководство по анимации в Compose ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Quick guide",
                    url = "https://developer.android.com/develop/ui/compose/animation/quick-guide?hl=ru"
                ),
                TextClickLink(
                    text = "Настройка анимации  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Customize",
                    url = "https://developer.android.com/develop/ui/compose/animation/customize?hl=ru"
                ),
                TextClickLink(
                    text = "Animations in Compose   ",
                    textUrl = "\uD83D\uDCD6 Developers. Compose. Animation. Introduction",
                    url = "https://developer.android.com/develop/ui/compose/animation/introduction"
                ),
                TextClickLink(
                    text = "Документация по типам, свойствам и функциям, доступным в пакете androidx.compose.animation.core  ",
                    textUrl = "\uD83D\uDCD6 Developers. Compose. Animation. Core",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/animation/core/package-summary#Ease()"
                ),
                TextClickLink(
                    text = "Ослабление и продолжительность  ",
                    textUrl = "\uD83D\uDCD6 m3.material.io. Easing and duration",
                    url = "https://m3.material.io/styles/motion/easing-and-duration/applying-easing-and-duration"
                ),
                TextClickLink(
                    text = "How to Create Gradient Background in Android Jetpack Compose ",
                    textUrl = "\uD83D\uDCD6 Bolt UiX ",
                    url = "https://www.boltuix.com/2023/01/how-to-create-gradient-background-in.html"
                ),
                TextClickLink(
                    text = "Кисть: градиенты и шейдеры — ",
                    textUrl = "\uD83D\uDCD6 Developers. Brush",
                    url = "https://developer.android.com/develop/ui/compose/graphics/draw/brush?hl=ru"
                ),
            )

        ),
        ExampleCode(
            id = 21,
            title = "Градиент шрифта",
            comment = """
Параметр |brush| (кисть) можно использовать вместо |color| для установки градиента цвета шрифта текста.
                
В нашем примере будем использовать кисть |horizontalGradient|:

|!fun horizontalGradient(
    colors: List<Color>,
    startX: Float = 0.0f,
    endX: Float = Float.POSITIVE_INFINITY,
    tileMode: TileMode = TileMode.Clamp
): Brush|
 
|colors| - Цвета градиента

|start| - Начальное положение линейного градиента. 

|end| - Конечное положение линейного градиента. 
     
|tileMode| - Определяет поведение шейдера при заполнении области за пределами его границ. 
 
 TileMode 
   .|!Clamp| - край фиксируется по конечному цвету (по умолчанию);
   .|!Decal| - визуализация пикселей изображения шейдера только в пределах исходных границ;
   .|!Mirror| - фрагмент зеркально отображен от последнего цвета к первому;
   .|!Repeated| - фрагмент повторяется от первого цвета до последнего;

 

                
            """.trimIndent(),
            highlightCode = highCodeList + listOf(
                HighlightCode("GradientDriver", Color(0xFFffc530)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { GradientDriver(it) },
            code ="""
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Кисть: градиенты и шейдеры — ",
                    textUrl = "\uD83D\uDCD6 Developers. Brush",
                    url = "https://developer.android.com/develop/ui/compose/graphics/draw/brush?hl=ru"
                ),
                TextClickLink(
                    text = "Brush — кисть для рисования ",
                    textUrl = "\uD83D\uDCD6 Developers. Brush",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Brush"
                ),

                ),

            ),

        ExampleCode(
            id = 21,
            title = "Кисть AGSL",
            comment = """
Пользовательская кисть |AGSL| (Android Graphics Shading Language) используется для определения поведения программируемых объектов |RuntimeShader|. 

Шейдеры - это инструкции, которые выполняет всю работу по вычислению цвета для каждого пикселя.

C помощью шейдеров можно делать больше, чем градиенты, а и различные анимационные эффекты, поскольку все это основано на математических вычислениях.

|AGSL| используется в Android 13 и более поздних версиях.

|GLSL| ES 1.0 - язык шейдинга |OpenGL ES|

|AGSL| и |GLSL| очень похожи по синтаксису, что позволяет |перенести| многие эффекты фрагментных шейдеров |GLSL| в |Android| с минимальными изменениями.
                
|AGSL| (и |GLSL|) — это предметно-ориентированные языки в стиле |C|. 

В GLSL введены специальные типы переменных:
 1)для связи шейдера с внешним миром (|uniform|); 
 2)фрагментного шейдера с вершинным шейдером (|varying|); 
 3)переменные-атрибуты вершина (|attribute|). 
 
Такие переменные должны иметь глобальную область видимости.

В GLSL есть циклы:  for, while, do..while ... 

|AGSL| поддерживает дополнительные короткие и половинные типы для обеспечения средней точности.

Имена компонентов вектора для векторов длины 2–4 обозначаются одной буквой.

|vect.xyzw| — используется при доступе к векторам, представляющим точки/нормали.

|vect.rgba| — используется при доступе к векторам, представляющим цвета.

|vect.LTRB| — используйте, когда вектор представляет прямоугольник (не в GLSL).

В |AGSL| 0 и 1 могут использоваться для создания константы 0 или 1 в этом канале. 
Пример: 
  |!vect.rgb1 == vec4(vect.rgb,1)|

 Каждая шейдерная программа начинается с основной функции |main|. 

В отличие от |GLSL|, функция |AGSL| принимает в качестве параметра положение шейдера в «локальных» координатах,а возвращает цвет пикселя в виде |vec4| со средней или высокой точностью.

Входные параметры шейдера определяются квалификатором |uniform|

Код шейдера вызывается |для каждого нарисованного пикселя| и возвращает |цвет|, которым пиксель должен быть окрашен.

Код шейдера можно разместить в переменной с типом |String|.

 Пример шейдерной программы:
************************** 
 | Входные параметры шейдера|    
 
 |!// Разрешение области просмотра (pixels)|
    uniform float2 iResolution;   
 |!// Воспроизведение шейдера time (s)|
    uniform float  iTime;         

Могут быть и другие параметры...
 
 |!// Тело шейдера| 
    half4 |main|(float2 fragCoord) {
 |!// Нормализованные координаты пикселей (from 0 to 1)|
       float2 scaled = fragCoord/iResolution.xy;
       float2 col = abs(1.0-mod(scaled+0.5*cos(iTime+vec2(0,2)),2.0));      
       return half4(col, 0.2, 1);
      
 }      
************************** 


      |Функции AGSL|
  
  1)|!Угловые и тригонометрические функции|
     |radians|(degrees) 	Преобразует градусы в радианы
     |degrees|(radians) 	Преобразует радианы в градусы
     |sin|(angle) 	Стандартный синус (угол)
     |cos|(angle) 	Стандартный косинус
     |tan|(angle) 	Стандартный тангенс
     |asin|(x) 	Возвращает угол, синус которого равен x, в диапазоне [-pi/2,pi/2]
     |acos|(x) 	Возвращает угол, косинус которого равен x, в диапазоне [0,pi]
     |atan|(y,x)	Возвращает угол, тригонометрический арктангенс которого равен y/x, в диапазоне [-pi,pi]
     |atan|(y_over_x) 	RВозвращает угол, тригонометрический арктангенс которого равен y_over_x в диапазоне [-pi/2,pi/2] 

   2)|!Экспоненциальные функции|
      |pow|(x, y) 	Возвращает x^y
      |exp|(x) 	    Возвращает x^2
      |log|(x) 	    Возвращает ln(x)
      |exp2|(x) 	Возвращает  2^x
      |log2|(x) 	Возвращает  log2(x)
      |sqrt|(x) 	Возвращает  sqrt(x)
      |inversesqrt|(x) 	Возвращает  1/sqrt(x)
  
    3)|!Общие функции|
       |abs|(x) Абсолютное значение
       |sign|(x) Возвращает -1,0, 0,0 или 1,0 в зависимости от знака x.
       |floor|(x) Ближайшее целое число <= x
       |ceil|(x) Ближайшее целое число >= x
       |fract|(x) Возвращает дробную часть x.
       |mod|(x,y) Возвращает значение x по модулю y.
       |mod|(x, float y) Возвращает значение x по модулю y.
       |min|(x,y) Возвращает минимальное значение x или y.
       |min|(x, float y) Возвращает минимальное значение x или y.
       |max|(x,y) Возвращает максимальное значение x или y.
       |max|(x, float y) Возвращает максимальное значение x или y.
       |Clamp|(x, minVal, maxVal) Возвращает значение x, зажатое между minVal и maxVal.
       |Clamp|(x, float minVal, float maxVal) Возвращает значение x, зажатое между minVal и maxVal.
       |saturation|(x) Возвращает значение x, ограниченное диапазоном от 0,0 до 1,0.
       |mix|(x, y, a) Возвращает линейную смесь x и y.
       |mix|(x, y, float a) Возвращает линейную смесь x и y.
       |step|(edge,x) Возвращает 0,0, если x < edge, иначе 1,0
       |Step|(float edge, x) Возвращает 0,0, если x < edge, иначе 1,0
       |Smoothstep|(edge0, edge1, x) Выполняет интерполяцию Эрмита между 0 и 1, когда edge0 < x < edge1
       |Smoothstep|(float edge0, float edge1,x) Выполняет интерполяцию Эрмита между 0 и 1, когда edge0 < x < edge1                   
                    
    4)|!Геометрические функции|
       |length|(x) Возвращает длину вектора
       |distance|(p0, p1) Возвращает расстояние между точками
       |dot|(x,y) Возвращает скалярное произведение
       |cross|(float3/half3 x, float3/half3 y) Возвращает векторное произведение
       |normalize|(x) Нормализовать вектор до  1
       |faceforward|(N, I, Nref) Возвращает N, если точка(Nref, I) < 0, иначе -N.
       |reflect|(I, N) Направление отражения I - 2 * dot(N,I) * N.
       |refract|(I, N, float/half eta) Возвращает векто преломления.                        
                        
    5)|!Матричные функции|
       mat |matrixCompMult|(mat x, mat y)	умножение x на y 
       mat |inverse|(mat m) 	Возвращает инверсию m     
       
    6)|!Векторные реляционные функции|
        (cравнение x и y покомпонентно) 

       BV |lessThan|(T x, T y) 	x < y
       BV |lessThanEqual|(T x, T y) 	x <= y
       BV |greaterThan|(T x, T y) 	x > y
       BV |greaterThanEqual|(T x, T y) 	x >= y
       BV |equal|(T x, T y) 	x == y
       BV |equal|(BV x, BV y) 	x == y
       BV |notEqual|(T x, T y) 	x != y
       BV |notEqual|(BV x, BV y) 	x != y
       bool |any|(BV x) 	true, если какой-либо компонент x true
       bool |all|(BV x) 	true, если все компоненты x true
       BV |not|(BV x) 	логическое дополнение x       

     Размеры векторов ввода и возврата для конкретного вызова должны совпадать.
        T — это объединение векторных типов целых чисел и с плавающей запятой. 
        BV — это логический вектор, соответствующий размеру входных векторов.

            
    7)|!Функции цвета|

       vec4 unpremul(vec4 color) 	Преобразует значение цвета в альфа без предварительного умножения
       half3 toLinearSrgb(half3 color) 	Преобразование цветового пространства в линейное SRGB
       half3 fromLinearSrgb(half3 color) 	реобразование цветового пространства 
            

Более детальную информацию смотрите по ссылкам ниже ...
               
                
            """.trimIndent(),
            highlightCode = highCodeList +  listOf(
                HighlightCode("ShaderDemo", Color(0xFFffc530)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    ShaderDriver()
                }
            },
            code ="""
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Кисть: градиенты и шейдеры — ",
                    textUrl = "\uD83D\uDCD6 Developers. Brush",
                    url = "https://developer.android.com/develop/ui/compose/graphics/draw/brush?hl=ru"
                ),

                TextClickLink(
                    text = "Язык шейдеров графики Android ",
                    textUrl = "\uD83D\uDCD6 Developers. Graphics. AGSL",
                    url = "https://developer.android.com/develop/ui/views/graphics/agsl?hl=ru"
                ),
                TextClickLink(
                    text = "Android Graphics Shading Language ",
                    textUrl = "\uD83D\uDCD6 Developers. RuntimeShader",
                    url = "https://developer.android.com/reference/android/graphics/RuntimeShader"
                ),
                TextClickLink(
                    text = "Краткий справочник AGSL ",
                    textUrl = "\uD83D\uDCD6 Developers. AGSL. Quick reference.",
                    url = "https://developer.android.com/develop/ui/views/graphics/agsl/agsl-quick-reference"
                ),
                TextClickLink(
                    text = "The OpenGL® ES Shading Language ",
                    textUrl = "\uD83D\uDCD6 Khronos.org (opengles_shading_language.pdf)",
                    url = "https://www.khronos.org/files/opengles_shading_language.pdf"
                ),
                TextClickLink(
                    text = "Примеры шейдеров ONLINE ",
                    textUrl = "\uD83D\uDCD6 Создавайте и делитесь своими лучшими шейдерами со всем миром и вдохновляйтесь!",
                    url = "https://www.shadertoy.com/browse"
                ),
            ),

        ),

        ExampleCode(
            id = 21,
            title = "Анимация AGSL",
            comment = """
Для примера анимации |AGSL| создадим новую функцию-расширения для |Modifier|, применяющую шейдер: 

 Modifier.|shaderAGSL|(
     shaderSrc:String = GRADIENT_SHADER
 ) 

Входным параметром функции будет переменная типа String, в которую будем передавать строку с |AGSL|-кодом шейдера.

Созданную нами функцию можно использовать как фон к любому |Composable| UI-элементу.

На сайте |https://www.shadertoy.com|  представлено множество шейдеров, которые можно использовать в Андроид приложениях.

Шейдеры написаны на |GLSL| (язык шейдинга OpenGL ES).

Они однотипны и имеют |одинаковые| входные параметры:

|uniform| vec3  iResolution;  - разрешение области просмотра (в пикселях)

|uniform| float iTime;        - воспроизведение (в секундах)

и др.

Также здесь можно создать свой шейдинг, откомпилировать и просмотреть.

При переносе шейдера в Андроид приложение, его необходимо просмотреть и при необходимости отредактировать, учитывая отличия языка |AGSL| от |GLSL|.

После переноса шейдера в Андроид приложение, необходмо основную функцию |mainImage| переименовать в |main| ,а в конце функции main добавить оператор |return| для возврата цвета пикселя при выходе из шейдера.

AGSL |не поддерживает| директивы препроцессора в стиле GLSL, такие как define и др.

            """.trimIndent(),
            highlightCode = highCodeList +  listOf(
                HighlightCode("ShaderDemo", Color(0xFFffc530)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = {
               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    ShaderAnimation()
                }
            },
            code ="""
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Примеры шейдеров ONLINE ",
                    textUrl = "\uD83D\uDCD6 https://www.shadertoy.com - Создавайте и делитесь своими лучшими шейдерами со всем миром и вдохновляйтесь!",
                    url = "https://www.shadertoy.com/browse"
                ),
                TextClickLink(
                    text = "Кисть: градиенты и шейдеры — ",
                    textUrl = "\uD83D\uDCD6 Developers. Brush",
                    url = "https://developer.android.com/develop/ui/compose/graphics/draw/brush?hl=ru"
                ),
            ),

        ),




        ExampleCode(
            id =  10,
            title = "Текст с тенью",
            comment = """
Параметр |shadow| задает затенение текста с помощью объекта |Shadow|.

Параметры |Shadow|:
 
  |!color|: устанавливает цвет тени.

  |!offset|: смещение тени в виде объекта Offset.

  |!blurRadius|: задает радиус размытия.

                
            """.trimIndent(),
            highlightCode = listOf(
                HighlightCode("TextShadow", Color(0xFFffc530)),
                HighlightCode("text ", Color.Cyan),
                HighlightCode("fontSize", Color.Cyan),
                HighlightCode("style ", Color.Cyan),
                HighlightCode("color", Color.Yellow),
                HighlightCode("offset", Color.Yellow),
                HighlightCode("blurRadius", Color.Yellow),
                HighlightCode("@Composable", Color(0xFF3CEE0A)),
                HighlightCode("Text(", Color(0xFF3CEE0A)),
                HighlightCode("shadow", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { ShadowDriver() },
            code ="""
@Composable
fun TextShadow() {

    val offset = Offset(3.0f, 5.0f)
    Text(
        text = "Text in jetpack Compose",
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Blue,
                offset = offset, //смещение тени
                blurRadius = 3f  //размытие
            )
        )
    )
}
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Shadow",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shadow"
                ),
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Открывайте мир через призму творчества авторов на ",
                    textUrl = "\uD83D\uDCD6 Pixabay ",
                    url = "https://pixabay.com/ru/photos/%D0%BC%D0%BE%D0%BB%D0%BD%D0%B8%D1%8F-%D0%B1%D1%83%D1%80%D1%8F-%D0%BD%D0%B5%D0%B1%D0%BE-%D0%BE%D0%B1%D0%BB%D0%B0%D0%BA%D0%BE-%D0%B3%D0%BE%D1%80%D0%B0-7401119/"
                ),
            ),

        ),



        ExampleCode(
            id = 13,
            title = "Текст с различными стилями",
            highlightCode = listOf(
                HighlightCode("TextShadow", Color(0xFFffc530)),
                HighlightCode("text ", Color.Cyan),
                HighlightCode("color", Color.Cyan),
                HighlightCode("fontWeight", Color.Cyan),
                HighlightCode("style ", Color.Cyan),
                HighlightCode("SpanStyle", Color.Yellow),
                HighlightCode("buildAnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("append", Color(0xFF3CEE0A)),
                HighlightCode("withStyle", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { MultipleStylesInText() },
            code ="""
    val Alice = FontFamily(
        Font(R.font.alice_regular)
    )
    val style = SpanStyle(
        color = Color.Cyan,
        fontSize = 22.sp,
        fontFamily = Alice,
        fontStyle = FontStyle.Italic,
    )

    Text(
        text = buildAnnotatedString {
            withStyle(
                style = style
            ) {
                append("T")
            }
            append("ext in jetpack ")

            withStyle(
                style = style.merge(
                    SpanStyle(
                        color = Color.Red,
                    )
                )
            ) {
                append("C")
            }
            append("ompose")
        },
        modifier = Modifier.padding(16.dp)
    )
            """.trimIndent()
        ),
        ExampleCode(
            id = 14,
            title = "Текст с различными стилями 2",
            highlightCode = listOf(
                HighlightCode("TextShadow", Color(0xFFffc530)),
                HighlightCode("text ", Color.Cyan),
                HighlightCode("color", Color.Cyan),
                HighlightCode("textAlign", Color.Cyan),
                HighlightCode("fontWeight", Color.Cyan),
                HighlightCode("style", Color.Cyan),
                HighlightCode("SpanStyle", Color.Yellow),
                HighlightCode("buildAnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("append", Color(0xFF3CEE0A)),
                HighlightCode("withStyle", Color(0xFF3CEE0A)),
                HighlightCode("ParagraphStyle", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { TextBuildAnnotatedString1() },
            code ="""
    val annotatedString = buildAnnotatedString {

        withStyle(
            style = ParagraphStyle(
                textAlign = TextAlign.Center
            )
        ) {
            withStyle(
                style = SpanStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                )
            ) {
                append("Text ")
            }
        }

        withStyle(
            style = ParagraphStyle(
                textAlign = TextAlign.Center
            )
        ) {
            append("in jetpack ")
        }

        withStyle(
            style = ParagraphStyle(
                textAlign = TextAlign.Center
            )
        ) {
            withStyle(
                style = SpanStyle(
                    color = Color.Green,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 24.sp
                )
            ) {
                append("Compose")
            }
        }
    }

    Text(
        annotatedString,
        modifier = Modifier
            .padding(16.dp)
    )
            """.trimIndent()
        ),

        ExampleCode(
            id = 15,
            title = "Текст с различными стилями 3",
            highlightCode = listOf(
                HighlightCode("TextShadow", Color(0xFFffc530)),
                HighlightCode("pushStyle", Color.Cyan),
                HighlightCode("pop", Color.Cyan),
                HighlightCode("text ", Color.Cyan),
                HighlightCode("color", Color.Cyan),
                HighlightCode("onClick", Color.Cyan),
                HighlightCode("textDecoration", Color.Cyan),
                HighlightCode("modifier", Color.Cyan),
                HighlightCode("horizontalAlignment", Color.Cyan),
                HighlightCode("textAlign", Color.Cyan),
                HighlightCode("fontFamily", Color.Cyan),
                HighlightCode("fontWeight", Color.Cyan),
                HighlightCode("style", Color.Cyan),
                HighlightCode("SpanStyle", Color.Yellow),
                HighlightCode("withStyle", Color.Yellow),
                HighlightCode("pushStringAnnotation", Color(0xFF3CEE0A)),
                HighlightCode("tag", Color.Yellow),
                HighlightCode("annotation", Color.Yellow),
                HighlightCode("buildAnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("uriHandler", Color(0xFFF06134)),
                HighlightCode("ClickableText", Color(0xFF3CEE0A)),
                HighlightCode("append", Color(0xFF3CEE0A)),
                HighlightCode("withStyle", Color(0xFF3CEE0A)),
                HighlightCode("ParagraphStyle", Color(0xFF3CEE0A)),
                HighlightCode("annotatedLinkString", Color(0xFFD44EEB)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { TextAnnotatedStringClickLink() },
            code ="""
               
    val annotatedLinkString = buildAnnotatedString {

        withStyle(
            style = SpanStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
            )
        ) {
            pushStyle(
                SpanStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                )
            )
            // append new text red style
            append("Text ")
            // pop the red style
            pop()

            // append new text
            append("in jetpack ")

        }

        withStyle(
            style = SpanStyle(
                color = Color.Magenta,
                fontFamily = FontFamily.Cursive,
                fontSize = 30.sp
            )
        ) {
            append("Compose")
        }

        pushStringAnnotation(
            tag = "URL",
            annotation = "https://developer.android.com/jetpack/compose"
        )

        //Переход на новую строку с выравниванием по центру
        withStyle(
            style = ParagraphStyle(
                textAlign = TextAlign.Center
            )
        ) {
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontFamily = FontFamily.SansSerif,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 18.sp
                )
            ) {
                append("Детальнее здесь...")
            }
        }

        pop()


    }

    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ClickableText(
            text = annotatedLinkString,
            modifier = Modifier
                .padding(16.dp),
            onClick = {
                annotatedLinkString
                    .getStringAnnotations("URL", it, it)
                    .firstOrNull()?.let { stringAnnotation ->
                        uriHandler.openUri(stringAnnotation.item)
                    }
            }
        )

    }
            """.trimIndent()
        ),
        ExampleCode(
            id = 16,
            title = "Текст с различными стилями 4",
            highlightCode = listOf(
                HighlightCode("TextShadow", Color(0xFFffc530)),
                HighlightCode("text ", Color.Cyan),
                HighlightCode("color", Color.Cyan),
                HighlightCode("modifier", Color.Cyan),
                HighlightCode("horizontalAlignment", Color.Cyan),
                HighlightCode("fontFamily", Color.Cyan),
                HighlightCode("style", Color.Cyan),
                HighlightCode("SpanStyle", Color.Yellow),
                HighlightCode("start", Color.Yellow),
                HighlightCode("end", Color.Yellow),
                HighlightCode("buildAnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("addStyle", Color(0xFF3CEE0A)),
                HighlightCode("append", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { TextBuildAnnotatedString() },
            code ="""
fun TextBuildAnnotatedString() {

    val annotatedString = buildAnnotatedString {

        append("Text in jetpack Compose")

        addStyle(
            style = SpanStyle(
                color = Color.Red,
                fontFamily = FontFamily.Cursive,
                fontSize = 24.sp
            ),
            start = 0,
            end = 1
        )

        addStyle(
            style = SpanStyle(
                color = Color.Blue
            ),
            start = 1,
            end = 4
        )

        addStyle(
            style = SpanStyle(
                color = Color.Black
            ),
            start = 5,
            end = 15
        )

        addStyle(
            style = SpanStyle(
                color = Color.Magenta,
                fontFamily = FontFamily.Cursive,
                fontSize = 25.sp
            ),
            start = 16,
            end = 23
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            annotatedString,
            modifier = Modifier
                .padding(16.dp)
        )
    }

            """.trimIndent()
        ),

        ExampleCode(
            id = 17,
            title = "Текст с различными стилями 5",
            highlightCode = listOf(
                HighlightCode("TextShadow", Color(0xFFffc530)),
                HighlightCode("text ", Color.Cyan),
                HighlightCode("color ", Color.Cyan),
                HighlightCode("textAlign", Color.Cyan),
                HighlightCode("fontWeight", Color.Cyan),
                HighlightCode("fontSize", Color.Cyan),
                HighlightCode("baselineShift", Color.Cyan),
                HighlightCode("style", Color.Cyan),
                HighlightCode("SpanStyle", Color.Yellow),
                HighlightCode("buildAnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("append", Color(0xFF3CEE0A)),
                HighlightCode("withStyle", Color(0xFF3CEE0A)),
                HighlightCode("ParagraphStyle", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { TextBuildAnnotatedString3() },
            code ="""
    val colorHour = MaterialTheme.colorScheme.primary
    val colorMin = MaterialTheme.colorScheme.outline
    val annotatedString = buildAnnotatedString {

        withStyle(
            style = ParagraphStyle(
                textAlign = TextAlign.Center
            )
        ) {
            withStyle(
                style = SpanStyle(
                    color = colorHour,
                    fontWeight = FontWeight.Bold,
                    fontSize = 60.sp,
                )
            ) {
                append("18")
            }
            append(" часов")
        }

        withStyle(
            style = ParagraphStyle(
                textAlign = TextAlign.Center
            )
        ) {
            withStyle(
                style = SpanStyle(
                    color = colorMin,
                    fontWeight = FontWeight.Bold,
                    fontSize = 50.sp,
                )
            ) {
                append("30")
            }
            withStyle(
                style = SpanStyle(
                    baselineShift = BaselineShift(+0.70f)
                )
            ) {
                append(" минут ")
            }
        }

        withStyle(
            style = ParagraphStyle(
                textAlign = TextAlign.Center,

            )
        ) {
            withStyle(
                style = SpanStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
            ) {
                append("${'$'}")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                )
            ) {
                append("0.99")
            }
        }

    }

    Text(
        text = annotatedString,
        modifier = Modifier
            .padding(16.dp)
    )

            """.trimIndent()
        ),
        ExampleCode(
            id = 18,
            title = "HTML со ссылками в тексте",
            highlightCode = listOf(
                HighlightCode("TextShadow", Color(0xFFffc530)),
                HighlightCode("https://www.android.com", Color(0xFFBAF576)),
                HighlightCode("fromHtml", Color(0xFFFF9800)),
                HighlightCode("AnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("Text(", Color(0xFF3CEE0A)),
                HighlightCode("@Composable", Color(0xFF3CEE0A)),
                HighlightCode("htmlString", Color(0xFFD857F5)),
                HighlightCode("linkStyles", Color(0xFFD857F5)),
                HighlightCode("<h1>", Color(0xFF1DDBF3)),
                HighlightCode("</h1>", Color(0xFF1DDBF3)),
                HighlightCode("<p>", Color(0xFF1DDBF3)),
                HighlightCode("</p>", Color(0xFF1DDBF3)),
                HighlightCode("<b>", Color(0xFF1DDBF3)),
                HighlightCode("</b>", Color(0xFF1DDBF3)),
                HighlightCode("<a", Color(0xFF1DDBF3)),
                HighlightCode("</a>", Color(0xFF1DDBF3)),
                HighlightCode("<ul>", Color(0xFF1DDBF3)),
                HighlightCode("</ul>", Color(0xFF1DDBF3)),
                HighlightCode("<li>", Color(0xFF1DDBF3)),
                HighlightCode("</li>", Color(0xFF1DDBF3)),
            ),
            lambdaFun = { AnnotatedHtmlString() },
            code ="""
@Composable
fun AnnotatedHtmlString(
    modifier: Modifier = Modifier,
    htmlText: String = ""${'"'}
 <h1>Text in Jetpack Compose</h1>

 <p>
  Simple <b>MVVM</b> 
  <a href="https://www.android.com">App</a> 
  to demonstrate text output in Jetpack Compose.
 </p>

Examples:
<ul>
 <li> Sizes and padding;</li>
 <li> Text and background color;</li>
 <li> Text alignment;</li>
 <li> Font usage;</li>
 <li> Text annotation;</li>
 <li> Text frame, underline and borders;</li>
 <li> Text animation.</li>
</ul>
           ""${'"'}.trimIndent(),
) {

    val textFromHtml = AnnotatedString.fromHtml(
        htmlString = htmlText,
        linkStyles = TextLinkStyles(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline,
                fontStyle = FontStyle.Italic,
                color = Color.Blue
            )
        )
    )
    Text(
        text = textFromHtml,
        modifier = modifier
    )
}
            """.trimIndent()
        ),
        ExampleCode(
            id = 3,
            title = "Маштабирование",
            comment = """
Modifier.|graphicsLayer|  применяет преобразования к составным объектам.                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите в ",
                    textUrl = "\uD83D\uDCD6 Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Модификаторы графики",
                    textUrl = "\uD83D\uDCD6 ",
                    url = "https://developer.android.com/develop/ui/compose/graphics/draw/modifiers?hl=ru"
                ),
            ),

            nameFun = "",
            highlightCode = highCodeList + listOf(
                HighlightCode("ScaleDraver", Color(0xFFffc530)),
                HighlightCode("fontSize", Color(0xFF3CEE0A)),
                HighlightCode("initialValue", Color(0xFF3CEE0A)),
                HighlightCode("targetValue", Color(0xFF3CEE0A)),
                HighlightCode("10f", Color(0xFF5EADD6)),
                HighlightCode("170f", Color(0xFF5EADD6)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { ScaleDraver() },
            code = """
            """.trimIndent()
        ),


        ExampleCode(
            id = 3,
            title = "Рисование текста на холсте",
            comment = """
Нарисовать текст вручную можно с DrawScope.|drawText|()

Чтобы нарисовать текст, создайте |TextMeasurer| с помощью |rememberTextMeasurer| и вызовите |drawText|
                 
val textMeasurer = rememberTextMeasurer()

|Canvas|(modifier = Modifier.fillMaxSize()) {
    drawText(textMeasurer, "Hello")
}

|!fun DrawScope.drawText(
    textMeasurer: TextMeasurer,
    text: String,
    topLeft: Offset,
    style: TextStyle,
    overflow: TextOverflow,
    softWrap: Boolean,
    maxLines: Int,
    size: Size,
    blendMode: BlendMode
): Unit|

Эта функция рисования поддерживает только один стиль текста и асинхронную загрузку шрифтов.

TextMeasurer имеет внутренний кеш для оптимизации измерения макета текста для повторных вызовов на этапе рисования.

|overflow| - как следует обрабатывать визуальное переполнение.

|softWrap| - должен ли текст разрываться при мягких разрывах строк. Если установлено значение false, глифы в тексте будут расположены так, как если бы пространство по горизонтали было неограниченным. 

|size| определяет насколько широким и высоким должен быть текст. 
 |Size.Unspecified| - текст помещаться внутри общей области рисования с того места, где он размещен. 
 |Size.width|  - определяет ширину текста 
 |Size.height| - помогает определить количество строк, которые помещаются, если включена |softWrap| и переполнением является |TextOverflow.Ellipsis|. В противном случае Size.height либо определяет, где текст обрезается (TextOverflow.Clip), либо становится неактивным.

|maxLines| - необязательный, определяет максимальное количество строк текста, при необходимости перенос. Если текст превышает заданное количество строк, он будет обрезан в соответствии с переполнением и softWrap. Если оно не равно нулю, то оно должно быть больше нуля.

|blendMode| - алгоритм смешивания, который будет применен к тексту

Для вывода текста по центру |DrawScope| необходимо определить размер в пикселях отображаемого текста.

Размер отображаемого текста зависит от:
   размера шрифта, 
   вида шрифта, 
   интервала между буквами,
   количества символов и др.

В Compose можно использовать |TextMeasurer|, чтобы получить доступ к измеренному размеру текста.
                        

                 
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Графика в Compose ",
                    textUrl = "\uD83D\uDCD6 Отображать текст",
                    url = "https://developer.android.com/develop/ui/compose/graphics/draw/overview?hl=ru"
                ),
                TextClickLink(
                    text = "Анимации в Compose",
                    textUrl = "\uD83D\uDCD6 Animations in Compose ",
                    url = "https://developer.android.com/develop/ui/compose/animation/introduction"
                ),
                TextClickLink(
                    text = "Коллекция быстрых руководств ",
                    textUrl = "\uD83D\uDCD6 Отображать текст",
                    url = "https://developer.android.com/develop/ui/compose/quick-guides/collections/display-text?hl=ru"
                ),
            ),

            nameFun = "",
            highlightCode = highCodeList + listOf(
                HighlightCode("AnimationSizeText", Color(0xFFffc530)),
                HighlightCode("fontSize", Color(0xFF3CEE0A)),
                HighlightCode("initialValue", Color(0xFF3CEE0A)),
                HighlightCode("targetValue", Color(0xFF3CEE0A)),
                HighlightCode("10f", Color(0xFF5EADD6)),
                HighlightCode("170f", Color(0xFF5EADD6)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { DrawTextCanvas() },
            code = """
@Composable
fun DrawTextCanvas(
    textToCenter: String = "Hello, World!"
) {
    val styleCenter = TextStyle(
        color = Color.White,
        fontSize = 24.sp,
        fontFamily = Alice,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline
    )

    val textMeasurer = rememberTextMeasurer()

    val textLayoutCenter = remember(textToCenter) {
        textMeasurer.measure(textToCenter, styleCenter)
    }

    Canvas(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.Black)
    ) {
        val height = size.height
        val width = size.width

        val startX = 0f
        val endX = width
        val startY = height / 2 + 50.dp.toPx()
        val endY = startY


        drawLine(
            start = Offset(x = startX, y = startY),
            end = Offset(x = endX, y = endY),
            color = Color.Yellow,
            strokeWidth = 10f,
            pathEffect = PathEffect.dashPathEffect(
                intervals = floatArrayOf(
                    10f.dp.toPx(),
                    10f.dp.toPx()
                ),
                phase = 10f.dp.toPx()
            )
        )

//размещение по центру
        drawText(
            textMeasurer = textMeasurer,
            text = textToCenter,
            style = styleCenter,
//            topLeft = Offset(50.dp.toPx(),50.dp.toPx()),
            topLeft = Offset(
                x = center.x - textLayoutCenter.size.width / 2,
                y = center.y - textLayoutCenter.size.height / 2,
            ),
        )

    }
}
                
            """.trimIndent()
        ),
        ExampleCode(
            id = 3,
            title = "Маштабирование на холсте",
            comment = """
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Графика в Compose ",
                    textUrl = "\uD83D\uDCD6 Отображать текст",
                    url = "https://developer.android.com/develop/ui/compose/graphics/draw/overview?hl=ru"
                ),
                TextClickLink(
                    text = "Анимации в Compose",
                    textUrl = "\uD83D\uDCD6 Animations in Compose ",
                    url = "https://developer.android.com/develop/ui/compose/animation/introduction"
                ),
                TextClickLink(
                    text = "Коллекция быстрых руководств ",
                    textUrl = "\uD83D\uDCD6 Отображать текст",
                    url = "https://developer.android.com/develop/ui/compose/quick-guides/collections/display-text?hl=ru"
                ),
            ),

            nameFun = "",
            highlightCode = highCodeList + listOf(
                HighlightCode("DrawAnimeScaleAText", Color(0xFFffc530)),
                HighlightCode("initialValue", Color(0xFF3CEE0A)),
                HighlightCode("targetValue", Color(0xFF3CEE0A)),
                HighlightCode("33f", Color(0xFF5EADD6)),
                HighlightCode("1f", Color(0xFF5EADD6)),
                HighlightCode("10000", Color(0xFF5EADD6)),
                HighlightCode("18", Color(0xFF5EADD6)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { DrawAnimeScaleAText() },
            code = """
@Composable
fun DrawAnimeScaleAText(
    modifier: Modifier = Modifier,
    duration: Int = 10000,   //10 sek
    textToCenter: String = "А",
    color: Color = Color.White,
    fontFamily: FontFamily = Cabin  //Alice
) {
    val textMeasurer = rememberTextMeasurer()

    val styleCenter = TextStyle(
        fontSize = 18.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        color = color,
    )
    val textLayoutCenter = remember(textToCenter) {
        textMeasurer.measure(textToCenter, styleCenter)
    }

    val infiniteTransition = rememberInfiniteTransition(
        label = "infinite"
    )

    val scale by infiniteTransition.animateFloat(
        initialValue = 33f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = duration,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale text"
    )

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black),
    ) {
        withTransform({
            scale(scaleX = scale, scaleY = scale)
        }) {
//размещение по цетру текста
            drawText(
                textMeasurer = textMeasurer,
                text = textToCenter,
                style = styleCenter,
                topLeft = Offset(
                    x = center.x - textLayoutCenter.size.width / 2,
                    y = center.y - textLayoutCenter.size.height / 2,
                ),
            )

        }

    }
}
                
            """.trimIndent()
        ),



        ExampleCode(
            id = 20,
            title = "",
            highlightCode = listOf(
                HighlightCode("AnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("SpanStyle", Color(0xFF3CEE0A)),
                HighlightCode("TextLinkStyles", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = {  },
            code ="""
            """.trimIndent()
        ),
        ExampleCode(
            id = 21,
            title = "",
            highlightCode = listOf(
                HighlightCode("AnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("SpanStyle", Color(0xFF3CEE0A)),
                HighlightCode("TextLinkStyles", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = {  },
            code ="""
            """.trimIndent()
        ),
        ExampleCode(
            id = 22,
            title = "",
            highlightCode = listOf(
                HighlightCode("AnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("SpanStyle", Color(0xFF3CEE0A)),
                HighlightCode("TextLinkStyles", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = {  },
            code ="""
            """.trimIndent()
        ),
        ExampleCode(
            id = 23,
            title = "",
            highlightCode = listOf(
                HighlightCode("AnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("SpanStyle", Color(0xFF3CEE0A)),
                HighlightCode("TextLinkStyles", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = {  },
            code ="""
            """.trimIndent()
        ),
        ExampleCode(
            id = 24,
            title = "",
            highlightCode = listOf(
                HighlightCode("AnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("SpanStyle", Color(0xFF3CEE0A)),
                HighlightCode("TextLinkStyles", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = {  },
            code ="""
            """.trimIndent()
        ),
        ExampleCode(
            id = 25,
            title = "",
            highlightCode = listOf(
                HighlightCode("AnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("SpanStyle", Color(0xFF3CEE0A)),
                HighlightCode("TextLinkStyles", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = {  },
            code ="""
            """.trimIndent()
        ),
        ExampleCode(
            id = 26,
            title = "",
            highlightCode = listOf(
                HighlightCode("AnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("SpanStyle", Color(0xFF3CEE0A)),
                HighlightCode("TextLinkStyles", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = {  },
            code ="""
            """.trimIndent()
        ),
        ExampleCode(
            id = 27,
            title = "",
            highlightCode = listOf(
                HighlightCode("AnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("SpanStyle", Color(0xFF3CEE0A)),
                HighlightCode("TextLinkStyles", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = {  },
            code ="""
            """.trimIndent()
        ),
        ExampleCode(
            id = 28,
            title = "",
            highlightCode = listOf(
                HighlightCode("AnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("SpanStyle", Color(0xFF3CEE0A)),
                HighlightCode("TextLinkStyles", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = {  },
            code ="""
            """.trimIndent()
        ),
        ExampleCode(
            id = 29,
            title = "",
            highlightCode = listOf(
                HighlightCode("AnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("SpanStyle", Color(0xFF3CEE0A)),
                HighlightCode("TextLinkStyles", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = {  },
            code ="""
            """.trimIndent()
        ),
        ExampleCode(
            id = 30,
            title = "",
            highlightCode = listOf(
                HighlightCode("AnnotatedString", Color(0xFF3CEE0A)),
                HighlightCode("SpanStyle", Color(0xFF3CEE0A)),
                HighlightCode("TextLinkStyles", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = {  },
            code ="""
            """.trimIndent()
        ),


    )
}
