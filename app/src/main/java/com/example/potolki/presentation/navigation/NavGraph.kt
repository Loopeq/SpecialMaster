package com.example.potolki.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.potolki.presentation.cart.ProductCartScreen
import com.example.potolki.presentation.favourite.MaterialFavouriteScreen
import com.example.potolki.presentation.product_review.ProductReviewScreen
import com.example.potolki.presentation.other.CitySettingsScreen
import com.example.potolki.presentation.product_content_view.ProductContentViewScreen
import com.example.potolki.presentation.product_content_view.ProductContentViewViewModel
import com.example.potolki.presentation.profile.ProfileScreen
import com.example.potolki.presentation.product_view_or_content.ProductViewOrContentScreen
import com.example.potolki.presentation.product_view_or_content.ProductViewOrContentViewModel


@Composable
fun NavGraph(navHostController: NavHostController, bottomBarPaddingValues: PaddingValues) {
    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreen.MaterialMenuScreen.route
    ) {

        composable(route = Screens.CitySettingsScreen.route) {
            CitySettingsScreen(navController = navHostController)
        }


        composable(route = BottomBarScreen.MaterialMenuScreen.route) {
            ProductReviewScreen(
                navController = navHostController,
                bottomBarPaddingValues = bottomBarPaddingValues
            )
        }

        composable(route = BottomBarScreen.MaterialCartScreen.route) {
            ProductCartScreen(
                navController = navHostController,
                bottomBarPaddingValues = bottomBarPaddingValues
            )
        }

        composable(route = BottomBarScreen.MaterialFavoritesScreen.route) {
            MaterialFavouriteScreen(
                navController = navHostController,
                bottomPaddingValues = bottomBarPaddingValues
            )
        }
        composable(route = BottomBarScreen.MaterialOrdersScreen.route) {

        }

        composable(route = BottomBarScreen.MaterialProfileScreen.route) {
            ProfileScreen(bottomPaddingValues = bottomBarPaddingValues)
        }




        composable(
            route = Screens.ProductViewOrContent.route + "/{review_id}" + "/{view_id}",
            arguments = (listOf(
                navArgument("review_id") { type = NavType.IntType},
                navArgument("view_id") { type = NavType.IntType}
            ))
        ) {
            navBackStackEntry ->
            val viewModel: ProductViewOrContentViewModel = hiltViewModel()
            ProductViewOrContentScreen(navController = navHostController, viewModel = viewModel)
        }

        composable(
            route = Screens.ProductContentViewScreen.route + "/{id}",
            arguments = (listOf(
                navArgument("id") { type = NavType.IntType}
            ))
        ){
            navBackStackEntry ->
            val viewModel: ProductContentViewViewModel = hiltViewModel()
            ProductContentViewScreen(viewModel = viewModel, navController = navHostController)
        }
    }

}