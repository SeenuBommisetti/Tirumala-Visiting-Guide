package com.example.tirumala_visitingguide.ui.screens

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.testing.TestNavHostController
import androidx.test.platform.app.InstrumentationRegistry
import com.example.tirumala_visitingguide.ui.GuideViewModel
import org.junit.Rule
import org.junit.Test

class DetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun detailScreen_displaysInfoIfAvailable() {
        val viewModel = GuideViewModel()
        val subCategoryId = viewModel.getSubCategoryById("sarva_darshanam")?.id
            ?: viewModel.getSubCategoryById(viewModel.getMainCategories().first().id)?.id ?: return

        val infoItem = viewModel.getInfoItem(subCategoryId) ?: return
        val navController = TestNavHostController(InstrumentationRegistry.getInstrumentation().targetContext)

        composeTestRule.setContent {
            DetailScreen(
                subCategoryId = subCategoryId,
                viewModel = viewModel,
                navController = navController
            )
        }

        composeTestRule.onNodeWithText(infoItem.description.toString(), substring = true).assertExists()
    }

    @Test
    fun detailScreen_showsFallback_whenInfoMissing() {
        val navController = TestNavHostController(InstrumentationRegistry.getInstrumentation().targetContext)
        val viewModel = GuideViewModel()

        composeTestRule.setContent {
            DetailScreen(
                subCategoryId = "invalid_id",
                viewModel = viewModel,
                navController = navController
            )
        }

        composeTestRule.onNodeWithText("Information not available.").assertIsDisplayed()
    }
}
