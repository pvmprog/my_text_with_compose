package com.pvmprog.mytextwithcompose.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.R

@Composable
fun CodeText(
    annotatedString: AnnotatedString,
){
    Box(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState())
    ) {
        SelectionContainer {
            Text(
                text = annotatedString,
                modifier = Modifier
                    .padding(top = dimensionResource(id = R.dimen.padding_small))
                    .fillMaxWidth()
                    .alpha(1.0f)
                    .drawBehind {
                        drawRoundRect(
                            Color.Black,
                            cornerRadius = CornerRadius(16.dp.toPx())
                        )
                    }
                    .border(
                        width = 1.dp,
                        color = Color.Yellow,
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.roundedCornerSmall))
                    )
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                color = colorResource(id = R.color.code_text),   //MaterialTheme.colorScheme.onTertiaryContainer,
            )

        }

    }

}