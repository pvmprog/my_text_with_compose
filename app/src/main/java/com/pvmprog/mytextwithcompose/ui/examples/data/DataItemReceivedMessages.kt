package com.pvmprog.mytextwithcompose.ui.examples.data

data class ItemReceivedMessage(
    val hour:Int = 0,
    val minute:Int = 0,
    val second:Int = 0,
    val codeMes:Int = 0,
    val value:Int = 0
)

object DataItemReceivedMessages {
    val receivedMessages:List<ItemReceivedMessage> = listOf(
        ItemReceivedMessage(10,12,5,1,1),
        ItemReceivedMessage(10,12,5,13,1),
        ItemReceivedMessage(10,12,5,12,1),
        ItemReceivedMessage(10,12,7,5,0),
        ItemReceivedMessage(10,12,7,8,1),
        ItemReceivedMessage(10,12,15,6,1),
        ItemReceivedMessage(10,15,20,1,0),
        ItemReceivedMessage(10,18,44,6,0),
        ItemReceivedMessage(10,22,4,8,0),
        ItemReceivedMessage(10,22,4,9,1),
        ItemReceivedMessage(10,22,54,7,1),
        ItemReceivedMessage(10,22,58,7,0),
        ItemReceivedMessage(10,23,2,12,0),
        ItemReceivedMessage(10,23,4,5,1),
        ItemReceivedMessage(10,23,4,13,0),
        ItemReceivedMessage(10,23,8,10,1),
    )

    val receivedMessages2:List<ItemReceivedMessage> = listOf(
        ItemReceivedMessage(15,25,13,32,1),
        ItemReceivedMessage(16,32,28,32,0),
        ItemReceivedMessage(17,24,5,33,1),
        ItemReceivedMessage(18,5,21,33,0),
        ItemReceivedMessage(19,33,54,34,1),
        ItemReceivedMessage(19,35,32,34,0),
        ItemReceivedMessage(21,18,44,33,1),

        )

}