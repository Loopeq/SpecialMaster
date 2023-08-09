package com.example.potolki.presentation.cart.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.potolki.R
import com.example.potolki.presentation.ui.FontSizes

@Composable
fun CreateOrderBox(modifier: Modifier = Modifier, totalPrice: Int,
createOrder: () -> Unit) {
    Surface(
        modifier = modifier
            .fillMaxWidth(),
        elevation = 12.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                )
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = R.string.total_price),
                    style = MaterialTheme.typography.h4.copy(fontSize = FontSizes.medium),
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
                Spacer(modifier.weight(1f))
                Text(
                    text = totalPrice.toString() + stringResource(id = R.string.rub),
                    style = MaterialTheme.typography.h1.copy(fontSize = FontSizes.large),
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.padding(end = 10.dp, top = 10.dp)
                )
            }
            Spacer(modifier = Modifier.height(1.dp))

            OutlinedButton(
                onClick = { createOrder() } ,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth().height(50.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,

                )

            ) {
                Text(
                    stringResource(id = R.string.order),
                    style = MaterialTheme.typography.h1.copy(fontSize = FontSizes.medium),
                    color = Color.White
                )
            }
        }


    }

}

