package com.example.potolki.domain.use_case.orders_use_case

import com.example.potolki.data.remote.model.client.OrdersItemDto
import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.domain.repository.ProductOrderRepository
import javax.inject.Inject

class InsertOrderItemUseCase @Inject constructor(
    private val productOrderRepository: ProductOrderRepository
) {
    suspend operator fun invoke(productsCartDto: List<ProductCartDto>){
        val orderItems: MutableList<OrdersItemDto> = mutableListOf()
        productsCartDto.forEach { productCart ->
            val orderItem = OrdersItemDto(
                product_id = productCart.product_id,
                order_id = 0,
                created_at = "22.02.2007",
                price = productCart.totalPrice,
                unit = productCart.totalUnit
            )
            orderItems.add(orderItem)
        }
        productOrderRepository.insertOrderItem(orderItems)
    }
}