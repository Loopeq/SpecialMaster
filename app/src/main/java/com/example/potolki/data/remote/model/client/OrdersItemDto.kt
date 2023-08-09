package com.example.potolki.data.remote.model.client

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "orders_item")
data class OrdersItemDto(
    @PrimaryKey val id: Int? = null,
    val product_id: Int,
    val order_id: Int,
    val created_at: String,
    val price: Int,
    @ColumnInfo(typeAffinity = ColumnInfo.REAL)
    val unit: Double
)
