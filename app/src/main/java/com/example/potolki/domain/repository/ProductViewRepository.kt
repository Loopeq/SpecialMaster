package com.example.potolki.domain.repository

import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.data.remote.model.server.ProductViewDto
import com.example.potolki.data.remote.model.server.ProductsReviewDto

interface ProductViewRepository {

    suspend fun getProductsReview(): List<ProductsReviewDto>

    suspend fun getProductView(review_id: Int): List<ProductViewDto>

    suspend fun getProductContentView(id: Int): ProductContentDto


    suspend fun getProductContent(view_id: Int, review_id: Int): List<ProductContentDto>
}