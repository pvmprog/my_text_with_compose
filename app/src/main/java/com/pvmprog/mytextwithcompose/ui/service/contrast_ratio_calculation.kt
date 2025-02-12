package com.pvmprog.mytextwithcompose.ui.service

import androidx.compose.ui.graphics.Color


//input: c8 = 0 .. 255
//output: c = 0.0 .. 1.0
//Определение линейного значения компоненты цвета
fun color_components(c8: Int):Float {
    var cSrgb:Float = c8.toFloat()/255

    cSrgb = if (cSrgb > 0.03928){
        val c = (cSrgb+0.055)/1.055
        Math.pow(c,2.4).toFloat()
    }
    else (cSrgb/12.92).toFloat()

    return cSrgb
}

//вычисления относительной яркости L
fun calculat_brightness(r:Float,g:Float,b:Float) = 0.2126 * r + 0.7152 * g + 0.0722 * b

//вычисления коэффициент контраста
//Текст должен иметь коэффициент контраста не менее 4.5.
//В идеале это значение должно быть не менее 7 - для людей с плохим зрением.
fun contrast_ratio_calculation(color1: Color, color2:Color):Float{


    var r = color_components((color1.red*255).toInt())
    var g = color_components((color1.green*255).toInt())
    var b = color_components((color1.blue*255).toInt())

    val l1 = calculat_brightness(r,g,b)

    r = color_components((color2.red*255).toInt())
    g = color_components((color2.green*255).toInt())
    b = color_components((color2.blue*255).toInt())

    val l2 = calculat_brightness(r,g,b)

    val contrast_ratio = if (l1>l2) ((l1 + 0.05)/(l2 + 0.05)).toFloat()
    else ((l2 + 0.05)/(l1 + 0.05)).toFloat()

    return contrast_ratio
}

fun contrast_ratio_comment(k: Float): String{
    val koef:Int = Math.round(k)
    return when {
        (koef >= 7) -> "(Отличный)"
        (koef >= 4) -> "(Хороший)"
        else -> "(Плохой)"
    }
}

/*

// Цвет фона: Color(0xFF201B16)  rgb(32, 27, 22)
    val hexColor1 = "#201B16"
    val color1 = Color.decode(hexColor1)
// Цвет текста: Color(0xFFEBE0D9)  rgb(235, 224, 217)
    val hexColor2 = "#EBE0D9"
    val color2 = Color.decode(hexColor2)

    val k= contrast_ratio_calculation(color1,color2)
    println("Цвет фона:   $hexColor1")
    println("Цвет текста: $hexColor2")
    println(" Контрастность: $k")

Цвет фона:   #201B16
Цвет текста: #EBE0D9
 Контрастность: 13.170426
 */
