package com.bogareksa.ui.pembeli.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bogareksa.R
import com.bogareksa.ui.pembeli.components.BuyButton
import com.bogareksa.ui.pembeli.components.CartItem
import com.bogareksa.ui.pembeli.di.Injection
import com.bogareksa.ui.pembeli.state.CartState
import com.bogareksa.ui.pembeli.state.UiState
import com.bogareksa.ui.pembeli.viewmodel.CartViewModel
import com.bogareksa.ui.pembeli.viewmodel.ViewModelFactory

@Composable
fun CartList(
    viewModel: CartViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        )
    ),
    navigateBack: () -> Unit,
    onOrderButtonClicked: (String) -> Unit,
){
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAddedOrederProduct()
            }
            is UiState.Success -> {
                CartListContent(
                    uiState.data,
                    onProductAmountChanged = { productid, count ->
                        viewModel.updateOrderProduct(productid, count)
                    },
                    onOrderButtonClicked = onOrderButtonClicked,
                    onBackClick = navigateBack,)
            }
            is UiState.Error -> {}
        }
    }
}
@Composable
fun CartListContent(
    state: CartState,
    onProductAmountChanged: (id: Long, count: Int) -> Unit,
    onOrderButtonClicked: (String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Column{
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 12.dp, top = 12.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.back),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { onBackClick() }
                )
                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    text = "Cart List",
                    fontSize = 16.sp,
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                items(state.orderProduct, key = {it.product.id}){  item ->
                    CartItem(
                        productId = item.product.id,
                        image = item.product.image,
                        name = item.product.name,
                        price = item.product.price,
                        count = item.amount,
                        amountChanged = onProductAmountChanged,
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Total Price",
                fontSize = 24.sp,
                modifier = modifier
                    .padding(start = 12.dp,)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = stringResource(R.string.rupiah, state.totalPrice),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .padding(start = 12.dp,)
            )
            Spacer(modifier = Modifier.height(32.dp))
            BuyButton(
                text = "buy",
                modifier = modifier
                    .padding(horizontal = 12.dp)
            ) {}
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun CartListPreview() {
    MaterialTheme {
        CartList(
            navigateBack = {},
            onOrderButtonClicked = {})
    }
}