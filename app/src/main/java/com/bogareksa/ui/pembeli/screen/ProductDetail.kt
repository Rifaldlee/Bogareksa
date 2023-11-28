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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bogareksa.R
import com.bogareksa.ui.pembeli.components.BuyButton

@Composable
fun ProductDetail(
    onBackClick: () -> Unit,
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
                    painter = painterResource(R.drawable.food),
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
                        .size(48.dp)
                        .clickable { onBackClick() }
                )
            }
            Column(
                modifier
                    .padding(start = 12.dp, end = 12.dp, bottom = 24.dp),
            ) {
                Text(
                    text = "Fast Food",
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
                        text = "Rp90000",
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                    Text(
                        text = "12-12-9999",
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
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
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
                    .padding(start = 12.dp, end = 12.dp,)
            ) {}
        }
    }
}
@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailCinemateAppPreview() {
    MaterialTheme {
        ProductDetail(onBackClick = {})
    }
}