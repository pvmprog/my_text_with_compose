package com.pvmprog.mytextwithcompose.data.locale

import android.os.Build
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import com.pvmprog.mytextwithcompose.data.model.TextClickLink
import com.pvmprog.mytextwithcompose.ui.examples.AnimationBgGradient
import com.pvmprog.mytextwithcompose.ui.examples.AnimationChildren
import com.pvmprog.mytextwithcompose.ui.examples.AnimationContent
import com.pvmprog.mytextwithcompose.ui.examples.AnimationContentSize
import com.pvmprog.mytextwithcompose.ui.examples.AnimationCrossfade
import com.pvmprog.mytextwithcompose.ui.examples.AnimationTransition
import com.pvmprog.mytextwithcompose.ui.examples.AnimationVisibilityContent
import com.pvmprog.mytextwithcompose.ui.examples.AnimationVisibilityExpend
import com.pvmprog.mytextwithcompose.ui.examples.AnimationVisibilityScale
import com.pvmprog.mytextwithcompose.ui.examples.AnimationVisibilitySlade
import com.pvmprog.mytextwithcompose.ui.examples.Animation_AsState
import com.pvmprog.mytextwithcompose.ui.examples.Animation_AsStateRepeatable
import com.pvmprog.mytextwithcompose.ui.examples.SimpleAlign
import com.pvmprog.mytextwithcompose.ui.examples.AnnotatedHtmlString
import com.pvmprog.mytextwithcompose.ui.examples.AnnotatedPushStyleAndUrl
import com.pvmprog.mytextwithcompose.ui.examples.BackgroundDriver
import com.pvmprog.mytextwithcompose.ui.examples.BorderExampleText
import com.pvmprog.mytextwithcompose.ui.examples.BoxCenterLambdaFun
import com.pvmprog.mytextwithcompose.ui.examples.DecorationExampleText
import com.pvmprog.mytextwithcompose.ui.examples.DirectionExampleText
import com.pvmprog.mytextwithcompose.ui.examples.DrawAnimeScaleAText
import com.pvmprog.mytextwithcompose.ui.examples.DrawTextCanvas
import com.pvmprog.mytextwithcompose.ui.examples.ExampleFontSize
import com.pvmprog.mytextwithcompose.ui.examples.FontScale
import com.pvmprog.mytextwithcompose.ui.examples.GeometricTransform
import com.pvmprog.mytextwithcompose.ui.examples.GradientDriver
import com.pvmprog.mytextwithcompose.ui.examples.GradientOverview
import com.pvmprog.mytextwithcompose.ui.examples.GraphicsLayerTextDriver
import com.pvmprog.mytextwithcompose.ui.examples.ImageBrush
import com.pvmprog.mytextwithcompose.ui.examples.TextFontWeight
import com.pvmprog.mytextwithcompose.ui.examples.ItalicText
import com.pvmprog.mytextwithcompose.ui.examples.LetterSpacing
import com.pvmprog.mytextwithcompose.ui.examples.LineBreakText
import com.pvmprog.mytextwithcompose.ui.examples.SimpleLimit
import com.pvmprog.mytextwithcompose.ui.examples.AnnotatedStylesInText
import com.pvmprog.mytextwithcompose.ui.examples.OutSipmleArticle
import com.pvmprog.mytextwithcompose.ui.examples.ScaleDraver
import com.pvmprog.mytextwithcompose.ui.examples.SemanticsText
import com.pvmprog.mytextwithcompose.ui.examples.ShaderAnimation
import com.pvmprog.mytextwithcompose.ui.examples.ShaderDriver
import com.pvmprog.mytextwithcompose.ui.examples.ShadowDriver
import com.pvmprog.mytextwithcompose.ui.examples.SimpleWithPadding
import com.pvmprog.mytextwithcompose.ui.examples.Simple
import com.pvmprog.mytextwithcompose.ui.examples.SimpleStringResource
import com.pvmprog.mytextwithcompose.ui.examples.SimpleAlignJustify
import com.pvmprog.mytextwithcompose.ui.examples.StyleDraver
import com.pvmprog.mytextwithcompose.ui.examples.AnnotatedWithAddStyle
import com.pvmprog.mytextwithcompose.ui.examples.AnnotatedParagraph
import com.pvmprog.mytextwithcompose.ui.examples.AnnotatedBaseLineShift
import com.pvmprog.mytextwithcompose.ui.examples.ArrowIndicator
import com.pvmprog.mytextwithcompose.ui.examples.ArrowNewIndicator
import com.pvmprog.mytextwithcompose.ui.examples.BasicTextAutoSize
import com.pvmprog.mytextwithcompose.ui.examples.CircularIndicator
import com.pvmprog.mytextwithcompose.ui.examples.ClickableMyText
import com.pvmprog.mytextwithcompose.ui.examples.Emoticons
import com.pvmprog.mytextwithcompose.ui.examples.FormatString
import com.pvmprog.mytextwithcompose.ui.examples.CarouselProducts
import com.pvmprog.mytextwithcompose.ui.examples.CheckboxWithTextExample
import com.pvmprog.mytextwithcompose.ui.examples.EllipsisText
import com.pvmprog.mytextwithcompose.ui.examples.LineDriverIndicator
import com.pvmprog.mytextwithcompose.ui.examples.ListProducts
import com.pvmprog.mytextwithcompose.ui.examples.PieChart
import com.pvmprog.mytextwithcompose.ui.examples.SegmentedButtonExample
import com.pvmprog.mytextwithcompose.ui.examples.SelectableText
import com.pvmprog.mytextwithcompose.ui.examples.TextColorAny
import com.pvmprog.mytextwithcompose.ui.examples.TextFontFamalyAlternate
import com.pvmprog.mytextwithcompose.ui.examples.TextFontFamily
import com.pvmprog.mytextwithcompose.ui.examples.TextLineHeight
import com.pvmprog.mytextwithcompose.ui.examples.TypographyStyles
import com.pvmprog.mytextwithcompose.ui.examples.VertikalOrientationText
import com.pvmprog.mytextwithcompose.ui.examples.data.DataItemProducts
import kotlin.math.PI

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
                TextClickLink(
                    text = "Библиотека «Jetpack Compose» для начинающего Android-разработчика ",
                    textUrl = "\uD83D\uDCD6 Habr. Разработка под Android. Kotlin. Jetpack Compose. ",
                    url = "https://habr.com/ru/articles/757572/"
                ),

                ),
/*
            highlightCode = highCodeList + listOf(
                HighlightCode("Simple", Color(0xFFffc530)),
                HighlightCode("Text", Color(0xFF3CEE0A)),
                HighlightCode("1", Color(0xFF2DB8FF)),
                ),

 */
            nameFun = "Simples.kt#L48-L63",
            lambdaFun =  @Composable { Simple() },
            code ="""
/*
   Пример использования функции Text(...)
*/                
@Composable
fun Simple() {

    Box(
        modifier = Modifier
            .fillMaxSize()
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .border(1.dp , MaterialTheme.colorScheme.onBackground)
        ) {
            Text("Hello, World!")
        }

    }
}
            """.trimIndent()
        ),


        ExampleCode(
            title = "Форматирование строки",
            comment = """
Форматирование включает в себя объединение строк, выравнивание текстов, форматирование десятичных чисел и т. д.

Способы форматирования:

1. |С использованием интерполяции| 
  "${'$'}{variable}"


2. |С использованием шаблонов|
 "${'$'}{"${'$'}%.nf".format(variable)}"
 
                
3. |С  использование метода String.format()|   
 "String.format("%.nf", variable)"
 Спецификаторы типа:                
 |%b| – логическое значение
 |%c| — символы (заключены в ‘’)
 |%d| – целые числа со знаком, например 1,2,14.
 |%e| — числа с плавающей запятой в научных обозначениях, например 1,5e12.
 |%f| — числа с плавающей запятой в десятичном формате, например 45.2341.
 |%g| — числа с плавающей запятой в десятичном или научном значении, в зависимости от размера значения.
 |%h| – Хэш-код данного аргумента
 |%n| – символ новой строки
 |%o| – восьмеричные целые числа (целые числа с основанием 8)
 |%s| – Строковые типы данных.
 |%t| — дата или время в формате даты и времени.
 |%x| – шестнадцатеричные целые числа с основанием 16.   
 

4. |C использованием заполнения(padding)|  
 "[String.format("%-ns", variable)]"
         
5. |C использованием функций padStart() и padEnd()| 
 "variable.padStart(n)"
 "variable.padEnd(n)"
          
Шаблоны:                
                
        |%d|     подставить число типа Int;
        |%3d|    подставить число типа Int, заняв не меньше трёх позиций (пустые заполняются по умолчанию пробелами);
        |%c|     подставить символ;
        |%s|     подставить строку;
        |%20s|   подставить строку, заняв не меньше 20 позиций;
        |%lf|    подставить число типа Double в обычном формате;
        |%le|    подставить число типа Double в экспоненциальном формате вида 1.3e+4;
        |%6.2lf| подставить число типа Double в обычном формате, заняв не меньше шести позиций и используя ровно два знака после запятой.
                
            """.trimIndent(),

            links = listOf(
                TextClickLink(
                    text = "Format String in Kotlin With Examples",
                    textUrl = "\uD83D\uDCD6 SparkByExamples.com",
                    url = "https://sparkbyexamples.com/kotlin/format-string-in-kotlin-with-examples/"
                ),
                TextClickLink(
                    text = "Форматирование строки ",
                    textUrl = "\uD83D\uDCD6 Kotlin Playground",
                    url = "https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS45LjIwIiwiY29kZSI6ImZ1biBtYWluKCkge1xuICAgIHZhbCBudW0gPSAxNDdcbiAgICB2YWwgdHlwZXMgPSBhcnJheU9mKFxuICAgICAgICBcImRlY2ltYWw6XCIsXG4gICAgICAgIFwiaGV4OlwiLFxuICAgICAgICBcImJpbmFyeTpcIlxuICAgIClcbiAgICB2YWwgdmFscyA9IGFycmF5T2YoXG4gICAgICAgIG51bS50b1N0cmluZygpLFxuICAgICAgICBudW0udG9TdHJpbmcoMTYpLnRvVXBwZXJDYXNlKCkucGFkU3RhcnQoNCwnMCcpLFxuICAgICAgICBudW0udG9TdHJpbmcoMikucGFkU3RhcnQoOCwnMCcpXG4gICAgICAgIClcbiAgICBwcmludGxuKFwiXCIucGFkU3RhcnQoMjcsJy0nKSlcbiAgICBmb3IgKGkgaW4gMC4uMil7XG4gICAgICAgIHByaW50bG4oXCJ8IFwiICsgdHlwZXNbaV0ucGFkRW5kKDEwKSArXCIgfCBcIisgdmFsc1tpXS5wYWRTdGFydCgxMCkrXCIgfFwiKVxuICAgIHByaW50bG4oXCJcIi5wYWRTdGFydCgyNywnLScpKVxuICAgIH1cbiAgICBcbn0iLCJwbGF0Zm9ybSI6ImphdmEiLCJhcmdzIjoiIn0="
                ),
                TextClickLink(
                    text = "Дата и время ",
                    textUrl = "\uD83D\uDCD6 Kotlin Playground",
                    url = "https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS44LjIxIiwiY29kZSI6ImltcG9ydCBqYXZhLnRleHQuU2ltcGxlRGF0ZUZvcm1hdFxuaW1wb3J0IGphdmEudXRpbC4qXG5cbmZ1biBtYWluKCkge1xuICAgIFxuICAgIHZhbCBkYXRlID0gRGF0ZSgpIFxuXG4gICAgcHJpbnRsbihcIkRhdGU6ICRkYXRlXCIpICBcblxuICAgIC8vIEZvcm1hdCB0aGUgZGF0ZSB2YWx1ZSB1c2luZyBTaW1wbGVEYXRlRm9ybWF0XG4gICAgcHJpbnRsbihcIkRhdGU6ICR7U2ltcGxlRGF0ZUZvcm1hdChcImRkLU1NLXl5eXlcIikuZm9ybWF0KGRhdGUpfVwiKSAgXG4gICAgcHJpbnRsbihcIlRpbWU6ICR7U2ltcGxlRGF0ZUZvcm1hdChcImhoOm1tOnNzXCIpLmZvcm1hdChkYXRlKX1cIikgIFxuIFxufSIsInBsYXRmb3JtIjoiamF2YSIsImFyZ3MiOiIifQ=="
                ),
            ),
            lambdaFun = { FormatString() },
            nameFun = "FormatString.kt",
            code ="""
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FormatString(){
    val date = Date()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "1. Строковая интерполяция",
            fontWeight = FontWeight.Bold
        )
        var name = "Павел"
        val age = 30

        var message = "Меня зовут ${'$'}name, мне ${'$'}age лет"
        OutTextInfo(
            formatStr = "Меня зовут ${'$'}name, мне ${'$'}age лет",
            message = message,
        )

        Text(
            text = "2. Шаблоны",
            fontWeight = FontWeight.Bold
        )

        val quantity = 10
        val price = 1.23
        val total = price * quantity

        message = "Итого: ${'$'}quantity тетрадей \nстоят ${'$'}{"$%.2f".format(total)}"
        OutTextInfo(
            formatStr = "\"Итого: ${'$'}quantity тетрадей \nстоят ${'$'}{\"${'$'}%.2f\".format(total)}\"",
            message = message,

        )

        Text(
            text = "3. String.format()",
            fontWeight = FontWeight.Bold
        )

        val boolValue = true
        OutTextInfo(
            formatStr = "\"%b\".format(boolValue)\nboolValue=${'$'}boolValue",
            message = "%b".format(boolValue)
        )
        val charValue = 'A'
        OutTextInfo(
            formatStr = "\"%c\".format(charValue)\ncharValue='A'",
            message = "%c".format(charValue)
        )
        val intValue = 25
        OutTextInfo(
            formatStr = "\"%d\".format(intValue)\nintValue=${'$'}intValue",
            message = "%d".format(intValue)
        )
        OutTextInfo(
            formatStr = "\"%4d\".format(intValue)",
            message = "%4d".format(intValue)
        )
        OutTextInfo(
            formatStr = "\"%04d\".format(intValue)",
            message = "%04d".format(intValue)
        )
        val floatValue = 33.3449f
        OutTextInfo(
            formatStr = "\"%f\".format(floatValue)\nfloatValue=33.3449f",
            message = "%f".format(floatValue)
        )
        OutTextInfo(
            formatStr = "\"%.2f\".format(floatValue)",
            message = "%.2f".format(floatValue)
        )

        val doubleValue = 32.44
        OutTextInfo(
            formatStr = "\"%.1f\".format(doubleValue)\ndoubleValue=32.44",
            message = "%.1f".format(doubleValue)
        )
        val hexValue = 255
        OutTextInfo(
            formatStr = "\"%x\".format(hexValue)\nhexValue = 255",
            message = "%x".format(hexValue)
        )
        
        OutTextInfo(
            formatStr = "\"%04x\".format(hexValue).uppercase()",
            message = "%04x".format(hexValue).uppercase()
        )


        OutTextInfo(
            formatStr = "hexValue.toHexString()",
            message = hexValue.toHexString()
        )

        OutTextInfo(
            formatStr = "String.format(\"%.2f\", PI)",
            message = String.format("%.2f", PI)
        )
        message = "Пи = $PI"
        OutTextInfo(
            formatStr = "Пи = ${'$'}PI",
            message = message
        )
        OutTextInfo(
            formatStr = "String.format(\"%+.4f\", 3.141592)",
            message = String.format("%+.4f", 3.141592)
        )

        Text(
            text = "4. Заполнение (padding)",
            fontWeight = FontWeight.Bold
        )
        OutTextInfo(
            formatStr = "\"\".padStart(22,'-')",
            message = "".padStart(22,'-'),
            fontFamily = FontFamily.Monospace

        )
        name = "Иван Иванович"
        OutTextInfo(
            formatStr = "| \${'$'}{String.format(\"%-20s\", name)} |",
            message = "|${'$'}{String.format("%-20s", name)}|",
            fontFamily = FontFamily.Monospace

        )
        name = "Семен Семенович"
        OutTextInfo(
            formatStr = "|\${'$'}{String.format(\"%-20s\", name)}|",
            message = "|${'$'}{String.format("%-20s", name)}|",
            fontFamily = FontFamily.Monospace

        )
        name = "Петр Петрович"
        OutTextInfo(
            formatStr = "|\${'$'}{name.padEnd(20,' ')}|",
            message = "|${'$'}{name.padEnd(20, ' ')}|",
            fontFamily = FontFamily.Monospace
        )
        name = "Иван Иванович"
        OutTextInfo(
            formatStr = "|\${'$'}{name.padStart(20,' ')}|",
            message = "|${'$'}{name.padStart(20, ' ')}|",
            fontFamily = FontFamily.Monospace
        )

        OutTextInfo(
            formatStr = "hexValue.toString(16).toUpperCase().padStart(4,'0')",
            message = hexValue.toString(16).toUpperCase().padStart(4,'0')
        )

        Text(
            text = "5. Дата и время",
            fontWeight = FontWeight.Bold
        )
        message = date.toString()
        OutTextInfo(
            formatStr = "date.toString()",
            message = message
        )

        message = SimpleDateFormat("dd-MM-yyyy").format(date)
        OutTextInfo(
            formatStr = "SimpleDateFormat(\"dd-MM-yyyy\").format(date)",
            message = message
        )

        message = SimpleDateFormat("hh:mm:ss").format(date)
        OutTextInfo(
            formatStr = "SimpleDateFormat(\"hh:mm:ss\").format(date)",
            message = message
        )

        val time = 12567  //длительность в секундах
        message = timeSecondsToStr(time)
        OutTextInfo(
            formatStr = "String.format(\"%02d:%02d:%02d\", hour, minute, second)",
            message = message
        )

        val seconds = timeStrToSeconds(message)
        OutTextInfo(
            formatStr = "seconds.toString()",
            message = seconds.toString()
        )

    }
}

@Composable
fun OutTextInfo(
    formatStr:String = "",
    message:String = "",
    fontFamily:FontFamily = FontFamily.SansSerif
){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formatStr,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 12.sp
        )
        Text(
            text = message,
            textAlign = TextAlign.Center,
            fontFamily = fontFamily
            )

    }

}

// convert int value (seconds) -> "hh:mm:ss" 
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

// convert "hh:mm:ss" -> int value (seconds)
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    return try {
        for (part in parts) {
            val number = part.toInt()
            result = result * 60 + number
        }
        result
    }
    catch (e: NumberFormatException) {
        -1
    }
}                
            """.trimIndent()
        ),

        ExampleCode(
            id = 1,
            title = "Модификаторы",
            comment = """
Параметр |modifier| содержат огромное количество методов, которые позволяют декорировать  какой-либо |compose|-объект, в частности |Text|. 

Модификаторы позволяют:
 1)|измененять внешний вид| составного объекта (размер, макет, поведение );
 
 2)|добавлять информацию|, например метки доступности;
 
 3)|обрабатывать ввод пользователя|;
 
 4)|добавлять высокоуровневые взаимодействия|, например сделать элемент кликабельным, прокручиваемым, перетаскиваемым или масштабируемым. 

По умолчанию макеты, представленные в |Compose|, обертывают свои дочерние элементы.

Это означает, что свойства родителя передаются его дочерным элементам. 

Свойства дочерных элементов можно переназначить.

Некоторые модификаторы:
 |padding| - установка отступов по одной или нескольким сторонам;
 |offset| - сдвиг содержимого компонента по горизонтали и вертикали;              
 |background| - цвет или градиент цвета для фона компонуемого;
 |border| - рамка компонуемого;
 |fillMaxSize| - все доступное пространства или ее часть;
 |fillMaxWidth| - все доступное пространство по |ширине| или ее часть;
 |fillMaxHeight| - все доступное пространство по |высоте| или ее часть;
 |requiredSize| - ширина и высота в dp |независимо| от входящих ограничений;
 |requiredWidth|  - ширина в dp |независимо| от входящих ограничений;
 |requiredHeight| - высота в dp |независимо| от входящих ограничений;
 |size| - ширина и высота в dp. Входные ограничения могут изменить размер;
 |width| - - ширина содержимого в |dp|. Входные ограничения могут изменить размер;
 |height| - высота содержимого в |dp|. Входные ограничения могут изменить размер;
 |weight| - модификатор веса, позволяет изменять размер в пределах родительского элемента;
 |aspectRatio| - определение ширины или высоты в соответствии с указанным соотношением сторон;
 |animateContentSize| - анимация при изменении размера контента; 
 
 и много других...

****************************
                
Modifier.|padding| используется для установки отступов.

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
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Compose modifiers ",
                    url = "https://developer.android.com/develop/ui/compose/modifiers?hl=ru"
                ),
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6  Вevelopers. Android. animateContentSize ",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier#(androidx.compose.ui.Modifier).animateContentSize(androidx.compose.animation.core.FiniteAnimationSpec,kotlin.Function2)"
                ),
            ),
            lambdaFun = { SimpleWithPadding() },
            nameFun = "Simples.kt#L66-L85",
            code ="""
            Text(
                text = "Hello, World!",
                modifier = Modifier
                    .padding(16.dp)
            )
            """.trimIndent()
        ),


        ExampleCode(
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
                TextClickLink(
                    text = "Строковые ресурсы ",
                    textUrl = "\uD83D\uDCD6 Developers. String resource",
                    url = "https://developer.android.com/guide/topics/resources/string-resource?hl=ru"
                ),
            ),
            lambdaFun = { SimpleStringResource() },
            nameFun = "Simples.kt#L99-L134",
            code ="""
    val text1 = stringResource (
        id = R.string.hello_world  //Hello, World!
    )

    //позиционное форматирование
    val text2 = stringResource(
        id = R.string.day_of_month, "January", 31
        //There are %2${'$'}d days in %1${'$'}s
    )

    val padding = dimensionResource (
        id = R.dimen.padding_medium  //16dp
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.onBackground)
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = text1)
            Text(text = text2)
        }
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

            lambdaFun = { ExampleFontSize() },
            nameFun = "ExampleFontSize.kt",
            code = """
                Text( 
                    text = text + "(default)",
                    fontSize = TextUnit.Unspecified
                )
                Text(
                    text = text + "(20.sp)",
                    fontSize = 20.sp
                )
                Text(
                    text = text + "(3.em)",
                    fontSize = 3.em
                )
                Text(
                    text = text + "(15.sp)",
                    style = TextStyle(
                        fontSize = 15.sp,
                    )
                )
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
            nameFun = "TypographyStyles.kt",
            lambdaFun = { TypographyStyles() },
            code = """
data class TypographyStyle(
    val name: String,
    val style:TextStyle
)

@Composable
fun TypographyStyles() {
    val listStyle = listOf(
        TypographyStyle("DisplayLarge", MaterialTheme.typography.displayLarge),
        TypographyStyle("DisplayMedium", MaterialTheme.typography.displayMedium),
        TypographyStyle("DisplaySmall", MaterialTheme.typography.displaySmall),
        TypographyStyle("HeadlineLarge", MaterialTheme.typography.headlineLarge),
        TypographyStyle("HeadlineMedium", MaterialTheme.typography.headlineMedium),
        TypographyStyle("HeadlineSmall", MaterialTheme.typography.headlineSmall),
        TypographyStyle("TitleLarge", MaterialTheme.typography.titleLarge),
        TypographyStyle("TitleMedium", MaterialTheme.typography.titleMedium),
        TypographyStyle("TitleSmall", MaterialTheme.typography.titleSmall),
        TypographyStyle("BodyLarge", MaterialTheme.typography.bodyLarge),
        TypographyStyle("BodyMedium", MaterialTheme.typography.bodyMedium),
        TypographyStyle("BodySmall", MaterialTheme.typography.bodySmall),
        TypographyStyle("LabelLarge", MaterialTheme.typography.labelLarge),
        TypographyStyle("LabelMedium", MaterialTheme.typography.labelMedium),
        TypographyStyle("LabelSmall", MaterialTheme.typography.labelSmall),
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
                Text(
                    text = it.name,
                    style = it.style
                )
                Text(
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
            nameFun = "Simples.kt#L138-L175",
            lambdaFun = { ItalicText() },
            code ="""
@Composable
fun ItalicText() {

    val text= stringResource(
        id = R.string.hello_world
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.onBackground)
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = text + " (Italic)",
                fontStyle = FontStyle.Italic
            )
            Text(
                text = text + " (Normal)",
                fontStyle = FontStyle.Normal
            )
        }
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
            nameFun = "Simples.kt#L177-L240",
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
            text = "${'$'}Text(Normal)",
            modifier = modifier,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = "${'$'}Text (Bold)",
            modifier = modifier,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "${'$'}Text (ExtraBold)",
            modifier = modifier,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "${'$'}Text (Light)",
            modifier = modifier,
            fontWeight = FontWeight.Light
        )
        Text(
            text = "${'$'}Text (W100)",
            modifier = modifier,
            fontWeight = FontWeight.W100
        )
        Text(
            text = "${'$'}Text (W300)",
            modifier = modifier,
            fontWeight = FontWeight.W300
        )
        Text(
            text = "${'$'}Text (W900)",
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
            title = "Межсимвольный отступ",
            comment = """
Параметр |letterSpacing| задает интервал между символами для текста. Расстояние, так как и размер шрифта, представлено классом |TextUnit| и определяется с помощью единиц |sp| или |em| 
                
            """.trimIndent(),
            nameFun = "LetterSpacing.kt",
            lambdaFun = { LetterSpacing() },
            code ="""
@Composable
fun LetterSpacing(){
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        val text = "letterSpacing in Text of jetpack Compose"

        item {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = text+" [default]",
                    letterSpacing = TextUnit.Unspecified, 
                )
                Text(
                    text = text+" [1.3.sp]",
                    letterSpacing = 1.3.sp,
                )
                Text(
                    text = text+" [0.1.sp]",
                    letterSpacing = 0.1.sp,
                )
                Text(
                    text = text+" [0.3.em]",
                    letterSpacing = 0.3.em,
                )

            }
        }
    }
}
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. letterSpacing",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle#letterSpacing()"
                ),
            ),
        ),

        ExampleCode(
            id = 9,
            title = "Высота строки",
            comment = """
Параметр |lineHeight| определяет высоту каждой строки путем добавления дополнительного пространства к верху первой строки, верху и низу последней строки.         
               
            """.trimIndent(),
            nameFun = "TextLineHeight.kt",
            lambdaFun = { TextLineHeight() },
            code = """
@Composable
fun TextLineHeight() {

    val text = ("Text in jetpack Compose.").repeat(5)

    val padding = 16.dp

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .border(1 .dp, MaterialTheme.colorScheme.onBackground)
            .padding(padding),
    ) {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(padding)
            ) {
                Text(
                    text = " default \n\n" + text,
                )

                Text(
                    text = " lineHeight = 2.0.em \n\n" + text,
                    lineHeight = 2.0.em,
                )

                Text(
                    text = " lineHeight = 1.0.em \n\n" + text,
                    lineHeight = 1.0.em,
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
            nameFun = "Simples.kt#L242-L289",
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
TextAlign.|!Justify| равномерно растягивает текст по всей ширине контейнера.

            """.trimIndent(),
            nameFun = "Simples.kt#L291-L324",
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
            id = 11,
            title = "Типы шрифтов",
            comment = """
 |Тип шрифта| определяется параметром |!fontFamily|, который предоставляет ряд встроенных констант:
 
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
            nameFun = "TextFontFamily.kt",
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
                TextClickLink(
                    text = "Google fonts \n Выберите language -> Cyrillic, необходимый шрифт и в виде архива скачайте. Файлы с расширением *.ttf переименовать в нижний регистр с подчеркиванием и переписать в папку /res/font проекта",
                    textUrl = "\uD83D\uDCD6 https://fonts.google.com/",
                    url = "https://fonts.google.com/"
                ),
                TextClickLink(
                    text = "Фотошоп русские шрифты ",
                    textUrl = "\uD83D\uDCD6 https://ofont.ru/category/",
                    url = "https://ofont.ru/category/32/page/8"
                ),
            ),

            ),

        ExampleCode(
            id = 12,
            title = "Альтернативные шрифты",
            comment = """
|FontFamily| позволяет использовать пользовательские шрифты с гарнитурами, которые необходимо разместить в папке 
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
            nameFun = "Simples.kt#L79-L190",
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
                text = "${'$'}Text(${'$'}nameFont)",
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
                TextClickLink(
                    text = "Google fonts \n Выберите language -> Cyrillic, необходимый шрифт и в виде архива скачайте. Файлы с расширением *.ttf переименовать в нижний регистр с подчеркиванием и переписать в папку /res/font проекта",
                    textUrl = "\uD83D\uDCD6 https://fonts.google.com/",
                    url = "https://fonts.google.com/"
                ),

            ),

            ),


        ExampleCode(
            id = 5,
            title = "Цвет, контастность",
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
                Text(
                    text = "Контраст:17.08 (Отличный)",
                    color = Color(0xFFEBE0D9),
                    fontSize = 18.sp
                )

                Text(
                    text = "Контраст:5.44 (Хороший)",
                    color = Color.Red,
                    fontSize = 18.sp
                )

                Text(
                    text = "Контраст:4.16 (Плохой)",
                    color = colorResource(id = R.color.red700),
                    fontSize = 18.sp
                )

                Text(
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

                Text(
                    text = "Контраст:2.67 (Плохой)", //32-bit ARGB color
                    color = Color(0xFF993399),
                    fontSize = 18.sp
                )

                Text(
                    text = "Контраст:12.44 (Отличный)",
                    fontSize = 18.sp,
                    style = TextStyle(
                        color = Color.Green,
                    )
                )

                Text(
                    text = "Контраст:8.59 (Хороший)",
                    style = TextStyle(
                        color = Color.Yellow,
                        background = Color.Blue
                    ),
                    fontSize = 18.sp,
                )

                Text(
                    text = "Контраст:16.40 (Отличный)",
                    modifier = Modifier
                        .background(Color(0xff22200d)),
                    color = Color(0xffffff00),
                    fontSize = 18.sp,
                )

                Text(
                    text = "Контраст:7.41 (Хороший)",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondary),
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontSize = 18.sp,
                )

                Text(
                    text = "Контраст:7.55 (Хороший)",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondaryContainer),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontSize = 18.sp,
                )

                Text(
                    text = "Контраст:9.31 (Хороший)",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.tertiaryContainer),
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    fontSize = 18.sp,
                )

                Text(
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

       vec4 |unpremul|(vec4 color) 	Преобразует значение цвета в альфа без предварительного умножения
       half3 |toLinearSrgb|(half3 color) 	Преобразование цветового пространства в линейное SRGB
       half3 |fromLinearSrgb|(half3 color) 	реобразование цветового пространства 
            

Более детальную информацию смотрите по ссылкам ниже ...
               
                
            """.trimIndent(),
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
Использовании |OpenGL|-шейдеров позволяют делать красивые анимированные интерфейсы.
                
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
                TextClickLink(
                    text = "Анимированные шейдеры в Jetpack Compose — ",
                    textUrl = "\uD83D\uDCD6 https://habr.com...",
                    url = "https://habr.com/ru/companies/timeweb/articles/736192/"
                ),
            ),

        ),

        ExampleCode(
            id = 21,
            title = "Кисть в виде Image",
            comment = """
В качестве |Brush| можно использовать изображение. 
    val imageBrush =
        ShaderBrush(
            shader = ImageShader(
                image = ImageBitmap.imageResource(id = R.drawable.my_cat)
            )
        )
Кисть применим к нескольким различным типам рисования: 
   фону, тексту и холсту.                 
   
            """.trimIndent(),
            lambdaFun = { ImageBrush()   },
            code ="""
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Кисть: градиенты и шейдеры — ",
                    textUrl = "\uD83D\uDCD6 Developers. Brush",
                    url = "https://developer.android.com/develop/ui/compose/graphics/draw/brush?hl=ru"
                ),
                TextClickLink(
                    text = "Image in JetPack Compose — ",
                    textUrl = "\uD83D\uDCD6 https://www.jetpackcompose.net",
                    url = "https://www.jetpackcompose.net/image-in-jetpack-compose"
                ),
            ),

            ),

        ExampleCode(
            id = 19,
            title = "Усечение текста",
            comment = """
|overflow| определяет, как будет обрабатываться текст при его выходе за границы контейнера. 

Этот параметр принимает значение класса |TextOverflow|:

|Clip|: текст усекается (по умолчанию)

|Ellipsis|: текст усекается, а в конце текста добавляется многоточие

|Visible|: весь текст может отображаться     
                   
Примечание. 
  Текст, который выходит за пределы своих границ с помощью |Visible|, может быть обрезан другими модификаторами, такими как Modifier.|clipToBounds|
  
  Кроме того, в |Compose 1.8| улучшена обработка переполнения текста с помощью новых опций:
   TextOverflow.|StartEllipsis| 
   TextOverflow.|MiddleEllipsis|, 
   которые позволяют отображать многоточие в начале или середине текстовой строки пока только при /maxLines = 1/
                
            """.trimIndent(),
            nameFun = "EllipsisText.kt",
            lambdaFun = { EllipsisText() },
            code ="""
            // ...
            
            Text(
                text = text,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Text(
                text = text,
                overflow = TextOverflow.StartEllipsis,
                maxLines = 1,
            )
            Text(
                text = text,
                overflow = TextOverflow.MiddleEllipsis,
                maxLines = 1,
            )
            
            //...

            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Что нового в выпуске Jetpack Compose от 25 апреля 25 года",
                    textUrl = "\uD83D\uDCD6 Блог разработчиков Android ",
                    url = "https://android-developers.googleblog.com/2025/04/whats-new-in-jetpack-compose-april-25.html"
                ),
            ),

            ),

        ExampleCode(
            title = "Декорации для текста",
            comment = """
Параметр |textDecoration| позволять задать декорации для текста. Данный параметр принимает объект класса |TextDecoration|, который предоставляет несколько встроенных значений:

 |LineThrough| - зачеркивает текст
 |Underline| - подчеркивает текст
 |None| - отсутствие декораций (по умолчанию)
 
Для декораций можно использовать и модификатор |Modifier.drawBehind|, который позволяет выполнять операции |DrawScope| за составным содержимым, отображаемым на экране.

Чтобы создать пунктирную линию,необходимо вызвать метод |dashPathEffect|() экземпляра |PathEffect| и передать ему массив чисел с плавающей запятой, а также смещение в указанном массиве. 

Числа с плавающей запятой обозначают интервалы «включения» и «выключения» в строке в пикселях. 

Интервалы должны содержать четное количество записей (минимум 2 значения). 

Четные индексы указывают интервалы «включения», а нечетные индексы представляют интервалы «выключения». 

                        
                
            """.trimIndent(),
            nameFun = "DecorationExampleText.kt",
            lambdaFun = { DecorationExampleText() },
            code ="""
@Composable
fun DecorationExampleText(){
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        var outText = "TextDecoration in jetpack Compose."

        Text(
            text = "1.${'$'}outText(None)",
            textDecoration = TextDecoration.None
        )

        Text(
            text = "2.${'$'}outText(LineThrough)",
            textDecoration = TextDecoration.LineThrough
        )

        Text(
            text = "3.${'$'}outText(Underline)",
            textDecoration = TextDecoration.Underline
        )

//одновременное подчеркивание и зачеркивание текста
        Text(
            text = "4.${'$'}outText(Underline + LineThrough)",
            textDecoration = TextDecoration.Underline +
                    TextDecoration.LineThrough,
//  можно и так:
//            textDecoration = TextDecoration.combine(
//                listOf(
//                    TextDecoration.Underline,
//                    TextDecoration.LineThrough
//                )
//            )
        )


        outText = "Decoration for Text in jetpack Compose."
        val modifierUnderline = Modifier.drawBehind{
            val strokeWidthPx = 1.dp.toPx()
            val verticalOffset = size.height - 3.sp.toPx()
            drawLine(
                color = Color.Red,
                strokeWidth = strokeWidthPx,
                start = Offset(0f, verticalOffset),
                end = Offset(size.width, verticalOffset)
            )
        }
        Text(
            text = "5.${'$'}outText ",
            modifier = modifierUnderline,
        )

        var modifierLineThrough = Modifier.drawBehind{
            val strokeWidthPx = 1.dp.toPx()
            val verticalOffset = size.height/2
            drawLine(
                color = Color.Red,
                strokeWidth = strokeWidthPx,
                start = Offset(0f, verticalOffset),
                end = Offset(size.width - 5.dp.toPx(), verticalOffset)
            )
        }
        Text(
            text = "6.${'$'}outText ",
            modifier = modifierLineThrough,
        )

        modifierLineThrough = Modifier
            .drawBehind{
                val strokeWidthPx = 1.dp.toPx()
                drawLine(
                    color = Color.Yellow,
                    strokeWidth = strokeWidthPx,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, size.height)
                )
            }
            .drawBehind{
                val strokeWidthPx = 1.dp.toPx()
                drawLine(
                    color = Color.Yellow,
                    strokeWidth = strokeWidthPx,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, 0f)
                )
            }
        Text(
            text = "7.${'$'}outText ",
            modifier = modifierLineThrough,
        )

        val modifierDashline = Modifier.drawBehind{
            val strokeWidthPx = 1.dp.toPx()
            val verticalOffset = size.height - 3.sp.toPx()
            drawLine(
                color = Color.Red,
                strokeWidth = strokeWidthPx,
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f)),
                start = Offset(0f, verticalOffset),
                end = Offset(size.width - 5.dp.toPx(), verticalOffset)
            )
        }

        Text(
            text = "8.${'$'}outText ",
            modifier = modifierDashline,
        )

        val modifierIntervalsline = Modifier.drawBehind{
            val strokeWidthPx = 1.dp.toPx()
            val verticalOffset = size.height - 3.sp.toPx()
            drawLine(
                color = Color.Cyan,
                strokeWidth = strokeWidthPx,
                start = Offset(0f, verticalOffset),
                end = Offset(size.width - 5.dp.toPx(), verticalOffset),
                pathEffect = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(
                        10f.dp.toPx(),
                        2f.dp.toPx(),
                        2f.dp.toPx(),
                        2f.dp.toPx()
                    ),
                    phase = 0f
                )

            )
        }

        Text(
            text = "9.${'$'}outText ",
            modifier = modifierIntervalsline,
        )

    }

}
            """.trimIndent()
        ),



        ExampleCode(
            title = "Текст с рамкой",
            comment = """
Модификатор |border| - самый простой способ для создания рамки для текста.                

Для создания рамки можно использовать и модификатор |Modifier.drawBehind|, который позволяет выполнять операции |DrawScope| за составным содержимым, отображаемым на экране.

            """.trimIndent(),
            nameFun = "BorderExampleText.kt",
            lambdaFun = { BorderExampleText() },
            code ="""
@Composable
fun BorderExampleText(
) {
    val outText = "Border for Text in jetpack Compose."

    val corner = 8.dp

    val style = LocalTextStyle.current.merge(
        TextStyle(
            fontSize = 20.sp,
            color = Color.White,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif,
        )
    )

    val modifier = Modifier
        .background(Color(0xFF9C27B0))

    Column(
        modifier = Modifier
            .padding(8.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .background(Color.DarkGray)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        Text(
            text = "1.${'$'}outText",
            modifier = modifier
                .border(
                    width = 2.dp,
                    color = Color.Cyan,
                )
                .padding(8.dp),
            style = style,
        )

        Text(
            text = "2.${'$'}outText",
            modifier = modifier
                .border(
                    width = 2.dp,
                    color = Color.Cyan,
                    shape = CutCornerShape(corner) //углы срезаны
                )
                .padding(8.dp),
            style = style,
        )

        Text(
            text = "3.${'$'}outText",
            modifier = Modifier
                .graphicsLayer{
                    shadowElevation = 8.dp.toPx()
                    shape = CutCornerShape(corner) //углы срезаны
                    clip = true //!!! обрезание всего, что вне формы
                }
                .border(
                    width = 2.dp,
                    color = Color.Cyan,
                    shape = CutCornerShape(corner) //углы срезаны
                )
                .background(Color(0xFF9C27B0))
                .padding(8.dp),
            style = style,
        )
        Text(
            text = "4.${'$'}outText",
            modifier = modifier
                .border(
                    width = 2.dp,
                    color = Color.Cyan,
                    shape = RoundedCornerShape(corner) //углы закруглены
                )
                .padding(8.dp),
            style = style,
        )

        Text(
            text = "5.${'$'}outText",
            modifier = Modifier
                .graphicsLayer{
                    shadowElevation = 8.dp.toPx()
                    shape = RoundedCornerShape(corner)
                    clip = true //!!! обрезание всего, что вне формы
                }
                .border(
                    width = 2.dp,
                    color = Color.Cyan,
                    shape = RoundedCornerShape(corner) //углы закруглены
                )
                .background(Color(0xFF9C27B0))
                .padding(8.dp),
            style = style,
        )

        Text(
            text = "6.${'$'}outText",
            modifier = Modifier
                .drawBehind{
                    drawRoundRect(
                        Color(0xFF9C27B0),
                        cornerRadius = CornerRadius(corner.toPx()),
                    )
                }
                .border(
                    width = 2.dp,
                    color = Color.Cyan,
                    shape = RoundedCornerShape(corner) //углы закруглены
                )
                .padding(8.dp),
            style = style,
        )

        Text(
            text = "7.${'$'}outText",
            modifier = Modifier
                .graphicsLayer{
                    shadowElevation = 8.dp.toPx()
                    shape = RoundedCornerShape(corner)
                    clip = true //!!! обрезание всего, что вне формы
                }
                .background(Color(0xFF9C27B0))
                .drawBehind{
//рисует границы прямоугольника с закруглёнными углами
                    drawRoundRect(
                        color = Color.Cyan,
                        cornerRadius = CornerRadius(corner.toPx()),
                        style = Stroke(
                            width = 4.dp.toPx(),
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
                        )
                    )

                }
                .padding(8.dp),
            style = style,
        )

    }
}
            """.trimIndent()
        ),


        ExampleCode(
            id = 19,
            title = "Стилизация текста",
            comment = """
Свойство |style| позволяет расширить настройки по стилизации текста, например тень, абзац текста, направление текста и т. д.

Свойство |style| предоставлно классом :
|TextStyle|( |!
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight? = null,
    fontStyle: FontStyle? = null,
    fontSynthesis: FontSynthesis? = null,
    fontFamily: FontFamily? = null,
    fontFeatureSettings: String? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    baselineShift: BaselineShift? = null,
    textGeometricTransform: TextGeometricTransform? = null,
    localeList: LocaleList? = null,
    background: Color = Color.Unspecified,
    textDecoration: TextDecoration? = null,
    shadow: Shadow? = null,
    drawStyle: DrawStyle? = null,
    textAlign: TextAlign = TextAlign.Unspecified,
    textDirection: TextDirection = TextDirection.Unspecified,
    lineHeight: TextUnit = TextUnit.Unspecified,
    textIndent: TextIndent? = null,
    platformStyle: PlatformTextStyle? = null,
    lineHeightStyle: LineHeightStyle? = null,
    lineBreak: LineBreak = LineBreak.Unspecified,
    hyphens: Hyphens = Hyphens.Unspecified,
    textMotion: TextMotion? = null|
)

Параметры конструктора:
    
    |color|: цвет текста.
    
    |fontSize|: размер шрифта.
    
    |fontWeight|: толщина шрифта.
    
    |fontStyle|: стиль шрифта.
    
    |fontSynthesis|: Синтезировать ли толщину и/или стиль шрифта, если запрошенную толщину или стиль невозможно найти в предоставленном семействе шрифтов.
    
    |fontFamily|:тип шрифта.
    
    |fontFeatureSettings|: определяет, как будут применяться настройки толщины шрифта и его наклон (то есть значения параметров fontWeight и fontStyle), если используемый шрифт не поддерживает выделение жирным и (или) наклон.
    
    |letterSpacing|: отступы между символами.
    
    |baselineShift|: насколько текст будет сдвигаться относительно базовой линии (baseline).
    
    |textGeometricTransform|: представляет применяемые к тексту геометрические трансформации в виде объекта |TextGeometricTransform?|.
    
    |localeList|:  представляет список со специфичными для региона символами.
    
    |background|: фоновый цвет.
    
    |textDecoration|: тип декораций.
    
    |shadow|: определяет применяемый к тексту эффект тени.
    
    |drawStyle|: Стиль рисования текста: заполнение текста во время рисования или обводка по краям.
    
    |textAlign|: выравнивание текста.
    
    |textDirection|: представляет направление текста.
    
    |lineHeight|: представляет высоту строки текста.
    
    |textIndent|: представляет отступ от начала текста.
    
    |platformStyle|: Параметры TextStyle, специфичные для платформы.
    
    |lineHeightStyle|: конфигурация высоты строки, такая как вертикальное выравнивание строки, добавление ли дополнительного пространства в зависимости от высоты строки к верху первой строки, верху и низу последней строки. Конфигурация применяется только в том случае, если определен lineHeight. Если значение равно нулю, используется LineHeightStyle.Default.
    
    |lineBreak|: Конфигурация разрыва строки для текста.
    
    |hyphens|: Настройка переносов.
    
    |textMotion|: Размещение текстовых символов, оптимизация для анимированного или статического текста.
                
  |!Свойства для изменения интервала внутри текста|:

|letterSpacing|: установка интервала между буквами

|lineHeight|: установка интервала между строками

|baselineShift|: изменение степени смещения текста вверх по сравнению с текущей базовой линией

|padding|: установка интервалов между абзацами                
                
|textIndent|: задает отступ, применяемый к первой строке и остальным строкам.
 |!TextIndent|(firstLine: TextUnit, restLine: TextUnit)
  |firstLine| - величина отступа первой строки;
  |restLine|  - величина отступа, примененных к каждой строке, кроме первой.
                 
            """.trimIndent(),
            nameFun = "StyleDraver.kt",
            lambdaFun = { StyleDraver() },
            code ="""
@Composable
fun TextStyleIndent(
    text: String = "Абзац - малоисследованный компонент литературной формы, имеющий композиционное, сюжетное и тематическое значение.\n" +
            "Выделение фразы в особый абзац усиливает падающий на неё смысловой акцент и способствует правильному и быстрому восприятию текста.",
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(
        textAlign = TextAlign.Justify,
        lineHeight = 20.sp,
        baselineShift = BaselineShift(1.5F),
        textIndent = TextIndent(
            firstLine = 24.sp,
            restLine = 5.sp
        )
    )
){
    Text(
        text = text,
        modifier = modifier,
        style = textStyle
        )

}
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Jetpack Compose: стилизация текста ",
                    textUrl = "\uD83D\uDCD6 alexzh.com",
                    url = "https://alexzh.com/jetpack-compose-styling-text/"
                ),
                TextClickLink(
                    text = "Абзац текста ",
                    textUrl = "\uD83D\uDCD6 Developers. TextIndent",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextIndent"
                ),
            ),
        ),


        ExampleCode(
            id =  10,
            title = "Текст с тенью",
            comment = """
Параметр |shadow| дает возможность накладывать тень на текст. 
Эффект тени основан на следующих параметрах:
 
  |!color|: устанавливает цвет тени.

  |!offset|: смещение тени в виде объекта Offset.

  |!blurRadius|: задает радиус размытия.

                
            """.trimIndent(),
            nameFun = "ShadowDriver.kt",
            lambdaFun = { ShadowDriver() },
            code ="""
@Composable
fun ShadowDriver(){
    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val offsetX = remember {
        mutableFloatStateOf(2f)
    }
    val offsetY = remember {
        mutableFloatStateOf(6f)
    }

    val blur = remember {
        mutableFloatStateOf(2f)
    }

    val fontSize = remember {
        mutableFloatStateOf(45f)
    }

    var indexColor by remember { mutableIntStateOf(-1) }

    var colorTxt by remember {
        mutableStateOf(Color(0xfffcce36))
    }
    var colorSh by remember {
        mutableStateOf(Color(0xffff0000))
    }
    var colorBg by remember {
        mutableStateOf(Color(0xff0000ff))
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.White)
                .background(colorBg)
                .heightIn(min = 150.dp)
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {

            MessageShadow(
                message = stringResource(R.string.hello_world),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontFamily = Alice,
                    fontSize = fontSize.floatValue.sp,
                    lineHeight = (fontSize.floatValue + 10).sp,
                    color = colorTxt,
                    shadow = Shadow(
                        color = colorSh,
                        offset = Offset(offsetX.floatValue, offsetY.floatValue), //смещение тени
                        blurRadius = blur.floatValue  //размытие
                    )
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
            )

        }
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

                        SliderSimple("size",fontSize,12f,80f)

                        SliderSimple("offsetX",offsetX,-20f,20f)

                        SliderSimple("offsetY",offsetY,-20f,20f)

                        SliderSimple("blur...",blur,0f,20f)

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
                                    .background(colorTxt)
                                    .size(40.dp)
                                    .clickable {
                                        indexColor = 0
                                    }
                            )
                            Box(
                                modifier = Modifier
                                    .padding(padding)
                                    .background(colorSh)
                                    .size(40.dp)
                                    .clickable {
                                        indexColor = 1
                                    }
                            )
                            Box(
                                modifier = Modifier
                                    .padding(padding)
                                    .background(colorBg)
                                    .size(40.dp)
                                    .clickable {
                                        indexColor = 2
                                    }
                            )
                        }

                    } else{
                        ColorSelect(
                            colorCurrent = when(indexColor){
                                0 -> colorTxt
                                1 -> colorSh
                                else -> colorBg
                            },
                            onColorSelect ={
                                when(indexColor){
                                    0 -> colorTxt = it
                                    1 -> colorSh = it
                                    else -> colorBg = it
                                }
                                indexColor = -1
                            },
                            title = when(indexColor){
                                0 -> "Выберите цвет текста"
                                1 -> "Выберите цвет тени"
                                else -> "Выберите цвет фона"
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
            title = "Направление текста",
            comment = """
Параметр |textDirection| определяет алгоритм, который будет использоваться при определении направления текста.

Возможные значения:
 
 |Content|: направление текста зависит от первого направляющего символа в соответствии с алгоритмом Unicode Bidirectional Algorithm
 
 |ContentOrLtr|: направление текста зависит от первого направляющего символа в соответствии с алгоритмом Unicode Bidirectional Algorithm, либо представляет направление слева направо
 
 |ContentOrRtl|: направление текста зависит от первого направляющего символа в соответствии с алгоритмом Unicode Bidirectional Algorithm, либо представляет направление справа налево
 
 |Ltr|: текс направлен слева направо
 
 |Rtl|: текст направлен справо налево
 
 |Unspecified|: Это представляет собой неустановленное значение, обычную замену «null», когда требуется примитивное значение.
                     
                
            """.trimIndent(),
            nameFun = "DirectionExampleText.kt",
            lambdaFun = { DirectionExampleText() },
            code ="""
@Composable
fun DirectionExampleText(){
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        val text = "TextDirection in jetpack Compose"
        val modifier = Modifier.fillMaxWidth()
        val style = TextStyle(
            fontSize = 25.sp,
            fontFamily = FontFamily.Serif,
        )

        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = text+" (Unspecified)",
                    modifier = modifier,.Unspecified
                    style = style.merge(
                        textDirection = TextDirection
                    )
                )
                Text(
                    text = text+" (Content)",
                    modifier = modifier,
                    style = style.merge(
                        textDirection = TextDirection.Content
                    )
                )
                Text(
                    text = text+" (ContentOrLtr)",
                    modifier = modifier,
                    style = style.merge(
                        textDirection = TextDirection.ContentOrLtr
                    )
                )
                Text(
                    text = text+" (ContentOrRtl)",
                    modifier = modifier,
                    style = style.merge(
                        textDirection = TextDirection.ContentOrRtl
                    )
                )
                Text(
                    text = text+" (Rtl)",
                    modifier = modifier,
                    style = style.merge(
                        textDirection = TextDirection.Rtl
                    )
                )
                Text(
                    text = text+" (Ltr)",
                    modifier = modifier,
                    style = style.merge(
                        textDirection = TextDirection.Ltr
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
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Алгоритм, который будет использоваться при определении направления текста. ",
                    textUrl = "\uD83D\uDCD6 Developers. TextDirection",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextDirection"
                ),
            ),
        ),

        ExampleCode(
            title = "Перенос строки",
            comment = """
|LineBreak| представляет собой конфигурацию для переноса строки, предлагая несколько пресетов для различных вариантов использования:

 |Simple| - базовый, быстрый для разрыва строки.
 
 |Heading| - более мягкие правила переноса, подходящие для коротких текстов, таких как заголовки или узкие газетные колонки.
  
 |Paragraph| -  более медленный и качественный перенос строк для улучшения читаемости.

Если мягкий перенос включен и ширина текста превышает ширину его контейнера, в текст вставляются разрывы строк, чтобы разделить его на несколько строк.

Существует ряд параметров, которые влияют на то, как вставляются разрывы строк. 

Например, алгоритм для разрыва строки может быть изменен на алгоритм с улучшенной читаемостью за счет скорости. 

Другим примером является строгость, которая в некоторых языках определяет, какие символы могут появляться в начале строки.
     
 LineBreak.|Strategy| - стратегия, используемая для разрыва строки.

 LineBreak.|Strictness| - описывает строгость переноса строки, определяя, перед какими символами могут быть вставлены разрывы строк.

 LineBreak.|WordBreak| - описывает, как разрывы строк должны вставляться в слова.     
            
            """.trimIndent(),
            nameFun = "LineBreakText.kt",
            lambdaFun = { LineBreakText() },
            code ="""
@Composable
fun LineBreakText(){

    val strategy: List<String> = remember {
        listOf(
            "Simple ",
            "Balanced",
            "HighQuality ",
        )
    }

    var idStrategy by remember { mutableIntStateOf(1) }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Text wrapping",
            style = TextStyle(
                fontSize = 24.sp,
                lineBreak = LineBreak(
                    strategy = LineBreak.Strategy.Simple,
                    strictness = LineBreak.Strictness.Strict,
                    wordBreak = LineBreak.WordBreak.Default
                )
            )
        )

        Text(
            text = "John really likes cream cake. I like chocolate ice cream the most. Maria likes milkshake with cake.",
            style = TextStyle(
                fontSize = 20.sp,
                lineBreak = LineBreak.Paragraph.copy(
                    strategy = when (idStrategy) {
                        0 -> LineBreak.Strategy.Simple
                        1 -> LineBreak.Strategy.Balanced
                        else -> LineBreak.Strategy.HighQuality
                    },
                    strictness = LineBreak.Strictness.Default,
                    wordBreak = LineBreak.WordBreak.Default
                )
            )
        )


        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            RadioButtonRow(idStrategy,strategy,{idStrategy = it})

        }


    }


}
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. LineBreak",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/LineBreak"
                ),
            ),
        ),

        ExampleCode(
            title = "Геометрические трансформации",
            comment = """
Параметр |TextGeometricTransform| задает геометрические трансформации текста с помощью объекта 
|TextGeometricTransform|(
    |!scaleX|: Float = 1.0f, 
    |!skewX|: Float = 0.0f
), где                        

 |scaleX| указывает на увеличение текста. Если значение меньше 1.0f, то текст сжимается, если больше - то увеличивается.

 |skewX| указывает на сдвиг текста. Например, точка с координатами (x, y), будет трансформирована в точку (x + y * skewX, y). Значение по умолчанию - 0.0f.                        
                
            """.trimIndent(),
            nameFun = "GeometricTransform.kt",
            lambdaFun = { GeometricTransform() },
            code ="""
@Composable
fun GeometricTransform(){
    Text(
        text = "Text in jetpack Compose",
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = TextStyle(
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Cursive,
            textGeometricTransform = TextGeometricTransform(
                scaleX = 2f,
                skewX = 1.2f
            )
        )
    )

}
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Геометрическое преобразование текста. ",
                    textUrl = "\uD83D\uDCD6 Developers. TextGeometricTransform",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextGeometricTransform"
                ),
            ),
        ),


        ExampleCode(
            title = "Модификатор графики\nВращение, перемещение",
            comment = """
Modifier.|graphicsLayer| — модификатор, который превращает содержимое составного рисунка в слой рисования. 

Слой предоставляет несколько различных функций, таких как:

 1.|Изоляция| инструкций рисования. Инструкции рисования, записанные как часть слоя, могут эффективно перевыдаваться конвейером рендеринга без повторного выполнения кода приложения.
     
 2.|Преобразования|, которые применяются ко всем инструкциям рисования, содержащимся в слое.
 
 3.|Растеризация| для возможностей композиции. Когда слой растрируется, выполняются его инструкции по рисованию, и выходные данные сохраняются во внеэкранном буфере. Создание такого буфера для последующих кадров выполняется быстрее, чем выполнение отдельных инструкций, но при применении таких преобразований, как масштабирование или вращение, он будет вести себя как растровое изображение.                
 
 Для вращения используются параметры:               
 |rotationX| для вращения по горизонтали, 
 |rotationY| для вращения по вертикали,
 |rotationZ| для вращения по оси Z.
  
 Значение указывается в градусах (0–360).   
                      
|transformOrigin| указывает точку, относительно которой происходят преобразования. 

По умолчанию точка отсчета находится по центру с координатами (0,5f, 0,5f). 

Если начало координат переместить в точку (0f, 0f), преобразования начнутся с верхнего левого угла составного объекта.

                      
                 
            """.trimIndent(),
            nameFun = "GraphicsLayerTextDriver.kt",
            lambdaFun = { GraphicsLayerTextDriver() },
            code ="""
@Composable
fun GraphicsLayerTextDriver(){
    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val layerRotationX = remember {
        mutableFloatStateOf(15f)
    }
    val layerRotationY = remember {
        mutableFloatStateOf(52f)
    }
    val layerRotationZ = remember {
        mutableFloatStateOf(0f)
    }
    val layerOriginX = remember {
        mutableFloatStateOf(0.5f)
    }
    val layerOriginY = remember {
        mutableFloatStateOf(0.5f)
    }

    val layerTranslationX = remember {
        mutableFloatStateOf(40f)
    }

    val layerTranslationY = remember {
        mutableFloatStateOf(20f)
    }



    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.White)
                .background(Color(0xff0000ff))
                .heightIn(min = 150.dp)
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {

            MessageShadow(
                message = stringResource(R.string.hello_world),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontFamily = Alice,
                    fontSize = 45.sp,
                    lineHeight = 55.sp,
                    color = Color(0xfffcce36),
                    shadow = Shadow(
                        color = Color(0xffff0000),
                        offset = Offset(2f, 6f), //смещение тени
                        blurRadius = 2f  //размытие
                    )
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .graphicsLayer{
                        this.transformOrigin = TransformOrigin(
                            layerOriginX.floatValue,
                            layerOriginY.floatValue
                        )
                        this.rotationX = layerRotationX.floatValue
                        this.rotationY = layerRotationY.floatValue
                        this.rotationZ = layerRotationZ.floatValue

                        this.translationX = layerTranslationX.value.dp.toPx()
                        this.translationY = layerTranslationY.value.dp.toPx()

                    }
                    .fillMaxWidth(),
            )

        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(padding)
        ) {
            SliderSimple("rotat.X ", layerRotationX, 0f, 360f)
            SliderSimple("rotat.Y ", layerRotationY, 0f, 360f)
            SliderSimple("rotat.Z ", layerRotationZ, 0f, 360f)
            SliderSimple("OriginX ", layerOriginX, 0f, 1f)
            SliderSimple("OriginY ", layerOriginY, 0f, 1f)
            SliderSimple("trans.X ", layerTranslationX, 0f, 100f)
            SliderSimple("trans.Y ", layerTranslationY, 0f, 100f)
        }
    }


}
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. TextIndent",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextIndent"
                ),
            ),
        ),

        ExampleCode(
            id = 3,
            title = "Модификатор графики\nТрансформация",
            comment = """
 Modifier.|graphicsLayer|  применяет преобразования к составным объектам.
Для маштабирования используются параметры:               
  |ScaleX| и |ScaleY| увеличивают или сжимают содержимое в горизонтальном или вертикальном направлении соответственно. 
  
  Значение 1,0f указывает на отсутствие изменений в масштабе, значение 0,5f означает половину размера.
                        
                
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

            nameFun = "ScaleDraver.kt",
            lambdaFun = { ScaleDraver() },
            code = """
@Composable
fun ScaleText(
    scaleX: Float = 1f,
    scaleY: Float = 1f,
){
    val text = stringResource(
        id = R.string.hello_world
    )

    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )
    Box(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.onBackground)
            .widthIn(min = 150.dp)
            .padding(padding),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text + "\n (${'$'}{scaleX},${'$'}{scaleY})",
            modifier = Modifier
                .padding(padding)
                .graphicsLayer{
                    this.scaleX = scaleX
                    this.scaleY = scaleY
                },
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
        )

    }

}
                
                
@Composable
fun ScaleDraver(){
    val padding = dimensionResource(
        id = R.dimen.padding_medium
    )

    val scaleX = remember {
        mutableFloatStateOf(0.5f)
    }
    val scaleY = remember {
        mutableFloatStateOf(0.5f)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        ScaleText(scaleX.floatValue,scaleY.floatValue)
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
                    SliderSimple("scaleX", scaleX, 0.1f, 3f)

                    SliderSimple("scaleY", scaleY, 0.1f, 3f)

                }

            }

        }
    }
}
                
            """.trimIndent()
        ),



        ExampleCode(
            id = 13,
            title = "Аннотированная строка.  \n" +
                    "withStyle",
            comment = """
Аннотированная строка |AnnotatedString| строка позволяет разбить текст на сегменты, каждый из которых имеет свою собственную стилизацию.

             
|AnnotatedString|(
    |!text|: String,
    |!annotations|: List<AnnotatedString.Range<AnnotatedString.Annotation>>
) - базовая структура данных текста с несколькими стилями и другими аннотациями.
                

|AnnotatedString|(
    |!text|: String,
    |!spanStyles|: List<AnnotatedString.Range<SpanStyle>>,
    |!paragraphStyles|: List<AnnotatedString.Range<ParagraphStyle>>
) - базовая структура данных текста с несколькими стилями.

 |text|: текст, который будет отображаться.
    
 |spanStyles|: предоставляет возможность стилизовать текстовый диапазон. Мы можем изменить атрибуты шрифта, цвета, а также добавить текстовые украшения и т. д. 
   
 |paragraphStyles|: определяющий стили абзацев для определенной части текста. Каждый ParagraphStyle с диапазоном определяет абзац текста. Требуется, чтобы диапазоны абзацев не пересекались друг с другом. Если между указанными диапазонами абзацев есть пробелы, между ними будет создан абзац по умолчанию.
                
|!@Immutable
class SpanStyle(
    val color: Color = Color.Unspecified,
    val fontSize: TextUnit = TextUnit.Unspecified,
    val fontWeight: FontWeight? = null,
    val fontStyle: FontStyle? = null,
    val fontSynthesis: FontSynthesis? = null,
    val fontFamily: FontFamily? = null,
    val fontFeatureSettings: String? = null,
    val letterSpacing: TextUnit = TextUnit.Unspecified,
    val baselineShift: BaselineShift? = null,
    val textGeometricTransform: TextGeometricTransform? = null,
    val localeList: LocaleList? = null,
    val background: Color = Color.Unspecified,
    val textDecoration: TextDecoration? = null,
    val shadow: Shadow? = null
)|                
                
                
Класс |Builder| для |AnnotatedString| позволяет создавать |AnnotatedString| с использованием таких методов, как |append| и |addStyle|.                        
                
            """.trimIndent(),
            nameFun = "AnnotatedStylesInText.kt",
            lambdaFun = {
                BoxCenterLambdaFun(
                    lambdaFun = { AnnotatedStylesInText(fontSize = 40) },
                    modifier = Modifier
                        .fillMaxSize()
                )
            },
            code ="""
@Composable
fun AnnotatedStylesInText(
    fontSize:Int = 32,
    style:SpanStyle = SpanStyle(
        fontSize = fontSize.sp,
        fontFamily = Alice,
        fontStyle = FontStyle.Italic,
    ),
    modifier: Modifier = Modifier.padding(16.dp)
) {

    Text(
        text = buildAnnotatedString {
            withStyle(
                style = style.merge(
                    SpanStyle(
                        color = Color.Cyan,
                    )
                )
            ) {
                append("T")
            }

            withStyle(
                style = style
            ){
                append("ext in jetpack ")
            }

            withStyle(
                style = style.merge(
                    SpanStyle(
                        color = Color.Red,
                    )
                )
            ) {
                append("C")
            }
            withStyle(
                style = style
            ){
                append("ompose")
            }


        },
        modifier = modifier,
        lineHeight = (fontSize+10).sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun BoxCenterLambdaFun(
    text: String = "Text in jetpack Compose",
    lambdaFun: @Composable (String) -> Unit = @Composable{},
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        lambdaFun(text)
    }

}

                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. AnnotatedString",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/AnnotatedString"
                ),
                TextClickLink(
                    text = "Несколько стилей в тексте ",
                    textUrl = "\uD83D\uDCD6 Developers. Figma. AnnotatedString",
                    url = "https://developer.android.com/develop/ui/compose/tooling/relay/multiple-styles-in-text?hl=ru"
                ),
            ),

        ),
        ExampleCode(
            id = 14,
            title = "Аннотированная строка.  \n" +
                    "ParagraphStyle",
            comment = """
|ParagraphStyle| - конфигурация стиля для абзаца. Разница между |SpanStyle| и |ParagraphStyle| заключается в том, что |ParagraphStyle| можно применить ко всему абзацу, а |SpanStyle| можно применить на уровне символа. 

После того, как часть текста отмечена |ParagraphStyle|, эта часть будет отделена от остального, как если бы был добавлен символ перевода строки.
                
            """.trimIndent(),
            nameFun = "AnnotatedParagraph.kt",
            lambdaFun = {
                BoxCenterLambdaFun(
                    lambdaFun = { AnnotatedParagraph() },
                    modifier = Modifier
                        .fillMaxSize()
                )
            },

            code ="""
@Composable
fun AnnotatedParagraph(
    fontSize:Int = 40,
) {
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
                    fontSize = fontSize.sp
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
                    fontSize = (fontSize+5).sp
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

}
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. AnnotatedString",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/AnnotatedString"
                ),
                TextClickLink(
                    text = "Конфигурация стиля абзаца  ",
                    textUrl = "\uD83D\uDCD6 Developers. ParagraphStyle",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/ParagraphStyle"
                ),
            ),

        ),

        ExampleCode(
            id = 15,
            title = "Аннотированная строка.  \n" +
                    "LinkAnnotation.Url",
            comment = """
            Аннотация |LinkAnnotation.Url|() содержит строку |URL|. При нажатии на текст, к которому прикреплена эта аннотация, приложение попытается открыть |URL| с помощью |androidx.compose.ui.platform.UriHandler|. 

            |!withLink(
                LinkAnnotation.Url(
                    url = "https://developer.android.com/jetpack/compose",
                    styles = TextLinkStyles(
                        style = SpanStyle(
                            color = Color.Blue,
                            letterSpacing = 1.5.sp,
                            textDecoration = TextDecoration.Underline,
                        )
                    )
                ){
                    val url = (it as LinkAnnotation.Url).url
                    uriHandler.openUri(url)
                }
            ) {
                append("Детальнее здесь...")
            }|
                 
            Можно использовать и несколько ссылок в одной строке.                 
                 
            В примере будем использовать метод |pushStyle|, который применяет |SpanStyle| или |ParagraphStyle| ко всему добавляемому тексту до тех пор, пока не будет вызван метод |pop|.
                
            """.trimIndent(),
            nameFun = "AnnotatedPushStyleAndUrl.kt",
            lambdaFun = {
                BoxCenterLambdaFun(
                    lambdaFun = { AnnotatedPushStyleAndUrl() },
                    modifier = Modifier
                        .fillMaxSize()
                )
            },
            code ="""
@Composable
fun AnnotatedPushStyleAndUrl(){

    val uriHandler = LocalUriHandler.current

    val annotatedLinkString = buildAnnotatedString {

        withStyle(
            style = SpanStyle(
                fontSize = 18.sp,
                color = Color.Black,
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

        //Переход на новую строку с выравниванием по центру
        withStyle(
            style = ParagraphStyle(
                textAlign = TextAlign.Center
            )
        ) {

            withLink(
                LinkAnnotation.Url(
                    url = "https://developer.android.com/jetpack/compose",
                    styles = TextLinkStyles(
                        style = SpanStyle(
                            color = Color.Blue,
                            letterSpacing = 1.5.sp,
                            textDecoration = TextDecoration.Underline,
                        )
                    )
                ){
                    val url = (it as LinkAnnotation.Url).url
                    uriHandler.openUri(url)
                }
            ) {
                append("Детальнее здесь...")
            }

        }

    }

    Text(
        text = annotatedLinkString,
        lineHeight = 48.sp,
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
    )

}

            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. AnnotatedString",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/AnnotatedString"
                ),
                TextClickLink(
                    text = "LinkAnnotation.Url  ",
                    textUrl = "\uD83D\uDCD6 Developers. ",
                    url = "https://developer.android.com.acc.wang/reference/kotlin/androidx/compose/ui/text/LinkAnnotation.Url"
                ),
            ),

        ),
        ExampleCode(
            id = 16,
            title = "Аннотированная строка.  \n" +
                    "addStyle",
            comment = """
Метод |addStyle| вместе с |append| также позволяет создавать |AnnotatedString|.                        

buildAnnotatedString {
    append("Hello")
    // push green text style 
    pushStyle(SpanStyle(color = Color.Green))
    // append new text, this text will be rendered as green
    append(" World")
    // pop the green style
    pop()
    // append a string without style
    append("!")
    // then style the last added word as red, exclamation mark will be red
    addStyle(
       SpanStyle(color = Color.Red), 
       start = "Hello World".length, 
       end = this.length
    )

    toAnnotatedString()
}

            """.trimIndent(),
            nameFun = "AnnotatedWithAddStyle.kt",
            lambdaFun = {
                BoxCenterLambdaFun(
                    lambdaFun = {
                        BoxCenterLambdaFun(
                            lambdaFun = { AnnotatedWithAddStyle() },
                            modifier = Modifier
                                .fillMaxSize()
                        )

                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            },
            code ="""
@Composable
fun AnnotatedWithAddStyle() {

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

    Text(
        annotatedString,
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
    )

}
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. AnnotatedString",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/AnnotatedString"
                ),
                TextClickLink(
                    text = "AnnotatedString.Builder ",
                    textUrl = "\uD83D\uDCD6 Developers. ",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/AnnotatedString.Builder"
                ),
            ),

        ),

        ExampleCode(
            id = 17,
            title = "Аннотированная строка.  \n" +
                    "BaselineShift",
            comment = """
Параметр |baselineShift| SpanStyle определяет величинну, на которую текст смещается вверх или вниз относительно текущей |базовой линии|.                
            """.trimIndent(),
            nameFun = "AnnotatedBaseLineShift.kt",
            lambdaFun = {
                BoxCenterLambdaFun(
                    lambdaFun = { AnnotatedBaseLineShift() },
                    modifier = Modifier
                        .fillMaxSize()
                )
            },

            code ="""
@Composable
fun AnnotatedBaseLineShift() {
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
            withStyle(
                style = SpanStyle(
                    baselineShift = BaselineShift(+0.70f)
                )
            ) {
                append(" часов ")
            }
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
                    background = Color.Black,
                    color = Color.Cyan,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
            ) {
                append("${'$'}")
                pushStyle(SpanStyle(fontSize = 28.sp))
                append("0.99")
                pop()

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
                    fontFamily = FontFamily.Cursive,
                    fontSize = 26.sp,
                )
            ) {
                append("Price")
            }


            withStyle(SpanStyle(baselineShift = BaselineShift.Superscript, fontSize = 10.sp)) {
                append("2")
                withStyle(SpanStyle(baselineShift = BaselineShift.Subscript)) {
                    append("4")
                }
            }
        }

    }

    Text(
        text = annotatedString,
        modifier = Modifier
            .padding(16.dp)
    )

}

            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. AnnotatedString",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/AnnotatedString"
                ),
                TextClickLink(
                    text = "AnnotatedString.Builder ",
                    textUrl = "\uD83D\uDCD6 Developers. ",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/AnnotatedString.Builder"
                ),
                TextClickLink(
                    text = "Смещение текста относительно базовой линии ",
                    textUrl = "\uD83D\uDCD6 Developers. BaselineShift ",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/BaselineShift"
                ),
            ),

        ),
        ExampleCode(
            id = 18,
            title = "Аннотированная строка.  \n" +
                    "HTML-разметка",
            comment = """
Стилизация с помощью |HTML|-разметки. AnnotatedString.|fromHtml|() преобразует строку htmlText в AnnotatedString
 
Поддерживаются следующие элементы HTML:
    Жирный: <|b|>
    Курсив: <|i|>, <|cite|>, <|dfn|>, <|em|>
    Увеличение текста на 25 %: <|big|>
    Текст на 20% меньше: <|small|>
    Установка свойств шрифта: <|font face="font_family" color="hex_color"|>. Примеры возможных семейств шрифтов включают monospace , serif и sans_serif .
    Установка семейства моноширинных шрифтов: <|tt|>
    Зачеркивание: <|s|>, <|strike|>, <|del|>
    Подчеркнуть: <|u|>
    Надстрочный индекс: <|sup|>
    Индекс: <|sub|>
    Точки списка: <|ul|>, <|li|>
    Разрывы строк: <|br|>
    Подразделение: <|div|>
    Стиль CSS: <|span style="color|background_color|text-decoration"|>
    Параграфы: <|p dir="rtl | ltr» style="…"|>               

Пример:
<h2>Здравствуй, друг!</h2>

<p>
 Создавайте  <big><b>отличные</b></big> приложения <br>  
 <small>с помощью</small> <br> 
 <a href="https://developer.android.com/compose">Jetpack Compose</a>
</p>

            """.trimIndent(),
            nameFun = "AnnotatedHtmlString.kt",
            lambdaFun = {
                BoxCenterLambdaFun(
                    lambdaFun = { AnnotatedHtmlString() },
                    modifier = Modifier
                        .fillMaxSize()
                )
            },

            code ="""
@Composable
fun AnnotatedHtmlString(
    modifier: Modifier = Modifier,
    htmlText: String = ""${'"'}
<h2>Здравствуй, друг!</h2>

<p>
 Создавайте  <big><b>отличные</b></big> приложения <br>  
 <small>с помощью</small> <br> 
 <a href="https://developer.android.com/compose">Jetpack Compose</a>
</p>

<p >
 Поднимите свою повседневную жизнь <br> 
 <big><font face="monospace" color="#3CEE0A"> на новый уровень</font></big> <br> 
 <small>с помощью</small> <br> 
 искусственного интеллекта <br> 
  <a href="https://www.android.com/ai/#gemini"> 
    <font face="cursive">Google</font>
  </a>
</p>
           ""${'"'}.trimIndent(),
) {

    val textFromHtml = AnnotatedString.fromHtml(
        htmlString = htmlText,
        linkStyles = TextLinkStyles(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline,
                fontStyle = FontStyle.Italic,
                fontSize = 30.sp,
                color = Color.Cyan,
                letterSpacing = 2.sp,
            )
        )
    )
    LazyColumn {
        item {
            Text(
                text = textFromHtml,
                color = Color.Yellow,
                textAlign = TextAlign.Center,
                lineHeight = 48.sp,
                modifier = modifier
                    .background(Color.Black)
                    .padding(16.dp)
            )

        }
    }
}
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. AnnotatedString",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/AnnotatedString"
                ),
                TextClickLink(
                    text = "AnnotatedString.Builder ",
                    textUrl = "\uD83D\uDCD6 Developers. ",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/AnnotatedString.Builder"
                ),
                TextClickLink(
                    text = "Преобразование строки с тегами HTML в AnnotatedString ",
                    textUrl = "\uD83D\uDCD6 Developers. AnnotatedString.Companion ",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/AnnotatedString.Companion"
                ),
                TextClickLink(
                    text = "Стилизация с помощью HTML-разметки ",
                    textUrl = "\uD83D\uDCD6 Developers. AnnotatedString.Companion ",
                    url = "https://developer.android.com/guide/topics/resources/string-resource#StylingWithHTML"
                ),
            ),
        ),


        ExampleCode(
            title = "Маштабирование текста",
            comment = """
Для определения размера шрифта всегда используйте |sp|.

 Если ваш дизайн предполагает, что весь текст всегда должен быть виден, а размер шрифта варьируется в зависимости от предпочтений пользователя, необходимо обеспечить |скроллинг|.
     
|Скроллинг| («просматривание; прокрутка») — форма представления информации, при которой содержимое (текст, изображение) двигается (прокручивается) в вертикальном или горизонтальном направлении.
                  
При использовании изображения, которое несет определенную информацию, необходимо назначить текстовое описание для параметра |contentDescription|, которое описывает изображение. Оно будет прочитано программами чтения с экрана, когда они столкнутся с картинкой.                   
 
Не везде есть смысл использовать |contentDescription|. Чисто декоративные изображения, которые не имеют значения, должны иметь значение |@null|.

           |Обнаружение всех жестов|

Вместо обработки необработанных событий указателя вы можете прослушивать определенные жесты и реагировать соответствующим образом. 

|AwaitPointerEventScope| предоставляет методы для прослушивания:
 
 1) |detectTapGestures| : нажатие, касание, двойное касание, долгое нажатие

 2) |detectHorizontalDragGestures|, 
    |detectVerticalDragGestures|, 
    |detectDragGestures|, 
    |detectDragGesturesAfterLongPress| : перетаскивание


 3) |detectTransformGestures| : трансформация, преобразование
 
 Это детекторы верхнего уровня, поэтому вы не можете добавить несколько детекторов в один модификатор |pointerInput|.
  
 Следующий фрагмент обнаруживает только касания, а не перетаскивания.

Внутри метод обнаружения TapGestures блокирует сопрограмму, и второй детектор никогда не достигается. 

Если вам нужно добавить более одного прослушивателя жестов в компонуемый объект, используйте вместо этого отдельные экземпляры модификатора |pointerInput|
                        
           |Обработка событий|
Жесты начинаются с события перемещения указателя вниз. 

Завершение жеста можно определить методом |awaitEachGesture|.
 
Метод |awaitEachGesture| перезапускает содержащий блок, когда все указатели подняты, указывая, что жест завершен.                        

           |Идентифицирование жестов|
Существует набор методов, которые помогают идентифицировать общие части жестов:
                        
|awaitFirstDown| - Приостановите работу до тех пор, пока указатель не опустится

|waitForUpOrCancellation|  - подождите, пока все указатели поднимутся                      

   Ннизкоуровневый прослушиватель перетаскивания

|awaitTouchSlopOrCancellation| - приостанавливается до тех пор, пока указатель не достигнет точки касания 

|awaitDragOrCancellation| - приостанавливается до тех пор, пока не произойдет первое событие перетаскивания

Если только по горизонтали:
|awaitHorizontalTouchSlopOrCancellation|,|awaitHorizontalDragOrCancellation|

Если только по вертикали:
|awaitVerticalTouchSlopOrCancellation|,|awaitVerticalDragOrCancellation|

|awaitLongPressOrCancellation| - Приостановите действие до тех пор, пока не произойдет долгое нажатие                       

Если модификатор |Transformable| или методы обнаружения |TransformGestures| не обеспечивают достаточно детального управления для вашего варианта использования, вы можете прослушивать необработанные события и применять к ним вычисления при помощи методов:
|calculateCentroid|, |calculateCentroidSize|, |calculatePan|, |calculateRotation|, |and calculateZoom|
                        
           |Использование событий|
Если более чем одному составному объекту назначен обработчик жестов, эти обработчики не должны конфликтовать.
                        
Жесты, включенные в готовые компоненты, и общие модификаторы жестов обрабатывают жесты и сообщают родительскому элементу, что на этот жест больше нельзя реагировать.

Если вы пишете свой собственный жест, вам придется обрабатывать события вручную используя метов |PointerInputChange.consume|
                        
           |Распространение событий|
Изменения указателя передаются каждому составному объекту, к которому он попадает.
                        
События указателя проходят через каждый из этих компонуемых объектов в три «прохода»:

1)|Initial pass| : На начальном этапе событие течет от верхней части дерева пользовательского интерфейса к нижней. Этот поток позволяет родителю перехватить событие до того, как дочерний элемент сможет его использовать. 

 Например, всплывающие подсказки должны перехватывать длительное нажатие, а не передавать их своим детям.

2)|Main pass| :  На главном проходе событие течет от конечных узлов дерева пользовательского интерфейса до корня дерева пользовательского интерфейса. 

На этом этапе вы обычно используете жесты и является этапом по умолчанию при прослушивании событий. Обработка жестов на этом проходе означает, что конечные узлы имеют приоритет над своими родительскими узлами, что является наиболее логичным поведением для большинства жестов.


3)|Final pass| :   На последнем проходе событие еще раз передается от вершины дерева пользовательского интерфейса к конечным узлам. Этот поток позволяет элементам, расположенным выше в стеке, реагировать на событие, полученное их родителем. 

  Например, кнопка убирает индикацию пульсации, когда нажатие превращается в перетаскивание ее прокручиваемого родительского элемента.

В коде вы можете указать интересующий вас проход:

           |Обработка нажатий|
Любой компонуемый UI-элемент можно сделать «кликабельным», т.е добавить возможность, при нажатии на него, выполнять определенные Вами действий (аналог кнопки Button).

Для этого используется модификатор |clickable|.

|clickable| существует двух видов:
 - со стандартной визуализацией нажатия, где положение нажатия не имеет значения для обработки этого события.
 
 - с возможностью дополнительного поведения |InteractionSource| и |indication|

|clickable| — это часто используемый модификатор, который заставляет компонуемый элемент реагировать на нажатия или щелчки. 

При использовании кликабельного модификатора |важно| указать метку доступности.

Параметры функции:

|enabled|: указывает, будет ли доступен компонент для нажатия. 

|onClickLabel|: задает метку, с помощью которой можно быстро обратиться к компоненту.

|role|: объект типа Role?, который устанавливает тип визуального элемента.

|onClick|: функция типа () -> Unit, которая обрабатывает нажатие.
           
     
            """.trimIndent(),
            nameFun = "OutSipmleArticle.kt",
            lambdaFun = {
                OutSipmleArticle(
                    sizeFontText = 18,
                    isNormalStyle = true,
                    isColorBackground = false,
                    isColorBorder = true,
                    isShapeLarge = false,
                    isTextCenter = false
                )
            },
            code = """
@Composable
fun OutSipmleArticle(
    title: String = "Адаптация UI/UX для людей с проблемами зрения",
    article: String = ""${'"'}
   Для определения размера шрифта всегда используйте |sp|.
      ...        
               ""${'"'}.trimIndent(),
    sizeFontText: Int = 18,     //: TextUnit = 18.sp
    isNormalStyle: Boolean = true,
    isColorBackground: Boolean = false,
    isColorBorder: Boolean = false,
    isShapeLarge: Boolean = false,
    isTextCenter: Boolean = false,
) {

    val colorBackground = MaterialTheme.colorScheme.tertiaryContainer

    Column(
        Modifier
            .fillMaxSize()
            .background(colorBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text="Маштабирование текста",
            modifier= Modifier
                .padding(8.dp)
                .background(Color.DarkGray),
            fontSize=23.sp,
            fontWeight = FontWeight.Bold,
            color= Color.Green,

            )

        // set scale transformation states
        var scale by remember {
            mutableFloatStateOf(1f)
        }

        val context = LocalContext.current

        val coroutineScope = rememberCoroutineScope()

        val state = rememberTransformableState { zoomChange,
                                                 offsetChange,
                                                 rotationChange ->
            scale = max(
                a = scale * zoomChange,
                b = 0.5f
            )
        }

        val sizeTitle = ((sizeFontText + 2) * scale).sp
        val sizeFirstArticle = ((sizeFontText + 6) * scale).sp
        val sizeArticle = (sizeFontText * scale).sp

        val color = MaterialTheme.colorScheme.outline

        val annotatedString = buildAnnotatedString {

            withStyle(
                style = ParagraphStyle(
                    lineHeight = sizeTitle,
                    textAlign = TextAlign.Center
                )
            ) {
                withStyle(
                    style = SpanStyle(
                        fontSize = sizeTitle,
                        fontWeight = FontWeight.Bold,
                    )
                ) {
                    append(title)
                }

            }

            withStyle(
                style = ParagraphStyle(
                    lineHeight = sizeArticle
                )
            ) {
//Первый символ статьи
                withStyle(
                    style = SpanStyle(
                        color = Color.Red,
                        fontSize = sizeFirstArticle,
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold,
                    )
                ) {
                    append(article[0])
                }

                val remainder = article.substring(1)

//разбивка статьи на фрагменты, разделенные символом "|"
                val messageArrayList = remainder.split("|")

                if (messageArrayList.size < 2) append(remainder)
                else {
                    messageArrayList.forEachIndexed { index, s ->
                        if (index % 2 != 0) {
                            withStyle(
                                style = SpanStyle(
                                    color = color,
                                    fontWeight = FontWeight.Bold,
                                )
                            ) {
                                append(s)
                            }

                        } else {
                            append(s)
                        }
                    }

                }

            }
        }

        Column(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                //прослушивание событий мультитач-преобразования
                .transformable(state = state)
                .verticalScroll(rememberScrollState())
                //двойной щелчок для масштабирования
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            Toast
                                .makeText(
                                    context, "Double click ",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                            if (scale == 1f) {
                                coroutineScope.launch {
                                    state.animateZoomBy(1.5f)
                                }
                            } else {
                                scale = 1f
                            }
                        }
                    )
                }
                .fillMaxSize()
                .border(1.dp, Color.DarkGray),
        ) {
            Text(
                text = annotatedString,
                style = if (isNormalStyle) MaterialTheme.typography.bodyMedium   //labelLarge  bodyLarge
                else MaterialTheme.typography.bodySmall,
                fontSize = sizeArticle,
                color = when {
                    isColorBackground -> MaterialTheme.colorScheme.background  //по умолчанию Color.Unspecified
                    else -> MaterialTheme.colorScheme.onTertiaryContainer
                },
                modifier = Modifier
                    .padding(top = dimensionResource(id = R.dimen.padding_medium))
                    .fillMaxWidth()
                    .alpha(if (isNormalStyle) 1.0f else 0.6f)
                    .clip(
                        shape = when {
                            isShapeLarge -> RoundedCornerShape(dimensionResource(id = R.dimen.roundedCornerCicle))
                            else -> RoundedCornerShape(5.dp)
                        }
                    )
                    .background(
                        color = when {
                            isColorBackground -> MaterialTheme.colorScheme.primary
                            else -> MaterialTheme.colorScheme.tertiaryContainer  //fon
                        }
                    )
                    .border(
                        width = 1.dp,
                        color = when {
                            isColorBorder -> MaterialTheme.colorScheme.primary
                            else -> MaterialTheme.colorScheme.tertiaryContainer  //fon
                        },
                        shape = when {
                            isShapeLarge -> RoundedCornerShape(dimensionResource(id = R.dimen.roundedCornerCicle))
                            else -> RoundedCornerShape(5.dp)
                        }
                    )
                    .padding(all = dimensionResource(id = R.dimen.padding_small)),
                textAlign = if (isTextCenter) {
                    TextAlign.Center
                } else {
                    TextAlign.Left
                }

            )

        }

    }
}
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. Стиль текста",
                    url = "https://developer.android.com/develop/ui/compose/text/style-text?hl=ru"
                ),
                TextClickLink(
                    text = "Больше информации смотрите ",
                    textUrl = "\uD83D\uDCD6 Developers. AnnotatedString",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/AnnotatedString"
                ),
                TextClickLink(
                    text = "Конфигурация стиля абзаца  ",
                    textUrl = "\uD83D\uDCD6 Developers. ParagraphStyle",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/text/ParagraphStyle"
                ),
                TextClickLink(
                    text = "Понимание  жестов  ",
                    textUrl = "Developers. Understand gestures",
                    url="https://developer.android.com/jetpack/compose/touch-input/pointer-input/understand-gestures"
                ),
                TextClickLink(
                    text = "Коснитесь и нажмите  ",
                    textUrl ="Android Developers. Tap and press",
                    url ="https://developer.android.com/jetpack/compose/touch-input/pointer-input/tap-and-press"
                ),
                TextClickLink(
                    text = "Обработка взаимодействия с пользователем   ",
                    textUrl = "Developers. Handling interactions",
                    url="https://developer.android.com/jetpack/compose/touch-input/user-interactions/handling-interactions"
                ),
            ),


            ),



        ExampleCode(
            id = 20,
            title = "AnimatedVisibility",
            comment = """
Анимация появление и исчезновение с помощью |AnimatedVisibility|.

var visible by remember {
    mutableStateOf(true)
}
// Анимированная видимость в конечном итоге удалит элемент из композиции после завершения анимации.
|AnimatedVisibility|(visible) {
    // your composable here
    // ...
}          
      
      
@Composable
public fun ColumnScope.AnimatedVisibility(
    visible: Boolean,
    modifier: Modifier = Modifier,
    |enter|: EnterTransition = |fadeIn|() + expandVertically(),
    |exit|: ExitTransition = |fadeOut|() + shrinkVertically(),
    label: String = "AnimatedVisibility",
    content: @Composable() (AnimatedVisibilityScope.() -> Unit)
): Unit

Переход можно настроить, указав |EnterTransition| и |ExitTransition|

|FadeIn| и |FadeOut| - плавно увеличивает содержимое перехода от указанного начального значения альфы (т. е. initialAlpha) до 1f, используя предоставленный |animationSpec|. 

Значение |initialAlpha| по умолчанию равно |0f|, а значение |spring| используется по умолчанию.

|!fun fadeIn(
    animationSpec: FiniteAnimationSpec<Float> = spring(stiffness = Spring.StiffnessMediumLow),
    initialAlpha: Float = 0.0f
): EnterTransition|              
  
Например:
  enter = fadeIn(
     initialAlpha = 0.3f,
     animationSpec = tween(durationMillis = 2000, easing = LinearOutSlowInEasing)
  )              
              
Функция |tween| имеет три параметра:

    |durationMillis| — продолжительность анимации в миллисекундах;

    |delayMillis| — |задержка| в миллисекундах, которая будет выполняться |до запуска| анимации;

    |easing| — кривая смягчения, по которой будет выполняться анимация.

|Easing| — это характеристика, которая заставляет элементы двигаться так, будто естественные силы, такие как трение, гравитация и масса, работают. 

Easing позволяет анимированным элементам ускоряться и замедляться с разной скоростью.

В Jetpack Compose доступны следующие easing:

 |FastOutSlowInEasing| - быстрое начало медленное завершение

 |LinearOutSlowInEasing| - медленное начало и медленное завершение

 |FastOutLinearInEasing| - медленное начало быстрое завершение

 |LinearEasing| - начало и завершение с ускорением

 |CubicBezierEasing| - позволяет реализовать свою собственную кривую смягчения. Данный easing основан на кривой Безье, которая строится по четырём точкам.


      
      
            """.trimIndent(),
            lambdaFun = {
                var expanded by remember {
                    mutableStateOf(false)
                }
                AnimationVisibilityContent(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            },
            nameFun = "AnimationVisibilityContent.kt",
            code ="""
/*
 
var expanded by remember {
   mutableStateOf(false)
}
AnimationVisibilityContent(
   expanded = expanded,
   onClick = { expanded = !expanded }
)
*/                
@Composable
fun AnimationVisibilityContent ( 
    enter: EnterTransition =  fadeIn() + expandVertically(), 
    exit: ExitTransition = fadeOut() + shrinkVertically(),   
    color: Color = Color.Unspecified,
    expanded: Boolean = false,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Card(
            modifier = Modifier
                .padding(16.dp)
                .aspectRatio(1f), //height = width
            onClick = onClick
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .background(color = color, shape = RoundedCornerShape(20.dp))
                        .padding(8.dp)
                        .weight(1f),
                    painter = painterResource(id = R.drawable.my_cat),
                    contentDescription = "My cat",
                    contentScale = ContentScale.Crop
                )
                AnimatedVisibility(
                    visible = expanded,
                    enter = enter,
                    exit = exit
                ) {
                    Text(
                        text = "Myuka",
                        fontSize = 50.sp,
                        fontFamily = FontFamily.Cursive
                    )
                }
            }
        }

    }

}
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Анимации играют важную роль в современном мобильном приложении, обеспечивая плавный и понятный пользовательский интерфейс.  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animations in Compose",
                    url = "https://developer.android.com/develop/ui/compose/animation/introduction"
                ),
                TextClickLink(
                    text = "Модификаторы анимации и составные элементы  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Composables modifiers",
                    url = "https://developer.android.com/develop/ui/compose/animation/composables-modifiers?hl=ru"
                ),
                TextClickLink(
                    text = "fadeIn  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Composables modifiers",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/animation/package-summary#fadeIn(androidx.compose.animation.core.FiniteAnimationSpec,kotlin.Float)"
                ),

            ),

        ),

        ExampleCode(
            id = 20,
            title = "Animated Slade",
            comment = """
|SladeIn|, |SladeOut| обеспечивает скольжение в контенте перехода от начального смещения, определенного в initialOffset, к IntOffset(0, 0). Направление скольжения можно контролировать, настраивая initialOffset. Положительное значение x означает скольжение справа налево, тогда как отрицательное значение x будет скользить контент вправо. Аналогично положительные и отрицательные значения y соответствуют скольжению вверх и вниз соответственно.

Если скольжение требуется только по горизонтали или вертикали, а не по обеим осям, рассмотрите возможность использования |slideInHorizontally| или |slideInVertically|.

|initialOffset| — это лямбда, которая принимает полный размер контента и возвращает смещение. Это позволяет определить смещение пропорционально полному размеру или как абсолютное значение.
                
|slideInHorizontally| скользит по содержимому по горизонтали, от начального смещения, определенного в |initialOffsetX|, до |0| пикселей. 

Направление скольжения можно контролировать, настраивая |initialOffsetX|. Положительное значение означает скольжение справа налево, тогда как отрицательное значение будет скользить содержимое слева направо.

|initialOffsetX| — это лямбда, которая берет полную ширину содержимого и возвращает смещение. Это позволяет определить начальное смещение пропорционально полному размеру или как абсолютное значение. По умолчанию возвращается половина отрицательной ширины, что смещает содержимое влево на половину его ширины и скользит вправо.

|slideInVertically| скользит по содержимому вертикально, от начального смещения, определенного в initialOffsetY, до 0 в пикселях. Направление скольжения можно контролировать, настраивая initialOffsetY. Положительное начальное смещение означает скольжение вверх, тогда как отрицательное значение будет скользить вниз.

initialOffsetY — это лямбда, которая берет полную высоту содержимого и возвращает смещение. Это позволяет определить начальное смещение пропорционально полной высоте или как абсолютное значение. По умолчанию возвращается половина отрицательной высоты, что смещает содержимое вверх на половину его высоты и скользит вниз.            ""${'"'}.trimIndent(),
                
                
            """.trimIndent(),
            lambdaFun = { AnimationVisibilitySlade() },
            nameFun = "AnimationVisibilitySlade.kt",
            code ="""
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Анимации играют важную роль в современном мобильном приложении, обеспечивая плавный и понятный пользовательский интерфейс.  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animations in Compose",
                    url = "https://developer.android.com/develop/ui/compose/animation/introduction"
                ),
                TextClickLink(
                    text = "Модификаторы анимации и составные элементы  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Composables modifiers",
                    url = "https://developer.android.com/develop/ui/compose/animation/composables-modifiers?hl=ru"
                ),
                TextClickLink(
                    text = "Скольжение ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. slideIn",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/animation/package-summary#slideIn(androidx.compose.animation.core.FiniteAnimationSpec,kotlin.Function1)"
                ),
                TextClickLink(
                    text = "Скольжение по вертикали  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. slideInVertically",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/animation/package-summary#slideInVertically(androidx.compose.animation.core.FiniteAnimationSpec,kotlin.Function1)"
                ),
                TextClickLink(
                    text = "Скольжение по горизонтали  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. slideInHorizontally",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/animation/package-summary#slideInHorizontally(androidx.compose.animation.core.FiniteAnimationSpec,kotlin.Function1)"
                ),

                ),

            ),


        ExampleCode(
            id = 20,
            title = "Animated Scale",
            comment = """
|scaleIn| масштабирует содержимое по мере его появления от начального масштаба (определенного в |initialScale|) до |1f|. 

fun scaleIn(
    |animationSpec|: FiniteAnimationSpec<Float> = spring(stiffness = Spring.StiffnessMediumLow),
    |initialScale|: Float = 0.0f,
    |transformOrigin|: TransformOrigin = TransformOrigin.Center
): EnterTransition
            
|transformOrigin| определяет точку поворота в виде доли от общего размера. TransformOrigin.|Center| по умолчанию. 

|scaleIn| можно использовать в сочетании с любым другим типом |EnterTransition| с использованием оператора плюс (например, scaleIn() + slideInHorizontally())

Примечание: масштаб применяется до слайда. Это означает, что при использовании slideIn/slideOut с scaleIn/scaleOut необходимо учитывать величину масштабирования при скольжении.

Масштабирование изменит визуальное представление содержимого, но не повлияет на размер макета. 

|scaleIn| можно комбинировать с |expandIn|/|expandHorizontally|/|expandVertically| для координации изменения размера макета при масштабировании.            

|scaleOut| масштабирует содержимое выходного перехода от |1f| до целевого масштаба, определенного в |targetScale|. 

|transformOrigin| определяет точку поворота в виде доли от общего размера. По умолчанию это |TransformOrigin.Center|. 

|scaleOut| можно использовать в сочетании с любым другим типом |ExitTransition| с помощью оператора плюс (например, scaleOut() + fadeOut())

Примечание: масштаб применяется до слайда. Это означает, что при использовании |slideIn|/|slideOut| с |scaleIn|/|scaleOut| необходимо учитывать величину масштабирования при скольжении.

Масштабирование изменит визуальное представление содержимого, но не повлияет на размер макета. 

|scaleOut| можно комбинировать с |shrinkOut|/|shrinkHorizontally|/|shrinkVertically| для скоординированной анимации изменения размера макета.

                 """.trimIndent(),
            lambdaFun = { AnimationVisibilityScale(it) },
            nameFun = "AnimationVisibilityScale.kt",
            code ="""
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Анимации играют важную роль в современном мобильном приложении, обеспечивая плавный и понятный пользовательский интерфейс.  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animations in Compose",
                    url = "https://developer.android.com/develop/ui/compose/animation/introduction"
                ),
                TextClickLink(
                    text = "Модификаторы анимации и составные элементы  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Composables modifiers",
                    url = "https://developer.android.com/develop/ui/compose/animation/composables-modifiers?hl=ru"
                ),
                TextClickLink(
                    text = "Маштабирование  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. scaleIn",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/animation/package-summary#scaleIn(androidx.compose.animation.core.FiniteAnimationSpec,kotlin.Float,androidx.compose.ui.graphics.TransformOrigin)"
                ),

                ),

            ),


        ExampleCode(
            title = "Animated Expand",
            comment = """
|expandIn| расширяет границы клипа отображаемого контента от размера |initialSize| до полного размера. 

fun expandIn(
    |animationSpec|: FiniteAnimationSpec<IntSize> = spring(
            stiffness = Spring.StiffnessMediumLow,
            visibilityThreshold = IntSize.VisibilityThreshold
        ),
    |expandFrom|: Alignment = Alignment.BottomEnd,
    |clip|: Boolean = true,
    |initialSize|: (fullSize: IntSize) -> IntSize = { IntSize(0, 0) }
): EnterTransition

|expandFrom| управляет тем, какая часть контента будет показана первой. По умолчанию границы клипа анимируются от |IntSize(0, 0)| до полного размера, начиная с показа нижнего правого угла (или нижнего левого угла в макетах RTL) контента, до полного показа всего контента по мере увеличения размера.

Примечание: |expandIn| анимирует границы контента. Это изменение границ также приведет к анимации других макетов, зависящих от этого размера.

|initialSize| — это лямбда, которая принимает полный размер контента и возвращает начальный размер границ контента. Это допускает не только абсолютный размер, но и начальный размер, пропорциональный размеру контента.

|clip| определяет, следует ли обрезать контент за пределами анимированных границ. По умолчанию |clip| имеет значение |true|, что показывает только контент в анимированных границах.

Для расширения только по горизонтали или вертикали можно использовать |expandHorizontally|, |expandVertically|.
                
            """.trimIndent(),
            lambdaFun = { AnimationVisibilityExpend(it)  },
            nameFun = "AnimationVisibilityExpend.kt",
            code ="""
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Анимации играют важную роль в современном мобильном приложении, обеспечивая плавный и понятный пользовательский интерфейс.  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animations in Compose",
                    url = "https://developer.android.com/develop/ui/compose/animation/introduction"
                ),
                TextClickLink(
                    text = "Модификаторы анимации и составные элементы  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Composables modifiers",
                    url = "https://developer.android.com/develop/ui/compose/animation/composables-modifiers?hl=ru"
                ),
                TextClickLink(
                    text = "Расширение границ  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Expend",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/animation/package-summary#expandIn(androidx.compose.animation.core.FiniteAnimationSpec,androidx.compose.ui.Alignment,kotlin.Boolean,kotlin.Function1)"
                ),

                ),

            ),

        ExampleCode(
            id = 20,
            title = "Animation of a child",
            comment = """
Модификатор |animateEnterExit| может использоваться для любых прямых или косвенных потомков |AnimatedVisibility| для создания анимации входа/выхода, отличной от той, что указана в |AnimatedVisibility|. 

Визуальный эффект этих потомков будет комбинацией анимации |AnimatedVisibility| и их собственных анимаций входа/выхода.
                
            """.trimIndent(),
            lambdaFun = { AnimationChildren(it) },
            nameFun = "AnimationChildren.kt",
            code ="""
@Composable
fun AnimationChildren(
    isScreenExpanded: Boolean = false,
) {
    var visible by remember { mutableStateOf(true) }
    val aspectModifier = if (isScreenExpanded) Modifier.aspectRatio(1.5f)
    else Modifier.aspectRatio(1f)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable { visible = !visible },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Click me...")
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = aspectModifier
                        .animateEnterExit(
                            enter = slideInVertically(),
                            exit = slideOutVertically()
                        )
                        .clip(RoundedCornerShape(10.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bg2),
                        contentDescription = null,
                        modifier = Modifier
                            .alpha(0.9f)
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                    Image(
                        painter = painterResource(id = R.drawable.earth),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(150.dp)
                            .animateEnterExit(
                                enter = scaleIn(
                                    animationSpec = tween(1000, easing = LinearOutSlowInEasing)
                                ) + expandVertically(expandFrom = Alignment.CenterVertically),
                                exit = scaleOut(
                                    animationSpec = tween(1000, easing = LinearOutSlowInEasing)
                                ) + shrinkVertically(shrinkTowards = Alignment.CenterVertically)
                            ),
                        contentScale = ContentScale.Crop,
                    )
                    Box(
                        modifier = aspectModifier,
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Text(
                            text = "Hello, World!",
                            color = Color.Cyan,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier
                                .padding(16.dp)
                                .animateEnterExit(
                                    // Slide in/out the rounded rect
                                    enter = expandIn(
                                        animationSpec = tween(1000, easing = LinearOutSlowInEasing),
                                        expandFrom = Alignment.BottomStart
                                    ) {
                                        IntSize(50, 50) //
                                    },
                                    exit = scaleOut() + shrinkVertically(shrinkTowards = Alignment.CenterVertically)
                                ),
                            fontSize = 45.sp,
                            lineHeight = 45.sp,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily.Cursive,
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
                    text = "Анимации играют важную роль в современном мобильном приложении, обеспечивая плавный и понятный пользовательский интерфейс.  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animations in Compose",
                    url = "https://developer.android.com/develop/ui/compose/animation/introduction"
                ),
                TextClickLink(
                    text = "Модификаторы анимации и составные элементы  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Composables modifiers",
                    url = "https://developer.android.com/develop/ui/compose/animation/composables-modifiers?hl=ru"
                ),
                TextClickLink(
                    text = "Модификатор animateEnterExit ",
                    textUrl = "\uD83D\uDCD6 Developers. animateEnterExit",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/animation/AnimatedVisibilityScope#(androidx.compose.ui.Modifier).animateEnterExit(androidx.compose.animation.EnterTransition,androidx.compose.animation.ExitTransition,kotlin.String)"
                ),
                TextClickLink(
                    text = "Загрузка изображений ",
                    textUrl = "\uD83D\uDCD6 Developers. Graphics. Images. Loading",
                    url = "https://developer.android.com/develop/ui/compose/graphics/images/loading?hl=ru"
                ),
                TextClickLink(
                    text = "Настройка изображения ",
                    textUrl = "\uD83D\uDCD6 Developers. Graphics. Images. Customize",
                    url = "https://developer.android.com/develop/ui/compose/graphics/images/customize?hl=ru"
                ),

                ),

            ),
        ExampleCode(
            title = "Пользовательская анимация",
            comment = """
Через свойство |transition|, внутри лямбда-выражения для |AnimatedVisibility|, можно добавить пользовательские эффекты анимации.
  
var visible by remember { mutableStateOf(true) }

AnimatedVisibility(
    visible = visible,
    enter = fadeIn(),
    exit = fadeOut()
) { 
    val background by transition.animateColor(label = "color") { state ->
        if (state == EnterExitState.Visible) Color.Blue else Color.Gray
    }
    Box(
        modifier = Modifier
            .size(128.dp)
            .background(background)
    )
}                


            """.trimIndent(),
            lambdaFun = { AnimationTransition() },
            nameFun = "AnimationTransition.kt",
            code ="""
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Анимация на основе значений ",
                    textUrl = "\uD83D\uDCD6 Developers.  animate*AsState",
                    url = "https://developer.android.com/develop/ui/compose/animation/value-based?hl=ru#updatetransition"
                ),
                TextClickLink(
                    text = "Анимации играют важную роль в современном мобильном приложении, обеспечивая плавный и понятный пользовательский интерфейс.  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animations in Compose",
                    url = "https://developer.android.com/develop/ui/compose/animation/introduction"
                ),
                TextClickLink(
                    text = "Модификаторы анимации и составные элементы  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Composables modifiers",
                    url = "https://developer.android.com/develop/ui/compose/animation/composables-modifiers?hl=ru"
                ),

                ),

            ),
        ExampleCode(
            title = "AnimatedContent",
            comment = """
|AnimatedContent| анимирует свое содержимое по мере его изменения в зависимости от целевого состояния.
 
 Row {
     var count by remember { mutableIntStateOf(0) }
     Button(onClick = { count++ }) {
         Text("Add")
     }
     AnimatedContent(
         targetState = count,
         label = "animated content"
     ) { targetCount ->
         // Make sure to use `targetCount`, not `count`.
         Text(text = "Count: ${'$'}targetCount")
     }
 }
 
 По умолчанию исходное содержимое исчезает, а затем появляется целевое содержимое (это поведение называется |сквозным исчезновением|). 
 
 Вы можете настроить это поведение анимации, указав объект |ContentTransform| в |transitionSpec|
 
 Вы можете создать |ContentTransform| , объединив |EnterTransition| с |ExitTransition| используя функцию |togetherWith|. 
 
 Вы можете применить |SizeTransform| к |ContentTransform| , присоединив его с помощью функции |using| . 
 
 AnimatedContent(
     targetState = count,
     transitionSpec = {
         if (targetState > initialState) {
             slideInVertically { height -> height } + fadeIn() togetherWith
                 slideOutVertically { height -> -height } + fadeOut()
         } else {
             slideInVertically { height -> -height } + fadeIn() togetherWith
                 slideOutVertically { height -> height } + fadeOut()
         }.using(
             SizeTransform(clip = false)
         )
     }, label = "animated content"
 ) { targetCount ->
     Text(text = "${'$'}targetCount")
 }
 
|EnterTransition| определяет, как должно выглядеть целевое содержимое, а |ExitTransition| определяет, как должно исчезнуть исходное содержимое. 

В дополнение ко всем функциям |EnterTransition| и |ExitTransition| доступным для |AnimatedVisibility| , |AnimatedContent| предлагает |slideIntoContainer| и |slideOutOfContainer| . Это удобные альтернативы |slideInHorizontally|/|Vertically| и |slideOutHorizontally|/|Vertically| , которые вычисляют расстояние слайда на основе размеров исходного содержимого и целевого содержимого содержимого AnimatedContent .

|SizeTransform| определяет, как размер должен анимироваться между исходным и целевым содержимым. При создании анимации у вас есть доступ как к начальному, так и к целевому размеру. 

|SizeTransform| также контролирует, должно ли содержимое обрезаться до размера компонента во время анимации. 
 
var expanded by remember { mutableStateOf(false) }
Surface(
    color = MaterialTheme.colorScheme.primary,
    onClick = { expanded = !expanded }
) {
    AnimatedContent(
        targetState = expanded,
        transitionSpec = {
            fadeIn(animationSpec = tween(150, 150)) togetherWith
                fadeOut(animationSpec = tween(150)) using
                SizeTransform { initialSize, targetSize ->
                    if (targetState) {
                        keyframes {
                            IntSize(targetSize.width, initialSize.height) at 150
                            durationMillis = 300
                        }
                    } else {
                        keyframes {
                            IntSize(initialSize.width, targetSize.height) at 150
                            durationMillis = 300
                        }
                    }
                }
        }, label = "size transform"
    ) { targetExpanded ->
        if (targetExpanded) {
            Expanded()
        } else {
            ContentIcon()
        }
    }
} 
            """.trimIndent(),
            lambdaFun = { AnimationContent() },
            nameFun = "AnimationContent.kt",
            code ="""
            var count by remember { mutableIntStateOf(0) }
            //....
                
            AnimatedContent(
                targetState = count,
                label = "animated content"
            ) { targetCount ->
                // Make sure to use `targetCount`, not `count`.
                Text(text = "${'$'}targetCount")
            }

            AnimatedContent(
                targetState = count,
                transitionSpec = {
            // Сравните входящее число с предыдущим числом.
                    if (targetState > initialState) {
            // Если целевое число больше, оно скользит вверх и постепенно исчезает.
            // в то время как начальное (меньшее) число скользит вверх и исчезает.
                        slideInVertically { height -> height } + fadeIn() togetherWith
                                slideOutVertically { height -> -height } + fadeOut()
                    } else {
            // Если целевое число меньше, оно опускается вниз и постепенно увеличивается.
            // в то время как начальное число скользит вниз и исчезает.
                        slideInVertically { height -> -height } + fadeIn() togetherWith
                                slideOutVertically { height -> height } + fadeOut()
                    }.using(
            // Отключите обрезку, так как плавное появление/исчезновение должно
            // отображаться вне границ.
                        SizeTransform(clip = false)
                    )
                }, label = "animated counter"
            ) { targetCount ->
                Text(text = "${'$'}targetCount")
            }
           
           // ...

           Row(
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.spacedBy(16.dp)
           ) {
               Button(onClick = { count++ }) {
                   Text("Add")
               }
               Button(onClick = { count-- }) {
                   Text("Subb")
               }
           }
           
           // ...            
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Анимация на основе значений ",
                    textUrl = "\uD83D\uDCD6 Developers.  animate*AsState",
                    url = "https://developer.android.com/develop/ui/compose/animation/value-based?hl=ru#updatetransition"
                ),
                TextClickLink(
                    text = "Анимации играют важную роль в современном мобильном приложении, обеспечивая плавный и понятный пользовательский интерфейс.  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animations in Compose",
                    url = "https://developer.android.com/develop/ui/compose/animation/introduction"
                ),
                TextClickLink(
                    text = "Модификаторы анимации и составные элементы  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Composables modifiers",
                    url = "https://developer.android.com/develop/ui/compose/animation/composables-modifiers?hl=ru"
                ),

                ),

            ),

        ExampleCode(
            title = "Animated Crossfade",
            comment = """
|Crossfade| анимирует переход между двумя макетами с помощью анимации плавного перехода. При переключении значения, переданного current параметру, содержимое переключается с помощью плавной анимации.                
            """.trimIndent(),
            lambdaFun = { AnimationCrossfade() },
            code ="""
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Анимация на основе значений ",
                    textUrl = "\uD83D\uDCD6 Developers.  animate*AsState",
                    url = "https://developer.android.com/develop/ui/compose/animation/value-based?hl=ru#updatetransition"
                ),
                TextClickLink(
                    text = "Анимации играют важную роль в современном мобильном приложении, обеспечивая плавный и понятный пользовательский интерфейс.  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animations in Compose",
                    url = "https://developer.android.com/develop/ui/compose/animation/introduction"
                ),
                TextClickLink(
                    text = "Модификаторы анимации и составные элементы  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Composables modifiers",
                    url = "https://developer.android.com/develop/ui/compose/animation/composables-modifiers?hl=ru"
                ),

                ),

            ),
        ExampleCode(
            title = "Анимация размера контента",
            comment = """
Модификатор |animateContentSize| анимирует изменение размера контента.                
            """.trimIndent(),
            nameFun = "AnimationContentSize.kt",
            lambdaFun = { AnimationContentSize() },
            code ="""
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
                    text = ""${'"'}
    Достоинства Jetpack Compose:
    ...
                    ""${'"'}.trimIndent(),
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
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Анимация на основе значений ",
                    textUrl = "\uD83D\uDCD6 Developers.  animate*AsState",
                    url = "https://developer.android.com/develop/ui/compose/animation/value-based?hl=ru#updatetransition"
                ),
                TextClickLink(
                    text = "Анимации играют важную роль в современном мобильном приложении, обеспечивая плавный и понятный пользовательский интерфейс.  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animations in Compose",
                    url = "https://developer.android.com/develop/ui/compose/animation/introduction"
                ),
                TextClickLink(
                    text = "Модификаторы анимации и составные элементы  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Composables modifiers",
                    url = "https://developer.android.com/develop/ui/compose/animation/composables-modifiers?hl=ru"
                ),

                ),

            ),

        ExampleCode(
            title = "Анимация значений",
            comment = """
Функции |animate*AsState| — это простейшие API-интерфейсы анимации в Compose для анимации одного значения. Вы указываете только целевое значение (или конечное значение), и API запускает анимацию от текущего значения до указанного значения.

Не нужно создавать экземпляр какого-либо класса анимации или обрабатывать прерывания. Под капотом объект анимации (а именно, экземпляр Animatable ) будет создан и запомнен в месте вызова с первым целевым значением в качестве начального значения. С этого момента каждый раз, когда вы указываете этому составному элементу другое целевое значение, автоматически запускается анимация для достижения этого значения. Если в полете уже есть анимация, она начинается с текущего значения (и скорости) и анимируется в направлении целевого значения. Во время анимации этот составной объект перекомпоновывается и возвращает обновленное значение анимации каждый кадр.

В стандартной комплектации |Compose| предоставляет функции |animate*AsState| для 
|Float| , |Color| , |Dp| , |Size| , |Offset| , |Rect| , |Int| , |IntOffset| и |IntSize| . 

Вы можете легко добавить поддержку других типов данных, предоставив |TwoWayConverter| для |animateValueAsState| , который принимает универсальный тип.

Вы можете настроить характеристики анимации, предоставив |AnimationSpec|.
                
            """.trimIndent(),
            nameFun = "Animation_AsState.kt",
            lambdaFun = { Animation_AsState() },
            code = """
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
                    text = ""${'"'}
 Функции animate*AsState ... 
                    ""${'"'}.trimIndent(),
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
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Анимация на основе значений  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Value",
                    url = "https://developer.android.com/develop/ui/compose/animation/value-based?hl=ru"
                ),
                TextClickLink(
                    text = "Анимация с помощью параметра AnimationSpec  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Customize",
                    url = "https://developer.android.com/develop/ui/compose/animation/customize?hl=ru#animationspec"
                ),
                TextClickLink(
                    text = "Анимации в Compose",
                    textUrl = "\uD83D\uDCD6 Animations in Compose ",
                    url = "https://developer.android.com/develop/ui/compose/animation/introduction"
                ),
            ),

        ),

        ExampleCode(
            title = "Повторение анимации",
            comment = """
|repeatable| многократно запускает анимацию на основе продолжительности (например, tween или keyframes ), пока не достигнет указанного количества итераций. 

Вы можете передать параметр |repeatMode| , чтобы указать, должна ли анимация повторяться, начиная с начала ( RepeatMode.|Restart| ) или с конца ( RepeatMode.|Reverse| )

            """.trimIndent(),
            nameFun = "Animation_AsStateRepeatable.kt",
            lambdaFun = { Animation_AsStateRepeatable() },
            code = """
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Анимация на основе значений  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Value",
                    url = "https://developer.android.com/develop/ui/compose/animation/value-based?hl=ru"
                ),
                TextClickLink(
                    text = "Анимация с помощью параметра AnimationSpec  ",
                    textUrl = "\uD83D\uDCD6 Developers. Animation. Customize",
                    url = "https://developer.android.com/develop/ui/compose/animation/customize?hl=ru#animationspec"
                ),
                TextClickLink(
                    text = "Анимации в Compose",
                    textUrl = "\uD83D\uDCD6 Animations in Compose ",
                    url = "https://developer.android.com/develop/ui/compose/animation/introduction"
                ),
            ),

            ),
        ExampleCode(
            title = "Бесконечная анимация",
            comment = """
Экземпляр |InfiniteTransition| создает бесконечно повторяющуюся анимацию. Используется для управления дочерними анимациями.

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
            nameFun = "AnimationInfiniteTransition.kt",
            code = """
@Composable
fun AnimationInfiniteTransition(
    text: String ="Ш Б",
){

    // Создает экземпляр [InfiniteTransition] для управления дочерними анимациями
    val infiniteTransition = rememberInfiniteTransition()

    // Создает дочернюю анимацию типа float
    val size by
    infiniteTransition.animateFloat(
        initialValue = 10f,
        targetValue = 170f,
        animationSpec =
        infiniteRepeatable(
    // Бесконечное повторение анимации 
            animation = tween(20000, easing = LinearEasing),
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

            ),

        ExampleCode(
            title = "Рисование текста на холсте",
            comment = """
Функция |Canvas| позволяет рисовать фигуры на холсте приложения.

|!@Composable
public fun Canvas(
    modifier: Modifier, 
    onDraw: DrawScope.() -> Unit
): Unit|
                
Нарисовать текст можно с DrawScope.|drawText|(). Для этого необходимо создать |TextMeasurer| с помощью |rememberTextMeasurer| и вызвать |drawText|
                 
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
                TextClickLink(
                    text = "Как получить высоту или ширину элемента в Jetpack Compose ",
                    textUrl = "\uD83D\uDCD6 Medium. How to get the Height or Width of an Element in Jetpack Compose",
                    url = "https://medium.com/@vontonnie/how-to-get-the-height-or-width-of-an-element-in-jetpack-compose-8af04365d555"
                ),
                TextClickLink(
                    text = "Работа с изображениями ",
                    textUrl = "\uD83D\uDCD6 Developers. Android. Graphics. images...",
                    url = "https://developer.android.com/develop/ui/compose/graphics/images?hl=ru"
                ),
            ),

            nameFun = "DrawTextCanvas.kt",
            lambdaFun = { DrawTextCanvas() },
            code = """
@Composable
fun DrawTextCanvas(
    textTitle: String = "You have a letter!",
    textMessage: String = "Happy Birthday to You!",
) {
    var isOpen by remember {
        mutableStateOf(false)
    }


    val styleCenter = TextStyle(
        color = Color.White,
        fontSize = 30.sp,
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline
    )

    val styleMessage = TextStyle(
        color = Color.Yellow,
        fontSize = 24.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
    )

    val corner = 8.dp


// get local density from composable
    val density = LocalDensity.current

//initial height set at 100
    var boxHeight by remember { mutableStateOf(100.dp) }
//initial width set at 100
    var boxWidth by remember { mutableStateOf(100.dp) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned {
                boxHeight = with(density) {
                    it.size.height.toDp()
                }
                boxWidth = with(density) {
                    it.size.width.toDp()
                }
            }
            .padding(8.dp)
            .graphicsLayer {
                shadowElevation = corner.toPx()
                shape = RoundedCornerShape(corner)
                clip = true //!!! обрезание всего, что вне формы
            }
            .background(color = Color.Black)
            .drawBehind {
//рисует границы прямоугольника с закруглёнными углами
                drawRoundRect(
                    color = Color.Cyan,
                    cornerRadius = CornerRadius(corner.toPx()),
                    style = Stroke(
                        width = 4.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
                    )
                )

            }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ){
        var ratio = 1f

        val maxBias = if (boxHeight>boxWidth) boxWidth/2
        else {
            ratio = 1.2f
            boxHeight/2
        }

        val bias: Dp by animateDpAsState(
            targetValue = if (isOpen) maxBias - 10.dp else 0.dp,
            animationSpec = tween(durationMillis = 800, easing = FastOutSlowInEasing),
            label = "bias"
        )

        val modifier = Modifier
            .aspectRatio(ratio)
            .padding(16.dp)
            .background(color = Color.Black)


        Crossfade(
            targetState = isOpen,
            label = "cross fade"
        ) { state ->
            when (state) {
                true -> DrawOnCanvas(modifier,textMessage,styleMessage,{isOpen = !isOpen},bias,state)
                else -> DrawOnCanvas(modifier,textTitle,styleCenter,{isOpen = !isOpen},bias,state)
            }
        }

        val enter = slideInVertically(animationSpec = tween(durationMillis = 2000)) { fullWidth ->
            -fullWidth / 3
        } + fadeIn(animationSpec = tween(durationMillis = 2000))

        val exit = slideOutVertically() + shrinkVertically() + fadeOut() + scaleOut(targetScale = 1.2f)

        val borderWidth = 4.dp

        AnimatedVisibility(
            visible = isOpen,
            enter = enter,
            exit = exit,
        ) {
        Image(
            painter = painterResource(id = R.drawable.kotik2),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            alignment = Alignment.BottomCenter,
            modifier = Modifier
                .widthIn(max = maxBias)
                .border(
                    BorderStroke(borderWidth, Color.Green),
                    RoundedCornerShape(16.dp)
                )
                .background(Color.Yellow)
                .clip(RoundedCornerShape(16.dp))        )
    }


    }



}


@Composable
fun DrawOnCanvas(
    modifier:Modifier = Modifier,
    text:String = "",
    style:TextStyle = TextStyle.Default,
    onClick: () -> Unit = {},
    bias:Dp = 100.dp,
    state:Boolean = false
){
    val textMeasurer = rememberTextMeasurer()

    val textLayoutCenter = remember(text) {
        textMeasurer.measure(text, style)
    }

    Canvas(
        modifier = modifier
            .clickable { onClick() }
    ) {

        fun drawMyLine(
            start: Offset = Offset(0f,0f),
            end: Offset = Offset(0f,0f),
            color: Color = Color.Yellow,
            strokeWidth:Float = 10f,
            intervals:Float = 10f,
            phase:Float = 10f,
        ){
            drawLine(
                start = start,
                end = end,
                color = color,
                strokeWidth = strokeWidth,
                pathEffect = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(
                        intervals.dp.toPx(),
                        intervals.dp.toPx()
                    ),
                    phase = phase.dp.toPx()
                )
            )
        }


        drawRoundRect(
            color = Color.Green,
            size = size,
            style = Stroke(
                width = 2f.dp.toPx(),
//пунктирная линия
                pathEffect = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(
                        10f.dp.toPx(),
                        10f.dp.toPx()
                    ),
                    phase = 0f
                )
            ),
//закругление углов
            cornerRadius = CornerRadius(
                x = 30.dp.toPx(),
                y = 30.dp.toPx()
            )
        )
        
        val direct = if (state) -1.5f
        else 1f
        
//размещение по центру
        drawText(
            textMeasurer = textMeasurer,
            text = text,
            style = style,
            topLeft = Offset(
                x = center.x - textLayoutCenter.size.width / 2,
                y = center.y - (40*direct).dp.toPx() - textLayoutCenter.size.height / 2,
            ),
        )

        //Перенос системы координат в позицию (offsetX,offsetY)
        inset(
            10.dp.toPx()
        ) {
            //Размер области DrawScope автоматически
            //уменьшается по горизонтали и по вертикали

            inset(
                left = 0f,
                top = size.height / 2,
                right = 0f,
                bottom = 0f
            ) {
//рисуем прямоугольник по краям
//всей области DrawScope
                drawRect(
                    color = Color.Cyan,
                    size = size,
                    style = Stroke(
                        width = 2f.dp.toPx(),
                    )
                )

                val point1 = Offset(x = 0f, y = 0f)
                
                val point2 = Offset(
                    x = size.width/2,
                    y = size.height/2 - bias.toPx()
                )

                drawMyLine(
                    start = point1,
                    end =  point2,
                    color = Color.Cyan,
                    intervals = 5f
                )

                val point3 = Offset(
                    x = size.width,
                    y = 0f
                )

                drawMyLine(
                    start = point2,
                    end =  point3,
                    color = Color.Cyan,
                    intervals = 5f
                )

            }

        }

    }

}
                
            """.trimIndent()
        ),

        ExampleCode(
            id = 3,
            title = "Индикатор выполнения",
            comment = """
В этом примере |IndicatorArc| — это composable, который принимает значение прогресса выполнения от 0 до 100 и рисует круговой индикатор выполнения. 

Значение прогресса от 0 до 100%
                
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
                    text = "androidx. compose. ui. graphics. drawscope ",
                    textUrl = "\uD83D\uDCD6 Developers graphics drawscope",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/drawscope/package-summary"
                ),
            ),

            lambdaFun = { CircularIndicator(it) },
            nameFun = "CircularIndicator.kt",
            code = """
@Composable
fun CircularIndicator(
    isExpanded: Boolean = false,
    progress: String = "%"
) {
    val sliderPosition = remember {
        mutableFloatStateOf(30f)
    }

    if (isExpanded) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IndicatorArc(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxHeight()
                    .weight(1f),
                sliderPosition = sliderPosition.floatValue
            )
            Column(
                modifier = Modifier.weight(0.7f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                SliderSimple(progress, sliderPosition, 0f, 100f)
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            IndicatorArc(
                modifier = Modifier
                    .padding(16.dp)
                    .aspectRatio(1f),
//                    .fillMaxWidth()
//                    .weight(1f),
                sliderPosition = sliderPosition.floatValue
            )
            SliderSimple(progress, sliderPosition, 0f, 100f)

        }

    }


}



@Composable
private fun IndicatorArc(
    modifier: Modifier = Modifier,
    sliderPosition: Float = 50f,
    background:Color = MaterialTheme.colorScheme.tertiaryContainer,
    circleColor:Color = MaterialTheme.colorScheme.onPrimaryContainer,
    arcColor:Color = MaterialTheme.colorScheme.primary,
    thickness: Dp = 8.dp,
    style: TextStyle = TextStyle(
        //LocalTextStyle.current,
        textAlign = TextAlign.Center,
        fontFamily = Alice,
        fontSize = 55.sp,
        color = MaterialTheme.colorScheme.onTertiaryContainer,
    )

) {
    val startAngle = 270f
    val sweepAngle = 360 * sliderPosition / 100

    val textPosition = sliderPosition.toInt().toString() + "%"

    val textMeasurer = rememberTextMeasurer()
    val textLayoutResult = remember(textPosition) {
        textMeasurer.measure(textPosition, style)
    }

    Canvas(
        modifier = modifier.background(background)
    ) {
/*
        val widthIndicator = if (size.width < size.height)
            size.width - 16.dp.toPx()
        else size.height - 16.dp.toPx()


 */
        val widthIndicator = size.minDimension - 16.dp.toPx()

        drawCircle(
            color = circleColor,
            center = center,
            radius = widthIndicator / 2,
            style = Stroke(width = 2.dp.toPx())
        )

        drawArc(
            color = arcColor,
            startAngle = startAngle,
            sweepAngle = sweepAngle,
            style = Stroke(
                width = thickness.toPx(),
                cap = StrokeCap.Round,
            ),
            useCenter = false,
            topLeft = Offset(
                (size.width - widthIndicator) / 2,
                (size.height - widthIndicator) / 2
            ),
            size = Size(
                widthIndicator, widthIndicator
            )
        )

        //размещение текста по цетру
        drawText(
            textMeasurer = textMeasurer,
            text = textPosition,
            style = style,
            topLeft = Offset(
                x = center.x - textLayoutResult.size.width / 2,
                y = center.y - textLayoutResult.size.height / 2,
            ),
        )


    }
}
                
            """.trimIndent()
        ),
        ExampleCode(
            id = 3,
            title = "Круговая диаграмма",
            comment = """
В этом примере |PieChart| — это composable, который принимает коллекцию закусок с показателями продажи и рисует круговую диаграмму. 
                
Круговая диаграмма используются для визуализации данных. Она проста в построении, понятна и смотрятся эффектно.

Круговая диаграмма применяется для отражения структуры или доли показателя.

Доли сравниваются по отношению к целому.
                 
Сумма долей в круговой диаграмме не должна быть больше или меньше 100%. 
                
Круговая диаграмма должна состоять не более чем из 3‒5 долей.
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Графика в Compose ",
                    textUrl = "\uD83D\uDCD6 Отображать текст",
                    url = "https://developer.android.com/develop/ui/compose/graphics/draw/overview?hl=ru"
                ),
                TextClickLink(
                    text = "Что стоит учесть при построении круговых диаграмм",
                    textUrl = "\uD83D\uDCD6 Netology.ru ",
                    url = "https://netology.ru/blog/03-2021-krugovye-diagrammy"
                ),
                TextClickLink(
                    text = "androidx. compose. ui. graphics. drawscope ",
                    textUrl = "\uD83D\uDCD6 Developers graphics drawscope",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/drawscope/package-summary"
                ),
            ),

            lambdaFun = { PieChart(it) },
            nameFun = "PieChart.kt",
            code = """
@Composable
fun PieChart(
    isExpanded: Boolean = false,
    listArc: List<ItemArc> = DataItemArc.listArc,
    textStyle: TextStyle = TextStyle(
        textAlign = TextAlign.Center,
        fontSize = 25.sp,
        color = Color.Cyan,
    )
) {

    if (isExpanded) {
        Column(
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Продажи легких закусок",
                modifier = Modifier
                    .padding(top = 16.dp),
                style = textStyle,
                textAlign = TextAlign.Center
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ChartArc(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    title = "",
                    stylePercent = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = Alice,
                        color = Color.White,
                    ),
                    listArc = listArc,

                    )
                ListLegend(
                    listArc = listArc,
                    modifier = Modifier
                        .weight(0.7f)
                        .verticalScroll(rememberScrollState()),

                    )

            }

        }


    } else {
        Column(
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Продажи легких закусок",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                style = textStyle,
                textAlign = TextAlign.Center
            )
            ChartArc(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                title = "",
                stylePercent = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = Alice,
                    color = Color.White,
                ),
                listArc = listArc,
            )

            ListLegend(
                listArc = listArc,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .verticalScroll(rememberScrollState()),

            )


        }

    }


}
                
            """.trimIndent()
        ),
        ExampleCode(
            title = "Стрелочный индикатор 1",
            comment = """
Пример стрелочного индикатора                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Графика в Compose ",
                    textUrl = "\uD83D\uDCD6 Отображать текст",
                    url = "https://developer.android.com/develop/ui/compose/graphics/draw/overview?hl=ru"
                ),
                TextClickLink(
                    text = "Что стоит учесть при построении круговых диаграмм",
                    textUrl = "\uD83D\uDCD6 Netology.ru ",
                    url = "https://netology.ru/blog/03-2021-krugovye-diagrammy"
                ),
                TextClickLink(
                    text = "androidx. compose. ui. graphics. drawscope ",
                    textUrl = "\uD83D\uDCD6 Developers graphics drawscope",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/drawscope/package-summary"
                ),
            ),

            lambdaFun = { ArrowIndicator(it) },
            nameFun = "ArrowIndicator(.kt",
            code = """
@Composable
fun ArrowIndicator(
    isExpanded: Boolean = false,
    progress: String = "mA",
    mivValue:Float = 0f,
    maxValue:Float = 1200f
) {
    val sliderPosition = remember {
        mutableFloatStateOf(500f)
    }

    if (isExpanded) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IndicatorArc(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxHeight()
                    .weight(1f),
                value = sliderPosition.floatValue
            )
            Column(
                modifier = Modifier.weight(0.7f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                SliderSimple(progress, sliderPosition, mivValue, maxValue)
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            IndicatorArc(
                modifier = Modifier
                    .padding(16.dp)
                    .aspectRatio(1f),
//                    .fillMaxWidth()
//                    .weight(1f),
                value = sliderPosition.floatValue,
                minValue = mivValue,
                maxValue = maxValue,
            )
            SliderSimple(progress, sliderPosition, mivValue, maxValue)
        }
    }
}

@Composable
private fun IndicatorArc(
    modifier: Modifier = Modifier,
    value: Float = 600f,
    minValue: Float = 0f,
    maxValue: Float = 1200f,
    startAngle:Float = 45f,
    sweepAngle:Float = -180f - 2 * startAngle,
    indentDp:Int = 16,
    strokeWidth:Float = 15f, //Ширина стрелки
    quantity:Int = 6,    //кол-во сегментов
    background: Color = MaterialTheme.colorScheme.tertiaryContainer,
    colorArrow: Color = MaterialTheme.colorScheme.onTertiaryContainer,
    arcColor: Color = MaterialTheme.colorScheme.primary,
    thickness: Dp = 8.dp,
    unitOfMeasurement: String  = "mA",
    styleUnitOfMeasurement: TextStyle = TextStyle(
        //LocalTextStyle.current,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontFamily = Alice,
        fontSize = 40.sp,
        color = MaterialTheme.colorScheme.onTertiaryContainer,
    ),
    styleScaleValues: TextStyle = TextStyle(
        textAlign = TextAlign.Center,
        fontSize = 35.sp,
        color = MaterialTheme.colorScheme.onTertiaryContainer,
    ),
    styleRealValue: TextStyle = TextStyle(
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.SansSerif,
        fontSize = 45.sp,
        color = MaterialTheme.colorScheme.secondary,
    )

) {

    val textPosition = unitOfMeasurement //sliderPosition.toInt().toString()

    val textMeasurer = rememberTextMeasurer()

    val textLayoutResult = remember(textPosition) {
        textMeasurer.measure(textPosition, styleUnitOfMeasurement)
    }

    //Контроль на корректность выводимого значения
    val delta = 0.02f * maxValue
    val outValue = if (value > maxValue) maxValue + delta
    else if (value < minValue) minValue - delta
    else value


    Canvas(
        modifier = modifier.background(background)
    ) {
        // ширина индикатора
        val widthIndicator = size.minDimension - 16.dp.toPx()
        val radius = widthIndicator/2
        val minAngle = sweepAngle + startAngle
        val maxAngle = startAngle

        //каркас индикатора
        drawArc(
            color = arcColor,
            startAngle = startAngle,
            sweepAngle = sweepAngle,
            style = Stroke(
                width = thickness.toPx(),
                cap = StrokeCap.Round,
            ),
            useCenter = false,
            topLeft = Offset(
                (size.width - widthIndicator) / 2,
                (size.height - widthIndicator) / 2
            ),
            size = Size(
                widthIndicator, widthIndicator
            )
        )

        //рисуем деления индикатора со значениями
        writeDivisionsIndicator(
            textMeasurer = textMeasurer,
            drawScope = this,
            color = colorArrow,
            radius = radius,
            minAngle = minAngle,
            maxAngle = maxAngle,
            minValue = minValue,
            maxValue = maxValue,
            quantity = quantity,
            widthDp = if (indentDp>2) indentDp-2 else 2,
            strokeWidth = if (strokeWidth>2f) strokeWidth/2 else 2f,
            isOutValue = true,
            style = styleScaleValues,
            indentTextDp = 60

        )

        //рисуем деления с меньшим шагом
        writeDivisionsIndicator(
            textMeasurer = textMeasurer,
            drawScope = this,
            color = colorArrow,
            radius = radius,
            minAngle = minAngle,
            maxAngle = maxAngle,
            minValue = minValue,
            maxValue = maxValue,
            quantity = quantity*2,
            widthDp = indentDp/2,
            strokeWidth = if (strokeWidth>2f) strokeWidth/2 else 2f,
            isOutValue = false,
            style = styleScaleValues

        )

        //рисуем стрелку индикатора
        writeIndicatorArrow(
            this,
            colorArrow,
            radius,
            sweepAngle + startAngle,
            startAngle,
            minValue,
            maxValue,
            outValue,
            indentDp,
            strokeWidth
        )

        //размещение текста по цетру

        drawText(
            textMeasurer = textMeasurer,
            text = textPosition,
            style = styleUnitOfMeasurement,
            topLeft = Offset(
                x = center.x - textLayoutResult.size.width / 2,
                y = center.y +  20.dp.toPx() ,
            ),
        )

        val textValue = "${'$'}{value.toInt()} (${'$'}unitOfMeasurement)"

        val valueLayout = textMeasurer.measure(textValue,styleRealValue)
        drawText(
            textMeasurer = textMeasurer,
            text = textValue,
            style = styleRealValue,
            topLeft = Offset(
                x = center.x - valueLayout.size.width / 2,
                y = size.height - valueLayout.size.height ,
            ),
        )


        writePointInCenter(this,colorArrow)


    }


}

private fun writeTexttoCanvas(
    textMeasurer: TextMeasurer,
    drawScope: DrawScope,
    outValue: String,
    style: TextStyle,
    x: Float,
    y: Float,

    ) {
    val textLayout = textMeasurer.measure(outValue, style)
    with(drawScope) {
        drawText(
            textMeasurer = textMeasurer,
            text = outValue,
            style = style,
            topLeft = Offset(
                x = x - textLayout.size.width / 2,
                y = y - textLayout.size.height / 2,
            ),
        )

    }
}


//Стрелка индикатора
private fun writeIndicatorArrow(
    drawScope : DrawScope,
    color:Color,
    radius:Float,
    minAngle:Float, //угол при min value
    maxAngle:Float, //угол при max value
    minValue:Float,
    maxValue:Float,
    realValue:Float,    //real value
    indentDp:Int,
    strokeWidth:Float
    ) {
    with(drawScope) {
        //центр индикатора (окружности)
        val x0 = center.x
        val y0 = center.y

        val degrees = valueIntoDegrees(minValue,maxValue,minAngle,maxAngle,realValue)
        val angle = degreesToRadians(degrees)
        val x1 = getPointX(radius - indentDp.dp.toPx(),x0,angle)
        val y1 = getPointY(radius - indentDp.dp.toPx(),y0,angle)
        //рисуем линию
        drawLine(
            start = Offset(x = x0, y = y0),
            end = Offset(x = x1, y = y1),
            strokeWidth = strokeWidth,
            color = color
        )

    }
}

//Центр индикатора
private fun writePointInCenter(drawScope : DrawScope, color:Color){
    with(drawScope){
        drawPoints(
            points = listOf(
                Offset(center.x, center.y),
            ),
            pointMode = PointMode.Points,
            cap = StrokeCap.Round,
            color = color,
            strokeWidth = 30.dp.toPx()
        )

    }
}

//Деления и значения циферблата
private fun writeDivisionsIndicator(
    textMeasurer:TextMeasurer,
    drawScope : DrawScope,
    color:Color,
    radius:Float,
    minAngle:Float, //угол при min value
    maxAngle:Float, //угол при max value
    minValue:Float,
    maxValue:Float,
    quantity:Int,    //кол-во сегментов
    widthDp:Int,
    strokeWidth:Float,
    isOutValue:Boolean,
    style: TextStyle,
    indentTextDp:Int = 50,
) {
    with(drawScope) {
//центр индикатора (окружности)
        val x0 = center.x
        val y0 = center.y

//приращение величины
        val increment = (maxValue - minValue) / quantity

        for (i in 0..quantity){
            val value = minValue + i * increment

            val degrees = valueIntoDegrees(minValue,maxValue,minAngle,maxAngle,value)
            val angle = degreesToRadians(degrees)
            val x1 = getPointX(radius,x0,angle)
            val y1 = getPointY(radius,y0,angle)
            val x2 = getPointX(radius - widthDp.dp.toPx(),x0,angle)
            val y2 = getPointY(radius - widthDp.dp.toPx(),y0,angle)
            //рисуем линию
            drawLine(
                start = Offset(x = x1, y = y1),
                end = Offset(x = x2, y = y2),
                strokeWidth = strokeWidth,
                color = color
            )

            if (isOutValue){
                val xx = getPointX(radius - indentTextDp.dp.toPx(),x0,angle)
                val yy = getPointY(radius - indentTextDp.dp.toPx(),y0,angle)
                writeTexttoCanvas(textMeasurer,drawScope,value.toInt().toString(),style,xx,yy)

            }


        }
    }
}


//пересчет величины в угол(в градусах)
//используем уровнение прямой, проходящей через две точки (x1,y1) (x2,y2)
private fun valueIntoDegrees(
    x1:Float = 0f,        //0 mA     min value
    x2:Float = 1200f,     //1200 mA  max value
    y1:Float = -225f,     //угол при min -225°
    y2:Float = 45f,       //угол при max  45°
    x:Float = 0f,  //физическая лтображаемая величина
):Float = y1 + (y2-y1)/(x2-x1)*(x - x1)

//пересчет градусов в радианы
private fun degreesToRadians(degrees:Float = 0f):Double = degrees * Math.PI / 180

//определение координаты точки Х на окружности с радиусом R с цетром в точке х0
private fun getPointX(
    r:Float = 100f,       //radius
    x0:Float = 0f,        //center
    angle:Double = 100.0, //angle in radians
):Float = (x0 + r * cos(angle)).toFloat()

//определение координаты точки Х на окружности с радиусом R с цетром в точке х0
private fun getPointY(
    r:Float = 100f,       //radius
    y0:Float = 0f,        //center
    angle:Double = 100.0, //angle in radians
):Float = (y0 + r * sin(angle)).toFloat()

                
            """.trimIndent()
        ),

        ExampleCode(
            title = "Стрелочный индикатор 2",
            comment = """
Другой вариант примера стрелочного индикатора                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Графика в Compose ",
                    textUrl = "\uD83D\uDCD6 Отображать текст",
                    url = "https://developer.android.com/develop/ui/compose/graphics/draw/overview?hl=ru"
                ),
                TextClickLink(
                    text = "Что стоит учесть при построении круговых диаграмм",
                    textUrl = "\uD83D\uDCD6 Netology.ru ",
                    url = "https://netology.ru/blog/03-2021-krugovye-diagrammy"
                ),
                TextClickLink(
                    text = "androidx. compose. ui. graphics. drawscope ",
                    textUrl = "\uD83D\uDCD6 Developers graphics drawscope",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/drawscope/package-summary"
                ),
            ),

            lambdaFun = { ArrowNewIndicator(it) },
            nameFun = "ArrowNewIndicator.kt",
            code = """
@Composable
private fun IndicatorArc(
    modifier: Modifier = Modifier,
    value: Float = 60f,
    minValue: Float = 0f,
    maxValue: Float = 100f,
    alarmValue: Float = 85f,
    startAngle:Float = 45f,
    sweepAngle:Float = -180f - 2 * startAngle,
    indentDp:Int = 16,
    strokeWidth:Float = 15f, //Ширина стрелки
    quantity:Int = 5,    //кол-во сегментов
    background: Color = MaterialTheme.colorScheme.tertiaryContainer,
    colorArrow: Color = MaterialTheme.colorScheme.onTertiaryContainer,
    arcColor: Color = MaterialTheme.colorScheme.primary,
    bgColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    alarmColor: Color = MaterialTheme.colorScheme.error,
    thickness: Dp = 8.dp,
    unitOfMeasurement: String  = "kV",
    styleUnitOfMeasurement: TextStyle = TextStyle(
        //LocalTextStyle.current,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontFamily = Alice,
        fontSize = 40.sp,
        color = MaterialTheme.colorScheme.onTertiaryContainer,
    ),
    styleScaleValues: TextStyle = TextStyle(
        textAlign = TextAlign.Center,
        fontSize = 35.sp,
        color = MaterialTheme.colorScheme.onTertiaryContainer,
    ),
    styleRealValue: TextStyle = TextStyle(
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.SansSerif,
        fontSize = 45.sp,
        color = MaterialTheme.colorScheme.secondary,
    )

) {

    val textPosition = unitOfMeasurement //sliderPosition.toInt().toString()

    val textMeasurer = rememberTextMeasurer()

    val textLayoutResult = remember(textPosition) {
        textMeasurer.measure(textPosition, styleUnitOfMeasurement)
    }

    //Контроль на корректность выводимого значения
    val delta = 0.02f * maxValue
    val outValue = if (value > maxValue) maxValue + delta
    else if (value < minValue) minValue - delta
    else value


    Canvas(
        modifier = modifier.background(background)
    ) {
        // ширина индикатора
        val widthIndicator = size.minDimension - 16.dp.toPx()
        val radius = widthIndicator/2
        val minAngle = sweepAngle + startAngle
        val maxAngle = startAngle

        val widthBorder = 3f
        val widthBg = 30f
        val widthFrame = 150f
        val alarmAngle = sweepAngle - sweepAngle * alarmValue/maxValue

        //каркас индикатора
        writeFrame(this,bgColor,startAngle,sweepAngle,widthBg + 2*widthBorder,widthIndicator - widthFrame/2)
        writeFrame(this,alarmColor,startAngle,alarmAngle,widthBg + 2*widthBorder,widthIndicator - widthFrame/2)
        writeFrame(this,arcColor,startAngle,sweepAngle,widthBorder,widthIndicator)
        writeFrame(this,arcColor,startAngle,sweepAngle,widthBorder,widthIndicator-widthFrame)

        //рисуем деления индикатора со значениями
        writeDivisionsIndicator(
            textMeasurer = textMeasurer,
            drawScope = this,
            color = colorArrow,
            radius = radius,
            minAngle = minAngle,
            maxAngle = maxAngle,
            minValue = minValue,
            maxValue = maxValue,
            quantity = quantity,
            widthDp = widthBg.toInt()+8,
            strokeWidth = if (strokeWidth>2f) strokeWidth/2 else 2f,
            isOutValue = true,
            style = styleScaleValues,
            indentTextDp = 60

        )

        //рисуем деления с меньшим шагом
        writeDivisionsIndicator(
            textMeasurer = textMeasurer,
            drawScope = this,
            color = colorArrow,
            radius = radius,
            minAngle = minAngle,
            maxAngle = maxAngle,
            minValue = minValue,
            maxValue = maxValue,
            quantity = quantity*2,
            widthDp = widthBg.toInt(),
            strokeWidth = if (strokeWidth>2f) strokeWidth/2 else 2f,
            isOutValue = false,
            style = styleScaleValues

        )

        //рисуем стрелку индикатора
        writeIndicatorArrow(
            this,
            colorArrow,
            radius,
            sweepAngle + startAngle,
            startAngle,
            minValue,
            maxValue,
            outValue,
            indentDp,
            strokeWidth
        )

        //размещение текста по цетру
        drawText(
            textMeasurer = textMeasurer,
            text = textPosition,
            style = styleUnitOfMeasurement,
            topLeft = Offset(
                x = center.x - textLayoutResult.size.width / 2,
                y = center.y +  20.dp.toPx() ,
            ),
        )

        val textValue = "${'$'}{value.toInt()} (${'$'}unitOfMeasurement)"

        val valueLayout = textMeasurer.measure(textValue,styleRealValue)
        drawText(
            textMeasurer = textMeasurer,
            text = textValue,
            style = styleRealValue,
            topLeft = Offset(
                x = center.x - valueLayout.size.width / 2,
                y = size.height - valueLayout.size.height ,
            ),
        )

        writePointInCenter(this,colorArrow)

    }

}

private fun writeFrame(
    drawScope : DrawScope,
    color: Color,
    startAngle:Float,
    sweepAngle:Float,
    widthBg:Float,
    widthIndicator:Float
) {
    with(drawScope) {
        drawArc(
            color = color,
            startAngle = startAngle,
            sweepAngle = sweepAngle,
            style = Stroke(
                width = widthBg.dp.toPx(),
//                cap = StrokeCap.Round,
            ),
            useCenter = false,
            topLeft = Offset(
                (size.width - widthIndicator) / 2,
                (size.height - widthIndicator) / 2
            ),
            size = Size(
                widthIndicator, widthIndicator
            )
        )

    }
}

// ...
                
            """.trimIndent()
        ),

        ExampleCode(
            title = "Линейный индикатор",
            comment = """
Пример линейного индикатора                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Графика в Compose ",
                    textUrl = "\uD83D\uDCD6 Отображать текст",
                    url = "https://developer.android.com/develop/ui/compose/graphics/draw/overview?hl=ru"
                ),
                TextClickLink(
                    text = "Что стоит учесть при построении круговых диаграмм",
                    textUrl = "\uD83D\uDCD6 Netology.ru ",
                    url = "https://netology.ru/blog/03-2021-krugovye-diagrammy"
                ),
                TextClickLink(
                    text = "androidx. compose. ui. graphics. drawscope ",
                    textUrl = "\uD83D\uDCD6 Developers graphics drawscope",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/drawscope/package-summary"
                ),
            ),

            lambdaFun = { LineDriverIndicator(it) },
            nameFun = "LineDriverIndicator.kt",
            code = """
@Composable
fun LineDriverIndicator(
    isExpanded: Boolean = false,
    labelSlider: String = "kV",
    mivValue:Float = 0f,
    maxValue:Float = 120f,
    alarmValue:Float = 105f
) {
    val sliderPosition = remember {
        mutableFloatStateOf(43f)
    }

    val modifier = Modifier
        .fillMaxWidth(if (isExpanded) 0.8f else 1f)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .padding(top = 32.dp)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        IndicatorLine(
            modifier = modifier,
            value = sliderPosition.floatValue,
            minValue = mivValue,
            maxValue = maxValue,
            alarmValue = alarmValue,
            unitOfMeasurement = labelSlider
        )
        SliderSimple(labelSlider+":", sliderPosition, mivValue, maxValue,modifier)
    }
}

@Composable
private fun IndicatorLine(
    title: String = "Напряжение электрофильта",
    modifier: Modifier = Modifier,
    value: Float = 0f,
    minValue: Float = 0f,
    maxValue: Float = 120f,
    alarmValue: Float = maxValue - 25f,
    indentDp: Int = 16,
    strokeWidth: Float = 15f, //Ширина ползунка
    quantity: Int = 8,    //кол-во сегментов
    background: Color = MaterialTheme.colorScheme.background,
    colorArrow: Color = MaterialTheme.colorScheme.onBackground,
    colorValue: Color = MaterialTheme.colorScheme.secondary,
    colorAlarm: Color = MaterialTheme.colorScheme.error,
    height: Int = 80,
    unitOfMeasurement: String = "kV",
    styleScaleValues: TextStyle = TextStyle(
        textAlign = TextAlign.Center,
        fontSize = 18.sp,
        color = MaterialTheme.colorScheme.onTertiaryContainer,
    ),
    styleRealValue: TextStyle = TextStyle(
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.SansSerif,
        fontSize = 25.sp,
        color = colorValue,
    )

) {
    val textMeasurer = rememberTextMeasurer()

    Card {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(title)
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(background),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                LineIndicator(
                    modifier = Modifier
                        .height(height.dp)
                        .weight(1f),
                    textMeasurer = textMeasurer,
                    color = colorArrow,
                    minValue = minValue,
                    maxValue = maxValue,
                    quantity = quantity * 2,
                    strokeWidth = if (strokeWidth > 2f) strokeWidth / 2 else 2f,
                    indentDp = indentDp,
                    style = styleScaleValues,
                    alarmValue = alarmValue,
                    alarmColor = colorAlarm,
                    realValue = value
                )
                Spacer(
                    modifier = Modifier
                        .width(2.dp)
                        .background(styleRealValue.color)
                        .height(height.dp)
                )
                Column(
                    modifier = Modifier
                        .background(background)
                        .padding(horizontal = 8.dp)
                        .widthIn(min = 70.dp)
                        .height(height.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "%.1f".format(value), style = styleRealValue.merge(
                            color = if (value >= alarmValue) colorAlarm else colorValue
                        )
                    )
                    Text(unitOfMeasurement, style = styleRealValue)

                }

            }

        }

    }

}

@Composable
fun LineIndicator(
    modifier: Modifier = Modifier,
    textMeasurer: TextMeasurer,
    color: Color,
    minValue: Float,
    maxValue: Float,
    quantity: Int,       //кол-во сегментов
    strokeWidth: Float,
    sliderHeightDp: Int = 30,
    divisionHeight: Int = 10,
    indentDp: Int = 0,
    style: TextStyle,
    alarmValue: Float = 0f,
    alarmColor: Color,
    realValue: Float = 70f
) {
    //Контроль на корректность выводимого значения
    val outValue = if (realValue > maxValue) maxValue
    else if (realValue < minValue) minValue
    else realValue

    Canvas(modifier) {
        val indentPx = indentDp.dp.toPx()
        val widthIndicator = size.width - 2 * indentPx

//рисуем бегунок (прямоугольник),размеры которого будем изменять
        val sliderWidth = outValue * widthIndicator / maxValue
        drawRect(
            topLeft = Offset(
                x = indentPx,
                y = size.height - sliderHeightDp.dp.toPx()
            ),

            size = Size(
                width = sliderWidth,
                height = sliderHeightDp.dp.toPx()
            ),

//градиент цвета заливки
            brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xff2962ff),
                    Color(0xffffeb3b),
                    Color(0xffff5722),
                )
            ),
        )

//нижняя линия индикатора
        drawLine(
            start = Offset(indentPx, size.height),
            end = Offset(size.width - indentPx, size.height),
            strokeWidth = strokeWidth,
            color = color
        )

//приращение величин
        val increment = (maxValue - minValue) / quantity
        val dx = widthIndicator / quantity
        var inc = 0
        var isSmoll = false

        for (i in 0..quantity) {
            val value = minValue + i * increment
            val x = indentPx + i * dx
            val y1 = size.height - sliderHeightDp.dp.toPx()

            val y2 = if (isSmoll) y1 - divisionHeight
            else y1 - 2 * divisionHeight

            val isBorder = if ((i == 0) || (i == quantity)) true
            else false
            //рисуем деление
            drawLine(
                start = Offset(x, y = if (isBorder) size.height else y1),
                end = Offset(x, y = y2),
                strokeWidth = strokeWidth,
                color = color
            )

            if (inc == 0) {
                //Выводим значения над делениями
                val textValue = "${'$'}{value.toInt()}"
                val valueLayout = textMeasurer.measure(textValue, style)
                val xx = when (i) {
                    0 -> x - 6.dp.toPx()
                    quantity -> x - valueLayout.size.width + 6.dp.toPx()
                    else -> x - valueLayout.size.width / 2
                }
                drawText(
                    textMeasurer = textMeasurer,
                    text = textValue,
                    style = style,
                    topLeft = Offset(
                        x = xx,
                        y = y2 - valueLayout.size.height - 8.dp.toPx()
                    ),
                )
            }

            inc++
            if (inc >= 4) inc = 0
            isSmoll = !isSmoll

        }


//рисуем указатель предельного допустимого значения
        val alarmX = alarmValue * widthIndicator / (maxValue - minValue) + indentPx
        val alarmY = size.height - sliderHeightDp.dp.toPx() + 3.dp.toPx()
        val alarmdWidth = 6.dp.toPx()
        val alarmTop = alarmY - 5 * divisionHeight
        val path = Path().apply {
            moveTo(alarmX, alarmY)
            lineTo(alarmX - alarmdWidth, alarmTop)
            lineTo(alarmX + alarmdWidth, alarmTop)
        }
        drawPath(path, alarmColor)

    }

}
                
            """.trimIndent()
        ),

        ExampleCode(
            title = "Маштабирование на холсте",
            comment = """
Функция DrawScope.|withTransform()| позволяет применить к рисункам несколько преобразований.

|withTransform()| создает и применяет одно преобразование, объединяющее все желаемые изменения. 
 
Использование |withTransform|() более эффективно, чем выполнение вложенных вызовов отдельных преобразований, поскольку все преобразования выполняются вместе в одной операции, вместо того, чтобы Compose вычислял и сохранял каждое из вложенных преобразований.
                
Canvas(modifier = Modifier.fillMaxSize()) {
    withTransform({
        translate(left = size.width / 5F)
        rotate(degrees = 45F)
    }) {
        drawRect(
            color = Color.Gray,
            topLeft = Offset(x = size.width / 3F, y = size.height / 3F),
            size = size / 3F
        )
    }
}
                
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
                    text = "androidx. compose. ui. graphics. drawscope ",
                    textUrl = "\uD83D\uDCD6 Developers graphics drawscope",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/drawscope/package-summary"
                ),
            ),

            lambdaFun = { DrawAnimeScaleAText() },
            nameFun = "DrawAnimeScaleAText.kt",
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
            title = "Текст, доступный для выбора",
            comment = """
Компонуемый |SelectionContainer| обеспечивает доступность для выбора текста с возможностью копирования,выбранной части текста, в буфер обмена. По умолчанию составные элементы недоступны для выбора, что означает, что по умолчанию пользователи не могут выбирать и копировать текст из вашего приложения. 

Чтобы включить выделение текста, вам необходимо обернуть текстовые элементы компонуемым |SelectionContainer|                        
                
            """.trimIndent(),
            lambdaFun = { SelectableText()  },

            code ="""

            """.trimIndent(),
            links = listOf(

                TextClickLink(
                    text = "Больше информации смотрите в ",
                    textUrl = "\uD83D\uDCD6 Developers. Accessibility",
                    url = "https://developer.android.com/develop/ui/compose/accessibility/semantics?hl=ru"
                ),
            ),
        ),

        ExampleCode(
            title = "Получение позиции касания по тексту",
            comment = """
Модификатор |clickable| обеспечивает прослушивание кликов по тексту. Однако если вы хотите получить позицию щелчка внутри составного текста, в случае, когда у вас есть разные действия, основанные на разных частях текста, вам нужно вместо этого использовать |ClickableText|                        
                
            """.trimIndent(),
            lambdaFun = { ClickableMyText()  },
            nameFun = "ClickableMyText.kt",

            code ="""
@Composable
fun ClickableMyText(
    identification:String = "Филин",
    comment:String = "\"Угукающая\" ночная птица",
    char:Char = '*'
) {
    val identLen = identification.length
    val comLen = comment.length
    val corner = 8.dp


    var expanded by remember { mutableStateOf(false) }

    val letters = remember { Array(identLen,{ _ -> char}) }

    var text by remember {
        mutableStateOf(letters.toStr())
    }

    val applicationContext = LocalContext.current

    val annotatedString = AnnotatedString(
        text = text+ " " +comment,
        spanStyles = listOf(
            AnnotatedString.Range(
                SpanStyle(
                    color = Color.Yellow,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 40.sp,
                    letterSpacing = 25.sp
                ),
                0, identLen //Филин
            ),
            AnnotatedString.Range(
                SpanStyle(
                    color = Color.Cyan,
                    fontSize = 15.sp
                ),
                identLen + 1, identLen + 1 + comLen  //Угукающая ночная птица
            ),
        ),

        // создаем два абзаца
        paragraphStyles = listOf(
            AnnotatedString.Range(
                ParagraphStyle(
                    textAlign = TextAlign.Center
                ),
                0, identLen //Филин
            ),
            AnnotatedString.Range(
                ParagraphStyle(
                    textAlign = TextAlign.Center
                ),
                identLen + 1, identLen + 1 + comLen  //Угукающая ночная птица
            ),
        )
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Отгадайте слово")
        ClickableText(
            text = annotatedString,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .graphicsLayer {
                    shadowElevation = 8.dp.toPx()
                    shape = RoundedCornerShape(corner)
                    clip = true //!!! обрезание всего, что вне формы
                }
                .background(color = Color.Black)
                .drawBehind {
//рисует границы прямоугольника с закруглёнными углами
                    drawRoundRect(
                        color = Color.Cyan,
                        cornerRadius = CornerRadius(corner.toPx()),
                        style = Stroke(
                            width = 4.dp.toPx(),
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
                        )
                    )

                }
                .padding(top = 32.dp,bottom = 32.dp),
            onClick = { ind ->
                if (ind < identLen){
                    letters[ ind ] = identification[ ind ].uppercaseChar()
                    text = letters.toStr()
                    Toast.makeText(
                        applicationContext,
                        "${'$'}{ind+1} -th character is clicked",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

            }
        )

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
            text = "Для подсказки коснитесь на любой символ '*' для отображения буквы",
            textAlign = TextAlign.Justify,
            letterSpacing = 1.3.sp,
            fontSize = 16.sp

        )
    }
}

fun Array<Char>.toStr(): String {
    val array: Array<Char> = this
    var result = ""
    array.forEach { result += it }
    return result
}
                

            """.trimIndent(),
            links = listOf(

                TextClickLink(
                    text = "Больше информации смотрите в ",
                    textUrl = "\uD83D\uDCD6 Developers. Accessibility",
                    url = "https://developer.android.com/develop/ui/compose/accessibility/semantics?hl=ru"
                ),
                TextClickLink(
                    text = "Онлайн версия кроссворда для детей Всезнайка",
                    textUrl = "\uD83D\uDCD6 Кроссворд для настоящих эрудитов ",
                    url = "https://www.obovsemka.com/crosswordy/crossword-vseznajka.html"
                ),

            ),
        ),


        ExampleCode(
            id = 1,
            title = "Доступность текста",
            comment = """
Свойство |liveRegion| из модификатора блока |semantics| используется для уведомления об изменениях состояния |Composable| 

Это может быть полезно для людей с ограниченым зрением.

Активная область указывает службам доступности, что они должны автоматически уведомлять пользователя об изменениях в описании или тексте содержимого узла или в описаниях или тексте содержимого дочерних узлов. 

Например, в случае активности |!TalkBack| программа чтения с экрана прочтет сообщение вслух.

|TalkBack| – это программа чтения с экрана от |Google|, предустановленная на устройствах |Android|. Она позволяет управлять устройством, не смотря на экран.                
                
Можно использовать один из двух вариантов для |liveRegion|:

 LiveRegionMode.|Polite| - режим региона в реальном времени, указывающий, что службы специальных возможностей должны объявлять об изменениях в этом узле;

 LiveRegionMode.|Assertive| - режим региона в реальном времени, указывающий, что службы специальных возможностей должны прерывать текущую речь, чтобы немедленно объявить об изменениях в этом узле.

 
 Ключевые шаги по улучшению доступности приложения |Compose|:

1)|!Учитывайте минимальные размеры сенсорных объектов|. Убедитесь, что кликабельные и интерактивные элементы имеют размер не менее |48| dp. Это соответствует рекомендациям по доступности |Material Design|.

2)|!Добавьте метки кликов! . Опишите поведение щелчка с помощью модификатора |clickable| или модификатора |semantics| , если у вас нет прямого доступа к |clickable| .

3)|!Опишите визуальные элементы| . Используйте параметр |contentDescription| для текстового описания значков и изображений. Установите для |contentDescription| значение |null| для декоративных элементов.

4)|!Определить заголовки| . Используйте свойство модификатора |semantics| , чтобы пометить элементы как заголовки для упрощения навигации.

5)|!Управляйте порядком обхода| . Используйте |isTraversalGroup| , чтобы отметить группы элементов, которые следует читать вместе. Используйте |traversalIndex| для дальнейшей настройки порядка элементов в этих группах.


            """.trimIndent(),
            lambdaFun = { SemanticsText() },
            nameFun = "SemanticsText.kt",

            code ="""
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
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Доступность в Jetpack Compose ",
                    textUrl = "\uD83D\uDCD6 Семантика в Compose ",
                    url = "https://developer.android.com/develop/ui/compose/accessibility?hl=ru#custom-actions"
                ),
                TextClickLink(
                    text = "Ключевые шаги по улучшению доступности Compose\n ",
                    textUrl = "\uD83D\uDCD6 Developers. Key steps ",
                    url = "https://developer.android.com/develop/ui/compose/accessibility/key-steps?hl=ru#add-click-labels"
                ),
                TextClickLink(
                    text = "Больше информации смотрите в ",
                    textUrl = "\uD83D\uDCD6 Developers. LiveRegionMode",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/semantics/LiveRegionMode"
                ),
                TextClickLink(
                    text = "Адаптируем Android-приложение для незрячих людей.  ",
                    textUrl = "\uD83D\uDCD6 https://habr.com/...",
                    url = "https://habr.com/ru/companies/surfstudio/articles/694622/"
                ),
                TextClickLink(
                    text = "Больше информации смотрите в ",
                    textUrl = "\uD83D\uDCD6 Developers. Accessibility",
                    url = "https://developer.android.com/develop/ui/compose/accessibility/semantics?hl=ru"
                ),
            ),
        ),

        ExampleCode(
            title = "Масштаб шрифта",
            comment = """
LocalDensity.current.|fontScale| является маштабным коэффициентом шрифта, который может установить пользователь в настройках смартфона. Приложения должны масштабировать текст до размера, указанного пользователями в системных настройках. Это особенно важно для пользователей с нарушениями зрения.

Величина свойства |fontSize| должна быть в масштабируемых пикселях |sp|             
             
Рекомендовано определить свойство |fontSize| внутри объекта |Typography|, чтобы обеспечить единообразие во всем приложении.


            """.trimIndent(),
            lambdaFun = { FontScale() },
            nameFun = "FontScale.kt",
            code ="""
        //...        
        Text(
            text = "Масштабный коэф. : ${'$'}{LocalDensity.current.fontScale}",
            textDecoration = TextDecoration.Underline,
            fontSize = 18.sp
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Text [fontSize = 18sp]\n зависит от маштаба",
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Text [fontSize = 18nonScaledSp()]\n не зависит от маштаба",
            textAlign = TextAlign.Center,
            fontSize = 18. nonScaledSp()
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Text [fontSize = 4.6em]\n не зависит от маштаба",
            textAlign = TextAlign.Center,
            fontSize = 4.6.em
        )
        //...

        @Composable
        fun Int.nonScaledSp(): TextUnit {
            val value: Int = this
            return with(LocalDensity.current) {
                val fontScale = this.fontScale
                val textSize = value / fontScale
                textSize.sp
            }
        }
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Доступность в Jetpack Compose ",
                    textUrl = "\uD83D\uDCD6 Семантика в Compose ",
                    url = "https://developer.android.com/develop/ui/compose/accessibility?hl=ru#custom-actions"
                ),
                TextClickLink(
                    text = "Текущие предпочтения пользователя относительно коэффициента масштабирования шрифтов.",
                    textUrl = "\uD83D\uDCD6 Developers. FontScaling ",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/FontScaling"
                ),
            ),
        ),

        ExampleCode(
            title = "Смайлики Эмодзи \uD83D\uDD25",  //🔥
            comment = """
🐱 🦉 😀 👋 🐱 🌻 🍁 🦉 🌎  ✨ 🎼 ≠ 📗 📘 📙 📕 📏  🪐              
            """.trimIndent(),
            lambdaFun = { Emoticons() },
            nameFun = "Emoticons.kt",
            code ="""
@Composable
fun Emoticons(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .padding(16.dp)
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(48.dp)
        ) {
            Text(
                text = "\uD83C\uDF87",
                fontSize = 120.sp,
            )
            Text(
                text = "✨ Good Day ✨",
                color = Color.White,
                fontFamily = FontFamily.Cursive,
                fontSize = 40.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "\uD83D\uDEF0\uFE0F",
                fontSize = 80.sp,
            )
        }

    }
}                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Все категории эмодзи ",
                    textUrl = "\uD83D\uDCD6 https://emojio.ru/category.html ",
                    url = "https://emojio.ru/category.html"
                ),
                TextClickLink(
                    text = "Высококачественные изображения PNG для бесплатного скачивания",
                    textUrl = "\uD83D\uDCD6 https://www.pngegg.com/ru ",
                    url = "https://www.pngegg.com/ru"
                ),
            ),
        ),

        ExampleCode(
            title = "Переходы общих элементов",
            comment = """
 |SharedTransitionLayout| - самый внешний макет, необходимый для реализации переходов общих элементов. Он предоставляет |SharedTransitionScope|. Чтобы использовать модификаторы общего элемента, составные элементы должны находиться в |SharedTransitionScope|.

 Modifier.|sharedElement|() : модификатор, который помечает в |SharedTransitionScope| составной объект, который должен сопоставляться с другим составным объектом.

 Modifier.|sharedBounds|() : модификатор, который указывает |SharedTransitionScope| , что границы этого составного объекта должны использоваться в качестве границ контейнера, где должен происходить переход. 
 
 В отличие от |sharedElement|() , |sharedBounds|() предназначен для визуально другого контента.

Важным моментом при создании общих элементов в |Compose| является то, как они работают с наложениями и обрезкой.    
            
            """.trimIndent(),
            lambdaFun = { ListProducts(it,DataItemProducts.listProducts) },
            nameFun = "ListProducts.kt",
            code ="""
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ListProducts(
    isExpanded: Boolean = false,
    itemList: List<ItemProduct>
) {
    var showDetails by remember {
        mutableStateOf(false)
    }

    var item by remember {
        mutableStateOf(ItemProduct())
    }

//самый внешний макет, необходимый для реализации переходов общих элементов
    SharedTransitionLayout {
        AnimatedContent(
            targetState = showDetails,
            label = "basic_transition"
        ) { targetState ->
            if (!targetState) {
                MainContent(
                    itemList = itemList,
                    onShowDetails = {
                        showDetails = true
                        item = it
                    },
                    animatedVisibilityScope = this@AnimatedContent,
                    sharedTransitionScope = this@SharedTransitionLayout
                )
            } else {
                DetailsContent(
                    isExpanded = isExpanded,
                    item = item,
                    onBack = {
                      showDetails = false
                    },
                    animatedVisibilityScope = this@AnimatedContent,
                    sharedTransitionScope = this@SharedTransitionLayout
                )
            }
        }

    }

}

@OptIn(ExperimentalSharedTransitionApi::class)
private val boundsTransform = BoundsTransform { _: Rect, _: Rect ->
    tween(durationMillis = boundsAnimationDurationMillis, easing = FastOutSlowInEasing)
}


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
    itemList: List<ItemProduct>,
    onShowDetails: (ItemProduct) -> Unit = {},
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope

){
    with(sharedTransitionScope){
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            contentPadding = PaddingValues(4.dp),
            modifier = modifier
                .padding(8.dp)
                .sharedBounds(
                    rememberSharedContentState(key = "bounds"),
                    animatedVisibilityScope = animatedVisibilityScope,
                    enter = fadeIn(
                        tween(
                            boundsAnimationDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    ),
                    exit = fadeOut(
                        tween(
                            boundsAnimationDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    ),
                    boundsTransform = boundsTransform
                )

        ) {
            itemsIndexed(itemList) { _,item ->
                ItemSharedUI(item,onShowDetails,sharedTransitionScope,animatedVisibilityScope)
            }
        }

    }

}


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun DetailsContent(
    isExpanded: Boolean = false,
    item: ItemProduct,
    onBack: () -> Unit = {},
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
){

    with(sharedTransitionScope) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                val modifier = Modifier
                    .padding(top = 70.dp, start = 16.dp, end = 16.dp)
                    .sharedBounds(
                        rememberSharedContentState(key = "bounds"),
                        animatedVisibilityScope = animatedVisibilityScope,
                        enter = fadeIn(
                            tween(
                                durationMillis = boundsAnimationDurationMillis,
                                easing = FastOutSlowInEasing
                            )
                        ),
                        exit = fadeOut(
                            tween(
                                durationMillis = boundsAnimationDurationMillis,
                                easing = FastOutSlowInEasing
                            )
                        ),
                        boundsTransform = boundsTransform
                    )
                    .border(1.dp, Color.Gray.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                    .background(
                        MaterialTheme.colorScheme.secondaryContainer,
                        RoundedCornerShape(8.dp)
                    )
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        onBack()
                    }
                    .fillMaxSize()
                    .padding(8.dp)

                if (isExpanded) DetailsSharedExpandedItemUI(item,modifier,sharedTransitionScope,animatedVisibilityScope)
                else DetailsSharedItemUI(item,modifier,sharedTransitionScope,animatedVisibilityScope)

            }
        }


    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun ItemSharedUI(
    item: ItemProduct,
    onItemClick: (ItemProduct) -> Unit = {},
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier,
){
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .requiredHeight(270.dp)  //296
            .clickable { onItemClick(item) },
        elevation = CardDefaults.cardElevation(),  //8.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            with(sharedTransitionScope) {

                Text(
                    text = stringResource(id = item.idTitle),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                        .sharedBounds(
                            rememberSharedContentState(key = "title ${'$'}{item.idTitle}"),
                            animatedVisibilityScope = animatedVisibilityScope
                        )
                        .padding(top = 4.dp, bottom = 8.dp)
                )

                Image(
                    modifier = Modifier
                        .sharedElement(
                            rememberSharedContentState(key = "image ${'$'}{item.idTitle}"),
                            animatedVisibilityScope = animatedVisibilityScope
                        )
                        .padding(16.dp)
                        .weight(1f),
                    painter = painterResource(id = item.idImage),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = setPriceString(item.price.toString()),
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .padding(top = 4.dp, bottom = 8.dp)
                )
            }

        }
    }

}


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun DetailsSharedItemUI(
    item: ItemProduct,
    modifier: Modifier = Modifier
        .padding(top = 70.dp, start = 16.dp, end = 16.dp)
        .border(1.dp, Color.Gray.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
        .background(
            MaterialTheme.colorScheme.secondaryContainer,
            RoundedCornerShape(8.dp)
        )
        .padding(8.dp),
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,


){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        with(sharedTransitionScope) {
            Image(
                modifier = Modifier
                    .sharedElement(
                        rememberSharedContentState(key = "image ${'$'}{item.idTitle}"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
                    .fillMaxWidth(),
                painter = painterResource(id = item.idImage),
                contentDescription = "",
            )
            Text(
                text = stringResource(id = item.idTitle),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .sharedBounds(
                        rememberSharedContentState(key = "title ${'$'}{item.idTitle}"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
            )
            Text(
                text = stringResource(id = item.idComment),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                textAlign = TextAlign.Justify,
            )
            Text(
                text = setPriceString(item.price.toString()),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }

}



@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun DetailsSharedExpandedItemUI(
    item: ItemProduct,
    modifier: Modifier = Modifier
        .padding(top = 70.dp, start = 16.dp, end = 16.dp)
        .border(1.dp, Color.Gray.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
        .fillMaxWidth()
        .background(
            MaterialTheme.colorScheme.secondaryContainer,
            RoundedCornerShape(8.dp)
        )
        .padding(8.dp),
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,

){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
    ) {
        with(sharedTransitionScope) {
            Image(
                painter = painterResource(id = item.idImage),
                contentDescription = "",
                modifier = Modifier
                    .sharedElement(
                        rememberSharedContentState(key = "image ${'$'}{item.idTitle}"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
                    .weight(1f),
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = stringResource(id = item.idTitle),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier
                        .sharedBounds(
                            rememberSharedContentState(key = "title ${'$'}{item.idTitle}"),
                            animatedVisibilityScope = animatedVisibilityScope
                        )
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(id = item.idComment),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    textAlign = TextAlign.Justify,
                )


            }
        }

    }

}


private fun setPriceString(priceStr:String = "0"):AnnotatedString = buildAnnotatedString {
    withStyle(
        style = ParagraphStyle(
            textAlign = TextAlign.Center,
        )
    ) {
        withStyle(
            style = SpanStyle(
                color = Color.Red,
                fontFamily = FontFamily.Cursive,
                fontSize = 24.sp
            )
        ) {
            append("${'$'}")
        }
        withStyle(
            style = SpanStyle(
                fontSize = 18.sp
            )
        ) {
            append(priceStr)
        }
    }
}
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Переходы общих элементов ",
                    textUrl = "\uD83D\uDCD6 Developers. Compose ",
                    url = "https://developer.android.com/develop/ui/compose/animation/shared-elements?hl=ru"
                ),
            ),
        ),

        ExampleCode(
            title = "Горизонтальная карусель",
            comment = """
|HorizontalMultiBrowseCarousel| - горизонтальная карусель, предназначенная для одновременного отображения множества элементов и быстрого просмотра более мелкого содержимого, например миниатюры фотографий.

Данная карусель может регулировать размер элементов для того, чтобы обеспечить микс крупных, средних, а мелкие предметы отлично вписываются в имеющееся пространство и располагаются в визуально приятноб. 
Затем «Карусель» размещает элементы с использованием большого размера и обрезает (или маскирует) элементы в зависимости от на их смещение прокрутки для создания элементов, которые плавно расширяются и сворачиваются между большими, средними и малыми размерами.

|!@ExperimentalMaterial3Api
@Composable
fun HorizontalMultiBrowseCarousel(
    state: CarouselState,
    preferredItemWidth: Dp,
    modifier: Modifier = Modifier,
    itemSpacing: Dp = 0.dp,
    flingBehavior: TargetedFlingBehavior =
        CarouselDefaults.singleAdvanceFlingBehavior(state = state),
    minSmallItemWidth: Dp = CarouselDefaults.MinSmallItemSize,
    maxSmallItemWidth: Dp = CarouselDefaults.MaxSmallItemSize,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: @Composable CarouselItemScope.(itemIndex: Int) -> Unit
)|


|state|	- объект state, который будет использоваться для управления состоянием карусели

|preferredItemWidth| - ширина, которую большие, полностью видимые предметы хотели бы иметь по горизонтальной оси. Эта ширина является целевой и, скорее всего, будет регулироваться с помощью карусели, чтобы в контейнере поместилось целое количество элементов. Карусель сначала корректирует мелкие элементы (между [minSmallItemWidth] и [maxSmallItemWidth]), затем средние элементы, если они есть, и, наконец, большие элементы, если это необходимо.

|modifier| - экземпляр модификатора, который будет применен к этому контейнеру кольцевой галереи

|itemSpacing| - объем пространства, используемого для разделения элементов в карусели

|flingBehavior| -свойство [TargetedFlingBehavior], используемое для жестов прокрутки после прокрутки

|minSmallItemWidth| -минимально допустимая ширина мелких предметов в dp. В зависимости от [preferredItemWidth] и ширины карусели, ширина маленького элемента будет выбрана из диапазона [minSmallItemWidth] и [maxSmallItemWidth]

|maxSmallItemWidth| - максимально допустимая ширина мелких предметов в dp. В зависимости от [preferredItemWidth] и ширины карусели, ширина маленького элемента будет выбрана из диапазона [minSmallItemWidth] и [maxSmallItemWidth]

|contentPadding| - набивка вокруг всего содержимого. Это добавит отступы для содержимого после того, как оно было обрезано. Вы можете использовать его для добавления отступа перед первым элементом или после последнего. Используйте [itemSpacing] для добавления интервала между элементами.

|content| = содержимое карусели Composable                
            """.trimIndent(),
            lambdaFun = { CarouselProducts() },
            nameFun = "CarouselProducts.kt",
            code ="""
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Горизонтальная карусель",
                    textUrl = "\uD83D\uDCD6 https://emojio.ru/category.html ",
                    url = "https://composables.com/material3/horizontalmultibrowsecarousel"
                ),
                TextClickLink(
                    text = "Find components for your Jetpack Compose apps",
                    textUrl = "\uD83D\uDCD6 Composables",
                    url = "https://composables.com/"
                ),
            ),
        ),

        ExampleCode(
            title = "Ресайзинг текста под контейнер",
            comment = """
Параметр |autoSize| в |!BasicText| автоматически подстраивает размер текста под размер контейнера.                
            """.trimIndent(),
            lambdaFun = { BasicTextAutoSize() },
            nameFun = "BasicTextAutoSize.kt",
            code ="""
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondary)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        BasicText(
            text = "С Новым годом!",
            modifier = Modifier
                .padding(16.dp),
            maxLines = 1,
            autoSize = TextAutoSize.StepBased()
        )

    }                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Что нового в выпуске Jetpack Compose от 25 апреля 25 года",
                    textUrl = "\uD83D\uDCD6 Блог разработчиков Android ",
                    url = "https://android-developers.googleblog.com/2025/04/whats-new-in-jetpack-compose-april-25.html"
                ),
            ),
        ),

        ExampleCode(
            title = "Вертикальная ориентация текста",
            comment = """
            Модификатор .|rotate|(-90f) позволяет развернуть текст по вертикали.
            """.trimIndent(),
            lambdaFun = { VertikalOrientationText(it) },
            nameFun = "VertikalOrientationText.kt",
            code ="""
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Что нового в выпуске Jetpack Compose от 25 апреля 25 года",
                    textUrl = "\uD83D\uDCD6 Блог разработчиков Android ",
                    url = "https://android-developers.googleblog.com/2025/04/whats-new-in-jetpack-compose-april-25.html"
                ),
                TextClickLink(
                    text = "Официальная среда разработки приложений для Android",
                    textUrl = "\uD83D\uDCD6 Android Studio ",
                    url = "https://developer.android.com/studio?utm_source=android-studio&hl=ru"
                ),
            ),
        ),

        ExampleCode(
            title = "Параметры печи",
            comment = """
 Используйте |SegmentedButton|,чтобы пользователи могли выбирать из набора опций, расположенных рядом.

 Сегментированные кнопки помогают пользователям выбирать параметры, переключать представления или сортировать элементы.

 Существует два типа сегментированных кнопок:
    Кнопка одиночного выбора : позволяет пользователям выбрать один вариант.
    Кнопка множественного выбора : позволяет пользователям выбирать от двух до пяти элементов. Для более сложного выбора или более пяти предметов используйте фишки
                 
 Используйте макеты |SingleChoiceSegmentedButtonRow| и |MultiChoiceSegmentedButtonRow| для создания сегментированных кнопок. 
 Эти макеты гарантируют правильное расположение и размер |SegmentedButton| , а также общие следующие ключевые параметры:

    space : регулирует перекрытие между кнопками.
    content : Содержит содержимое сегментированной строки кнопки, которая обычно представляет собой последовательность SegmentedButton .                 
    """.trimIndent(),
            lambdaFun = { SegmentedButtonExample(it) },
            nameFun = "SegmentedButtonExample.kt",
            code ="""
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Сегментированная кнопка  ",
                    textUrl = "\uD83D\uDCD6 Android. Developers ",
                    url = "https://developer.android.com/develop/ui/compose/components/segmented-button?hl=ru"
                ),
                TextClickLink(
                    text = "Segmented buttons.  ",
                    textUrl = "\uD83D\uDCD6 m3.material.io ",
                    url = "https://m3.material.io/components/segmented-buttons/overview"
                ),
                TextClickLink(
                    text = "Пример использования ",
                    textUrl = "\uD83D\uDCD6 SegmentedButtonSingleSelectSample() ",
                    url = "https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:compose/material3/material3/samples/src/main/java/androidx/compose/material3/samples/SegmentedButtonSamples.kt"
                ),
            ),
        ),

        ExampleCode(
            title = "Контроллер безопасности",
            comment = """
Checkbox позволяют пользователют выбрать один или несколько вариантов из набора. Обычно представляются в вертикальном списке.
                 
 Поскольку набор параметров флажков позволяет пользователю выбирать несколько элементов, каждый флажок управляется отдельно, и для каждого из них необходимо зарегистрировать прослушиватель кликов.
                  
            """.trimIndent(),
            lambdaFun = { CheckboxWithTextExample(it) },
            nameFun = "CheckboxWithTextExample.kt",
            code ="""
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

val checkedState = remember { mutableStateOf(true) }
Checkbox(
    checked = checkedState.value, 
    onCheckedChange = { checkedState.value = it }
)
                
            """.trimIndent(),
            links = listOf(
                TextClickLink(
                    text = "Добавьте флажки в свое приложение  ",
                    textUrl = "\uD83D\uDCD6  Android.Developers ",
                    url = "https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#Checkbox(kotlin.Boolean,kotlin.Function1,androidx.compose.ui.Modifier,kotlin.Boolean,androidx.compose.material3.CheckboxColors,androidx.compose.foundation.interaction.MutableInteractionSource)"
                ),
                TextClickLink(
                    text = "Material Design checkbox  ",
                    textUrl = "\uD83D\uDCD6  m3.material.io ",
                    url = "https://m3.material.io/components/checkbox/overview"
                ),
                TextClickLink(
                    text = "Пример использования ",
                    textUrl = "\uD83D\uDCD6  CheckboxWithTextSample ",
                    url = "https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:compose/material3/material3/samples/src/main/java/androidx/compose/material3/samples/CheckboxSamples.kt"
                ),
            ),
        ),

        )
}
