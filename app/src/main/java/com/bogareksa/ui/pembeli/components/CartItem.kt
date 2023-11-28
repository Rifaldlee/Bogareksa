package com.bogareksa.ui.pembeli.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.unit.sp
import com.bogareksa.R

@Composable
fun CartItem (
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ){
        Image(
            painter = painterResource(id = R.drawable.food),
            contentDescription = "image description",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .height(75.dp)
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .height(75.dp)
                .background(
                    color = Color(0xFF3B8197),
                    shape = RoundedCornerShape(8.dp))
                .padding(8.dp),
        ) {
            Text(
                text = "Fast Food",
                color = Color.White,
                fontSize = 20.sp,
                maxLines = 1,
                modifier = modifier
                    .fillMaxWidth()
            )
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ){
                Text(
                    text = "Rp90000",
                    color = Color.White,
                    fontSize = 20.sp,
                )
                ProductCounter()
            }
        }
    }
}
@Composable
@Preview(showBackground = true)
fun CartItemPreview() {
    MaterialTheme {
        CartItem()
    }
}
