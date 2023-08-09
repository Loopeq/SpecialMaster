package com.example.potolki.domain.use_case.product_cart_use_case

import com.example.potolki.common.Resource
import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.data.remote.model.client.ProductCartWithContent
import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.domain.repository.ProductCartRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetProductCartUseCase @Inject constructor(
    private val productCartRepository: ProductCartRepository,
) {
    operator fun invoke(): Flow<Resource<Flow<List<ProductCartWithContent>>>> = flow{
        try{
            emit(Resource.Loading<Flow<List<ProductCartWithContent>>>())
            val productCartWithContent = productCartRepository.getProductCart()
            emit(Resource.Success<Flow<List<ProductCartWithContent>>>(productCartWithContent))
        } catch (e: java.lang.Exception){
            emit(Resource.Error<Flow<List<ProductCartWithContent>>>(e.toString()))
        }
    }
}

