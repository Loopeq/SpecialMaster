package com.example.potolki.presentation.cart

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potolki.common.Resource
import com.example.potolki.data.remote.model.client.OrdersItemDto
import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.domain.repository.ProductCartRepository
import com.example.potolki.domain.repository.ProductOrderRepository
import com.example.potolki.domain.use_case.orders_use_case.InsertOrderItemUseCase
import com.example.potolki.domain.use_case.product_cart_use_case.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductCartViewModel @Inject constructor(
    private val getProductCartUseCase: GetProductCartUseCase,
    private val getTotalPriceUseCase: GetTotalPriceUseCase,
    private val updateProductCartUseCase: UpdateProductCartUseCase,
    private val deleteProductFromCartUseCase: DeleteProductFromCartUseCase,
    private val insertOrderItemUseCase: InsertOrderItemUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(ProductCartState())
    val state: State<ProductCartState> = _state

    val totalPrice = getTotalPriceUseCase()
    var cancelButtonState by mutableStateOf(true)

    init {
        viewModelScope.launch {
            getProductCart()
        }
    }

    private fun getProductCart() {
        getProductCartUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = ProductCartState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ProductCartState(productCart = result.data ?: emptyFlow())
                }
                is Resource.Error -> {
                    _state.value = ProductCartState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }

    internal fun deleteProductFromCart(product: ProductCartDto) {
        viewModelScope.launch {
            deleteProductFromCartUseCase(product)
        }
    }

    internal fun updateProductCart(
        inc: Boolean,
        productCartDto: ProductCartDto,
        price: Int,
        unit: Double
    ) {
        viewModelScope.launch {
            cancelButtonState = false
            updateProductCartUseCase(
                inc = inc, productCartDto = productCartDto,
                price = price, unit = unit
            )
            cancelButtonState = true
        }

    }

    internal fun createOrder(){
        val productsCart: MutableList<ProductCartDto> = mutableListOf()
        viewModelScope.launch {
            state.value.productCart.first().forEach {
                productsCart.add(it.product_cart)
            }
            Log.d("logi", productsCart.toString())
            insertOrderItemUseCase(productsCart)
        }
    }

}

