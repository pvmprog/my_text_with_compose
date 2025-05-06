package com.pvmprog.mytextwithcompose.ui.examples.data

data class ItemState( // use val instead of var, so you cannot change it
    val idMes: Int = 0,
    val checkedState: Boolean = false,
)

object DataItemStates {

    val kbStatesIn: List<ItemState> = listOf(
        ItemState(0,false),
        ItemState(1,true),
        ItemState(2,false),
        ItemState(3,false),
        ItemState(4,false),
        ItemState(5,false),
        ItemState(6,true),
        ItemState(7,false),
    )

    val kbStatesOut: List<ItemState> = listOf(
        ItemState(8,false),
        ItemState(9,false),
        ItemState(10,false),
        ItemState(11,true),
        ItemState(12,true),
        ItemState(13,false),
        ItemState(14,false),
    )



}

