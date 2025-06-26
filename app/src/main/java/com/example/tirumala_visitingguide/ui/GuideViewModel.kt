package com.example.tirumala_visitingguide.ui

import androidx.lifecycle.ViewModel
import com.example.tirumala_visitingguide.data.LocalDataProvider
import com.example.tirumala_visitingguide.data.model.*

class GuideViewModel : ViewModel() {

    fun getMainCategories(): List<MainCategory> {
        return LocalDataProvider.mainCategories
    }

    fun getSubCategories(categoryId: String): List<SubCategory> {
        return LocalDataProvider.getSubCategories(categoryId)
    }

    fun getInfoItem(subCategoryId: String): InfoItem? {
        return LocalDataProvider.getInfoItemBySubCategory(subCategoryId)
    }

    fun getCategoryById(id: String): MainCategory? {
        return LocalDataProvider.mainCategories.find { it.id == id }
    }

    fun getSubCategoryById(id: String): SubCategory? {
        return LocalDataProvider.subCategories.find { it.id == id }
    }
}
