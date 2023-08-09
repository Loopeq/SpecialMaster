package com.example.potolki.data.remote.model.client

import androidx.room.Embedded
import androidx.room.Relation
import com.example.potolki.data.remote.model.server.ProductContentDto

data class ProductCartWithContent(
    @Embedded
    val product_cart: ProductCartDto,
    @Relation(entity = ProductContentDto::class, parentColumn = "product_id", entityColumn = "id")
    val product_content: ProductContentDto
)
