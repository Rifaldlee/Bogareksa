package com.bogareksa.ui.penjual.listProductPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bogareksa.R
import com.bogareksa.ui.pembeli.components.Search
import com.bogareksa.ui.penjual.listProductPage.component.ItemCard
import com.bogareksa.ui.penjual.listProductPage.component.SearchItemSeller

@Composable
fun ListSellerProductPage(navBack: () -> Unit){
    ListSellerProductPageContent(navBack = navBack)
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListSellerProductPageContent(navBack : () -> Unit){
    Scaffold(

        topBar = {
            Box(modifier = Modifier){
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp),
                    painter = painterResource(id = R.drawable.bgappbar),
                    contentDescription = "Background image"
                    , contentScale = ContentScale.Crop

                )

                TopAppBar(
                    colors = TopAppBarColors(containerColor = Color.Transparent, actionIconContentColor = Color.White, navigationIconContentColor = Color.White, scrolledContainerColor = Color.Transparent, titleContentColor = Color.White) ,
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .padding(start = 5.dp, end = 10.dp),
                    title = {
                    SearchItemSeller(deleteText = { /*TODO*/ }, query = "", onQueryChange = {})
                },
                    navigationIcon = {
                        Icon(modifier = Modifier.clickable {
                                navBack()
                        },imageVector = Icons.Default.ArrowBack, contentDescription = "back page"
                        )
                    },
                    actions = {
                        Icon(imageVector = Icons.Default.Clear, contentDescription ="delete" )
                    }

                )
            }
        }
    ){
        Box(modifier = Modifier.padding(paddingValues = it).background(color = Color(0xfff0eded))){
            ListSellerProduct()
        }
    }
}


@Composable
fun ListSellerProduct(){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(140.dp),
        contentPadding = PaddingValues(15.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.spacedBy(17.dp)
        ){
        for (i in 1..10){
            item {
                ItemCard(image = R.drawable.food, title = "testing items ,with default text from another source", price = 20000, rate = 5)
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun Preview(){
    ListSellerProductPageContent({})
}