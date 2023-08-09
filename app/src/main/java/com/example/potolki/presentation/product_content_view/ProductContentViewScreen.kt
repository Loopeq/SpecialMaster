package com.example.potolki.presentation.product_content_view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.potolki.R
import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.presentation.favourite.components.LoadingScreen
import com.example.potolki.presentation.navigation.BottomBarScreen
import com.example.potolki.presentation.navigation.TopMaterialDescriptionAppBar
import com.example.potolki.presentation.ui.FontSizes

@Composable
fun ProductContentViewScreen(
    viewModel: ProductContentViewViewModel = hiltViewModel(),
    navController: NavController
) {

    val state = viewModel.state.value
    val inCart = viewModel.inCart.collectAsState(initial = false).value
    if (state.isLoading) {
        LoadingScreen(bottomPaddingValues = PaddingValues(0.dp))
    } else if (state.productContentView != null) {
        ProductContentViewScreenContent(
            productContentView = state.productContentView,
            navController = navController,
            insertProductToCart = {
                                  productCartDto ->
                viewModel.insertProductToCart(productCartDto)
            },
            inCart = inCart
        )
    }
}

@Composable
fun ProductContentViewScreenContent(
    modifier: Modifier = Modifier,
    productContentView: ProductContentDto,
    inCart: Boolean,
    navController: NavController,
    insertProductToCart: (ProductCartDto) -> Unit,
) {
    Scaffold(topBar = {
        TopMaterialDescriptionAppBar(
            navController = navController
        )
    }) {
        Box {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(it.calculateTopPadding()), verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(
                            LocalContext.current
                        ).data(productContentView.imageSrc).build()
                    ), contentDescription = "image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    contentScale = ContentScale.FillBounds
                )
                Card(elevation = 4.dp, modifier = Modifier.padding(10.dp)) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Min)
                            .padding(12.dp)
                    ) {
                        Text(
                            text = productContentView.title,
                            style = MaterialTheme.typography.h1.copy(fontSize = FontSizes.large),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)
                        ) {
                            Text(
                                text = productContentView.price + stringResource(id = R.string.rub),
                                style = MaterialTheme.typography.h1.copy(fontSize = FontSizes.large),
                                color = MaterialTheme.colors.primary,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "/ " + productContentView.unit,
                                style = MaterialTheme.typography.h4.copy(fontSize = FontSizes.small),
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(top = 8.dp)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            OutlinedButton(
                                onClick = {
                                    if(inCart){
                                        navController.navigate(BottomBarScreen.MaterialCartScreen.route)
                                    }
                                    else{
                                        insertProductToCart(
                                            ProductCartDto(
                                                product_id = productContentView.id!!.toInt(),
                                                totalPrice = productContentView.price.toInt(),
                                                totalUnit = productContentView.amount
                                            )
                                        )
                                    }
                                },
                                modifier = Modifier
                                    .align(Alignment.Bottom)
                                    .padding(end = 4.dp), colors = ButtonDefaults.buttonColors(
                                    backgroundColor = if(inCart) Color.LightGray else MaterialTheme.colors.primary,
                                ),
                                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
                            ) {
                                Text(
                                    text = if(inCart) stringResource(
                                        id = R.string.move_to_cart) else stringResource(id = R.string.add_to_cart)
                                    ,
                                    style = MaterialTheme.typography.h1.copy(fontSize = FontSizes.small),
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )

                            }
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Divider(color = Color.LightGray, thickness = 1.dp, startIndent = 1.dp)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = stringResource(id = R.string.productUnitInf) +
                                    " ${productContentView.amount} ${productContentView.unit} /шт.",
                            style = MaterialTheme.typography.h4.copy(fontSize = FontSizes.small)
                        )
                    }
                }

            }
            var isFav by remember { mutableStateOf(false) }
            Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.fillMaxSize()) {
                IconButton(
                    onClick = { isFav = !isFav },
                    modifier = Modifier.padding(top = 8.dp, end = 8.dp)
                ) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = null,
                        modifier = Modifier.size(28.dp),
                        tint = if (isFav) MaterialTheme.colors.primary else Color.Gray
                    )
                }
            }
        }

    }
}