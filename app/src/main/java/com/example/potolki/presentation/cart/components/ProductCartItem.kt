package com.example.potolki.presentation.cart.components

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.potolki.R
import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.data.remote.model.client.ProductCartWithContent
import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.presentation.ui.FontSizes

@Composable
fun ProductCartItem(
    modifier: Modifier = Modifier,
    navController: NavController,
    cancelButtonState: Boolean,
    item: ProductCartWithContent,
    onIncDecPressed: (Boolean, ProductCartDto, Int, Double) -> Unit,
    deleteItemFromCart: (ProductCartDto) -> Unit,
) {
    val imageSize = 128.dp
    Row(
        modifier = modifier
            .fillMaxSize()
            .clickable {

            }
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(
                    LocalContext.current
                ).data(item.product_content.imageSrc).build()
            ), contentDescription = "image",
            modifier = Modifier.size(imageSize), contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(imageSize)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    item.product_content.title,
                    style = MaterialTheme.typography.h1.copy(fontSize = FontSizes.medium),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )

                Icon(
                    Icons.Outlined.Close, contentDescription = "close",
                    modifier = Modifier.clickable {
                        if(cancelButtonState) deleteItemFromCart(item.product_cart)
                    }
                )

            }
            Row {
                Text(
                    item.product_content.price + stringResource(id = R.string.rub),
                    style = MaterialTheme.typography.h4.copy(fontSize = FontSizes.medium),
                    modifier = Modifier.padding(top = 3.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = Modifier.fillMaxWidth()) {
                AddRemoveBox(
                    itemContent = item.product_content,
                    itemCart = item.product_cart,
                    onIncDecPressed = onIncDecPressed
                )
                Spacer(modifier.weight(1f))
                Text(
                    item.product_cart.totalPrice.toString() + stringResource(id = R.string.rub),
                    style = MaterialTheme.typography.h1.copy(fontSize = FontSizes.medium),
                    maxLines = 2,
                    color = MaterialTheme.colors.primary,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .align(Alignment.CenterVertically)
                )
            }


        }
    }
}


