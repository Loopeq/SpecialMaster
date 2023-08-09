package com.example.potolki.domain.use_case.product_content_view_use_case

import com.example.potolki.domain.repository.ProductCartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CheckProductInCartUseCase @Inject constructor(
    private val productCartRepository: ProductCartRepository
){
    operator fun invoke(id: Int): Flow<Boolean>{
        return productCartRepository.checkProductInCart(id)
    }
}