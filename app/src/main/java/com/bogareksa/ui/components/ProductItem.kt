package com.bogareksa.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bogareksa.R

@Composable
fun ProductItem(
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(Color.White)
            .width(160.dp)
            .border(width = 1.dp,
                    color = Color(0x26000000),
                    shape = RoundedCornerShape(size = 10.dp)),
    ){
        Image(
            painter = painterResource(id = R.drawable.food),
            contentDescription = "image description",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .height(144.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Fast Food",
            color = Color.Black,
            modifier = modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
        Text(
            text = "Deskripsi",
            color = Color.Black,
            modifier = modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
        Text(
            text = "Rp90000",
            color = Color.Black,
            modifier = modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
    }
}
@Composable
@Preview(showBackground = true)
fun ProductItemPreview() {
    MaterialTheme {
        ProductItem()
    }
}
