package com.pvmprog.mytextwithcompose.ui.examples.data

data class ItemParam(
    val name: String = "",
    val value:Float = 0f,
    val min:Float = 0f,
    val max:Float = 100f,
    val avar:Float = 0f,
    val quantity:Int = 8,
    val isOutAvar:Boolean = false,
    val type:Int = 0
)
