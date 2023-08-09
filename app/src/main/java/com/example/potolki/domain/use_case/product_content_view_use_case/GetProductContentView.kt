package com.example.potolki.domain.use_case.product_content_view_use_case

import com.example.potolki.common.Resource
import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.domain.repository.MaterialRepository
import com.example.potolki.domain.repository.ProductViewRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductContentView @Inject constructor(
    private val repository: ProductViewRepository
) {

    operator fun invoke(id: Int): Flow<Resource<ProductContentDto>> = flow{
        try{
            emit(Resource.Loading<ProductContentDto>())
            val productContentView = repository.getProductContentView(id)
            emit(Resource.Success<ProductContentDto>(productContentView))
        } catch (e: java.lang.Exception){
            emit(Resource.Error<ProductContentDto>(e.toString()))
        }
    }
}