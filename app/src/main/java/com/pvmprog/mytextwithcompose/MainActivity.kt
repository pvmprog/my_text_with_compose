package com.pvmprog.mytextwithcompose

import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.ui.MainScreen
import com.pvmprog.mytextwithcompose.ui.screens.Examplescreen
import com.pvmprog.mytextwithcompose.ui.screens.GreetingScreen
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme
import dagger.hilt.android.AndroidEntryPoint

/*
        Create project with MVVM Architecture

 MVVM (Model-View-ViewModel) — способ организации кода.
 Помогает отделить пользовательский интерфейс(UI) от данных.

 UI не зависит от логики работы с данными и их источником.

     Model - данные и логика для работы с ними
     View - UI
     ViewModel - связывает UI и данные

 Будем использовать:
 Jetpack Compose – для создания современного пользовательского интерфейса
 Dagger Hilt – для dependency injection (внедрение зависимостей)

Будем следовать лучшим практикам:
 1)разделение на слои data, domain и presentation;
 2)применение принципов SOLID.

    data включает имплементации Repository, DataSource и классы для работы с Room.
    domain будет содержать UseCase и интерфейсы Repository
    presentation слой будет содержать Composable и ViewModel.

 SOLID - это принципы разработки программного обеспечения, следуя которым Вы получите хороший код, который в дальнейшем будет хорошо масштабироваться и поддерживаться в рабочем состоянии.


1.Создаем проект
 Открываем Android Studio, кликаем
   File →
      New →
          New Project.
 В появившемся окне New Project выберите тип проекта – Empty Activity.
 Вводим название приложения.

2.Добавляем зависимости:

libs.versions.toml
****************************************
[versions]
animation = "1.7.6"
navigationCompose = "2.7.7"
hiltVersion ="2.49"
hiltVersionNavigation ="1.2.0"

[libraries]
...
androidx-animation = { module = "androidx.compose.animation:animation", version.ref = "animation" }
androidx-navigation-compose = { module = "androidx.navigation:navigation-compose", version.ref = "navigationCompose" }


dagger-hilt-android = { module = "com.google.dagger:hilt-android", version.ref = "hiltVersion" }
dagger-hilt-android-compiler = { module = "com.google.dagger:hilt-android-compiler", version.ref = "hiltVersion" }
dagger-hilt-navigation = { module = "androidx.hilt:hilt-navigation-compose", version.ref = "hiltVersionNavigation" }
....

[plugins]
...
googleDaggerHilt = { id = "com.google.dagger.hilt.android", version.ref = "hiltVersion" }

****************************************

  build.gradle.kts (app)
****************************************
plugins {
...
    alias(libs.plugins.googleDaggerHilt) apply false
...
}
****************************************


  build.gradle.kts (app)
****************************************
plugins {
...
    alias(libs.plugins.googleDaggerHilt)
    kotlin("kapt")
...
}


dependencies {
...
    implementation(libs.androidx.animation)
    // Hilt dependency for dependency injection
    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.android.compiler)

    implementation(libs.dagger.hilt.navigation)
    implementation(libs.androidx.navigation.compose)


...
}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}
****************************************

3.Создаем класс TextWithComposeApp и добавляем аннотацию @HiltAndroidApp
@HiltAndroidApp
class TextWithComposeApp: Application()  {
    private var instance: TextWithComposeApp? = null

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}

4.Регистрируем его в AndroidManifest.xml:

<application
  android:name=".TextWithComposeApp"
  ...
/>
5.Ддобавляем аннотацию классу MainActivity: @AndroidEntryPoint

Android Compose: Create a simple MVVM project with basic four layers
https://medium.com/@anteprocess/android-compose-create-a-simple-mvvm-project-with-basic-four-layers-776b586d00af

Стиль текста
https://developer.android.com/develop/ui/compose/text/style-text?hl=ru

https://developer.android.com/develop/ui/compose/resources?hl=ru#strings

 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTextWithComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val h = getScreenHeight()
                    val w = getScreenWidth()
                    val minSizeScreen = if (h > w) w
                    else h
                    val minSizeScreenDp = intToDp(minSizeScreen).toInt() - 16

                    val windowSize = calculateWindowSizeClass(this)
                    val isExpanded =  (windowSize.widthSizeClass == WindowWidthSizeClass.Expanded)
                    MainScreen(
                        isExpanded = isExpanded,
                        minSizeScreenDp = minSizeScreenDp,
                        modifier = Modifier.fillMaxSize()
                    )

                }
            }
        }
    }

    private fun intToDp(size:Int): Float = Math.round(
            size / TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 1f,
                this.resources.displayMetrics
            )
        ).toFloat()




    private fun getScreenWidth(): Int =
        Resources.getSystem().displayMetrics.widthPixels

    private fun getScreenHeight(): Int =
        Resources.getSystem().displayMetrics.heightPixels



}

