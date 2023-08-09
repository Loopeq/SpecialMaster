package com.example.potolki.data.repository

import com.example.potolki.data.database.ProductCartDao
import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.data.remote.model.client.ProductCartWithContent
import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.domain.repository.ProductCartRepository
import kotlinx.coroutines.flow.Flow

class ProductCartRepositoryImpl(private val productCartDao: ProductCartDao): ProductCartRepository {
    override fun getProductCart(): Flow<List<ProductCartWithContent>> {
        return productCartDao.getProductCart()
    }

    override suspend fun insertProductToCart(product: ProductCartDto) {
        productCartDao.insertProductToCart(product)
    }

    override suspend fun updateProductInCart(productCartDto: ProductCartDto) {
        productCartDao.updateProductInCart(productCartDto)
    }

    override suspend fun deleteProductFromCart(product: ProductCartDto) {
        productCartDao.deleteProductFromCart(product)
    }

    override suspend fun deleteAllFromCart() {
        productCartDao.deleteAllFromCart()
    }

    override fun checkProductInCart(id: Int): Flow<Boolean> {
        return productCartDao.checkProductInCart(id)
    }

    override fun getTotalSumFromCart(): Flow<Int> {
        return productCartDao.getTotalPrice()
    }


}