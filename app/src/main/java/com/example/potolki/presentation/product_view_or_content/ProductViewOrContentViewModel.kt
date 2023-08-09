package com.example.potolki.presentation.product_view_or_content

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potolki.common.Resource
import com.example.potolki.domain.use_case.product_content_use_case.GetProductContent
import com.example.potolki.domain.use_case.product_view_use_case.GetProductView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductViewOrContentViewModel @Inject constructor(
    private val getProductView: GetProductView,
    private val getProductContent: GetProductContent,

    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ProductViewOrContentState())
    val state: State<ProductViewOrContentState> = _state

    private val review_id: Int = checkNotNull(savedStateHandle["review_id"])
    private val view_id: Int = checkNotNull(savedStateHandle["view_id"])

    init {
        if(view_id == 0) {
            getProductViewInit(review_id, view_id = view_id)
        }
        else {
            getProductContentInit(review_id, view_id)
        }
    }

    private fun getProductViewInit(review_id: Int, view_id: Int) {
        getProductView(review_id).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = ProductViewOrContentState(isLoading = true)
                }
                is Resource.Success -> {
                    if(result.data.isNullOrEmpty()){
                        getProductContentInit(review_id, view_id)
                    } else {
                        _state.value = ProductViewOrContentState(
                            productView = result.data ?: emptyList(),
                            isView = true
                        )
                    }
                }
                is Resource.Error -> {
                    _state.value = ProductViewOrContentState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getProductContentInit(review_id: Int, view_id: Int){
        getProductContent(review_id, view_id).onEach {
            result ->
            when(result){
                is Resource.Loading -> {
                    _state.value = ProductViewOrContentState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ProductViewOrContentState(productContent = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ProductViewOrContentState(error = result.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }



}