package com.example.potolki.data.remote.model.client

import androidx.room.*
import com.example.potolki.data.remote.model.server.ProductContentDto


@Entity(tableName = "product_cart")
data class ProductCartDto(
    @PrimaryKey val id: Int? = null,
    val product_id: Int,
    @ColumnInfo(typeAffinity = ColumnInfo.REAL)
    val totalUnit: Double,
    val totalPrice: Int,
)





