package com.example.potolki.presentation.orders

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.potolki.R
import com.example.potolki.presentation.ui.FontSizes
import com.example.potolki.presentation.ui.theme.PotolkiTheme

@Composable
fun SelectRegionScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.Top){
            Row {
                Icon(
                    Icons.Filled.ArrowBackIos,
                    contentDescription = "cancel",
                    tint = MaterialTheme.colors.primary
                )
                Text(
                    text = "отменить",
                    style = MaterialTheme.typography.h1.copy(fontSize = FontSizes.small),
                    color = MaterialTheme.colors.primary
                )
            }
            Text(text = stringResource(id = R.string.selectRegion), style = MaterialTheme.typography.h1.copy(fontSize = FontSizes.large),)
        }
        LinearProgressIndicator(progress = 0.3f, color = MaterialTheme.colors.primary, backgroundColor = Color.LightGray)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SelectRegionScreenPrev() {
    PotolkiTheme {
        SelectRegionScreen()
    }

}


