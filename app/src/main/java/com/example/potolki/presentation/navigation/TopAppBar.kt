package com.example.potolki.presentation.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.potolki.R
import com.example.potolki.presentation.ui.FontSizes
import com.example.potolki.presentation.ui.theme.PotolkiTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopMaterialAppBar(
    modifier: Modifier = Modifier,
    text: String,
    navController: NavController

) {
    Card(elevation = 4.dp) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.White),
            title = {
                Text(
                    text = text,
                    style = MaterialTheme.typography.h1.copy(fontSize = FontSizes.large)
                )
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigate(BottomBarScreen.MaterialMenuScreen.route) }) {
                    Icon(
                        Icons.Outlined.ArrowBackIosNew,
                        contentDescription = null,
                        modifier = Modifier.size(25.dp),
                        tint = Color.Black,
                    )
                }
            },
            modifier = modifier,

            )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    city: String,
) {
    Card(elevation = 4.dp) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.White),
            title = {
                Text(
                    text = stringResource(R.string.menu),
                    style = MaterialTheme.typography.h1.copy(fontSize = FontSizes.large)
                )
            },
            actions = {
                Text(city, style = MaterialTheme.typography.h3.copy(fontSize = FontSizes.thin),
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screens.CitySettingsScreen.route)

                        }
                        .padding(end = 10.dp), color = MaterialTheme.colors.primary
                )
            },
            modifier = modifier,

            )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopMaterialDescriptionAppBar(
    modifier: Modifier = Modifier,
    navController: NavController

) {
    Card(elevation = 4.dp) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.White),
            title = {
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        Icons.Outlined.ArrowBackIosNew,
                        contentDescription = null,
                        modifier = Modifier.size(25.dp),

                        )
                }
            },

            modifier = modifier,
            )
    }
}



