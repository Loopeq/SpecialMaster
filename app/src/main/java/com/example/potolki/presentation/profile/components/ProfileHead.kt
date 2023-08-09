package com.example.potolki.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.potolki.R

@Composable
fun ProfileHead(modifier: Modifier = Modifier, fullName: String) {
    Column(modifier = modifier
        .fillMaxWidth().background(MaterialTheme.colors.primaryVariant)
        .fillMaxHeight(0.3f),
    verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(id = R.drawable.fon), contentDescription = "ava",
        modifier = Modifier.size(128.dp).clip(CircleShape).align(Alignment.CenterHorizontally), contentScale = ContentScale.Crop)

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = fullName, style = MaterialTheme.typography.h3.copy(fontSize = 23.sp),
        modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}