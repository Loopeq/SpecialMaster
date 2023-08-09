package com.example.potolki.presentation.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.potolki.R
import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.data.remote.model.client.ProductCartWithContent
import com.example.potolki.presentation.cart.components.CreateOrderBox
import com.example.potolki.presentation.cart.components.ProductCartBlankScreen
import com.example.potolki.presentation.cart.components.ProductCartItem

import com.example.potolki.presentation.favourite.components.LoadingScreen
import com.example.potolki.presentation.navigation.TopMaterialAppBar

@Composable
fun ProductCartScreen(
    navController: NavController, bottomBarPaddingValues: PaddingValues,
    viewModel: ProductCartViewModel = hiltViewModel()
) {
    val state by viewModel.state
    val productCart by state.productCart.collectAsState(initial = emptyList())
    val totalPrice by viewModel.totalPrice.collectAsState(initial = 0)
    val cancelButtonState = viewModel.cancelButtonState
    Scaffold(
        topBar = { TopMaterialAppBar(text = stringResource(id = R.string.cart), navController = navController) }
    ) { paddingValue ->
        if(state.isLoading){
            LoadingScreen(bottomPaddingValues = bottomBarPaddingValues)
        }
        else if(productCart.isNotEmpty()) {
            MaterialCartScreenContent(
                paddingValues = paddingValue,
                bottomBarPaddingValues = bottomBarPaddingValues,
                productCart = productCart,
                onIncDecPressed = {
                                  inc, productCart, price, unit ->
                    viewModel.updateProductCart(inc, productCart, price, unit)
                },
                deleteItemFromCart = { productCart -> viewModel.deleteProductFromCart(productCart) },
                totalPrice = totalPrice,
                createOrder = {},
                navController = navController,
                cancelButtonState = cancelButtonState
            )
        } else {
            ProductCartBlankScreen(bottomBarPaddingValues = bottomBarPaddingValues)
        }
    }
}

@Composable
fun MaterialCartScreenContent(
    modifier: Modifier = Modifier, paddingValues: PaddingValues,
    bottomBarPaddingValues: PaddingValues,
    navController: NavController,
    productCart: List<ProductCartWithContent>,
    onIncDecPressed: (Boolean, ProductCartDto, Int, Double) -> Unit,
    deleteItemFromCart: (ProductCartDto) -> Unit,
    totalPrice: Int,
    cancelButtonState: Boolean,
    createOrder: () -> Unit,
) {

    Column(modifier = modifier.padding(
        top = paddingValues.calculateTopPadding(),
        bottom = bottomBarPaddingValues.calculateBottomPadding()
    )) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 10.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),

            ) {
            item { Spacer(modifier = Modifier.height(3.dp)) }
            itemsIndexed(productCart) { index, item ->
                ProductCartItem(
                    item = item,
                    onIncDecPressed = onIncDecPressed,
                    deleteItemFromCart = deleteItemFromCart,
                    cancelButtonState = cancelButtonState,
                navController = navController)
                if (index < productCart.lastIndex) {
                    Divider(color = Color.LightGray, thickness = 1.dp)
                }
            }
        }
        CreateOrderBox(totalPrice = totalPrice, createOrder = createOrder
        )
    }
}