package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun AnimationTransition() {
    var visible by remember { mutableStateOf(false) }
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
                val background by transition.animateColor(label = "color") { state ->
                    if (state == EnterExitState.Visible) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.onError
                }
                Box(
                    Modifier
                        .padding(16.dp)
                        .animateEnterExit(
                            // Slide in/out the rounded rect
                            enter = slideInVertically(tween(500,200)),
                            exit = slideOutVertically(spring(stiffness = 50f))
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .requiredHeight(100.dp)
                        .fillMaxWidth()
                        .background(background),
                    contentAlignment = Alignment.Center
                ) {
                    // Content of the notification goes here
                    Text(
                        text = "Hello, World!",
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                            .animateEnterExit(
                                // Slide in/out the rounded rect
                                enter = scaleIn() + expandVertically(expandFrom = Alignment.CenterVertically),
                                exit = scaleOut() + shrinkVertically(shrinkTowards = Alignment.CenterVertically)
                            ),
                        fontSize = 50.sp,
                        fontFamily = FontFamily.Cursive,
                    )
                }
            }
        }

    }

}
@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnimationTransitionPreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AnimationTransition()
        }

    }
}
