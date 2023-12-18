package com.bogareksa.ui.pembeli.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.bogareksa.R
import com.bogareksa.ui.pembeli.navigation.Screen
import com.bogareksa.ui.pembeli.data.remote.ProductsItem
import java.net.URLEncoder

@Composable
fun ProductItem(
    data: ProductsItem,
    modifier: Modifier = Modifier,
    navigateToDetail: NavHostController
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(Color.White)
            .width(160.dp)
            .border(
                width = 1.dp,
                color = Color(0x26000000),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .clickable {
                val encodedUrl = URLEncoder.encode(data.imageUrl, "UTF-8")
                navigateToDetail.navigate(
                    Screen.ProductDetail.createRoute(
                        productId = data.productId.toString(),
                        productImage = encodedUrl,
                        productName = data.name.toString(),
                        productPrice = data.price!!.toInt(),
                        productDesc = data.desc.toString()
                    )
                )
            },
    ){
        AsyncImage(
            model = data.imageUrl,
            contentDescription = "image description",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .height(144.dp)
                .fillMaxWidth()
        )
        Text(
            text = data.name.toString(),
            color = Color.Black,
            modifier = modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
        Text(
            text = data.desc.toString(),
            color = Color.Black,
            modifier = modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
        Text(
            text = stringResource(R.string.rupiah, data.price.toString()),
            color = Color.Black,
            modifier = modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
    }
}
//@Composable
//@Preview(showBackground = true)
//fun ProductItemPreview() {
//    MaterialTheme {
//        val product = ProductsItem(
//            productId = "1",
//            imageUrl = "R.drawable.food",
//            name = "Fast Food",
//            desc = "Deskripsi",
//            price = 90000
//        )
//        ProductItem(data = product, modifier = Modifier)
//    }
//}
