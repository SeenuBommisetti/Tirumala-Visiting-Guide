package com.example.tirumala_visitingguide.navigation

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tirumala_visitingguide.ui.GuideViewModel
import com.example.tirumala_visitingguide.ui.navigation.AppNavigation
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BackStackNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    private val viewModel = GuideViewModel()

    @Before
    fun setup() {
        navController = TestNavHostController(composeTestRule.activity)
        navController.navigatorProvider.addNavigator(ComposeNavigator())

        composeTestRule.setContent {
            AppNavigation(navController = navController, viewModel = viewModel)
        }
    }

    @Test
    fun testBackNavigationFromDetailsToMainMenu() {
        val category = viewModel.getMainCategories().first()
        val subCategory = viewModel.getSubCategories(category.id).first()

        // Navigate: Main -> Sub -> Detail
        composeTestRule.onNodeWithText(category.title).performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText(subCategory.title).performClick()
        composeTestRule.waitForIdle()

        // Back: Detail -> SubCategory
        composeTestRule.activityRule.scenario.onActivity {
            navController.popBackStack()
        }
        composeTestRule.waitForIdle()

        // Assert: SubCategory screen is now visible
        composeTestRule.onNodeWithText(subCategory.title).assertIsDisplayed()

        // Back: SubCategory -> Main
        composeTestRule.activityRule.scenario.onActivity {
            navController.popBackStack()
        }
        composeTestRule.waitForIdle()

        // Assert: MainMenu screen is now visible
        composeTestRule.onNodeWithText(category.title).assertIsDisplayed()
    }
}
