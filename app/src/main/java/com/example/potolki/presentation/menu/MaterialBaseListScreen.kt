package com.example.potolki.presentation.menu

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.potolki.domain.model.Materials
import com.example.potolki.presentation.menu.components.MaterialBaseListItem
import com.example.potolki.presentation.menu.components.MaterialBaseListTopBar

@Composable
fun MaterialBaseListScreen(
    navController: NavController,
    viewModel: MaterialBaseListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shadowElevation = 10.dp
            ) {
                MaterialBaseListTopBar()
            }
        },
    ) { paddingValues ->
        MaterialBaseListScreenContent(modifier = Modifier.padding(paddingValues), state.material)
    }

}

@Composable
fun MaterialBaseListScreenContent(modifier: Modifier = Modifier, materials: List<Materials>) {
    val lzGridState = rememberLazyGridState()
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(), state = lzGridState,
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(materials) { material ->
            MaterialBaseListItem(material = material)
        }
    }
}


