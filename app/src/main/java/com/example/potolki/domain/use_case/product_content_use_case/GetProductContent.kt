package com.example.potolki.domain.use_case.product_content_use_case

import android.widget.ResourceCursorAdapter
import com.example.potolki.common.Resource
import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.data.remote.model.server.ProductsReviewDto
import com.example.potolki.domain.repository.MaterialRepository
import com.example.potolki.domain.repository.ProductViewRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductContent @Inject constructor(
    private val repository: ProductViewRepository
) {
    operator fun invoke(review_id: Int, view_id: Int): Flow<Resource<List<ProductContentDto>>> = flow{
        try{
            emit(Resource.Loading<List<ProductContentDto>>())
            val productContent = repository.getProductContent(view_id = view_id, review_id = review_id)
            emit(Resource.Success<List<ProductContentDto>>(productContent))
        } catch (e: Exception){
            emit(Resource.Error<List<ProductContentDto>>(e.toString()))
        }
    }
}