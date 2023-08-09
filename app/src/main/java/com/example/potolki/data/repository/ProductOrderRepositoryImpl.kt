package com.example.potolki.data.repository

import com.example.potolki.data.database.ProductOrderDao
import com.example.potolki.data.remote.model.client.OrdersItemDto
import com.example.potolki.domain.repository.ProductOrderRepository

class ProductOrderRepositoryImpl(private val productOrderDao: ProductOrderDao): ProductOrderRepository {

    override suspend fun insertOrderItem(ordersItemDto: List<OrdersItemDto>) {
        productOrderDao.insertOrderItem(ordersItemDto)
    }

}