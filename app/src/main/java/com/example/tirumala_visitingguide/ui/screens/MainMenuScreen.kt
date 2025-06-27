package com.example.tirumala_visitingguide.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.tirumala_visitingguide.data.model.MainCategory
import com.example.tirumala_visitingguide.ui.GuideViewModel
import com.example.tirumala_visitingguide.ui.components.TirumalaGuideTopAppBar

@Composable
fun MainMenuScreen(
    onCategoryClick: (String) -> Unit,
    viewModel: GuideViewModel
) {
    val categories = viewModel.getMainCategories()

    Scaffold(
        topBar = { TirumalaGuideTopAppBar(title = "Tirumala - Visiting Guide") }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
            ) {
                items(categories) { category ->
                    MainMenuItem(category = category, onClick = onCategoryClick)
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outline
            )

            Text(
                text = "Developed by Seenu Bommisetti",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp),
                color = MaterialTheme.colorScheme.tertiary,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Composable
fun MainMenuItem(
    category: MainCategory,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick(category.id) },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Text(
            text = category.title,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.titleMedium
        )
    }
}
