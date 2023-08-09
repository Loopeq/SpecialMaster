package com.example.potolki.domain.use_case.product_cart_use_case

import com.example.potolki.domain.repository.ProductCartRepository
import javax.inject.Inject

class DeleteAllFromCartUseCase @Inject constructor(
    private val productCartRepository: ProductCartRepository
) {

    suspend operator fun invoke(){
        productCartRepository.deleteAllFromCart()
    }
}