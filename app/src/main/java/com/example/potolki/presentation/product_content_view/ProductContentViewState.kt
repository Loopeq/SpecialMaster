package com.example.potolki.presentation.product_content_view

import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.data.remote.model.server.ProductsReviewDto
import kotlinx.coroutines.flow.emptyFlow

data class ProductContentViewState(
    val isLoading: Boolean = false,
    val productContentView: ProductContentDto? = null,
    val error: String = "",
)
