package com.example.tirumala_visitingguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.tirumala_visitingguide.ui.GuideViewModel
import com.example.tirumala_visitingguide.ui.navigation.AppNavigation
import com.example.tirumala_visitingguide.ui.theme.TirumalaVisitingGuideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TirumalaVisitingGuideTheme {
                val navController = rememberNavController()
                val viewModel: GuideViewModel = viewModel()
                AppNavigation(navController, viewModel)
            }
        }
    }
}


