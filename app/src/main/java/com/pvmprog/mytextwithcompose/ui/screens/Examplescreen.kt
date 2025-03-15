package com.pvmprog.mytextwithcompose.ui.screens

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme
import com.pvmprog.mytextwithcompose.ui.topbar.TopSubBar

//Анимация на основе значений
//https://developer.android.com/develop/ui/compose/animation/value-based?hl=ru

/*
Как добавить иконки в проект В Android Studio смотрите по ссылке:
  https://developer.android.com/studio/write/vector-asset-studio?hl=ru#svg
или можно загрузит файлы иконок из сайта Google Fonts в разделе Icons и поместить их в папку res/draweble
  https://fonts.google.com/icons?selected=Material+Symbols+Outlined:pip_exit:FILL@0;wght@400;GRAD@0;opsz@24&icon.size=24&icon.color=%235f6368

*/


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Examplescreen(
    selectedDestination: Int = 1, //1-result 2-code 3-theory
    isExpanded: Boolean = false,
    indexExample: Int = 0,
    itemList: List<ExampleCode> = DataCodeUI.codeUI,
    onNext: (Int) -> Unit = {},
    heightMinDp:Int = 200,
    onIntentClicked: (String) -> Unit ={}

    ) {
    var isViewTheory by remember { mutableStateOf(true) }
    var isViewLinks by remember { mutableStateOf(true) }

    val weightTheory: Float by animateFloatAsState(if (isViewTheory) 1f else 0.01f, label = "result")
    val weightLinks: Float by animateFloatAsState(if (isViewLinks) 1f else 0.01f, label = "code")

//    var isViewResult2 by remember { mutableStateOf(true) }
//    var isViewCode2 by remember { mutableStateOf(true) }

    val isViewTheory2 = (weightTheory > 0.1f)
    val isViewLinks2 = (weightLinks > 0.1f)

    //BackHandler для обнаружения нажатий на кнопку «Назад» устройства внутри Compose
    BackHandler(
        // your condition to enable handler
        enabled = true
    ) {
        isViewTheory = true
        onNext(-1)
    }

    val example = if (indexExample < itemList.size) itemList[indexExample]
    else ExampleCode()

    val context =  LocalContext.current

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
                    isViewTheory = true
                }
            )
        },
        floatingActionButton = {
            Row(
                Modifier
                    .padding(10.dp)
            ) {
                if (selectedDestination != 1){
                    //Установить маштаб по умолчанию
                    if (fontSizeCode != defaultFontSizeCode){
                        Icon(
                            imageVector = Icons.Filled.Clear,
//                    painter = painterResource(id = R.drawable.baseline_disabled_by_default_24),
                            contentDescription = stringResource(R.string.zoom_is_default),
                            modifier = modifierIcon
                                .background(MaterialTheme.colorScheme.inversePrimary)
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


                }


                //переход на следующий пример
                FloatingActionButton(
                    onClick = {
                        var index = indexExample + 1
                        if (index >= itemList.size) index = 0
                        isViewTheory = true
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
                .fillMaxWidth(),
            color = MaterialTheme.colorScheme.background
        ) {

            when (selectedDestination){
//Result
                1 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                    ) {
                        example.lambdaFun(isExpanded)
                    }
                }

//Code
                2 -> {
                    CodeScreen(
                        modifier = Modifier
                            .fillMaxWidth(),
                        item = example,
                        fontSizeCode = fontSizeCode,
                        onIntentClicked = onIntentClicked,
                    )
                }

//theory+link
                3 -> {
                    if (isExpanded) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            if (isViewTheory2){
                                LazyColumn(
                                    modifier = Modifier.weight(weightTheory),
                                ) {
                                    item {
                                        MessageScreen(
                                            message = example.comment,
                                            sizeFontText = fontSizeCode,
                                            isNormalStyle = true,
                                            isColorBackground = false,
                                            isColorBorder = true,
                                            isShapeLarge = false,
                                            isTextCenter = false,
                                            modifier = Modifier
                                                .pointerInput(Unit) {
                                                    detectTapGestures(
                                                        onDoubleTap = {
                                                            isViewLinks = !isViewLinks
                                                        },
                                                    )
                                                },

                                            )

                                    }
                                }
                            }
                            if ((isViewTheory) && (isViewLinks))
                                Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_spacer)))

                            if (isViewLinks2){
                                LazyColumn(
                                    modifier = Modifier.weight(weightLinks),
                                ) {
                                    item {
                                        LinksScreen(
                                            example = example,
                                            sizeFontText = fontSizeCode,
                                            modifier = Modifier
                                                .pointerInput(Unit) {
                                                    detectTapGestures(
                                                        onDoubleTap = {
                                                            isViewTheory = !isViewTheory
                                                        },
                                                    )
                                                },
                                        )

                                    }
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
                                    MessageScreen(
                                        message = example.comment,
                                        sizeFontText = fontSizeCode,
                                        isNormalStyle = true,
                                        isColorBackground = false,
                                        isColorBorder = true,
                                        isShapeLarge = false,
                                        isTextCenter = false,
                                        modifier = Modifier
                                            .fillMaxWidth(),

                                    )

                                    Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))

                                    LinksScreen(
                                        example = example,
                                        sizeFontText = fontSizeCode,
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                    )

                                    Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)))
                                }

                            }
                        }
                    }

                }
//theory
                3 -> {
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

                            Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))

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
