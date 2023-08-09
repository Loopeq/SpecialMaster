package com.example.potolki.presentation.cart

import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.data.remote.model.client.ProductCartWithContent
import com.example.potolki.data.remote.model.server.ProductContentDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class ProductCartState(
    val isLoading: Boolean = false,
    val productCart: Flow<List<ProductCartWithContent>> = emptyFlow(),
    val error: String = ""
)
