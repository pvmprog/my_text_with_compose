package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun AnimationChildren(
    isScreenExpanded: Boolean = false,
) {
    var visible by remember { mutableStateOf(true) }
    val aspectModifier = if (isScreenExpanded) Modifier.aspectRatio(1.5f)
    else Modifier.aspectRatio(1f)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable { visible = !visible },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Click me...")
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            // Fade in/out the background and foreground
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = aspectModifier
                        .animateEnterExit(
                            // Slide in/out the rounded rect
                            enter = slideInVertically(),
                            exit = slideOutVertically()
                        )
                        .clip(RoundedCornerShape(10.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bg2),
                        contentDescription = null,
                        modifier = Modifier
                            .alpha(0.9f)
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                    Image(
                        painter = painterResource(id = R.drawable.earth),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(150.dp)
                            .animateEnterExit(
                                // Slide in/out the rounded rect
                                enter = scaleIn(
                                    animationSpec = tween(1000, easing = LinearOutSlowInEasing)
                                ) + expandVertically(expandFrom = Alignment.CenterVertically),
                                exit = scaleOut(
                                    animationSpec = tween(1000, easing = LinearOutSlowInEasing)
                                ) + shrinkVertically(shrinkTowards = Alignment.CenterVertically)
                            ),
                        contentScale = ContentScale.Crop,
                    )
                    Box(
                        modifier = aspectModifier,
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Text(
                            text = "Hello, World!",
                            color = Color.Cyan,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier
                                .padding(16.dp)
                                .animateEnterExit(
                                    // Slide in/out the rounded rect
                                    enter = expandIn(
// Перезаписывает стандартную пружинную анимацию с помощью tween
                                        animationSpec = tween(1000, easing = LinearOutSlowInEasing),
// Перезаписывает угол содержимого, который был показан первым
                                        expandFrom = Alignment.BottomStart
                                    ) {
// Изменяет начальный размер на width=50 , height=50 пикселей
                                        IntSize(50, 50)
                                    },
                                    exit = scaleOut() + shrinkVertically(shrinkTowards = Alignment.CenterVertically)
                                ),
                            fontSize = 45.sp,
                            lineHeight = 45.sp,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily.Cursive,
                        )

                    }

                }
            }
        }

    }

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnimationChildrenPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AnimationChildren()
        }

    }
}
@Preview("Light Theme",showBackground = true, heightDp = 400, widthDp = 1000)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, heightDp = 400,widthDp = 1000)
@Composable
fun AnimationChildrenPreview2() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AnimationChildren(isScreenExpanded = true)
        }

    }
}

