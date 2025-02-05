package com.pvmprog.mytextwithcompose.data.locale

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import com.pvmprog.mytextwithcompose.data.model.HighlightCode
import com.pvmprog.mytextwithcompose.data.model.TextClickLink
import com.pvmprog.mytextwithcompose.ui.examples.SimpleAlign
import com.pvmprog.mytextwithcompose.ui.examples.AnnotatedHtmlString
import com.pvmprog.mytextwithcompose.ui.examples.ExampleFontSize
import com.pvmprog.mytextwithcompose.ui.examples.TextFontWeight
import com.pvmprog.mytextwithcompose.ui.examples.ItalicText
import com.pvmprog.mytextwithcompose.ui.examples.MessageGradient
import com.pvmprog.mytextwithcompose.ui.examples.MessageShodow
import com.pvmprog.mytextwithcompose.ui.examples.SimpleLimit
import com.pvmprog.mytextwithcompose.ui.examples.MultipleStylesInText
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
    val highCodeList = listOf(
        HighlightCode("@Composable", Color(0xFFb2c231)),
        HighlightCode("class", Color(0xFFd27749)),
        HighlightCode("data", Color(0xFFd27749)),
        HighlightCode("val", Color(0xFFd27749)),
        HighlightCode("false", Color(0xFFd27749)),
        HighlightCode("true", Color(0xFFd27749)),
        HighlightCode(".repeat", Color(0xFFd27749)),
        HighlightCode("when", Color(0xFFB84E18)),
        HighlightCode("else", Color(0xFFB84E18)),
        HighlightCode("if ", Color(0xFFB84E18)),
        HighlightCode("items", Color(0xFFF5996B)),
        HighlightCode(".padding", Color(0xFFF5996B)),
        HighlightCode(".fillMaxWidth", Color(0xFFF5996B)),
        HighlightCode(".clickable", Color(0xFFF5996B)),
        HighlightCode(".clip", Color(0xFFF5996B)),
        HighlightCode(".background", Color(0xFFF5996B)),
        HighlightCode(".border", Color(0xFFF5996B)),
        HighlightCode("withStyle", Color(0xFFF5996B)),

        HighlightCode("LazyColumn", Color(0xFF0D8113)),
        HighlightCode("Text ", Color(0xFF0D8113)),
        HighlightCode("Column", Color(0xFF0D8113)),
        HighlightCode("Row", Color(0xFF0D8113)),
        HighlightCode("Box", Color(0xFF0D8113)),
        HighlightCode(".typography", Color(0xFF0D8113)),
        HighlightCode(".current", Color(0xFF0D8113)),
        HighlightCode(".colorScheme", Color(0xFF0D8113)),
        HighlightCode("isSystemInDarkTheme", Color(0xFF0D8113)),
        HighlightCode(".colorScheme", Color(0xFF0D8113)),
        HighlightCode("stringResource", Color(0xFF0D8113)),
        HighlightCode("dimensionResource", Color(0xFF0D8113)),
        HighlightCode("colorResource", Color(0xFF0D8113)),
        HighlightCode("Surface", Color(0xFF0D8113)),
        HighlightCode("text =", Color(0xFF00a9ff)),
        HighlightCode("fontSize =", Color(0xFF00a9ff)),
        HighlightCode("fontWeight =", Color(0xFF00a9ff)),
        HighlightCode("style = ", Color(0xFF00a9ff)),
        HighlightCode("modifier =", Color(0xFF00a9ff)),
        HighlightCode("id ", Color(0xFF00a9ff)),
        HighlightCode("bottom =", Color(0xFF2DB8FF)),
        HighlightCode("top =", Color(0xFF2DB8FF)),
        HighlightCode("horizontalAlignment =", Color(0xFF2DB8FF)),
        HighlightCode("platformStyle =", Color(0xFF2DB8FF)),
        HighlightCode("includeFontPadding =", Color(0xFF2DB8FF)),
        HighlightCode("lineHeight =", Color(0xFF2DB8FF)),
        HighlightCode("alignment =", Color(0xFF2DB8FF)),
        HighlightCode("trim =", Color(0xFF2DB8FF)),
        HighlightCode("shadow =", Color(0xFF2DB8FF)),
        HighlightCode("color =", Color(0xFF2DB8FF)),
        HighlightCode("brushColors =", Color(0xFF2DB8FF)),
        HighlightCode("startX =", Color(0xFF2DB8FF)),
        HighlightCode("endX =", Color(0xFF2DB8FF)),
        HighlightCode("StartDp =", Color(0xFF2DB8FF)),
        HighlightCode("endDp =", Color(0xFF2DB8FF)),
        HighlightCode("tileMode =", Color(0xFF2DB8FF)),
        HighlightCode("offset =", Color(0xFF2DB8FF)),
        HighlightCode("blurRadius =", Color(0xFF2DB8FF)),
        HighlightCode("overflow =", Color(0xFF2DB8FF)),
        HighlightCode("maxLines =", Color(0xFF2DB8FF)),
        HighlightCode("verticalArrangement =", Color(0xFF2DB8FF)),
        HighlightCode("textAlign =", Color(0xFF2DB8FF)),
        HighlightCode("fontFamily =", Color(0xFF2DB8FF)),
        HighlightCode("0xff000000", Color(0xFF2DB8FF)),
        HighlightCode("0xffffffff", Color(0xFF2DB8FF)),
        HighlightCode("0xff22200d", Color(0xFF2DB8FF)),
        HighlightCode("0xffffff00", Color(0xFF2DB8FF)),
        HighlightCode("0xFF993399", Color(0xFF2DB8FF)),
        HighlightCode(".value", Color(0xFFe48def)),
        HighlightCode(".resources.displayMetrics.density", Color(0xFFe48def)),
        HighlightCode(".Unspecified", Color(0xFFe48def)),
        HighlightCode(".sp", Color(0xFFe48def)),
        HighlightCode(".dp", Color(0xFFe48def)),
        HighlightCode(".em", Color(0xFFe48def)),
        HighlightCode(".hello_world", Color(0xFFe48def)),
        HighlightCode(".padding_medium", Color(0xFFe48def)),
        HighlightCode(".padding_small", Color(0xFFe48def)),
        HighlightCode(".padding_large", Color(0xFFe48def)),
        HighlightCode(".titleLarge", Color(0xFFe48def)),
        HighlightCode(".titleMedium", Color(0xFFe48def)),
        HighlightCode(".titleSmall", Color(0xFFe48def)),
        HighlightCode(".Italic", Color(0xFFe48def)),
        HighlightCode(".Normal", Color(0xFFe48def)),
        HighlightCode(".Bold", Color(0xFFe48def)),
        HighlightCode(".ExtraBold", Color(0xFFe48def)),
        HighlightCode(".Light", Color(0xFFe48def)),
        HighlightCode(".W100", Color(0xFFe48def)),
        HighlightCode(".W300", Color(0xFFe48def)),
        HighlightCode(".W900", Color(0xFFe48def)),
        HighlightCode(".Center", Color(0xFFe48def)),
        HighlightCode(".CenterHorizontally", Color(0xFFe48def)),
        HighlightCode(".Left", Color(0xFFe48def)),
        HighlightCode(".Right", Color(0xFFe48def)),
        HighlightCode(".bodyMedium", Color(0xFFe48def)),
        HighlightCode(".bodySmall", Color(0xFFe48def)),
        HighlightCode(".bodyLarge", Color(0xFFe48def)),
        HighlightCode(".Justify", Color(0xFFe48def)),
        HighlightCode("LocalTextStyle", Color(0xFFe48def)),
        HighlightCode(".LastLineBottom", Color(0xFFe48def)),
        HighlightCode(".Ellipsis", Color(0xFFe48def)),
        HighlightCode(".Start", Color(0xFFe48def)),
        HighlightCode(".End", Color(0xFFe48def)),
        HighlightCode(".Bottom", Color(0xFFe48def)),
        HighlightCode(".SpaceAround", Color(0xFFe48def)),
        HighlightCode(".SpaceBetween", Color(0xFFe48def)),
        HighlightCode(".SpaceEvenly", Color(0xFFe48def)),
        HighlightCode(".size", Color(0xFFe48def)),
        HighlightCode(".Clamp", Color(0xFFe48def)),
        HighlightCode("LocalTextStyle", Color(0xFFe48def)),
        HighlightCode("LocalContext", Color(0xFFe48def)),
        HighlightCode(".Cyan", Color(0xFFe48def)),
        HighlightCode(".Yellow", Color(0xFFe48def)),
        HighlightCode(".Green", Color(0xFFe48def)),
        HighlightCode(".Blue", Color(0xFFe48def)),
        HighlightCode(".Black", Color(0xFFe48def)),
        HighlightCode(".Red", Color(0xFFe48def)),
        HighlightCode(".red700", Color(0xFFe48def)),
        HighlightCode("Alice", Color(0xFFe48def)),
        HighlightCode(".secondary", Color(0xFFe48def)),
        HighlightCode(".onSecondary", Color(0xFFe48def)),
        HighlightCode(".secondaryContainer", Color(0xFFe48def)),
        HighlightCode(".onSecondaryContainer", Color(0xFFe48def)),
        HighlightCode(".tertiaryContainer", Color(0xFFe48def)),
        HighlightCode(".onTertiaryContainer", Color(0xFFe48def)),
        HighlightCode(".text_compose", Color(0xFFFFEB3B)),
        HighlightCode(".spacedBy", Color(0xFFFFFFFF)),
        HighlightCode("//", Color(0xFF3CEE0A)),
    )

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
            id = 4,
            title = "Cтили типографики Material 3",
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
            ),

            highlightCode = highCodeList + listOf(
                HighlightCode("TextColorAny", Color(0xFFffc530)),
                HighlightCode("color = ", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { TextColorAny() },
            code ="""   
/*
Примечание.
В примере контрастность определена относительно темной (darkTheme) темы.
*/
@Composable
fun TextColorAny() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text (
            text = "Контраст:17.08 (Отличный)",
        )

        Text (
            text = "Контраст:5.44 (Хороший)",
            color = Color.Red,
        )

        Text (
            text = "Контраст:4.16 (Плохой)",
            color = colorResource(id = R.color.red700),
        )

        Text (
            text = "Контраст:2.14 (Плохой)",
//Из целочисленных значений компонентов SRGB. Альфа необязательна
            color = Color(
                red = 0x44,   //between 0 and 255
                green = 0x55, //between 0 and 255
                blue = 0x88,  //between 0 and 255
                alpha = 0xFF
            ),//between 0 and 255
        )

        Text (
            text = "Контраст:2.67 (Плохой)",
//32-bit ARGB color
            color = Color(0xFF993399),
        )

//Установка цвета с использованием TextStyle
        Text (
            text = "Контраст:12.44 (Отличный)",
            style = TextStyle(
                color = Color.Green
            )
        )

        Text (
            text = "Контраст:8.59 (Хороший)",
            style = TextStyle(
                color = Color.Yellow,
                background = Color.Blue
            )
        )

        Text (
            text = "Контраст:16.40 (Отличный)",
            modifier = Modifier
                .background(Color(0xff22200d))
                .padding(8.dp),
            color = Color(0xffffff00),
        )



        Text (
            text = "Контраст:7.41 (Хороший)",
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary),
            color = MaterialTheme.colorScheme.onSecondary,
        )

        Text (
            text = "Контраст:7.55 (Хороший)",
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .padding(8.dp),
            color = MaterialTheme.colorScheme.onSecondaryContainer,
        )

        Text (
            text = "Контраст:9.31 (Хороший)",
            modifier = Modifier
                .background(MaterialTheme.colorScheme.tertiaryContainer)
                .padding(8.dp),
            color = MaterialTheme.colorScheme.onTertiaryContainer,
        )

        Text (
            text = "Контраст:21.00 (Отличный)",
            modifier = Modifier
                .background(Color(0xff000000))
                .padding(8.dp),
            color = Color(0xffffffff),
        )

    }
}
            """.trimIndent()
        ),

        ExampleCode(
            id = 5,
            title = "Градиент цвета",
            comment = """
Кисть(Brush) в Compose описывает, как что-то рисуется на экране: 
 она определяет цвет(а), которые рисуются в области рисования (круг, прямоугольник, путь). 

Кисть применяется к нескольким различным типам рисования: 
   |фону|, |тексту| и |холсту|.                        
 
Есть несколько встроенных кистей, которые полезны для рисования:
 
|horizontalGradient|(colorStops)
  или
|horizontalGradient|(colors)

|linearGradient|(colorStops)
  или
|linearGradient|(colors)

|verticalGradient|(colorStops)
  или
|verticalGradient|(colors)

|sweepGradient|(colorStops)
  или
|sweepGradient|(colors)

|radialGradient|(colorStops)
  или
|radialGradient|(colors)

  или обычная кисть |SolidColor|.

Кисти можно использовать с вызовами отрисовки 
 |Modifier.background|() 
 |TextStyle| 
 |DrawScope| 
  для применения стиля рисования к рисуемому содержимому.

 
 Можно настроить |распределение цветов| с помощью |colorStops|.

 Можно настроить |повторение фрагмента| рисунка с помощью |TileMode|.

 Можно изменить размер кисти.

 Можно использовать изображение в качестве кисти.

 Можно использовать пользовательскую кисть |AGSL| RuntimeShader

В нашем примере будем использовать |horizontalGradient|

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
                    text = " Brush — кисть для рисования ",
                    textUrl = "\uD83D\uDCD6 Developers. Brush",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Brush"
                ),
                TextClickLink(
                    text = " RuntimeShader — вычисляет цвет каждого пикселя на основе выходных данных пользовательской функции языка шейдеров графики Android (AGSL)",
                    textUrl = "\uD83D\uDCD6 Developers.  Android Graphics Shading Language (AGSL)",
                    url = "https://developer.android.com/reference/android/graphics/RuntimeShader"
                ),
            ),

            highlightCode = highCodeList + listOf(
                HighlightCode("MessageGradient", Color(0xFFffc530)),
                HighlightCode("brush = ", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { MessageGradient(it) },
            code ="""   
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
            highlightCode = listOf(
                HighlightCode("@Composable", Color(0xFF3CEE0A)),
                HighlightCode("Text(", Color(0xFF3CEE0A)),
                HighlightCode("fontStyle", Color(0xFF3CEE0A)),
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
            highlightCode = listOf(
                HighlightCode("@Composable", Color(0xFF3CEE0A)),
                HighlightCode("Text(", Color(0xFF3CEE0A)),
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
            highlightCode = listOf(
                HighlightCode("@Composable", Color(0xFF3CEE0A)),
                HighlightCode("Text(", Color(0xFF3CEE0A)),
                HighlightCode("Left", Color(0xFF00BCD4)),
                HighlightCode("Center", Color(0xFF00BCD4)),
                HighlightCode("Right", Color(0xFF00BCD4)),
                HighlightCode("textAlign", Color(0xFF3CEE0A)),
                HighlightCode("fillMaxWidth", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { SimpleAlign() },
            code ="""
@Composable
fun AlignText () {
    val modifier = Modifier
        .padding(top = 16.dp)
        .fillMaxWidth()

    Column {
        Text(
            text = "Text in jetpack Compose",
            fontSize = 15.sp,
            textAlign = TextAlign.Left,
            modifier = modifier
        )
        Text(
            text = "Text in jetpack Compose",
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
        Text(
            text = "Text in jetpack Compose",
            fontSize = 15.sp,
            textAlign = TextAlign.Right,
            modifier = modifier
        )

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
            highlightCode = listOf(
                HighlightCode("@Composable", Color(0xFF3CEE0A)),
                HighlightCode("Text(", Color(0xFF3CEE0A)),
                HighlightCode(".Justify", Color.Cyan),
                HighlightCode("textAlign", Color(0xFF3CEE0A)),
                HighlightCode("fillMaxWidth", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { SimpleAlignJustify() },
            code ="""
@Composable
fun TextAlignJustify() {

    val text = "Text in jetpack Compose. ".repeat(10)

    val modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()

    Column {

        //Без выравнивания
        Text(
            text = text,
            modifier = modifier,
            style = MaterialTheme.typography.bodyMedium,
        )

        //выравнивание строк по всей ширине контейнера, кроме последней
        Text(
            text = text + "(Justify)",
            modifier = modifier,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Justify,
        )

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
            highlightCode = listOf(
                HighlightCode("@Composable", Color(0xFF3CEE0A)),
                HighlightCode("Text(", Color(0xFF3CEE0A)),
                HighlightCode("alignment", Color.Cyan),
                HighlightCode("includeFontPadding", Color.Cyan),
                HighlightCode("trim", Color.Cyan),
                HighlightCode("false", Color.Yellow),
                HighlightCode(".Center", Color.Yellow),
                HighlightCode(".em", Color.Yellow),
                HighlightCode(".LastLineBottom", Color.Yellow),
                HighlightCode("lineHeightStyle", Color(0xFF3CEE0A)),
                HighlightCode("lineHeight ", Color(0xFF3CEE0A)),
                HighlightCode("platformStyle", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { TextAlignedHeight() },
            code ="""
@Composable
fun TextAlignedHeight() {
    val text = "Text in jetpack Compose. ".repeat(5)

    val modifier = Modifier
        .padding(16.dp)

    Column {
        //без выравнивания
        Text(
            text = text,
            modifier = modifier,
            style = MaterialTheme.typography.bodyMedium,
        )

        //выравнивание строки по заданной высоте
        Text(
            text = text,
            modifier = modifier,
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
            lambdaFun = { MessageShodow() },
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
            highlightCode = listOf(
                HighlightCode("@Composable", Color(0xFF3CEE0A)),
                HighlightCode("Text(", Color(0xFF3CEE0A)),
                HighlightCode("style", Color.Cyan),
                HighlightCode(".Serif", Color.Yellow),
                HighlightCode(".SansSerif", Color.Yellow),
                HighlightCode(".Cursive", Color.Yellow),
                HighlightCode(".Monospace", Color.Yellow),
                HighlightCode(".Default", Color.Yellow),
                HighlightCode("fontFamily", Color(0xFF3CEE0A)),
                HighlightCode("merge", Color(0xFFD540EE)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { TextFontFamily() },
            code ="""
@Composable
fun TextFontFamily() {

    val modifier = Modifier
        .padding(top = 16.dp)
        .fillMaxWidth()

    val style = MaterialTheme.typography.bodyMedium.merge(
        TextStyle(
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            //шрифт с засечками
            fontFamily = FontFamily.Serif
        )
    )

    Column()
    {
        Text(
            text = "Text in jetpack Compose\n(Serif)",
            modifier = modifier,
            //шрифт с засечками
            style = style,
        )

        Text(
            text = "Text in jetpack Compose\n(SansSerif)",
            modifier = modifier,
            style = style.merge(
                TextStyle(
                    //шрифт без засечек
                    fontFamily = FontFamily.SansSerif
                )
            )
        )

        Text(
            text = "Text in jetpack Compose\n(Cursive)",
            modifier = modifier,
            style = style.merge(
                TextStyle(
                    //курсивный, рукописный шрифт
                    fontFamily = FontFamily.Cursive
                )
            )
        )

        Text(
            text = "Text in jetpack Compose\n(Monospace)",
            modifier = modifier,
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
            modifier = modifier,
            style = style.merge(
                TextStyle(
                    //шрифт по умолчанию на текущей платформе
                    fontFamily = FontFamily.Default
                )
            )
        )

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
            highlightCode = listOf(
                HighlightCode("@Composable", Color(0xFF3CEE0A)),
                HighlightCode("Text(", Color(0xFF3CEE0A)),
                HighlightCode("style", Color.Cyan),
                HighlightCode("fontFamily", Color(0xFF3CEE0A)),
                HighlightCode("merge", Color(0xFFD540EE)),
                HighlightCode("Cormorantinfant", Color(0xFF3CEE0A)),
                HighlightCode("Serif", Color(0xFF3CEE0A)),
                HighlightCode("Cabin", Color(0xFF3CEE0A)),
                HighlightCode("Poppins", Color(0xFF3CEE0A)),
                HighlightCode("AbrilFatface", Color(0xFF3CEE0A)),
                HighlightCode("Alice", Color(0xFF3CEE0A)),
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

    var style = MaterialTheme.typography.bodyMedium.merge(
        TextStyle(
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
            fontFamily = Cabin,
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


    var nameFont: String
    val text = "Альтернативные шрифты."

    Column {
        for (item in fonts) {
            nameFont = item.nameFont
            style = item.style

            Text(
                text = "${'$'}text (${'$'}nameFont)",
                style = style
            )

            Text(
                text = "${'$'}text - Italic",
                style = style.merge(
                    TextStyle(
                        fontStyle = FontStyle.Italic
                    )
                )
            )

            Text(
                text = "${'$'}text - Bold",
                style = style.merge(
                    TextStyle(
                        fontWeight = FontWeight.Bold,
                    )
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
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
            id = 13,
            title = "Текст с различными стилями",
            highlightCode = listOf(
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
            highlightCode = listOf(
                HighlightCode("@Composable", Color(0xFF3CEE0A)),
                HighlightCode("overflow", Color(0xFF3CEE0A)),
                HighlightCode("maxLines", Color(0xFF3CEE0A)),
                HighlightCode("Text(", Color(0xFF3CEE0A)),
                HighlightCode("//", Color(0xFF3CEE0A)),
            ),
            lambdaFun = { SimpleLimit() },
            code ="""
@Composable
fun LongText ()  {
    Text(
        text = "Text in Jetpack Compose.".repeat(10),
        modifier = Modifier
            .padding(16.dp),
        style = MaterialTheme.typography.bodyMedium,
        overflow = TextOverflow.Ellipsis,
        maxLines = 2,
    )
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
