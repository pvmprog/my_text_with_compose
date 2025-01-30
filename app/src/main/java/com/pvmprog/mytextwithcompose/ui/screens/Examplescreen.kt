package com.pvmprog.mytextwithcompose.ui.screens

import android.content.res.Configuration
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.data.Constants.defaultFontSizeCode
import com.pvmprog.mytextwithcompose.data.Constants.maxFontSizeCode
import com.pvmprog.mytextwithcompose.data.Constants.minFontSizeCode
import com.pvmprog.mytextwithcompose.data.locale.DataCodeUI
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import com.pvmprog.mytextwithcompose.ui.service.OutTextMessage
import com.pvmprog.mytextwithcompose.ui.service.TextWithLink
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme
import com.pvmprog.mytextwithcompose.ui.topbar.TopSubBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Examplescreen(
    selectedDestination: Int = 1, //1-result+code; 2-theory 3-links
    isExpanded: Boolean = false,
    indexExample: Int = 0,
    itemList: List<ExampleCode> = DataCodeUI.codeUI,
    onNext: (Int) -> Unit = {},

    ) {
    var isAllView by remember { mutableStateOf(true) }


    //BackHandler для обнаружения нажатий на кнопку «Назад» устройства внутри Compose
    BackHandler(
        // your condition to enable handler
        enabled = true
    ) {
        isAllView = true
        onNext(-1)
    }

    val example = if (indexExample < itemList.size) itemList[indexExample]
    else ExampleCode()

    val context =  LocalContext.current

    val spacerModifier = Modifier
        .padding(horizontal = dimensionResource(id = R.dimen.padding_small))
        .height(2.dp)
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.primary)
        .padding(dimensionResource(id = R.dimen.padding_medium))

    var fontSizeCode by remember {
        mutableIntStateOf(defaultFontSizeCode)     //18.sp
    }

    val modifierIcon = Modifier
        .padding(
            top = 60.dp,
            bottom = 10.dp,
            start = 10.dp,
            end = 10.dp
        )

    Scaffold(
        topBar = {
            TopSubBar(
                title = example.title,
                navigateUp = {
                    onNext(indexExample - 1) //indexExample - 1
                    isAllView = true
                }
            )
        },
        floatingActionButton = {
            Row(
                Modifier
                    .padding(10.dp)
            ) {
/*
Как добавить иконки в проект В Android Studio смотрите по ссылке:
  https://developer.android.com/studio/write/vector-asset-studio?hl=ru#svg
или можно загрузит файлы иконок из сайта Google Fonts в разделе Icons и поместить их в папку res/draweble
  https://fonts.google.com/icons?selected=Material+Symbols+Outlined:pip_exit:FILL@0;wght@400;GRAD@0;opsz@24&icon.size=24&icon.color=%235f6368

 */

                //Установить маштаб по умолчанию
                if (fontSizeCode != defaultFontSizeCode){
                    Icon(
                        imageVector = Icons.Filled.Clear,
//                    painter = painterResource(id = R.drawable.baseline_disabled_by_default_24),
                        contentDescription = stringResource(R.string.zoom_is_default),
                        modifier = modifierIcon
                            .background(MaterialTheme.colorScheme.background)
                            .clickable {
                                fontSizeCode = defaultFontSizeCode
                            },
                    )

                }

                //Увеличить маштаб
                Icon(
                    painter = painterResource(id = R.drawable.zoom_in_24px),
                    contentDescription = stringResource(R.string.zoom_in),
                    modifier = modifierIcon
                        .background(MaterialTheme.colorScheme.inversePrimary)
                        .clickable {
                            fontSizeCode += 2
                            if (fontSizeCode > maxFontSizeCode) fontSizeCode = maxFontSizeCode
                        },
                )

                //Уменьшить маштаб
                Icon(
                    painter = painterResource(id = R.drawable.zoom_out_24px),
                    contentDescription = stringResource(R.string.zoom_out),
                    modifier = modifierIcon
                        .background(MaterialTheme.colorScheme.inversePrimary)
                        .clickable {
                            fontSizeCode -= 2
                            if (fontSizeCode < minFontSizeCode) fontSizeCode = minFontSizeCode
                        },
                )

                //переход на следующий пример
                FloatingActionButton(
                    onClick = {
                        var index = indexExample + 1
                        if (index >= itemList.size) index = 0
                        isAllView = true
                        onNext(index)
                    },
                    shape = MaterialTheme.shapes.medium, //  shape = Shapes.medium,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = stringResource(R.string.next)
                    )
                }

            }
        }
    ) {
        Surface(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            when (selectedDestination){
//result+code
                1 -> {
                    if (isExpanded) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            if (isAllView){
                                LazyColumn(
                                    modifier = Modifier.weight(1f),
                                ) {
                                    item {
                                        ResultScreen(
                                            item = example
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_spacer)))

                            }
                            LazyColumn(
                                modifier = Modifier.weight(1f),
                            ) {
                                item {
                                    CodeScreen(
                                        item = example,
                                        fontSizeCode = fontSizeCode,
                                        onClick = {
                                            isAllView = !isAllView
                                        }
                                    )

                                }
                            }

                        }
                    } else {
                        LazyColumn {
                            item {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                ) {
                                    ResultScreen(
                                        modifier = Modifier.fillMaxWidth(),
                                        item = example
                                    )

                                    Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))

                                    CodeScreen(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        item = example,
                                        fontSizeCode = fontSizeCode
                                    )
                                }

                            }
                        }
                    }

                }
//theory
                2 -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        item {
                            MessageScreen(
                                message = example.comment,
                                sizeFontText = fontSizeCode,
                                isNormalStyle = true,
                                isColorBackground = false,
                                isColorBorder = true,
                                isShapeLarge = false,
                                isTextCenter = false
                            )

                        }
                    }
                }

//links
                3 -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        item {
                            LinksScreen(
                                example = example,
                                sizeFontText = fontSizeCode,
                            )

                        }
                    }

                }
            }

        }


    }
}

@Preview("Light Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewExamplescreen() {
    MyTextWithComposeTheme {
        Examplescreen(
            selectedDestination = 1,
            isExpanded = false
        )
    }
}

@Preview("Light Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO, widthDp = 1000)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, widthDp = 1000)
@Composable
fun PreviewExpandedExamplescreen() {
    MyTextWithComposeTheme {
        Examplescreen(
            selectedDestination = 1,
            isExpanded = true
        )
    }
}
