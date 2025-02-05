package com.pvmprog.mytextwithcompose.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.service.OutTextMessage

@Composable
fun OutCardMessage(
    message: String,
    sizeFontText: Int = 18,     //: TextUnit = 18.sp
    isNormalStyle: Boolean = true,
    isColorBackground: Boolean = false,
    isColorBorder: Boolean = false,
    isShapeLarge: Boolean = false,
    isTextCenter: Boolean = false,
    indexItem:Int = 0,
    onClick: (Int) -> Unit = {},
){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(R.dimen.card_elevation)),  //2.dp
        modifier = Modifier
            .clickable {
                onClick(indexItem)
            },
    ) {
        OutTextMessage(
            message = message,
            sizeFontText = sizeFontText,
            isNormalStyle = isNormalStyle,
            isColorBackground = isColorBackground,
            isColorBorder = isColorBorder,
            isShapeLarge = isShapeLarge,
            isTextCenter = isTextCenter,
            maxLines = 2,
        )

    }

}