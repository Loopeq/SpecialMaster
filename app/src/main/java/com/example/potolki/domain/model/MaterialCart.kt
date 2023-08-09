package com.example.potolki.domain.model

data class MaterialCart(
    val id: Int,
    val title: String,
    val parentId: Int,
    val price: Int,
    val imageSrc: Int,
    val totalPrice: Int,
    val count: Int
)
