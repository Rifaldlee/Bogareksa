package com.bogareksa.ui.penjual.getImgPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bogareksa.R
import com.bogareksa.ui.penjual.mainSellerComponent.AppbarImgBackground


@Composable
fun GetImgPage(navBack: () -> Unit){
    GetImgPageContent(navBack)
}



@Composable
fun GetImgPageContent(navBack : () -> Unit){
    var imgExists = false

   Scaffold (
       topBar = {
           AppbarImgBackground(navBack = { /*TODO*/ }, title = "Upload Image")
       }
   ){
       Column(modifier = Modifier
           .padding(paddingValues = it)
           .padding(top = 5.dp)){
           if(imgExists){
               Image(painter = painterResource(id = R.drawable.testing_image),modifier = Modifier
                   .fillMaxWidth()
                   .height(400.dp),contentDescription = "photo image")
           }else{

               Box(modifier = Modifier
                   .fillMaxWidth()
                   .height(400.dp)
                   .background(color = Color.Gray)){
                   Image(painter = painterResource(id = R.drawable.camera),modifier = Modifier
                       .size(50.dp)
                       .align(alignment = Alignment.Center)
                       .clickable {
//                        getImgPage()
                       }, contentDescription ="add image" )
               }
           }
       }
   }
}

@Composable
@Preview(showBackground = true)
fun preview(){
    GetImgPageContent(navBack = {})
}