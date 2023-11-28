package com.bogareksa.ui.penjual.homePage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomePageSeller(){
    Box(modifier = Modifier.padding(15.dp)){
        HomePageContent()
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageContent(modifier: Modifier = Modifier){
    Scaffold(
       topBar = {
           TopAppBar(title = {
               Text(text = "Hello Seller")
           })
       }
    ){
        Column(modifier.padding(paddingValues = it)){
            Text(text = "body")
        }
    }
}



@Composable
@Preview(showBackground = true)
fun preview(){
    HomePageContent()
}