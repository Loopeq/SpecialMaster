package com.example.potolki.domain.repository

import com.example.potolki.data.remote.model.client.MaterialCartDto
import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.data.remote.model.client.UserProfileDto
import com.example.potolki.data.remote.model.server.MaterialDto
import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.data.remote.model.server.ProductViewDto
import com.example.potolki.data.remote.model.server.ProductsReviewDto

interface MaterialRepository {

    //other
    suspend fun getAllRegions(): List<String>

    // profile
    suspend fun getProfileData(): UserProfileDto

    suspend fun editRegionSettings(regionId: Int): UserProfileDto
    suspend fun updatePhone(newPhoneNumber: String): UserProfileDto

    suspend fun updateEmail(newEmail: String): UserProfileDto


    // cart
    suspend fun getMaterialToCart(): List<MaterialCartDto>
    suspend fun updateItemInfo(itemId: Int, parentId: Int, newValueOfCount: Int, newValueOfTotalPrice: Int): List<MaterialCartDto>

    suspend fun createOrder(): Int

    // favourite

    suspend fun getFavourite(): List<MaterialDto>

    // varieties
    suspend fun getVarietiesDescription(id: Int, parentId: Int): MaterialDto
    suspend fun getVarieties(parentId: Int): List<MaterialDto>

    suspend fun addVarietiesToCart(parentId: Int, id: Int): MaterialCartDto

    suspend fun deleteVarietiesFromCart(id: Int, parentId: Int): List<MaterialCartDto>

    suspend fun checkVarietiesInCart(id: Int, parentId: Int): Boolean

    suspend fun addVarietiesToFavourite(parentId: Int, id: Int): MaterialDto

    suspend fun deleteVarietiesFromFavourite(parentId: Int, id: Int): List<MaterialDto>

    suspend fun checkVarietiesInFavourite(parentId: Int, id: Int): Boolean
}