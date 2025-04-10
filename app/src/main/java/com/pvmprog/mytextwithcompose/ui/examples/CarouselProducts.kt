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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.data.Constants
import com.pvmprog.mytextwithcompose.ui.examples.data.DataItemProducts.listProducts
import com.pvmprog.mytextwithcompose.ui.examples.data.ItemProduct
import com.pvmprog.mytextwithcompose.ui.theme.Alice
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme


@OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)
@Composable
fun CarouselProducts(
    isExpanded: Boolean = false,
    items: List<ItemProduct> = listProducts
) {
    var showDetails by remember {
        mutableStateOf(false)
    }

    var product by remember {
        mutableStateOf(ItemProduct())
    }

    SharedTransitionLayout {
        AnimatedContent(
            targetState = showDetails,
            label = "basic_transition"
        ) { targetState ->
            if (!targetState) {
                MainContent(
                    items = items,
                    onShowDetails = {
                        showDetails = true
                        product = it
                    },
                    animatedVisibilityScope = this@AnimatedContent,
                    sharedTransitionScope = this@SharedTransitionLayout
                )
            } else {
                DetailsContent(
                    isExpanded = isExpanded,
                    item = product,
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
    tween(durationMillis = Constants.boundsAnimationDurationMillis, easing = FastOutSlowInEasing)
}


@OptIn(ExperimentalSharedTransitionApi::class, ExperimentalMaterial3Api::class)
@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
    items: List<ItemProduct>,
    onShowDetails: (ItemProduct) -> Unit = {},
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope

) {
    with(sharedTransitionScope) {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .sharedBounds(
                    rememberSharedContentState(key = "bounds"),
                    animatedVisibilityScope = animatedVisibilityScope,
                    enter = fadeIn(
                        tween(
                            Constants.boundsAnimationDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    ),
                    exit = fadeOut(
                        tween(
                            Constants.boundsAnimationDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    ),
                    boundsTransform = boundsTransform
                )
                .background(MaterialTheme.colorScheme.tertiaryContainer)

        ) {
            item {
                HorizontalMultiBrowseCarousel(
                    state = rememberCarouselState { items.count() },
                    modifier = Modifier
                        .width(412.dp)
                        .height(281.dp),
                    preferredItemWidth = 186.dp,
                    itemSpacing = 8.dp,
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) { i ->
                    val item = items[i]
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        with(sharedTransitionScope) {
                            Text(
                                text = stringResource(item.titleResId),
                                modifier = Modifier
                                    .sharedBounds(
                                        rememberSharedContentState(key = "title ${item.titleResId}"),
                                        animatedVisibilityScope = animatedVisibilityScope
                                    ),
                                color = MaterialTheme.colorScheme.onSecondaryContainer,                        )
                            Image(
                                modifier = Modifier
                                    .height(205.dp)
                                    .sharedElement(
                                        rememberSharedContentState(key = "image ${item.titleResId}"),
                                        animatedVisibilityScope = animatedVisibilityScope
                                    )
                                    .clickable { onShowDetails(item) }
                                    .maskClip(MaterialTheme.shapes.extraLarge),
                                painter = painterResource(id = item.imageResId),
                                contentDescription = stringResource(item.contentDescriptionResId),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = setPriceString(item.price.toString()),
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .sharedBounds(
                                        rememberSharedContentState(key = "price ${item.titleResId}"),
                                        animatedVisibilityScope = animatedVisibilityScope
                                    )
                                    .padding(top = 4.dp, bottom = 8.dp)
                            )

                        }
                    }
                }
                Text(
                    text = myDescription(),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )

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
                    .padding(top = 20.dp, start = 16.dp, end = 16.dp)
                    .sharedBounds(
                        rememberSharedContentState(key = "bounds"),
                        animatedVisibilityScope = animatedVisibilityScope,
                        enter = fadeIn(
                            tween(
                                durationMillis = Constants.boundsAnimationDurationMillis,
                                easing = FastOutSlowInEasing
                            )
                        ),
                        exit = fadeOut(
                            tween(
                                durationMillis = Constants.boundsAnimationDurationMillis,
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

                if (isExpanded) DetailsSharedExpandedItemUI(item,modifier,sharedTransitionScope,animatedVisibilityScope)
                else DetailsSharedItemUI(item,modifier,sharedTransitionScope,animatedVisibilityScope)

            }
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
                        rememberSharedContentState(key = "image ${item.titleResId}"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
                    .fillMaxWidth(),
                painter = painterResource(id = item.imageResId),
                contentDescription = "",
            )
            Text(
                text = stringResource(id = item.titleResId),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .sharedBounds(
                        rememberSharedContentState(key = "title ${item.titleResId}"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
            )
            Text(
                text = stringResource(id = item.contentDescriptionResId),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                textAlign = TextAlign.Justify,
            )
            Text(
                text = setPriceString(item.price.toString()),
                modifier = Modifier
                    .sharedBounds(
                        rememberSharedContentState(key = "price ${item.titleResId}"),
                        animatedVisibilityScope = animatedVisibilityScope
                    ),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
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
                painter = painterResource(id = item.imageResId),
                contentDescription = "",
                modifier = Modifier
                    .sharedElement(
                        rememberSharedContentState(key = "image ${item.titleResId}"),
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
                    text = stringResource(id = item.titleResId),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier
                        .sharedBounds(
                            rememberSharedContentState(key = "title ${item.titleResId}"),
                            animatedVisibilityScope = animatedVisibilityScope
                        )
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(id = item.contentDescriptionResId),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    textAlign = TextAlign.Justify,
                )


            }
        }

    }

}



@Composable
fun myDescription(
    fontSize:Int = 18,
    style:SpanStyle = SpanStyle(
        fontSize = fontSize.sp,
        fontFamily = Alice,
        fontStyle = FontStyle.Italic,
    )
): AnnotatedString = buildAnnotatedString {
    withStyle(
        style = style.merge(
            SpanStyle(
                color = MaterialTheme.colorScheme.onTertiaryContainer,
            )
        )
    ) {
        append("Изготовление металлоконструкций любой сложности. ")
    }

    withStyle(
        style = style.merge(
            SpanStyle(
                fontSize = (fontSize-4).sp
            )
        )    ){
        append("Имею большой опыт работы с металлом и знаю, как создать конструкции, которые будут надежными и прочными. Использую только качественные материалы, соответствующие высоким стандартам качества.")
    }
    withStyle(
        style = style.merge(
            SpanStyle(
                fontSize = (fontSize-4).sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondaryContainer,

            )
        )    ){
        append(" Инновационные решения и самые передовые технологии помогают добиться хороших результатов. ")
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
                fontSize = 20.sp
            )
        ) {
            append("$")
        }
        withStyle(
            style = SpanStyle(
                fontSize = 14.sp
            )
        ) {
            append(priceStr)
        }
    }
}


@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HorizontalCarouselPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            CarouselProducts()
        }

    }
}

