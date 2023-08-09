package com.example.potolki.presentation.product_review

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potolki.common.Resource
import com.example.potolki.domain.use_case.product_review_use_case.GetProductsReview
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel()
class ProductReviewViewModel @Inject constructor(
    private val getProductsReview: GetProductsReview
): ViewModel() {

    private val _state = mutableStateOf(ProductReviewState())
    val state: State<ProductReviewState> = _state

    init{
        getProductsReviewInit()
    }

    private fun getProductsReviewInit(){
        getProductsReview().onEach{ result ->
            when(result){
                is Resource.Success -> {
                    _state.value = ProductReviewState(productReview = result.data ?: emptyList())
                }
                is Resource.Loading ->
                    _state.value = ProductReviewState(isLoading = true)

                is Resource.Error ->
                    _state.value = ProductReviewState(error = result.message ?: "")
            }
        }.launchIn(viewModelScope)

    }
}