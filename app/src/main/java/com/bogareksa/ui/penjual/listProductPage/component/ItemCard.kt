package com.bogareksa.ui.penjual.listProductPage.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bogareksa.R


@Composable
fun ItemCard(
    image :Int,
    title : String,
    price : Int,
    rate : Int,
    modifier: Modifier = Modifier){
    Box(
        modifier
            .height(265.dp)
            .background(color = Color(0xFFF8F8F8))
            .width(180.dp)
            .padding(10.dp)
        ){
        Column{
            Image(painter = painterResource(id = image), contentDescription = title, modifier = modifier.size(150.dp),contentScale = ContentScale.Crop,)
            Column(modifier.padding(5.dp)){
                Spacer(modifier = modifier.height(7.dp))
                Text(text = title, overflow = TextOverflow.Ellipsis, maxLines = 2, fontSize = 15.sp)
                Spacer(modifier = modifier.height(7.dp))
                Text(text = "Rp. ${price.toString()}",style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.ExtraBold, fontSize = 18.sp))
                Spacer(modifier = modifier.weight(1f))

                Row {
                    Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Yellow)
                    Text(text = rate.toString())
//                    Text(text = " | ")
//                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "sold", tint = Color.Gray)
//                    Text(text = rate.toString())

                }
            }
    }

    }

}

@Composable
@Preview(showBackground = true)
fun preview(){

        ItemCard(image = R.drawable.food, title = "AISURIX VGA Card RX 560XT 8GB AMD DDR5 256Bit GPU Radeon Video Card - RX550-DK", price = 2000, rate = 2)

}