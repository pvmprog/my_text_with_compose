package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.BoundsTransform
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.data.Constants.boundsAnimationDurationMillis
import com.pvmprog.mytextwithcompose.ui.examples.data.DataItemProducts
import com.pvmprog.mytextwithcompose.ui.examples.data.ItemProduct
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ListProducts(
    isExpanded: Boolean = false,
    itemList: List<ItemProduct>
) {
    var showDetails by remember {
        mutableStateOf(false)
    }

    var item by remember {
        mutableStateOf(ItemProduct())
    }

//самый внешний макет, необходимый для реализации переходов общих элементов
    SharedTransitionLayout {
        AnimatedContent(
            targetState = showDetails,
            label = "basic_transition"
        ) { targetState ->
            if (!targetState) {
                MainContent(
                    itemList = itemList,
                    onShowDetails = {
                        showDetails = true
                        item = it
                    },
                    animatedVisibilityScope = this@AnimatedContent,
                    sharedTransitionScope = this@SharedTransitionLayout
                )
            } else {
                DetailsContent(
                    isExpanded = isExpanded,
                    item = item,
                    onBack = {
                      showDetails = false
                    },
                    animatedVisibilityScope = this@AnimatedContent,
                    sharedTransitionScope = this@SharedTransitionLayout
                )
            }
        }

    }

}

@OptIn(ExperimentalSharedTransitionApi::class)
private val boundsTransform = BoundsTransform { _: Rect, _: Rect ->
    tween(durationMillis = boundsAnimationDurationMillis, easing = FastOutSlowInEasing)
}


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
    itemList: List<ItemProduct>,
    onShowDetails: (ItemProduct) -> Unit = {},
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope

){
    with(sharedTransitionScope){
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            contentPadding = PaddingValues(4.dp),
            modifier = modifier
                .padding(8.dp)
                .sharedBounds(
                    rememberSharedContentState(key = "bounds"),
                    animatedVisibilityScope = animatedVisibilityScope,
                    enter = fadeIn(
                        tween(
                            boundsAnimationDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    ),
                    exit = fadeOut(
                        tween(
                            boundsAnimationDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    ),
                    boundsTransform = boundsTransform
                )

        ) {
            itemsIndexed(itemList) { _,item ->
//                ItemUI(item,onShowDetails)
                ItemSharedUI(item,onShowDetails,sharedTransitionScope,animatedVisibilityScope)
            }
        }

    }

}


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun DetailsContent(
    isExpanded: Boolean = false,
    item: ItemProduct,
    onBack: () -> Unit = {},
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
){

    with(sharedTransitionScope) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                val modifier = Modifier
                    .padding(top = 70.dp, start = 16.dp, end = 16.dp)
                    .sharedBounds(
                        rememberSharedContentState(key = "bounds"),
                        animatedVisibilityScope = animatedVisibilityScope,
                        enter = fadeIn(
                            tween(
                                durationMillis = boundsAnimationDurationMillis,
                                easing = FastOutSlowInEasing
                            )
                        ),
                        exit = fadeOut(
                            tween(
                                durationMillis = boundsAnimationDurationMillis,
                                easing = FastOutSlowInEasing
                            )
                        ),
                        boundsTransform = boundsTransform
                    )
                    .border(1.dp, Color.Gray.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                    .background(
                        MaterialTheme.colorScheme.secondaryContainer,
                        RoundedCornerShape(8.dp)
                    )
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        onBack()
                    }
                    .fillMaxSize()
                    .padding(8.dp)

//                if (isExpanded) DetailsExpandedItemUI(item,modifier)
//                else DetailsItemUI(item,modifier)

                if (isExpanded) DetailsSharedExpandedItemUI(item,modifier,sharedTransitionScope,animatedVisibilityScope)
                else DetailsSharedItemUI(item,modifier,sharedTransitionScope,animatedVisibilityScope)

            }
        }


    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun ItemSharedUI(
    item: ItemProduct,
    onItemClick: (ItemProduct) -> Unit = {},
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier,
){
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .requiredHeight(270.dp)  //296
            .clickable { onItemClick(item) },
        elevation = CardDefaults.cardElevation(),  //8.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            with(sharedTransitionScope) {

                Text(
                    text = stringResource(id = item.idTitle),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                        .sharedBounds(
                            rememberSharedContentState(key = "title ${item.idTitle}"),
                            animatedVisibilityScope = animatedVisibilityScope
                        )
                        .padding(top = 4.dp, bottom = 8.dp)
                )

                Image(
                    modifier = Modifier
                        .sharedElement(
                            rememberSharedContentState(key = "image ${item.idTitle}"),
                            animatedVisibilityScope = animatedVisibilityScope
                        )
                        .padding(16.dp)
                        .weight(1f),
                    painter = painterResource(id = item.idImage),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = setPriceString(item.price.toString()),
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .padding(top = 4.dp, bottom = 8.dp)
                )
            }

        }
    }

}


@Composable
private fun ItemUI(
    item: ItemProduct,
    onItemClick: (ItemProduct) -> Unit = {},
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .requiredHeight(270.dp)  //296
            .clickable { onItemClick(item) },
        elevation = CardDefaults.cardElevation(),  //8.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = item.idTitle),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .padding(top = 4.dp, bottom = 8.dp)
            )

            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                painter = painterResource(id = item.idImage),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Text(
                text = setPriceString(item.price.toString()),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(top = 4.dp, bottom = 8.dp)
            )

        }
    }

}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun DetailsSharedItemUI(
    item: ItemProduct,
    modifier: Modifier = Modifier
        .padding(top = 70.dp, start = 16.dp, end = 16.dp)
        .border(1.dp, Color.Gray.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
        .background(
            MaterialTheme.colorScheme.secondaryContainer,
            RoundedCornerShape(8.dp)
        )
        .padding(8.dp),
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,


){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        with(sharedTransitionScope) {
            Image(
                modifier = Modifier
                    .sharedElement(
                        rememberSharedContentState(key = "image ${item.idTitle}"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
                    .fillMaxWidth(),
                painter = painterResource(id = item.idImage),
                contentDescription = "",
            )
            Text(
                text = stringResource(id = item.idTitle),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .sharedBounds(
                        rememberSharedContentState(key = "title ${item.idTitle}"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
            )
            Text(
                text = stringResource(id = item.idComment),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                textAlign = TextAlign.Justify,
            )
            Text(
                text = setPriceString(item.price.toString()),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }

}


@Composable
private fun DetailsItemUI(
    item: ItemProduct,
    modifier: Modifier = Modifier
        .padding(top = 70.dp, start = 16.dp, end = 16.dp)
        .border(1.dp, Color.Gray.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
        .background(
            MaterialTheme.colorScheme.secondaryContainer,
            RoundedCornerShape(8.dp)
        )
        .padding(8.dp),
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(id = item.idImage),
            contentDescription = "",
        )
        Text(
            text = stringResource(id = item.idTitle),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(id = item.idComment),
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            textAlign = TextAlign.Justify,
        )
        Text(
            text = setPriceString(item.price.toString()),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Spacer(modifier = Modifier.height(4.dp))

    }

}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun DetailsSharedExpandedItemUI(
    item: ItemProduct,
    modifier: Modifier = Modifier
        .padding(top = 70.dp, start = 16.dp, end = 16.dp)
        .border(1.dp, Color.Gray.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
        .fillMaxWidth()
        .background(
            MaterialTheme.colorScheme.secondaryContainer,
            RoundedCornerShape(8.dp)
        )
        .padding(8.dp),
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,

){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
    ) {
        with(sharedTransitionScope) {
            Image(
                painter = painterResource(id = item.idImage),
                contentDescription = "",
                modifier = Modifier
                    .sharedElement(
                        rememberSharedContentState(key = "image ${item.idTitle}"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
                    .weight(1f),
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = stringResource(id = item.idTitle),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier
                        .sharedBounds(
                            rememberSharedContentState(key = "title ${item.idTitle}"),
                            animatedVisibilityScope = animatedVisibilityScope
                        )
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(id = item.idComment),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    textAlign = TextAlign.Justify,
                )


            }
        }

    }

}

@Composable
private fun DetailsExpandedItemUI(
    item: ItemProduct,
    modifier: Modifier = Modifier
        .padding(top = 70.dp, start = 16.dp, end = 16.dp)
        .border(1.dp, Color.Gray.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
        .fillMaxWidth()
        .background(
            MaterialTheme.colorScheme.secondaryContainer,
            RoundedCornerShape(8.dp)
        )
        .padding(8.dp),
){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
    ) {
        Image(
            painter = painterResource(id = item.idImage),
            contentDescription = "",
            modifier = Modifier
                .weight(1f),
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(id = item.idTitle),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
            Text(
                text = stringResource(id = item.idComment),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                textAlign = TextAlign.Justify,
            )


        }

    }

}



private fun setPriceString(priceStr:String = "0"):AnnotatedString = buildAnnotatedString {
    withStyle(
        style = ParagraphStyle(
            textAlign = TextAlign.Center,
        )
    ) {
        withStyle(
            style = SpanStyle(
                color = Color.Red,
                fontFamily = FontFamily.Cursive,
                fontSize = 24.sp
            )
        ) {
            append("$")
        }
        withStyle(
            style = SpanStyle(
                fontSize = 18.sp
            )
        ) {
            append(priceStr)
        }
    }
}


@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewItemUI() {
    MyTextWithComposeTheme {
        ItemUI(
            modifier = Modifier
                .width(150.dp),
            item = DataItemProducts.listProducts[0],
        )
    }

}


@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun  DetailsItemUIPreview() {
    MyTextWithComposeTheme {
        DetailsItemUI(DataItemProducts.listProducts[0])
    }
}



@Preview("Light Theme", showBackground = true,widthDp = 1000,heightDp = 400)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES,widthDp = 1000,heightDp = 400)
@Composable
fun  DetailsItemUIPreviewExpanded() {
    MyTextWithComposeTheme {
        DetailsExpandedItemUI(DataItemProducts.listProducts[0])
    }
}





