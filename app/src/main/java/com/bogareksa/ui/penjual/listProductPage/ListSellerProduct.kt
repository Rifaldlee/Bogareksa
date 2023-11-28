package com.bogareksa.ui.penjual.listProductPage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bogareksa.R
import com.bogareksa.ui.pembeli.components.Search
import com.bogareksa.ui.penjual.listProductPage.component.ItemCard
import com.bogareksa.ui.penjual.listProductPage.component.SearchItemSeller

@Composable
fun ListSellerProductPage(){

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListSellerProductPageContent(){
    Scaffold(
        topBar = {
            TopAppBar(title = {
                SearchItemSeller(deleteText = { /*TODO*/ }, query = "", onQueryChange = {})
            })
        }
    ){
        Box(modifier = Modifier.padding(paddingValues = it)){
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
    ListSellerProductPageContent()
}