package com.example.potolki.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.potolki.R

sealed class BottomBarScreen(
    val route: String,
    val icon: ImageVector,
    val title: Int
) {
    object MaterialMenuScreen : BottomBarScreen(
        "material_base_list_screen",
        icon = Icons.Default.Home,
        title = R.string.menu
    )
    object MaterialCartScreen: BottomBarScreen(
        "material_cart_screen",
        icon = Icons.Outlined.ShoppingCart,
        title = R.string.cart
    )
    object MaterialFavoritesScreen: BottomBarScreen(
        "material_favourites_screen",
        icon = Icons.Filled.FavoriteBorder,
        title = R.string.favourites
    )
}