package com.example.tirumala_visitingguide.navigation

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
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
class NavigationFlowTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        navController = TestNavHostController(composeTestRule.activity)
        navController.navigatorProvider.addNavigator(ComposeNavigator())

        val viewModel = GuideViewModel()

        composeTestRule.setContent {
            AppNavigation(navController = navController, viewModel = viewModel)
        }
    }

    @Test
    fun fullNavigationFlow_mainToSubCategoryToDetail() {
        val viewModel = GuideViewModel()
        val category = viewModel.getMainCategories().first()
        val subCategory = viewModel.getSubCategories(category.id).first()

        // Click on category title
        composeTestRule.onNodeWithText(category.title).performClick()

        composeTestRule.waitForIdle()
        assert(navController.currentDestination?.route?.startsWith("sub_categories") == true)

        // Click on sub-category title
        composeTestRule.onNodeWithText(subCategory.title).performClick()

        composeTestRule.waitForIdle()
        assert(navController.currentDestination?.route?.startsWith("details") == true)
    }
}