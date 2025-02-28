package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.animateZoomBy
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
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
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme
import kotlinx.coroutines.launch
import kotlin.math.max

@Composable
fun OutSipmleArticle(
    title: String = "Адаптация UI/UX для людей с проблемами зрения",
    article: String = """
   Для определения размера шрифта всегда используйте |sp|.

     Если ваш дизайн предполагает, что весь текст всегда должен быть виден, а размер шрифта варьируется в зависимости от предпочтений пользователя, необходимо обеспечить |скроллинг|.
     
     |Скроллинг| («просматривание; прокрутка») — форма представления информации, при которой содержимое (текст, изображение) двигается (прокручивается) в вертикальном или горизонтальном направлении.
                  
     При использовании изображения, которое несет определенную информацию, необходимо назначить текстовое описание для параметра |contentDescription|, которое описывает изображение. Оно будет прочитано программами чтения с экрана, когда они столкнутся с картинкой.                   
 
     Не везде есть смысл использовать |contentDescription|. Чисто декоративные изображения, которые не имеют значения, должны иметь значение |@null|.
 
  Инструкция по изменению размера шрифта в этом примере:
     
        |Для увеличения размера шрифта| используйте жест "растягивания" - сведите два пальца вместе, торкнитесь экрана и плавно, |двигаясь по экрану|, растяните пальцы.
        
        |Для уменьшения размера экрана| используйте жесты "сужения".
        
            """.trimIndent(),
    sizeFontText: Int = 18,     //: TextUnit = 18.sp
    isNormalStyle: Boolean = true,
    isColorBackground: Boolean = false,
    isColorBorder: Boolean = false,
    isShapeLarge: Boolean = false,
    isTextCenter: Boolean = false,
) {


    val colorBackground = MaterialTheme.colorScheme.tertiaryContainer

    Column(
        Modifier
            .fillMaxSize()
            .background(colorBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // set scale transformation states
        var scale by remember {
            mutableFloatStateOf(1f)
        }

        val context = LocalContext.current

        val coroutineScope = rememberCoroutineScope()

        val state = rememberTransformableState { zoomChange,
                                                 offsetChange,
                                                 rotationChange ->
            scale = max(
                a = scale * zoomChange,
                b = 0.5f
            )
        }

        val sizeTitle = ((sizeFontText + 2) * scale).sp
        val sizeFirstArticle = ((sizeFontText + 6) * scale).sp
        val sizeArticle = (sizeFontText * scale).sp


        val color = MaterialTheme.colorScheme.outline


        val annotatedString = buildAnnotatedString {

            withStyle(
                style = ParagraphStyle(
                    lineHeight = sizeTitle,
                    textAlign = TextAlign.Center
                )
            ) {
                withStyle(
                    style = SpanStyle(
                        fontSize = sizeTitle,
                        fontWeight = FontWeight.Bold,
                    )
                ) {
                    append(title)
                }

            }

            withStyle(
                style = ParagraphStyle(
                    lineHeight = sizeArticle
                )
            ) {
//Первый символ статьи
                withStyle(
                    style = SpanStyle(
                        color = Color.Red,
                        fontSize = sizeFirstArticle,
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold,
                    )
                ) {
                    append(article[0])
                }

                val remainder = article.substring(1)

//разбивка статьи на фрагменты, разделенные символом "|"
                val messageArrayList = remainder.split("|")

                if (messageArrayList.size < 2) append(remainder)
                else {
                    messageArrayList.forEachIndexed { index, s ->
                        if (index % 2 != 0) {
                            withStyle(
                                style = SpanStyle(
                                    color = color,
                                    fontWeight = FontWeight.Bold,
                                )
                            ) {
                                append(s)
                            }

                        } else {
                            append(s)
                        }
                    }

                }

            }
        }

        Column(
            Modifier
                //прослушивание событий мультитач-преобразования
                .transformable(state = state)
                .verticalScroll(rememberScrollState())
                //двойной щелчок для масштабирования
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            Toast
                                .makeText(
                                    context, "Double click ",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                            if (scale == 1f) {
                                coroutineScope.launch {
                                    state.animateZoomBy(1.5f)
                                }
                            } else {
                                scale = 1f
                            }
                        }
                    )
                }
                .fillMaxSize()
                .border(1.dp, Color.DarkGray),
        ) {
            Text(
                text = annotatedString,
                style = if (isNormalStyle) MaterialTheme.typography.bodyMedium   //labelLarge  bodyLarge
                else MaterialTheme.typography.bodySmall,
                fontSize = sizeArticle,
                color = when {
                    isColorBackground -> MaterialTheme.colorScheme.background  //по умолчанию Color.Unspecified
                    else -> MaterialTheme.colorScheme.onTertiaryContainer
                },
                modifier = Modifier
                    .padding(top = dimensionResource(id = R.dimen.padding_medium))
                    .fillMaxWidth()
                    .alpha(if (isNormalStyle) 1.0f else 0.6f)
                    .clip(
                        shape = when {
                            isShapeLarge -> RoundedCornerShape(dimensionResource(id = R.dimen.roundedCornerCicle))
                            else -> RoundedCornerShape(5.dp)
                        }
                    )
                    .background(
                        color = when {
                            isColorBackground -> MaterialTheme.colorScheme.primary
                            else -> MaterialTheme.colorScheme.tertiaryContainer  //fon
                        }
                    )
                    .border(
                        width = 1.dp,
                        color = when {
                            isColorBorder -> MaterialTheme.colorScheme.primary
                            else -> MaterialTheme.colorScheme.tertiaryContainer  //fon
                        },
                        shape = when {
                            isShapeLarge -> RoundedCornerShape(dimensionResource(id = R.dimen.roundedCornerCicle))
                            else -> RoundedCornerShape(5.dp)
                        }
                    )
                    .padding(all = dimensionResource(id = R.dimen.padding_small)),
                textAlign = if (isTextCenter) {
                    TextAlign.Center
                } else {
                    TextAlign.Left
                }

            )

        }

    }
}

@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OutSipmleArticlePreview() {
    MyTextWithComposeTheme {
        OutSipmleArticle(
            sizeFontText = 18,
            isNormalStyle = true,
            isColorBackground = false,
            isColorBorder = true,
            isShapeLarge = false,
            isTextCenter = false
        )
    }
}
