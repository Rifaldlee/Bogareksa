package com.bogareksa.ui.penjual.addProductPage

import android.provider.MediaStore.Images
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.bogareksa.R
import com.bogareksa.ui.penjual.mainSellerComponent.VerticalSpace


@Composable
fun AddProductPageSeller(navBack : () -> Unit){
    AddProductSellerContent(navBack = navBack)
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductSellerContent(navBack: () -> Unit,modifier: Modifier = Modifier){

    val imgExists = false
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Add Product") },
                navigationIcon = {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "arrow back")
                }

            )
        }
    ){
        Column(modifier.padding(paddingValues = it), verticalArrangement = Arrangement.Top){
            if(imgExists){
                Image(painter = painterResource(id = R.drawable.testing_image),modifier = modifier
                    .fillMaxWidth()
                    .height(400.dp),contentDescription = "photo image")
            }else{

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .background(color = Color.Gray)){
                    Image(painter = painterResource(id = R.drawable.camera),modifier = Modifier
                        .size(50.dp)
                        .align(alignment = Alignment.Center).clickable {
                            navBack()
                        }, contentDescription ="add image" )
                }
            }
            VerticalSpace()

        }
    }
}



@Composable
@Preview(showBackground = true)
fun preview(){
    val navController = rememberNavController()
    AddProductSellerContent(navBack = {navController.navigateUp()})
}