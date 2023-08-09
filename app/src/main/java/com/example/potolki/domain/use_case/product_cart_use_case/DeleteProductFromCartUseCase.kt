package com.example.potolki.domain.use_case.product_cart_use_case

import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.domain.repository.ProductCartRepository
import javax.inject.Inject

class DeleteProductFromCartUseCase @Inject constructor(
    private val productCartRepository: ProductCartRepository
) {

    suspend operator fun invoke(product: ProductCartDto){
        productCartRepository.deleteProductFromCart(product)
    }

}