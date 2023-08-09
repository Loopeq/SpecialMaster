package com.example.potolki.data.database

import androidx.room.Dao
import androidx.room.Insert
import com.example.potolki.data.remote.model.client.OrdersItemDto


@Dao
interface ProductOrderDao {
    @Insert
    suspend fun insertOrderItem(orderItemDto: List<OrdersItemDto>)

}