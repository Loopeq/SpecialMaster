package com.example.potolki.presentation.product_review.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.potolki.data.remote.model.server.ProductsReviewDto
import com.example.potolki.presentation.navigation.Screens
import com.example.potolki.presentation.ui.FontSizes
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@Composable
fun ProductReviewItem(
    modifier: Modifier = Modifier, item: ProductsReviewDto,
    navigateToViewOrContent: (Int, Int) -> Unit
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(
            LocalContext.current
        ).data(item.imageSrc).build()
    )

    Card(elevation = 3.dp, modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(bottom = 5.dp)
        .clickable {
            navigateToViewOrContent(item.id!!.toInt(), 0)
        }) {
        Row {
            Box(
                modifier = Modifier.fillMaxHeight().width(160.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painter, contentDescription = "image",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )

                if (painter.state is AsyncImagePainter.State.Loading) {
                    CircularProgressIndicator(modifier = Modifier.size(30.dp))
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = item.title,
                style = MaterialTheme.typography.h1.copy(fontSize = FontSizes.large),
                modifier = Modifier.align(Alignment.CenterVertically),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
            )
        }
    }
}

