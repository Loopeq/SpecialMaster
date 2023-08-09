package com.example.potolki.domain.repository

import com.example.potolki.data.remote.model.client.OrdersItemDto

interface ProductOrderRepository {

    suspend fun insertOrderItem(ordersItemDto: List<OrdersItemDto>)
}