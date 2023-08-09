package com.example.potolki.presentation.product_content_view

import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potolki.common.Resource
import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.domain.use_case.product_cart_use_case.InsertProductToCartUseCase
import com.example.potolki.domain.use_case.product_content_view_use_case.CheckProductInCartUseCase
import com.example.potolki.domain.use_case.product_content_view_use_case.GetProductContentView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductContentViewViewModel @Inject constructor(
    private val getProductContentView: GetProductContentView,
    private val insertProductToCartUseCase: InsertProductToCartUseCase,
    private val checkProductInCartUseCase: CheckProductInCartUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ProductContentViewState())
    val state: State<ProductContentViewState> = _state

    private val id: Int = checkNotNull(savedStateHandle["id"])

    val inCart = checkProductInCartUseCase(id)


    init {
        getProductContentViewInit(id)
    }

    private fun getProductContentViewInit(id: Int) {
        getProductContentView(id).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = ProductContentViewState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ProductContentViewState(productContentView = result.data)
                }
                is Resource.Error -> {
                    _state.value = ProductContentViewState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }

    internal fun insertProductToCart(product: ProductCartDto){
        viewModelScope.launch {
            insertProductToCartUseCase(product)
        }
    }



}
