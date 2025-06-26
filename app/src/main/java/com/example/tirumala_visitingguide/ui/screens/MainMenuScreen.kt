package com.example.tirumala_visitingguide.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tirumala_visitingguide.ui.GuideViewModel
import com.example.tirumala_visitingguide.data.model.MainCategory
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
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(categories) { category ->
                MainMenuItem(category = category, onClick = onCategoryClick)
            }
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
