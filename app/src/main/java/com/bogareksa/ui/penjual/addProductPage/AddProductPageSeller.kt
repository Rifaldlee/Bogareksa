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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.compose.rememberNavController
import com.bogareksa.R
import com.bogareksa.ui.penjual.addProductPage.component.InputAddForm
import com.bogareksa.ui.penjual.mainSellerComponent.VerticalSpace


@Composable
fun AddProductPageSeller(navBack : () -> Unit,toTheGetImg : () -> Unit){
    AddProductSellerContent(navBack = navBack, getImgPage = toTheGetImg)
}




@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AddProductSellerContent(getImgPage: () -> Unit,navBack: () -> Unit,modifier: Modifier = Modifier){
    val scrollState = rememberScrollState()
    val imgExists = true

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Add Product") },
                navigationIcon = {
                    Icon(modifier = Modifier.clickable {
                        navBack()
                    },imageVector = Icons.Default.ArrowBack, contentDescription = "arrow back")
                }

            )
        }
    ){
        Column(
            modifier
                .padding(paddingValues = it)
                .verticalScroll(scrollState), verticalArrangement = Arrangement.Top){
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
                        .align(alignment = Alignment.Center)
                        .clickable {
                            getImgPage()
                        }, contentDescription ="add image" )
                }
            }
            Column (modifier.padding(start = 10.dp, end = 10.dp)){
                VerticalSpace()
                InputAddForm(hint = "insert text", title = "Product Name")
                VerticalSpace()
                InputAddForm(hint = "insert text", title = "Product Price")
                VerticalSpace()
                InputAddForm(hint = "insert text", title = "Product Expired")
                VerticalSpace()
                InputAddForm(hint = "insert text", title = "Amout")
                VerticalSpace()
                Box(
                    modifier = Modifier.fillMaxWidth().height(50.dp).background(color = Color.Gray)){

                }

                Button(onClick = {

                },modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Access")
                }
            }



        }
    }
}



@Composable
@Preview(showBackground = true)
fun preview(){
    val navController = rememberNavController()
    AddProductSellerContent(navBack = {navController.navigateUp()}, getImgPage = {})
}