package com.example.potolki.data.remote.model.client

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "order")
data class Order(
    @PrimaryKey val id: Int? = null,
    val order_id: Int,
    @ColumnInfo(name = "create_at")
    val create_at: String,
    val email: String,
    val phone: String,
    val region: String,
    val payment: String,
    val status: String,
    val total_price: Int,
    @ColumnInfo(typeAffinity = ColumnInfo.REAL)
    val total_unit: Double
)
