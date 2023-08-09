package com.example.potolki.presentation.product_review

import com.example.potolki.data.remote.model.server.ProductsReviewDto


data class ProductReviewState(
    val isLoading: Boolean = false,
    val productReview: List<ProductsReviewDto> = emptyList(),
    val error: String = ""
)