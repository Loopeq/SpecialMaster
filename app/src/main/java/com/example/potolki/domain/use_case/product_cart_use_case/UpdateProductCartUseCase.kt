package com.example.potolki.domain.use_case.product_cart_use_case

import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.domain.repository.ProductCartRepository
import javax.inject.Inject

class UpdateProductCartUseCase @Inject constructor(
    private val productCartRepository: ProductCartRepository
) {
    suspend operator fun invoke(
        inc: Boolean,
        productCartDto: ProductCartDto,
        price: Int,
        unit: Double
    ) {
        val newPrice: Int =
            if (inc) productCartDto.totalPrice + price else
                if (productCartDto.totalPrice - price > 0)
                    (productCartDto.totalPrice - price)
                else productCartDto.totalPrice
        val newUnit: Double =
            if (inc) productCartDto.totalUnit + unit else
                if (productCartDto.totalUnit - unit > 0)
                    (productCartDto.totalUnit - unit)
                else productCartDto.totalUnit
        productCartRepository.updateProductInCart(
            ProductCartDto(
                id = productCartDto.id, totalPrice = newPrice,
                totalUnit = newUnit, product_id = productCartDto.product_id
            )
        )
    }
}