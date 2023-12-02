package com.bogareksa.ui.penjual.detailProductPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bogareksa.R
import com.bogareksa.ui.penjual.mainSellerComponent.AppbarImgBackground


@Composable
fun DetailProductSellerPage(navBack : () -> Unit){
    DetailProductSellerPageContent(navBack)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailProductSellerPageContent(
    navBack: () -> Unit,
//    image : Int,
//                                   title : String,
//                                   price : Int,
//                                   rating : Int,
//                                   sold : Int,
//                                   detail : String,
//                                   backClick : () -> Unit,
//                                   navToCart: (count:Int) -> Unit,
                                   modifier: Modifier = Modifier,
//                                   count : Int

){
//    var itemOrderCount by rememberSaveable{ mutableStateOf(count) }

    Scaffold(
        topBar = {
            AppbarImgBackground(navBack = {
                                          navBack()
            }, title = "Detail Product")
        }
    ){
        Column(
            modifier
                .padding(paddingValues = it)
                .verticalScroll(rememberScrollState())){



            Image(painter = painterResource(id = R.drawable.testing_image), contentDescription ="title", modifier = Modifier
                .height(400.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)) )

            Column(
                modifier.padding(15.dp)
            ){
                Text(text = "title", style = MaterialTheme.typography.titleLarge)
                Row {
                    Text(text = "terjual 5")
                    Spacer(modifier = modifier.width(15.dp))
                    Row {
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Yellow)
                        Text(text = "5")
                    }
                }
                Spacer(modifier = modifier.height(20.dp))
                Text(text = "Rp10000",style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.ExtraBold
                ))
                Spacer(modifier = modifier.height(20.dp))
                Divider()
                Spacer(modifier = modifier.height(10.dp))
                Text(text = "Detail", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = modifier.height(5.dp))
                Text(text = "detail")
                Spacer(modifier = modifier.height(20.dp))

//            HorizontalDivider()
                Divider()
                Spacer(modifier = modifier.height(10.dp))


//            ItemCounter(itemId = 1, onItemAdd = {itemOrderCount++}, onItemDec = {if(itemOrderCount > 0)itemOrderCount--}, orderItemCount =itemOrderCount )

                Spacer(modifier = modifier.height(10.dp))
                if (true){
                    Button(onClick = {
//                    navToCart(itemOrderCount)
                    },modifier.fillMaxWidth()) {
                        Text(text = "Add To Cart")
                    }
                }else{
                    Button(onClick = {

                    },modifier.fillMaxWidth(), colors = ButtonColors(containerColor = Color.Gray, contentColor = Color.Black, disabledContainerColor = Color.White, disabledContentColor = Color.Gray)) {
                        Text(text = "Add To Cart")
                    }
                }

            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview(){
    DetailProductSellerPageContent({})
}
