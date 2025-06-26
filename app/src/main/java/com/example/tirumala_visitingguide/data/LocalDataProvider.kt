package com.example.tirumala_visitingguide.data

import com.example.tirumala_visitingguide.R
import com.example.tirumala_visitingguide.data.model.InfoItem
import com.example.tirumala_visitingguide.data.model.MainCategory
import com.example.tirumala_visitingguide.data.model.SubCategory

object LocalDataProvider {

    val mainCategories = listOf(
        MainCategory(id = "how_to_reach", title = "How to Reach"),
        MainCategory(id = "darshanam_types", title = "Darshanam - Types"),
        MainCategory(id = "places_to_visit", title = "Places to Visit")
    )

    val subCategories = listOf(
        // How to Reach
        SubCategory(id = "reach_tpt", parentCategoryId = "how_to_reach", title = "Reaching Tirupati"),
        SubCategory(id = "reach_tml", parentCategoryId = "how_to_reach", title = "Reaching Tirumala"),

        // Darshanam - Types
        SubCategory(id = "sarva_darshan", parentCategoryId = "darshanam_types", title = "Sarva Darshanam"),
        SubCategory(id = "divya_darshan", parentCategoryId = "darshanam_types", title = "Divya Darshanam"),
        SubCategory(id = "special_entry_darshan", parentCategoryId = "darshanam_types", title = "Special Entry Darshanam"),
        SubCategory(id = "vip_darshan", parentCategoryId = "darshanam_types", title = "VIP Darshanam"),

        // Places to Visit
        SubCategory(id = "venu_gopala_swami_temple", parentCategoryId = "places_to_visit", title = "Venu Gopala Swamy Temple"),
        SubCategory(id = "japali", parentCategoryId = "places_to_visit", title = "Japali Hanuman Temple"),
        SubCategory(id = "akasa_ganga", parentCategoryId = "places_to_visit", title = "Akasa Ganga"),
        SubCategory(id = "papavinasam", parentCategoryId = "places_to_visit", title = "Papavinasam Theertham"),
        SubCategory(id = "sila_thoranam", parentCategoryId = "places_to_visit", title = "Sila Thoranam"),
        SubCategory(id = "srivari_padhalu", parentCategoryId = "places_to_visit", title = "Srivari Padhalu")
    )

    val infoItems = listOf(
        InfoItem(
            id = "reach_tpt_info",
            subCategoryId = "reach_tpt",
            imageResId = R.drawable.tirupathi,
            description = R.string.how_to_reach_tirupati
        ),
        InfoItem(
            id = "reach_tml_info",
            subCategoryId = "reach_tml",
            imageResId = R.drawable.tirumala,
            description = R.string.how_to_reach_tirumala
        ),
        InfoItem(
            id = "sarva_darshan_info",
            subCategoryId = "sarva_darshan",
            imageResId = R.drawable.sarva_darshanam,
            description = R.string.sarva_darshanam
        ),
        InfoItem(
            id = "divya_darshan_info",
            subCategoryId = "divya_darshan",
            imageResId = R.drawable.divya_darshanam,
            description = R.string.divya_darshanam
        ),
        InfoItem(
            id = "special_entry_darshan_info",
            subCategoryId = "special_entry_darshan",
            imageResId = R.drawable.special_entry_darshanam,
            description = R.string.special_entry_darshanam
        ),
        InfoItem(
            id = "vip_darshan_info",
            subCategoryId = "vip_darshan",
            imageResId = R.drawable.vip_darshanam,
            description = R.string.vip_darshanam
        ),
        InfoItem(
            id = "venu_gopala_swamy_temple_info",
            subCategoryId = "venu_gopala_swami_temple",
            imageResId = R.drawable.venu_gopala_swami_temple,
            description = R.string.venu_gopala_swamy_temple
        ),
        InfoItem(
            id = "japali_info",
            subCategoryId = "japali",
            imageResId = R.drawable.japali,
            description = R.string.japali_hanuman_temple
        ),
        InfoItem(
            id = "akasa_ganga_info",
            subCategoryId = "akasa_ganga",
            imageResId = R.drawable.akasa_ganga,
            description = R.string.akasa_ganga
        ),
        InfoItem(
            id = "papavinasam_info",
            subCategoryId = "papavinasam",
            imageResId = R.drawable.papa_vinasanam,
            description = R.string.papa_vinasanam
        ),
        InfoItem(
            id = "sila_thoranam_info",
            subCategoryId = "sila_thoranam",
            imageResId = R.drawable.silathoranam,
            description = R.string.sila_thoranam
        ),
        InfoItem(
            id = "srivari_padhalu_info",
            subCategoryId = "srivari_padhalu",
            imageResId = R.drawable.srivari_padalu,
            description = R.string.srivari_padalu
        )
    )

    // Optional: utility functions to fetch subcategories or items based on id
    fun getSubCategories(parentId: String): List<SubCategory> =
        subCategories.filter { it.parentCategoryId == parentId }

    fun getInfoItemBySubCategory(subId: String): InfoItem? =
        infoItems.find { it.subCategoryId == subId }
}
