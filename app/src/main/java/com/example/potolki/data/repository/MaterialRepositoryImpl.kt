package com.example.potolki.data.repository

import android.util.Log
import com.example.potolki.data.database.ProductDao
import com.example.potolki.data.remote.*
import com.example.potolki.data.remote.model.client.MaterialCartDto
import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.data.remote.model.client.UserProfileDto
import com.example.potolki.data.remote.model.server.MaterialDto
import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.data.remote.model.server.ProductViewDto
import com.example.potolki.data.remote.model.server.ProductsReviewDto
import com.example.potolki.domain.model.UserProfile
import com.example.potolki.domain.repository.MaterialRepository
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

class MaterialRepositoryImpl(
    private val dao: ProductDao
) : MaterialRepository {
    override suspend fun getAllRegions(): List<String> {
        return LocalRegionModel.regions
    }

    override suspend fun getProfileData(): UserProfileDto {
        return LocalUserProfileModel.profile
    }

    override suspend fun editRegionSettings(regionId: Int): UserProfileDto {
        LocalUserProfileModel.profile.region = LocalRegionModel.regions[regionId]
        return LocalUserProfileModel.profile
    }

    override suspend fun updatePhone(newPhoneNumber: String): UserProfileDto {
        LocalUserProfileModel.profile.phone = newPhoneNumber
        return LocalUserProfileModel.profile
    }

    override suspend fun updateEmail(newEmail: String): UserProfileDto {
        LocalUserProfileModel.profile.email = newEmail
        return LocalUserProfileModel.profile
    }

    // product review



    override suspend fun getMaterialToCart(): List<MaterialCartDto> {
        return LocalMaterialCartModel.listOfMaterialCart
    }

    override suspend fun updateItemInfo(
        itemId: Int,
        parentId: Int,
        newValueOfCount: Int,
        newValueOfTotalPrice: Int
    ): List<MaterialCartDto> {

        LocalMaterialCartModel.listOfMaterialCart.filter { it.id == itemId && it.parentId == parentId }[0].count =
            newValueOfCount
        LocalMaterialCartModel.listOfMaterialCart.filter { it.id == itemId && it.parentId == parentId }[0].totalPrice =
            newValueOfTotalPrice
        return LocalMaterialCartModel.listOfMaterialCart
    }

    override suspend fun createOrder(): Int {
        return Random.nextInt(1, 1000)
    }

    override suspend fun getFavourite(): List<MaterialDto> {
        return LocalMaterialFavouriteModel.listOfFavourite
    }

    override suspend fun getVarietiesDescription(id: Int, parentId: Int): MaterialDto {
        return LocalMaterialVarietiesModel.listOfMaterialVarieties.filter { it.id == id && it.parentId == parentId }[0]
    }

    override suspend fun getVarieties(parentId: Int): List<MaterialDto> {
        return LocalMaterialVarietiesModel.listOfMaterialVarieties.filter { it.parentId == parentId }
    }

    override suspend fun addVarietiesToCart(parentId: Int, id: Int): MaterialCartDto {
        val result =
            LocalMaterialVarietiesModel.listOfMaterialVarieties.filter { parentId == it.parentId && id == it.id }[0]

        val item: MaterialCartDto = MaterialCartDto(
            id = id,
            title = result.title,
            price = result.price,
            imageSrc = result.imageSrc,
            count = 1,
            parentId = parentId
        )
        LocalMaterialCartModel.listOfMaterialCart.add(item)
        return item

    }

    override suspend fun deleteVarietiesFromCart(id: Int, parentId: Int): List<MaterialCartDto> {
        LocalMaterialCartModel.listOfMaterialCart.remove(LocalMaterialCartModel.listOfMaterialCart.filter { it.id == id && it.parentId == parentId }[0])
        return LocalMaterialCartModel.listOfMaterialCart
    }

    override suspend fun checkVarietiesInCart(id: Int, parentId: Int): Boolean {
        val result =
            LocalMaterialCartModel.listOfMaterialCart.filter { it.id == id && it.parentId == parentId }
        if (result.isNotEmpty()) {
            return true
        }
        return false
    }

    override suspend fun addVarietiesToFavourite(parentId: Int, id: Int): MaterialDto {
        val result =
            LocalMaterialVarietiesModel.listOfMaterialVarieties.filter { it.parentId == parentId && it.id == id }[0]

        val item: MaterialDto = MaterialDto(
            id = id,
            title = result.title,
            parentId = parentId,
            imageSrc = result.imageSrc,
            description = result.description,
            price = result.price,
            amount = result.amount,
            unit = result.unit
        )
        LocalMaterialFavouriteModel.listOfFavourite.add(item)
        return item
    }

    override suspend fun deleteVarietiesFromFavourite(parentId: Int, id: Int): List<MaterialDto> {
        LocalMaterialFavouriteModel.listOfFavourite.remove(LocalMaterialFavouriteModel.listOfFavourite.filter { it.parentId == parentId && it.id == id }[0])
        return LocalMaterialFavouriteModel.listOfFavourite
    }

    override suspend fun checkVarietiesInFavourite(parentId: Int, id: Int): Boolean {
        val result =
            LocalMaterialFavouriteModel.listOfFavourite.filter { it.id == id && it.parentId == parentId }
        if (result.isNotEmpty()) {
            return true
        }
        return false
    }

}