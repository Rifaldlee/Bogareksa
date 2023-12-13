package com.bogareksa.ui.pembeli.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bogareksa.R

@Composable
fun TransactionItem (
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0x26000000),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .padding(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Image(
                painter = painterResource(R.drawable.food),
                contentDescription = "image description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(75.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = "Fast Food",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                )
                Text(
                    text = "1 Barang",
                    fontSize = 16.sp,
                )
            }
        }
        Text(
            text = "Total Belanja",
            fontSize = 16.sp,
        )
        Text(
            text = "Rp 90000",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Lokasi pengambilan barang :",
            modifier = Modifier
        )
        Text(
            text = "Jl. Raya Makam No.5 RT 01 / RW 05 Kecamatan Rembang, Kabupaten Purbalingga , Jawa Tengah Kodepos 53356",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
        )
    }
}
@Composable
@Preview(showBackground = true)
fun TransactionItemPreview() {
    MaterialTheme {
        TransactionItem()
    }
}