package com.example.tirumala_visitingguide.ui

import com.example.tirumala_visitingguide.data.model.*

sealed class UIState {
    object MainMenu : UIState()

    data class SubCategoryList(
        val category: MainCategory,
        val subCategories: List<SubCategory>
    ) : UIState()

    data class DetailScreen(
        val subCategory: SubCategory,
        val infoItem: InfoItem
    ) : UIState()
}
