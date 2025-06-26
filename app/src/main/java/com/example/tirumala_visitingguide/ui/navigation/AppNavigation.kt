package com.example.tirumala_visitingguide.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tirumala_visitingguide.ui.GuideViewModel
import com.example.tirumala_visitingguide.ui.screens.MainMenuScreen
import com.example.tirumala_visitingguide.ui.screens.SubCategoryScreen
import com.example.tirumala_visitingguide.ui.screens.DetailScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    viewModel: GuideViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "main_menu"
    ) {
        // Main menu screen
        composable("main_menu") {
            MainMenuScreen(
                viewModel = viewModel,
                onCategoryClick = { categoryId ->
                    navController.navigate("sub_categories/$categoryId")
                }
            )
        }

        // Sub-category screen
        composable("sub_categories/{categoryId}") { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId") ?: return@composable
            SubCategoryScreen(
                categoryId = categoryId,
                viewModel = viewModel,
                onSubCategoryClick = { subCategoryId ->
                    navController.navigate("details/$subCategoryId")
                },
                navController = navController
            )
        }

        // Detail screen
        composable("details/{subCategoryId}") { backStackEntry ->
            val subCategoryId = backStackEntry.arguments?.getString("subCategoryId") ?: return@composable
            DetailScreen(
                subCategoryId = subCategoryId,
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}

