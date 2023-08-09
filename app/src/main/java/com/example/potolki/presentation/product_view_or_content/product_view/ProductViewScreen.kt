package com.example.potolki.presentation.product_view.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.potolki.data.remote.model.server.ProductViewDto
import com.example.potolki.presentation.navigation.Screens
import com.example.potolki.presentation.navigation.TopMaterialAppBar
import com.example.potolki.presentation.ui.FontSizes

@Composable
fun ProductViewScreen(productViewState: List<ProductViewDto>, modifier: Modifier = Modifier,
navController: NavController) {
    Scaffold(modifier = modifier.fillMaxSize(),
    topBar = { TopMaterialAppBar(text = "", navController = navController)}) {
        paddingValues ->

        LazyVerticalGrid(modifier = Modifier.padding(paddingValues.calculateTopPadding()),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ){
            items(productViewState){ productView ->
                ProductViewContent(productView = productView, navController = navController)
            }
        }
    }

}


@Composable
fun ProductViewContent(modifier: Modifier = Modifier, productView: ProductViewDto, navController: NavController) {
    Card(elevation = 4.dp, modifier = modifier.height(250.dp).clickable {
        navController.navigate(Screens.ProductViewOrContent.route + "/${productView.review_id}" + "/${productView.id}")
    }){
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Image(
                painter = rememberAsyncImagePainter(model = ImageRequest.Builder(
                    LocalContext.current
                ).data(productView.imageSrc).build()), contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth().height(160.dp),
                contentScale = ContentScale.FillBounds
            )
            Box(modifier = Modifier.fillMaxSize().padding(5.dp), contentAlignment = Alignment.Center) {
                Text(
                    text = productView.title,
                    style = MaterialTheme.typography.h3.copy(fontSize = FontSizes.medium),
                    textAlign = TextAlign.Center,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            }
    }
}