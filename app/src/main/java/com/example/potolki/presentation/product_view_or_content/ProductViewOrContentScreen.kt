package com.example.potolki.presentation.product_view_or_content

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.potolki.presentation.favourite.components.LoadingScreen
import com.example.potolki.presentation.navigation.Screens
import com.example.potolki.presentation.product_view.components.ProductViewScreen
import com.example.potolki.presentation.product_view_or_content.product_content.ProductContentScreen

@Composable
fun ProductViewOrContentScreen(
    navController: NavController, viewModel: ProductViewOrContentViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    if (state.isLoading) {
        LoadingScreen(bottomPaddingValues = PaddingValues(0.dp))
    }
    else if (state.isView && state.productView.isNotEmpty()) {
        ProductViewScreen(productViewState = state.productView, navController = navController)
    }
    else if(!state.isView && state.productContent.isNotEmpty()){
        ProductContentScreen(productContentState = state.productContent, navController = navController)
    }

}

