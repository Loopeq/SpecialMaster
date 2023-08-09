package com.example.potolki.data.remote.model.server

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_view")
data class ProductViewDto(
    @PrimaryKey val id: Int? = null,
    val review_id: Int,
    val title: String,
    val imageSrc: String
)
