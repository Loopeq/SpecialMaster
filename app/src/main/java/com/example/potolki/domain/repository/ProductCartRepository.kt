package com.example.potolki.domain.repository

import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.data.remote.model.client.ProductCartWithContent
import com.example.potolki.data.remote.model.server.ProductContentDto
import kotlinx.coroutines.flow.Flow

interface ProductCartRepository {

    fun getProductCart(): Flow<List<ProductCartWithContent>>

    suspend fun insertProductToCart(product: ProductCartDto)

    suspend fun updateProductInCart(productCartDto: ProductCartDto)

    suspend fun deleteProductFromCart(product: ProductCartDto)

    suspend fun deleteAllFromCart()

    fun checkProductInCart(id: Int): Flow<Boolean>

    fun getTotalSumFromCart(): Flow<Int>




}