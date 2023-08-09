package com.example.potolki.presentation.other

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.potolki.R
import com.example.potolki.presentation.navigation.TopMaterialAppBar

@Composable
fun CitySettingsScreen(modifier: Modifier = Modifier, navController: NavController,
    viewModel: CitySettingsScreenViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    Scaffold(topBar = {
        TopMaterialAppBar(
            text = stringResource(id = R.string.region),
            navController = navController
        )
    }){
        paddingValues ->

        CitySettingsScreenContent(paddingValues = paddingValues, navController = navController, regions = state.regions)
    }

}

@Composable
fun CitySettingsScreenContent(modifier: Modifier = Modifier, navController: NavController, paddingValues: PaddingValues,
regions: List<String>) {
    var isSelected by remember { mutableStateOf(regions[0]) }

    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(regions){ region ->
                Card(elevation = 4.dp, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 7.dp)
                    .height(60.dp)){
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center){
                        Text(text = region, style = MaterialTheme.typography.h3)
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(selected = region == isSelected, onClick = { isSelected = region },
                        colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colors.primaryVariant))
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp, bottom = 20.dp)){
            Text(text = stringResource(id = R.string.accept), style = MaterialTheme.typography.h2.copy(fontSize = 20.sp))
        }
    }

}

