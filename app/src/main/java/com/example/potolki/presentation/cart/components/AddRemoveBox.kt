package com.example.potolki.presentation.cart.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.presentation.ui.FontSizes

@Composable
fun AddRemoveBox(modifier: Modifier = Modifier,
                 itemContent: ProductContentDto,
                 itemCart: ProductCartDto,
                 onIncDecPressed: (Boolean, ProductCartDto, Int, Double) -> Unit,
){

    Box(modifier = modifier
        .height(50.dp)
        .padding()){
        Row(modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
            IconButton(onClick = {
                onIncDecPressed(false, itemCart, itemContent.price.toInt(), itemContent.amount)
            }) {
                Icon(Icons.Outlined.Remove, contentDescription = null, tint = MaterialTheme.colors.primary)
            }

            BasicTextField(
                value = itemCart.totalUnit.toString() + " " + itemContent.unit,
                onValueChange = {
                },
                readOnly = true,
                textStyle = MaterialTheme.typography.h4
                    .copy(fontSize = FontSizes.medium),

                singleLine = true,
                modifier = Modifier
                    .width(IntrinsicSize.Min)
                    .align(Alignment.CenterVertically),
            )

            IconButton(onClick = {
                                 onIncDecPressed(true, itemCart, itemContent.price.toInt(), itemContent.amount)
            }, modifier = Modifier) {
                Icon(Icons.Filled.Add, contentDescription = "add", tint = MaterialTheme.colors.primary)
            }


        }

    }

}
