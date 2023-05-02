package com.example.potolki.presentation.menu.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.potolki.R
import com.example.potolki.presentation.ui.theme.PotolkiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaterialBaseListTopBar(modifier: Modifier = Modifier) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = MaterialTheme.colors.primary),
            title = {
                Text(
                    text = stringResource(id = R.string.menu),
                    style = MaterialTheme.typography.h1
                )
            },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Outlined.Notifications,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                        tint = Color.Black,
                    )
                }
            },
            modifier = modifier,
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.AccountCircle,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp),
                        tint = Color.Black
                    )

                }
            },
        )
    }

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MaterialBaseListTopBarPrev() {
    PotolkiTheme() {
        MaterialBaseListTopBar()
    }
}

