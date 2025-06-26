package com.example.tirumala_visitingguide.ui

import com.example.tirumala_visitingguide.data.LocalDataProvider
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GuideViewModelTest {

    private lateinit var viewModel: GuideViewModel

    @Before
    fun setup() {
        viewModel = GuideViewModel()
    }

    @Test
    fun guideViewModel_GetMainCategories_ReturnAllMainCategories() {
        val expected = LocalDataProvider.mainCategories
        val result = viewModel.getMainCategories()

        assertEquals(expected.size, result.size)
        assertEquals(expected, result)
    }

    @Test
    fun guideViewModel_GetSubCategories_ReturnCorrectSubCategories() {
        val categoryId = "how_to_reach"
        val expected = LocalDataProvider.getSubCategories(categoryId)
        val result = viewModel.getSubCategories(categoryId)

        assertEquals(expected, result)
    }

    @Test
    fun guideViewModel_GetInfoItem_ReturnInfoItemWhenCorrectSubCategoryIsGiven() {
        val subCategoryId = "sarva_darshanam"
        val expected = LocalDataProvider.getInfoItemBySubCategory(subCategoryId)
        val result = viewModel.getInfoItem(subCategoryId)

        assertEquals(expected, result)
    }

    @Test
    fun guideViewModel_GetInfoItem_ReturnNullWhenInvalidSubCategoryIsGiven() {
        val result = viewModel.getInfoItem("invalid_id")
        assertNull(result)
    }

    @Test
    fun guideViewModel_GetCategoryById_ReturnCorrectCategory(){
        val validId = LocalDataProvider.mainCategories.first().id
        val result = viewModel.getCategoryById(validId)

        assertNotNull(result)
        assertEquals(validId, result?.id)
    }

    @Test
    fun guideViewModel_GetCategoryById_ReturnNullForInvalidId() {
        val result = viewModel.getCategoryById("invalid_id")
        assertNull(result)
    }

    @Test
    fun guideViewModel_GetSubCategoryById_ReturnCorrectSubCategory() {
        val validId = LocalDataProvider.subCategories.first().id
        val result = viewModel.getSubCategoryById(validId)

        assertNotNull(result)
        assertEquals(validId, result?.id)
    }

    @Test
    fun guideViewModel_GetSubCategoryById_ReturnNullForInvalidId() {
        val result = viewModel.getSubCategoryById("invalid_id")
        assertNull(result)
    }
}
