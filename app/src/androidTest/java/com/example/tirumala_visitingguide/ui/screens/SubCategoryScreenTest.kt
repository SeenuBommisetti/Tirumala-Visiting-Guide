package com.example.tirumala_visitingguide.ui.screens

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.testing.TestNavHostController
import androidx.test.platform.app.InstrumentationRegistry
import com.example.tirumala_visitingguide.ui.GuideViewModel
import org.junit.Rule
import org.junit.Test

class SubCategoryScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun subCategoryScreen_displaysSubCategories() {
        val viewModel = GuideViewModel()
        val categoryId = viewModel.getMainCategories().first().id
        val subCategories = viewModel.getSubCategories(categoryId)

        val navController = TestNavHostController(InstrumentationRegistry.getInstrumentation().targetContext)

        composeTestRule.setContent {
            SubCategoryScreen(
                categoryId = categoryId,
                onSubCategoryClick = {},
                viewModel = viewModel,
                navController = navController
            )
        }

        subCategories.forEach {
            composeTestRule.onNodeWithText(it.title).assertIsDisplayed()
        }
    }
}
