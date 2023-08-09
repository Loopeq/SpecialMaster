package com.example.potolki.data.database

import androidx.room.Query
import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.data.remote.model.server.ProductViewDto
import com.example.potolki.data.remote.model.server.ProductsReviewDto


@androidx.room.Dao
interface ProductDao {

    @Query("SELECT * FROM products_review")
    suspend fun getProductsReview(): List<ProductsReviewDto>

    @Query("SELECT * FROM product_view WHERE review_id = :review_id")
    suspend fun getProductView(review_id: Int): List<ProductViewDto>

    @Query("SELECT * FROM product_content WHERE view_id = :view_id AND review_id = :reviewId")
    suspend fun getProductContent(view_id: Int, reviewId: Int): List<ProductContentDto>

    @Query("SELECT * FROM product_content WHERE id = :id")
    suspend fun getProductContentView(id: Int): ProductContentDto

}