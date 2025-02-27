package com.pvmprog.mytextwithcompose.data.locale

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.withStyle
import com.pvmprog.mytextwithcompose.data.model.HighlightCode

object DataHighCode {
    val highCodeList = listOf(
        HighlightCode("@Composable", Color(0xFFb2c231)),

        HighlightCode("fun ", Color(0xFFd27749)),
        HighlightCode("class", Color(0xFFd27749)),
        HighlightCode("val", Color(0xFFd27749)),
        HighlightCode("var", Color(0xFFd27749)),
        HighlightCode("false", Color(0xFFd27749)),
        HighlightCode("true", Color(0xFFd27749)),
        HighlightCode(".padding", Color(0xFFF5996B)),
        HighlightCode(".fillMaxWidth", Color(0xFFF5996B)),
        HighlightCode(".fillMaxSize", Color(0xFFF5996B)),
        HighlightCode(".background(", Color(0xFFF5996B)),
        HighlightCode(".border", Color(0xFFF5996B)),
        HighlightCode("items", Color(0xFFF5996B)),
        HighlightCode("withStyle", Color(0xFFF5996B)),



        /*
                HighlightCode("items", Color(0xFFF5996B)),
                HighlightCode("withStyle", Color(0xFFF5996B)),
                HighlightCode(".clickable", Color(0xFFF5996B)),
                HighlightCode(".clip", Color(0xFFF5996B)),
        HighlightCode("data", Color(0xFFd27749)),
        HighlightCode(".repeat", Color(0xFFd27749)),

         */

        HighlightCode("when", Color(0xFFB84E18)),
        HighlightCode("else", Color(0xFFB84E18)),
        HighlightCode("if ", Color(0xFFB84E18)),
        HighlightCode("weight", Color(0xFFB84E18)),
/*
        HighlightCode("drawText", Color(0xFFB84E18)),
        HighlightCode("withTransform", Color(0xFFB84E18)),

 */



        HighlightCode("remember", Color(0xFF05B80D)),
        HighlightCode("LazyColumn", Color(0xFF05B80D)),
        HighlightCode("Text ", Color(0xFF05B80D)),
        HighlightCode("Column", Color(0xFF05B80D)),
        HighlightCode("Row", Color(0xFF05B80D)),
        HighlightCode("Box", Color(0xFF05B80D)),
        HighlightCode(".colorScheme", Color(0xFF05B80D)),
        HighlightCode("stringResource", Color(0xFF05B80D)),
        HighlightCode("dimensionResource", Color(0xFF05B80D)),
        HighlightCode("colorResource", Color(0xFF05B80D)),
        HighlightCode("Hello, World!", Color(0xFF05B80D)),
        HighlightCode("rememberInfiniteTransition", Color(0xFF05B80D)),
        HighlightCode("animateFloat", Color(0xFF05B80D)),


/*
        HighlightCode("Surface", Color(0xFF0D8113)),
        HighlightCode(".typography", Color(0xFF0D8113)),
        HighlightCode(".current", Color(0xFF0D8113)),
        HighlightCode("isSystemInDarkTheme", Color(0xFF0D8113)),
        HighlightCode("rememberInfiniteTransition", Color(0xFF0D8113)),
        HighlightCode(".animateFloat", Color(0xFF0D8113)),
        HighlightCode("Canvas ", Color(0xFF0D8113)),
        HighlightCode("rememberTextMeasurer", Color(0xFF0D8113)),
        HighlightCode("linearGradient", Color(0xFF0D8113)),
        HighlightCode("horizontalGradient", Color(0xFF0D8113)),
        HighlightCode("verticalGradient", Color(0xFF0D8113)),
        HighlightCode(".sweepGradient", Color(0xFF0D8113)),
        HighlightCode(".radialGradient", Color(0xFF0D8113)),

 */

        HighlightCode("text =", Color(0xFF00a9ff)),
        HighlightCode("fontSize =", Color(0xFF00a9ff)),
        HighlightCode("style = ", Color(0xFF00a9ff)),
        HighlightCode("modifier =", Color(0xFF00a9ff)),
        HighlightCode("color =", Color(0xFF2DB8FF)),
        HighlightCode("textAlign =", Color(0xFF2DB8FF)),
        HighlightCode("fontFamily =", Color(0xFF2DB8FF)),
        HighlightCode("contentAlignment =", Color(0xFF2DB8FF)),
        HighlightCode("horizontalAlignment =", Color(0xFF2DB8FF)),
        HighlightCode("verticalArrangement =", Color(0xFF2DB8FF)),
        HighlightCode("animationSpec =", Color(0xFF2DB8FF)),
        HighlightCode("animation = ", Color(0xFF2DB8FF)),
        HighlightCode("repeatMode =", Color(0xFF2DB8FF)),
        HighlightCode("easing = ", Color(0xFF2DB8FF)),

                /*
                        HighlightCode("textMeasurer =", Color(0xFF2DB8FF)),
                        HighlightCode("indexSelect =", Color(0xFF2DB8FF)),
                        HighlightCode("initialValue =", Color(0xFF2DB8FF)),
                        HighlightCode("targetValue =", Color(0xFF2DB8FF)),
                        HighlightCode("animationSpec =", Color(0xFF2DB8FF)),
                        HighlightCode("animation =", Color(0xFF2DB8FF)),
                        HighlightCode("easing =", Color(0xFF2DB8FF)),
                        HighlightCode("repeatMode =", Color(0xFF2DB8FF)),
                        HighlightCode("StartDp =", Color(0xFF2DB8FF)),
                        HighlightCode("endDp =", Color(0xFF2DB8FF)),
                        HighlightCode("tileMode =", Color(0xFF2DB8FF)),
                        HighlightCode("offset =", Color(0xFF2DB8FF)),
                        HighlightCode("blurRadius =", Color(0xFF2DB8FF)),
                        HighlightCode("overflow =", Color(0xFF2DB8FF)),
                        HighlightCode("maxLines =", Color(0xFF2DB8FF)),
                        HighlightCode("brushColors =", Color(0xFF2DB8FF)),
                        HighlightCode("alignment =", Color(0xFF2DB8FF)),
                        HighlightCode("trim =", Color(0xFF2DB8FF)),
                        HighlightCode("shadow =", Color(0xFF2DB8FF)),
                        HighlightCode("bottom =", Color(0xFF2DB8FF)),
                        HighlightCode("top =", Color(0xFF2DB8FF)),
                        HighlightCode("platformStyle =", Color(0xFF2DB8FF)),
                        HighlightCode("includeFontPadding =", Color(0xFF2DB8FF)),
                        HighlightCode("lineHeight =", Color(0xFF2DB8FF)),
                        HighlightCode("fontWeight =", Color(0xFF00a9ff)),
                        HighlightCode("label =", Color(0xFF2DB8FF)),
                        HighlightCode("durationMillis =", Color(0xFF2DB8FF)),

                 */



        HighlightCode(".sp", Color(0xFFe48def)),
        HighlightCode(".dp", Color(0xFFe48def)),
        HighlightCode(".padding_medium", Color(0xFFe48def)),
        HighlightCode(".Center", Color(0xFFe48def)),
        HighlightCode(".CenterHorizontally", Color(0xFFe48def)),
        HighlightCode(".background ", Color(0xFFe48def)),
        HighlightCode(".onBackground", Color(0xFFe48def)),
        HighlightCode(".hello_world", Color(0xFFe48def)),
        HighlightCode(".Reverse", Color(0xFFe48def)),
        HighlightCode("LinearEasing", Color(0xFFe48def)),
        HighlightCode(".Black", Color(0xFFe48def)),
        HighlightCode(".White", Color(0xFFe48def)),


        /*
        HighlightCode(".value", Color(0xFFe48def)),
        HighlightCode(".Unspecified", Color(0xFFe48def)),
        HighlightCode("Alice", Color(0xFFe48def)),
        HighlightCode(".padding_small", Color(0xFFe48def)),
        HighlightCode(".padding_large", Color(0xFFe48def)),
        HighlightCode(".em", Color(0xFFe48def)),
        HighlightCode(".Left", Color(0xFFe48def)),
        HighlightCode(".Start", Color(0xFFe48def)),
        HighlightCode(".End", Color(0xFFe48def)),
        HighlightCode(".Bottom", Color(0xFFe48def)),
        HighlightCode(".size", Color(0xFFe48def)),
        HighlightCode(".Clamp", Color(0xFFe48def)),
        HighlightCode(".Cyan", Color(0xFFe48def)),
        HighlightCode(".Yellow", Color(0xFFe48def)),
        HighlightCode(".Green", Color(0xFFe48def)),
        HighlightCode(".Blue", Color(0xFFe48def)),
        HighlightCode(".Black", Color(0xFFe48def)),
        HighlightCode(".White", Color(0xFFe48def)),

        HighlightCode("LinearEasing", Color(0xFFe48def)),
        HighlightCode(".Reverse", Color(0xFFe48def)),
        HighlightCode("floatValue", Color(0xFFe48def)),
                HighlightCode(".titleLarge", Color(0xFFe48def)),
                HighlightCode(".titleMedium", Color(0xFFe48def)),
                HighlightCode(".titleSmall", Color(0xFFe48def)),
                HighlightCode(".Italic", Color(0xFFe48def)),
                HighlightCode(".Normal", Color(0xFFe48def)),
                HighlightCode(".Bold", Color(0xFFe48def)),
                HighlightCode(".ExtraBold", Color(0xFFe48def)),
                HighlightCode(".Light", Color(0xFFe48def)),
                HighlightCode(".W100", Color(0xFFe48def)),
                HighlightCode(".W300", Color(0xFFe48def)),
                HighlightCode(".W900", Color(0xFFe48def)),
                HighlightCode(".Right", Color(0xFFe48def)),
                HighlightCode(".bodyMedium", Color(0xFFe48def)),
                HighlightCode(".bodySmall", Color(0xFFe48def)),
                HighlightCode(".bodyLarge", Color(0xFFe48def)),
                HighlightCode(".Justify", Color(0xFFe48def)),
                HighlightCode("LocalTextStyle", Color(0xFFe48def)),
                HighlightCode(".LastLineBottom", Color(0xFFe48def)),
                HighlightCode(".Ellipsis", Color(0xFFe48def)),

                HighlightCode(".secondary", Color(0xFFe48def)),
                HighlightCode(".onSecondary", Color(0xFFe48def)),
                HighlightCode(".secondaryContainer", Color(0xFFe48def)),
                HighlightCode(".onSecondaryContainer", Color(0xFFe48def)),
                HighlightCode(".tertiaryContainer", Color(0xFFe48def)),
                HighlightCode(".onTertiaryContainer", Color(0xFFe48def)),

                HighlightCode(".red700", Color(0xFFe48def)),
                HighlightCode("center.x", Color(0xFFe48def)),
                HighlightCode("center.y", Color(0xFFe48def)),
                HighlightCode("size.width", Color(0xFFe48def)),
                HighlightCode("size.height", Color(0xFFe48def)),
                HighlightCode(".сontrast", Color(0xFFe48def)),
                HighlightCode("colors", Color(0xFFe48def)),
                HighlightCode("LocalTextStyle", Color(0xFFe48def)),
                HighlightCode("LocalContext", Color(0xFFe48def)),
                HighlightCode(".SpaceAround", Color(0xFFe48def)),
                HighlightCode(".SpaceBetween", Color(0xFFe48def)),
                HighlightCode(".SpaceEvenly", Color(0xFFe48def)),

         */


        HighlightCode(".spacedBy", Color(0xFFFFFFFF)),

        HighlightCode("//", Color(0xFF3CEE0A)),
    )


}