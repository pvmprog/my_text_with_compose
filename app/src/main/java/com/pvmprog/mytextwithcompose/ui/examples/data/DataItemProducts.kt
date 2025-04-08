package com.pvmprog.mytextwithcompose.ui.examples.data

import com.pvmprog.mytextwithcompose.R

object DataItemProducts {
    val listProducts: List<ItemProduct> = listOf(
        ItemProduct(
            idTitle = R.string.gates,//ворота
            idImage = R.drawable.gates,
            idComment = R.string.comment_gates,
            price = 5000
        ),
        ItemProduct(
            idTitle = R.string.canopy, //навес
            idImage = R.drawable.canopy,
            idComment = R.string.comment_canopy,
            price = 1200

        ),
        ItemProduct(
            idTitle = R.string.fence, //забор
            idImage = R.drawable.fence,
            idComment = R.string.comment_fence,
            price = 570
        ),
        ItemProduct(
            idTitle = R.string.ladder, //лестница
            idImage = R.drawable.ladder,
            idComment = R.string.comment_ladder,
            price = 17000
        ),
        ItemProduct(
            idTitle = R.string.gilding, //Золочение
            idImage = R.drawable.gilding,
            idComment = R.string.comment_gilding,
            price = 1000
        ),
        ItemProduct(
            idTitle = R.string.modeling,  //Моделирование
            idImage = R.drawable.modeling,
            idComment = R.string.comment_modeling
        ),
    )
}