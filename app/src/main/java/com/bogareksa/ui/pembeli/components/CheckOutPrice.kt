package com.bogareksa.ui.pembeli.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckOutPrice (
    modifier: Modifier = Modifier
){
    Column {
        Text(
            text = "Total Price",
            fontSize = 24.sp,
            modifier = modifier
                .padding(start = 12.dp,)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "90000",
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
    }
}
@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun CheckOutPricePreview() {
    MaterialTheme {
        CheckOutPrice()
    }
}