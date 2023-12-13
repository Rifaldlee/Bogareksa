package com.bogareksa.ui.pembeli.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bogareksa.R
import com.bogareksa.ui.pembeli.components.BuyButton
import com.bogareksa.ui.pembeli.di.Injection
import com.bogareksa.ui.pembeli.state.UiState
import com.bogareksa.ui.pembeli.viewmodel.ProductDetailViewModel
import com.bogareksa.ui.pembeli.viewmodel.ViewModelFactory

@Composable
fun ProductDetail(
    productId: Long,
    viewModel: ProductDetailViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        )
    ),
    onBackClick: () -> Unit,
    navigateToCart: () -> Unit,
){
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when(uiState){
            is UiState.Loading -> {
                viewModel.getProductById(productId)
            }
            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    data.product.image,
                    data.product.name,
                    data.product.price,
                    data.product.expired,
                    data.product.desc,
                    onBackClick = onBackClick,
                    addToCart = {
                        viewModel.addToCart(data.product)
                        navigateToCart()
                    }
                )
            }
            else -> {}
        }
    }
}

@Composable
fun DetailContent(
    image: Int,
    name: String,
    price: Int,
    expired: String,
    desc: String,
    onBackClick: () -> Unit,
    addToCart: () ->Unit,
    modifier: Modifier = Modifier,
){
    Column(modifier = modifier) {
        Column(
            modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
                .fillMaxWidth()
        ) {
            Box(
                modifier
                    .padding(bottom = 12.dp,),
            ){
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(360.dp)
                )
                Image(
                    painter = painterResource(R.drawable.back),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .padding(start = 12.dp, top = 12.dp)
                        .size(32.dp)
                        .clickable { onBackClick() }
                )
            }
            Column(
                modifier
                    .padding(start = 12.dp, end = 12.dp, bottom = 24.dp),
            ) {
                Text(
                    text = name,
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = modifier
                        .fillMaxWidth()
                )
                Row(
                    modifier
                        .padding(top = 12.dp, bottom = 36.dp),
                ) {
                    Text(
                        text = stringResource(R.string.rupiah, price),
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                    Text(
                        text = expired,
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.End,
                        modifier = modifier
                            .fillMaxWidth()
                    )
                }
                Text(
                    text = "Product Description",
                    color = Color.Black,
                    fontSize = 20.sp,
                )
                Text(
                    text = desc,
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp)
                )
            }
            BuyButton(
                text = "buy",
                modifier = modifier
                    .padding(start = 12.dp, end = 12.dp,),
                onClick = {addToCart()}
            )
        }
    }
}
@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailCinemateAppPreview() {
    MaterialTheme {
        ProductDetail(
            productId = 1,
            onBackClick = {},
            navigateToCart = {}
        )
    }
}