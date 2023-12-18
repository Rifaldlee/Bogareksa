package com.bogareksa.ui.pembeli.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bogareksa.ui.pembeli.BogareksaCustomerApp
import com.bogareksa.ui.pembeli.components.Search
import com.bogareksa.ui.pembeli.viewmodel.ProductListViewModel
import com.bogareksa.ui.pembeli.components.ProductItem as ProductItem

@Composable
fun ProductList(
    modifier: Modifier = Modifier,
    navigateToDetail: NavHostController,
    viewModel: ProductListViewModel,
){
    Column {
        Search(
            viewModel
        )
        ProductListContent(
            viewModel,
            modifier = modifier,
            navigateToDetail = navigateToDetail
        )
    }

}

@SuppressLint("SuspiciousIndentation")
@Composable
fun ProductListContent(
    viewModel: ProductListViewModel,
    modifier: Modifier = Modifier,
    navigateToDetail: NavHostController
){
    val data by viewModel.productList.observeAsState()
    viewModel.getProducts()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(data.orEmpty()) { product ->
            ProductItem(
                data = product,
                navigateToDetail = navigateToDetail
            )
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