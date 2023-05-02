package com.example.potolki.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.potolki.presentation.cart.MaterialCartScreen
import com.example.potolki.presentation.favourite.MaterialFavouriteScreen
import com.example.potolki.presentation.menu.MaterialBaseListScreen


@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = BottomBarScreen.MaterialMenuScreen.route ){

        composable(route = BottomBarScreen.MaterialMenuScreen.route){
            MaterialBaseListScreen(navController = navHostController)
        }

        composable(route = BottomBarScreen.MaterialCartScreen.route){
            MaterialCartScreen()
        }

        composable(route = BottomBarScreen.MaterialFavoritesScreen.route){
            MaterialFavouriteScreen()
        }
    }
}