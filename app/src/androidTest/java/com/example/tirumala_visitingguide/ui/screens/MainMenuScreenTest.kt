package com.example.tirumala_visitingguide.ui.screens

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.tirumala_visitingguide.data.LocalDataProvider
import com.example.tirumala_visitingguide.ui.GuideViewModel
import org.junit.Rule
import org.junit.Test

class MainMenuScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun mainMenu_displaysAllMainCategories() {
        val viewModel = GuideViewModel()

        composeTestRule.setContent {
            MainMenuScreen(
                onCategoryClick = {},
                viewModel = viewModel
            )
        }

        LocalDataProvider.mainCategories.forEach {
            composeTestRule.onNodeWithText(it.title).assertIsDisplayed()
        }
    }

    @Test
    fun mainMenu_clickCategory_triggersCallback() {
        val viewModel = GuideViewModel()
        var clickedId: String? = null

        composeTestRule.setContent {
            MainMenuScreen(
                onCategoryClick = { clickedId = it },
                viewModel = viewModel
            )
        }

        val firstCategory = LocalDataProvider.mainCategories.first()
        composeTestRule.onNodeWithText(firstCategory.title).performClick()
        assert(clickedId == firstCategory.id)
    }
}
