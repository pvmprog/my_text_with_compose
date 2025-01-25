package com.pvmprog.mytextwithcompose.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.data.locale.DataCodeUI
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme

@Composable
fun ResultScreen(
    modifier: Modifier = Modifier,
    item: ExampleCode = DataCodeUI.codeUI[0]
){
    val spacerModifier = Modifier
        .height(2.dp)
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.primary)
        .padding(dimensionResource(id = R.dimen.padding_medium))

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.tertiaryContainer)
            .padding(dimensionResource(id = R.dimen.padding_small)),
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(R.dimen.card_elevation)),  //2.dp
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
            ){
                Spacer(modifier = spacerModifier)

                item.lambdaFun()

                /*

            when (index) {
                0 -> SimpleText()
                1 -> SimplePaddingText()
                2 -> StringResourceText()
                3 -> ColorText()      //color = Color.Blue
                4 -> TextFontSize()   //fontSize = 30.sp
                5 -> ItalicText()     //FontStyle.Italic
                6 -> BoldText()       //fontWeight = FontWeight.Bold
                7 -> AlignText()         //textAlign
                8 -> TextAlignJustify()  //textAlign
                9 -> TextAlignedHeight() //LineHeightStyle alignment
                10 -> TextShadow()        //shadow = Shadow(color = Color.Blue, offset = offset, blurRadius = 3f)
                11 -> TextFontFamily()   //fontFamily = FontFamily.Serif
                12 -> TextFontFamalyAlternate() //fontStyle = FontStyle.Italic
                13 -> MultipleStylesInText() //buildAnnotatedString withStyle
                14 -> TextBuildAnnotatedString1() //buildAnnotatedString pushStringAnnotation annotation
                15 -> TextAnnotatedStringClickLink() //buildAnnotatedString ClickableText addStyle addStringAnnotation
                16 -> TextBuildAnnotatedString() //buildAnnotatedString addStyle
                17 -> TextBuildAnnotatedString3() //buildAnnotatedString append
                18 -> AnnotatedHtmlString() //buildAnnotatedString append
                            19 -> LongText()  //maxLines OverflowedText
                            20 -> TextLetterSpacingExample(isExit = false)
                            21 -> TextStyledBrush() //TextStyle Brush.linearGradient
                            22 -> TextStyledBrushAnnotated() //buildAnnotatedString SpanStyle Brush.linearGradient
                            23 -> TextDecorationExample(isExit = false)
                            24 -> SelectableText(isExit = false) //SelectionContainer
                //---
                            24 -> TextClickableText() //real-> OutSipmleArticle()
                //---
                            25 -> TextClickableText() //SelectionContainer Column DisableSelection
                            26 -> TextBorderExamples(isExit = false)
                            27 -> TextBorderExamples3(isExit = false)
                            28 -> BorderTrianglesShape2(isExit = false)
                            29 -> SimpleBackgroundAGSL(indexSelect = 3)
                            30 -> ShaderTextDemoAnimate()
                }
            */

                Spacer(modifier = spacerModifier)

            }

        }


    }
}

@Preview("Light Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewResultScreen() {
    MyTextWithComposeTheme {
        ResultScreen(
            item = DataCodeUI.codeUI[18]
        )
    }
}
