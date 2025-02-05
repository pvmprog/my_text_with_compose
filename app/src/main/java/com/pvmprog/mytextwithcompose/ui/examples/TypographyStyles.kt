package com.pvmprog.mytextwithcompose.ui.examples

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pvmprog.mytextwithcompose.ui.theme.MyTextWithComposeTheme


data class TypographyStyle(
    val name: String,
    val style:TextStyle
)

@Composable
fun TypographyStyles() {
    val listStyle = listOf(
        TypographyStyle("displayLarge", MaterialTheme.typography.displayLarge),
        TypographyStyle("displayMedium", MaterialTheme.typography.displayMedium),
        TypographyStyle("displaySmall", MaterialTheme.typography.displaySmall),
        TypographyStyle("headlineLarge", MaterialTheme.typography.headlineLarge),
        TypographyStyle("headlineMedium", MaterialTheme.typography.headlineMedium),
        TypographyStyle("headlineSmall", MaterialTheme.typography.headlineSmall),
        TypographyStyle("titleLarge", MaterialTheme.typography.titleLarge),
        TypographyStyle("titleMedium", MaterialTheme.typography.titleMedium),
        TypographyStyle("titleSmall", MaterialTheme.typography.titleSmall),
        TypographyStyle("bodyLarge", MaterialTheme.typography.bodyLarge),
        TypographyStyle("bodyMedium", MaterialTheme.typography.bodyMedium),
        TypographyStyle("bodySmall", MaterialTheme.typography.bodySmall),
        TypographyStyle("labelLarge", MaterialTheme.typography.labelLarge),
        TypographyStyle("labelMedium", MaterialTheme.typography.labelMedium),
        TypographyStyle("labelSmall", MaterialTheme.typography.labelSmall),
    )

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(listStyle) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = it.name,
                    style = it.style
                )
                Text(
                    text = "(${it.style.fontSize})",
                )
            }
        }

    }

}

@Preview("Light Theme",showBackground = true)
@Preview("Dark Theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TypographyFontSizePreview() {
    MyTextWithComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TypographyStyles()
        }

    }
}
