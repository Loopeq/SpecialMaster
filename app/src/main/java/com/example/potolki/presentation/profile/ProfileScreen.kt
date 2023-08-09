package com.example.potolki.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.potolki.domain.model.UserProfile
import com.example.potolki.presentation.profile.components.InfoScreenContent
import com.example.potolki.presentation.profile.components.ProfileHead
import com.example.potolki.presentation.ui.theme.PotolkiTheme

@Composable
fun ProfileScreen(modifier: Modifier = Modifier, viewModel: ProfileScreenViewModel = hiltViewModel(), bottomPaddingValues: PaddingValues) {
    val state = viewModel.state.value
    ProfileScreenContent(userInfo = state.material, bottomPaddingValues = bottomPaddingValues)
}

@Composable
fun ProfileScreenContent(modifier: Modifier = Modifier, userInfo: UserProfile, bottomPaddingValues: PaddingValues) {
    Column(modifier = Modifier.fillMaxSize()){
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.4f).background(MaterialTheme.colors.primaryVariant))
        Box(modifier = Modifier.fillMaxSize().background(Color.White))
    }
    Card(elevation = 4.dp, modifier = Modifier.fillMaxSize().padding(25.dp).padding(bottom = bottomPaddingValues.calculateBottomPadding())) {
        Column(modifier = modifier.fillMaxSize().padding(5.dp)) {
            InfoScreenContent(userInfo = userInfo)

        }
    }
}
