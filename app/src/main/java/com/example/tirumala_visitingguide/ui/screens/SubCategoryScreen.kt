package com.example.tirumala_visitingguide.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.tirumala_visitingguide.ui.GuideViewModel
import com.example.tirumala_visitingguide.ui.components.TirumalaGuideTopAppBar
import com.example.tirumala_visitingguide.data.model.SubCategory

@Composable
fun SubCategoryScreen(
    categoryId: String,
    onSubCategoryClick: (String) -> Unit,
    viewModel: GuideViewModel,
    navController: NavHostController
) {
    val category = viewModel.getCategoryById(categoryId)
    val subCategories = viewModel.getSubCategories(categoryId)

    Scaffold(
        topBar = { TirumalaGuideTopAppBar(
            title = category?.title ?: "Back",
            showBackButton = true,
            onBackClick = { navController.navigateUp() }
        )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(subCategories) { sub ->
                SubCategoryItem(subCategory = sub, onClick = onSubCategoryClick)
            }
        }
    }
}

@Composable
fun SubCategoryItem(
    subCategory: SubCategory,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick(subCategory.id) },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Text(
            text = subCategory.title,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.titleMedium
        )
    }
}


