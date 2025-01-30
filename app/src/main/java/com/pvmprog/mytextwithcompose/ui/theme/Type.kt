package com.pvmprog.mytextwithcompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R

val AbrilFatface = FontFamily(
    Font(R.font.abril_fatface_regular)
)

val Alice = FontFamily(
    Font(R.font.alice_regular)
)

val Cabin = FontFamily(
    Font(R.font.cabin_regular, FontWeight.Normal),
    Font(R.font.cabin_bold, FontWeight.Bold)
)

//шрифт для курсивный для кириллицы
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


val Poppins = FontFamily(
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold)
)
/*
Typography(
    displayLarge: TextStyle,   //самый большой отображаемый текст.
    displayMedium: TextStyle,  //является вторым по величине отображаемым текстом.
    displaySmall: TextStyle,   //это самый маленький отображаемый текст

    headlineLarge: TextStyle,  // самый большой заголовок, предназначенный для короткого, важного текста или цифр. Для заголовков можно выбрать выразительный шрифт, например экранный, рукописный или рукописный. Эти нетрадиционные шрифты имеют детали и сложность, которые помогают привлечь внимание.
    headlineMedium: TextStyle, //второй по величине заголовок, предназначенный для короткого, важного текста или цифр. Для заголовков можно выбрать выразительный шрифт, например экранный, рукописный или рукописный. Эти нетрадиционные шрифты имеют детали и сложность, которые помогают привлечь внимание.
    headlineSmall: TextStyle,

    titleLarge: TextStyle,     //это самый большой заголовок, который обычно зарезервирован для текста со средним акцентом, который короче по длине. Шрифты с засечками или без засечек хорошо подходят для субтитров.
    titleMedium: TextStyle,
    titleSmall: TextStyle,

    bodyLarge: TextStyle,     //bodyLarge является самым большим телом и обычно используется для длинного письма, поскольку он хорошо подходит для небольших размеров текста. Для более длинных участков текста рекомендуется использовать шрифт с засечками или без засечек.
    bodyMedium: TextStyle,
    bodySmall: TextStyle,

    labelLarge: TextStyle,   // это призыв к действию, используемый в различных типах кнопок (например, в текстовых, обведенных и содержащихся кнопках), а также во вкладках, диалоговых окнах и карточках. Текст кнопки, как правило, без засечек и написан заглавными буквами.
    labelMedium: TextStyle,
    labelSmall: TextStyle    //один из самых маленьких размеров шрифта. Он редко используется для аннотирования изображений или для введения заголовка.
  )
 */


// Set of Material typography styles to start with
val typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,   //Cabin
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),


    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

)