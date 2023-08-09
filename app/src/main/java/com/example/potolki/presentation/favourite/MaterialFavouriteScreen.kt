package com.example.potolki.presentation.favourite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.potolki.R
import com.example.potolki.domain.model.Material
import com.example.potolki.presentation.favourite.components.MaterialFavouriteCartItem
import com.example.potolki.presentation.favourite.components.MaterialFavouriteEmptyScreen
import com.example.potolki.presentation.favourite.components.LoadingScreen
import com.example.potolki.presentation.navigation.TopMaterialAppBar

@Composable
fun MaterialFavouriteScreen(modifier: Modifier = Modifier, navController: NavController,
viewModel: MaterialFavouriteScreenViewModel = hiltViewModel(),
bottomPaddingValues: PaddingValues) {
    val state = viewModel.state.value
    Scaffold(topBar = {
        TopMaterialAppBar(
            text = stringResource(id = R.string.favourites),
            navController = navController
        )
    }){paddingValues ->
        if(state.isLoading) {
            LoadingScreen(bottomPaddingValues = bottomPaddingValues)
        }
        else if (state.material.isEmpty()){
            MaterialFavouriteEmptyScreen(bottomPaddingValues = bottomPaddingValues)
        }
        else {
            MaterialFavouriteScreenContent(
                paddingValues = paddingValues, bottomPaddingValues = bottomPaddingValues,
            materials = state.material)
        }

    }
}


@Composable
fun MaterialFavouriteScreenContent(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues, bottomPaddingValues: PaddingValues, materials: List<Material>
) {
    LazyColumn(modifier = modifier
        .fillMaxSize()
        .padding(
            top = paddingValues.calculateTopPadding(),
            bottom = bottomPaddingValues.calculateBottomPadding()
        ),
    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(materials){ item ->
            MaterialFavouriteCartItem(item = item)
        }
    }

}