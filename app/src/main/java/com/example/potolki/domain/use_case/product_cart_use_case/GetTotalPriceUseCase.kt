package com.example.potolki.domain.use_case.product_cart_use_case

import com.example.potolki.domain.repository.ProductCartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTotalPriceUseCase @Inject constructor(
    private val productCartRepository: ProductCartRepository
) {
    operator fun invoke(): Flow<Int>{
        return productCartRepository.getTotalSumFromCart()
    }
}