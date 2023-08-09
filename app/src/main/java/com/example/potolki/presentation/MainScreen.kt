package com.example.potolki.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.potolki.presentation.navigation.BottomBarScreen
import com.example.potolki.presentation.navigation.NavGraph
import com.example.potolki.presentation.ui.FontSizes

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val screens = listOf(
        BottomBarScreen.MaterialMenuScreen,
        BottomBarScreen.MaterialCartScreen,
        BottomBarScreen.MaterialFavoritesScreen,
        BottomBarScreen.MaterialOrdersScreen,
    )

    Scaffold(
        bottomBar = {
            if (currentDestination?.route.toString() in screens.map { it.route }) {
                if (currentDestination != null) {
                    BottomBar(
                        navController = navController,
                        screens = screens,
                        currentDestination = currentDestination
                    )
                }
            }
        }
    ) { bottomBarPaddingValues ->
        NavGraph(navHostController = navController, bottomBarPaddingValues = bottomBarPaddingValues)
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    screens: List<BottomBarScreen>,
    currentDestination: NavDestination
) {
    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(

        label = {
            BoxWithConstraints {
                Text(
                    modifier = Modifier
                        .wrapContentWidth(unbounded = true)
                        .requiredWidth(maxWidth + 24.dp),
                    text = stringResource(screen.title),
                    style = MaterialTheme.typography.h1.copy(fontSize = FontSizes.small),
                    softWrap = false,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                )

            }

        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "Nav Icon", Modifier.size(29.dp))
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
        },
        selectedContentColor = MaterialTheme.colors.primary,
        unselectedContentColor = Color.Gray,
        modifier = Modifier.background(Color.White)
    )
}