package com.example.potolki.data.remote.model.server

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products_review")
data class ProductsReviewDto(
    @PrimaryKey val id: Int? = null,
    val title: String,
    val imageSrc: String
)


