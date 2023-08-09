package com.example.potolki.presentation.product_view_or_content.product_content

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.potolki.R
import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.presentation.navigation.Screens
import com.example.potolki.presentation.navigation.TopMaterialDescriptionAppBar
import com.example.potolki.presentation.ui.FontSizes

@Composable
fun ProductContentScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    productContentState: List<ProductContentDto>,
) {
    Scaffold(
        topBar = {
            TopMaterialDescriptionAppBar(navController = navController)
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 15.dp, vertical = 15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(productContentState) { productContent ->
                ProductContentScreenContent(
                    paddingValues = paddingValues,
                    productContent = productContent,
                    navController = navController,
                )
            }
        }
    }
}

@Composable
fun ProductContentScreenContent(
    modifier: Modifier = Modifier, paddingValues: PaddingValues,
    productContent: ProductContentDto,
    navController: NavController,
) {
    Row() {
        Card(elevation = 3.dp, modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(bottom = 5.dp)
            .clickable {
                navController.navigate(Screens.ProductContentViewScreen.route + "/${productContent.id}")
            }) {
            Row {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(
                            LocalContext.current
                        ).data(productContent.imageSrc).build()
                    ), contentDescription = "image",
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(160.dp),
                    contentScale = ContentScale.FillBounds
                )


                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                ) {
                    Text(
                        text = productContent.title,
                        style = MaterialTheme.typography.h3.copy(fontSize = FontSizes.medium),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                    )
                    Row {
                        Column {
                            Text(
                                text = productContent.price + stringResource(id = R.string.rub),
                                style = MaterialTheme.typography.h1.copy(fontSize = FontSizes.large),
                                color = MaterialTheme.colors.primary
                            )
                            Spacer(modifier = Modifier.weight(1f))

                            Text(
                                text = productContent.unit,
                                style = MaterialTheme.typography.h3.copy(fontSize = FontSizes.small)
                            )
                        }
                    }
                }
            }
        }
    }


}