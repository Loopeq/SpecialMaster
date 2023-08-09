package com.example.potolki.domain.use_case.product_view_use_case

import android.util.Log
import com.example.potolki.common.Resource
import com.example.potolki.common.Source
import com.example.potolki.data.remote.model.server.ProductViewDto
import com.example.potolki.domain.repository.MaterialRepository
import com.example.potolki.domain.repository.ProductViewRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetProductView @Inject constructor(
    private val repository: ProductViewRepository
) {
    operator fun invoke(review_id: Int): Flow<Resource<List<ProductViewDto>>> = flow {
        try {
            emit(Resource.Loading<List<ProductViewDto>>())
            val productView = repository.getProductView(review_id)
            emit(Resource.Success<List<ProductViewDto>>(productView))
        } catch (e: Exception) {
            emit(Resource.Error<List<ProductViewDto>>(message = e.toString()))
        }
    }
}