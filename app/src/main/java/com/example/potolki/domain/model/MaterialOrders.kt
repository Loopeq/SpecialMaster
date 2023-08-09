package com.example.potolki.domain.model

data class MaterialOrders(
    val id: Int,
    val order: Boolean = false,
    val title: String,
    val imageSrc: String,
    val count: Int,
    val price: Int
)
