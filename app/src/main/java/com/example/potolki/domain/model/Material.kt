package com.example.potolki.domain.model

data class Material(
    val amount: String,
    val unit: String,
    val id: Int,
    val parentId: Int,
    val title: String,
    val imageSrc: Int,
    val description: String,
    val price: Int,
)
