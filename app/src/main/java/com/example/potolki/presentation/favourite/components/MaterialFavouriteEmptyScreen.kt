package com.example.potolki.presentation.favourite.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HeartBroken
import androidx.compose.material.icons.outlined.ProductionQuantityLimits
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.potolki.R

@Composable
fun MaterialFavouriteEmptyScreen(modifier: Modifier = Modifier, bottomPaddingValues: PaddingValues) {
    Column(modifier = Modifier
        .fillMaxSize().padding(bottom = bottomPaddingValues.calculateBottomPadding() + 50.dp)
        , verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Icon(
            Icons.Outlined.HeartBroken, contentDescription = "no items", modifier = modifier.size(128.dp),
            tint = MaterialTheme.colors.primary)
        Spacer(modifier = Modifier.height(10.dp))
        Row{
            Text(text = stringResource(id = R.string.emptyFav), style = MaterialTheme.typography.h2.copy(fontSize = 20.sp))
        }
    }

}