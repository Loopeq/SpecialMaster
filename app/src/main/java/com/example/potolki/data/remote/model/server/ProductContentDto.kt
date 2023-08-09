package com.example.potolki.data.remote.model.server

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_content")
data class ProductContentDto(
    @PrimaryKey val id: Int? = null,
    val review_id: Int,
    val view_id: Int,
    val title: String,
    @ColumnInfo(typeAffinity = ColumnInfo.REAL)
    val amount: Double,
    val unit: String,
    val imageSrc: String,
    val price: String,
    val description: String
)
