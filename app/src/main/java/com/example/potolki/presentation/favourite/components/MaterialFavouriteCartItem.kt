package com.example.potolki.presentation.favourite.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.potolki.R
import com.example.potolki.domain.model.Material

@Composable
fun MaterialFavouriteCartItem(modifier: Modifier = Modifier, item: Material) {
    val imageSize = 128.dp
    Row(
        modifier = modifier
            .fillMaxSize()
            .clickable {

            }
    ) {
        Image(
            painterResource(id = item.imageSrc), contentDescription = "image",
            modifier = Modifier.size(imageSize), contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(imageSize)
        ) {
            Row {
                Text(item.title, style = MaterialTheme.typography.h3, maxLines = 1)
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Outlined.Close, contentDescription = "close",
                    modifier = Modifier.clickable{})
            }
            Text(text = item.description, style = MaterialTheme.typography.h6.copy(fontSize = 14.sp), maxLines = 2)
            Spacer(modifier = Modifier.weight(1f))
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    item.price.toString() + "₽", style = MaterialTheme.typography.h4.copy(fontSize = 18.sp),
                    modifier = Modifier.padding(bottom = 8.dp, start = 8.dp),
                )
                Spacer(modifier = Modifier.weight(1f))
                OutlinedButton(
                    onClick = {
                    }, modifier = Modifier
                        .padding(end = 4.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primaryVariant
                    )
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "add",
                    tint = Color.Black)
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        Icons.Filled.ShoppingCart, contentDescription = null,
                        tint = Color.Black
                    )
                }
            }
        }
    }
}