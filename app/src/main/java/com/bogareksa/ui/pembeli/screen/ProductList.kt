package com.bogareksa.ui.pembeli.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bogareksa.R
import com.bogareksa.ui.pembeli.BogareksaCustomerApp
import com.bogareksa.ui.pembeli.components.ProductItem as ProductItem

@Composable
fun ProductList(
    modifier: Modifier = Modifier,
//    navigateToDetail: (Long) -> Unit,
){
    ProductListContent(
        modifier = modifier,
//        navigateToDetail = navigateToDetail
    )
}

@Composable
fun ProductListContent(
    modifier: Modifier = Modifier,
//    navigateToDetail: (Long) -> Unit
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        repeat(10) { index ->
            item {
                ProductItem(R.drawable.food, "Fast Food", "Deskripsi", 90000)
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun JetCoffeeAppPreview() {
    MaterialTheme {
        BogareksaCustomerApp()
    }
}