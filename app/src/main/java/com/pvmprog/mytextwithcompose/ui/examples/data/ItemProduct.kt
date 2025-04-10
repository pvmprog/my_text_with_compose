package com.pvmprog.mytextwithcompose.ui.examples.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ItemProduct(
    val idProduct:Int = -1,
    @StringRes val titleResId:Int = -1,
    @DrawableRes val imageResId:Int = -1,
    @StringRes val contentDescriptionResId:Int = -1,
    val price:Int = 0
)
