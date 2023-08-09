package com.example.potolki.presentation.product_review

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.potolki.R
import com.example.potolki.presentation.product_review.components.ProductReviewItem
import com.example.potolki.presentation.product_review.components.ProductSaleItem
import com.example.potolki.presentation.navigation.MainAppBar
import com.example.potolki.presentation.navigation.Screens
import com.example.potolki.presentation.ui.FontSizes

@Composable
fun ProductReviewScreen(
    navController: NavController, bottomBarPaddingValues: PaddingValues,
    viewModel: ProductReviewViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Scaffold(topBar = { MainAppBar(navController = navController, city = "Ярославль") }) { paddingValue ->
        ProductReviewScreenContent(
            paddingValues = paddingValue,
            bottomBarPaddingValues = bottomBarPaddingValues,
            state = state,
            navigateToViewOrContent = { review_id, view_id ->
                navController.navigate(Screens.ProductViewOrContent.route + "/${review_id}" + "/${view_id}")
            }
        )
    }
}


@Composable
fun ProductReviewScreenContent(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    bottomBarPaddingValues: PaddingValues,
    state: ProductReviewState,
    navigateToViewOrContent: (Int, Int) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = paddingValues.calculateTopPadding(),
                bottom = bottomBarPaddingValues.calculateBottomPadding()
            ),
        contentPadding = PaddingValues(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        item{
            Spacer(modifier = Modifier.height(10.dp))
        }
        item{
            var text by remember{mutableStateOf("")}
            OutlinedTextField(
                modifier = Modifier
                    .height(50.dp),
                value = text, onValueChange = { text = it },
                singleLine = true,
                textStyle = MaterialTheme.typography.h3.copy(fontSize = FontSizes.thin),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.searchholder),
                        style = MaterialTheme.typography.h2.copy(fontSize = FontSizes.thin),
                        modifier = Modifier
                            .fillMaxSize()
                    )
                },
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "search") },
                shape = RoundedCornerShape(percent = 20),
                maxLines = 1,
            )
        }

        item {
            Spacer(modifier = Modifier.height(15.dp))
        }
        item {
            ProductSaleItem()
        }
        item {
            Spacer(modifier = Modifier.height(3.dp))
        }
        items(state.productReview) { item ->
            ProductReviewItem(item = item, navigateToViewOrContent = navigateToViewOrContent)
        }
    }
}

