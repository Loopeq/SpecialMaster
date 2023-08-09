package com.example.potolki.data.repository

import com.example.potolki.data.database.ProductDao
import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.data.remote.model.server.ProductViewDto
import com.example.potolki.data.remote.model.server.ProductsReviewDto
import com.example.potolki.domain.repository.ProductViewRepository

class ProductViewRepositoryImpl(private val productDao: ProductDao): ProductViewRepository{

    override suspend fun getProductsReview(): List<ProductsReviewDto> {
        return productDao.getProductsReview()
    }

    // product view
    override suspend fun getProductView(review_id: Int): List<ProductViewDto> {
        return productDao.getProductView(review_id)
    }

    override suspend fun getProductContentView(id: Int): ProductContentDto {
        return productDao.getProductContentView(id)
    }


    // product content
    override suspend fun getProductContent(view_id: Int, review_id: Int): List<ProductContentDto> {
        return productDao.getProductContent(view_id, review_id)
    }

}