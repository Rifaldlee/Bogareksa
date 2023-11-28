package com.bogareksa.ui.penjual.listProductPage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bogareksa.ui.pembeli.components.Search
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
        Column(modifier = Modifier.padding(paddingValues = it)){

        }
    }
}


@Composable
@Preview(showBackground = true)
fun Preview(){
    ListSellerProductPageContent()
}