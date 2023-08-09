package com.example.potolki.presentation.product_view_or_content

import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.data.remote.model.server.ProductViewDto

data class ProductViewOrContentState(
    val error: String = "",
    val isLoading: Boolean = false,
    val isView: Boolean = false,
    val productView: List<ProductViewDto> = emptyList(),
    val productContent: List<ProductContentDto> = emptyList()
    )
