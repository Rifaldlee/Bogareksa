package com.bogareksa.ui.penjual.homePage

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bogareksa.R
import com.bogareksa.ui.penjual.homePage.component.BoxData
import com.bogareksa.ui.penjual.homePage.component.CardProfile
import com.bogareksa.ui.penjual.homePage.component.VerticalSpace
import com.bogareksa.ui.penjual.listProductPage.component.ItemCard


class HomePageSellerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                HomePageSeller()
        }
    }
}




@Composable
fun HomePageSeller(){
    Box(modifier = Modifier){
        HomePageContent()
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageContent(modifier: Modifier = Modifier){
    Scaffold(
       topBar = {
           TopAppBar(
               actions = {
                   Image(imageVector = Icons.Default.Notifications,modifier = modifier.size(25.dp),contentDescription = "notification")
               },
               navigationIcon = {
                  
               },
               title = {
               Text(text = "Hello Seller")

           },)
       }
    ){
        Column(
            modifier
                .fillMaxWidth()
                .padding(paddingValues = it)
                .padding(15.dp)){
            CardProfile(sellerName = "Reihan Wudd H", sellerEmail = "wudd404@gmail.com")
VerticalSpace()
            HorizontalDivider()
            VerticalSpace()
            LazyVerticalGrid(

                columns = GridCells.Adaptive(140.dp),
                contentPadding = PaddingValues(15.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalArrangement = Arrangement.spacedBy(17.dp)
            ){
                for (i in 1..4){
                    item {
                       BoxData()
                    }
                }
            }
        }
    }
}



@Composable
@Preview(showBackground = true)
fun preview(){
    HomePageContent()
}