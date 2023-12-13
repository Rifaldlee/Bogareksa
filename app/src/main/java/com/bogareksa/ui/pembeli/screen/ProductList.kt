package com.bogareksa.ui.pembeli.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bogareksa.R
import com.bogareksa.ui.pembeli.BogareksaCustomerApp
import com.bogareksa.ui.pembeli.components.Search
import com.bogareksa.ui.pembeli.data.OrderProduct
import com.bogareksa.ui.pembeli.di.Injection
import com.bogareksa.ui.pembeli.state.UiState
import com.bogareksa.ui.pembeli.viewmodel.ProductListViewModel
import com.bogareksa.ui.pembeli.viewmodel.ViewModelFactory
import com.bogareksa.ui.pembeli.components.ProductItem as ProductItem

@Composable
fun ProductList(
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
    viewModel: ProductListViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
){
    val query by viewModel.query
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState){
            is UiState.Loading -> {
                viewModel.getProducts()
            }
            is UiState.Success -> {
                Column {
                    Search(
                        query = query,
                        onQueryChange = viewModel::search,
                    )
                    ProductListContent(
                        product = uiState.data,
                        modifier = modifier,
                        navigateToDetail = navigateToDetail
                    )
                }

            }
            is UiState.Error -> {}
        }
    }

}

@Composable
fun ProductListContent(
    product: List<OrderProduct>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(product) {data ->
            ProductItem(
                id = data.product.id,
                image = data.product.image,
                name = data.product.name,
                desc = data.product.desc,
                price = data.product.price,
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