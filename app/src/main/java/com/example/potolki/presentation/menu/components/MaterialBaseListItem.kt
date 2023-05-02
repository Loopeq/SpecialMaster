package com.example.potolki.presentation.menu.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.potolki.domain.model.Materials

@Composable
fun MaterialBaseListItem(modifier: Modifier = Modifier, material: Materials) {
    Box(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Surface(elevation = 4.dp, modifier = Modifier.size(120.dp).background(Color.LightGray)) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(material.imageSrc)
                        .crossfade(true)
                        .build(), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    onLoading = {
                    }
                )
            }
            Text(text = material.title, style = MaterialTheme.typography.body1)
        }

    }
}


@Preview
@Composable
fun MaterialBaseListItemPrev() {
    MaterialBaseListItem(material = Materials(id = 0, title = "", imageSrc = ""))
}