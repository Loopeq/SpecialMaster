package com.example.potolki.domain.use_case.product_review_use_case

import android.util.Log
import com.example.potolki.common.Resource
import com.example.potolki.data.remote.model.server.ProductsReviewDto
import com.example.potolki.domain.repository.MaterialRepository
import com.example.potolki.domain.repository.ProductViewRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsReview @Inject constructor(
    private val repository: ProductViewRepository
) {
    operator fun invoke(): Flow<Resource<List<ProductsReviewDto>>> = flow{
        try{
            emit(Resource.Loading<List<ProductsReviewDto>>())
            val productReview = repository.getProductsReview()
            emit(Resource.Success<List<ProductsReviewDto>>(productReview))
        } catch(e: java.lang.Exception){
            Log.d("Logi", "error in get materials use case $e")
        }
    }
}