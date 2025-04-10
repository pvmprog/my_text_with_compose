package com.pvmprog.mytextwithcompose.ui.examples.data

import com.pvmprog.mytextwithcompose.R

object DataItemProducts {
    val listProducts: List<ItemProduct> = listOf(
        ItemProduct(
            idProduct = 0,
            titleResId = R.string.gates,//ворота
            imageResId = R.drawable.gates,
            contentDescriptionResId = R.string.comment_gates,
            price = 5000
        ),
        ItemProduct(
            idProduct = 1,
            titleResId = R.string.canopy, //навес
            imageResId = R.drawable.canopy,
            contentDescriptionResId = R.string.comment_canopy,
            price = 1200

        ),
        ItemProduct(
            idProduct = 2,
            titleResId = R.string.fence, //забор
            imageResId = R.drawable.fence,
            contentDescriptionResId = R.string.comment_fence,
            price = 570
        ),
        ItemProduct(
            idProduct = 3,
            titleResId = R.string.ladder, //лестница
            imageResId = R.drawable.ladder,
            contentDescriptionResId = R.string.comment_ladder,
            price = 17000
        ),
        ItemProduct(
            idProduct = 4,
            titleResId = R.string.gilding, //Золочение
            imageResId = R.drawable.gilding,
            contentDescriptionResId = R.string.comment_gilding,
            price = 1000
        ),
        ItemProduct(
            idProduct = 5,
            titleResId = R.string.modeling,  //Моделирование
            imageResId = R.drawable.modeling,
            contentDescriptionResId = R.string.comment_modeling
        ),
    )
}