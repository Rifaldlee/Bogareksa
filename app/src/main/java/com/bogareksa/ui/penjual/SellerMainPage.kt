package com.bogareksa.ui.penjual

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bogareksa.ui.navigation.Screen
import com.bogareksa.ui.penjual.addProductPage.AddProductPageSeller
import com.bogareksa.ui.penjual.detailProductPage.DetailProductSellerPage
import com.bogareksa.ui.penjual.editDetailProductSellerPage.EditDetailProduct
import com.bogareksa.ui.penjual.getImgPage.GetImgPage
import com.bogareksa.ui.penjual.homePage.HomePageSeller
import com.bogareksa.ui.penjual.listProductPage.ListSellerProductPage
import com.bogareksa.ui.penjual.listProductPage.ProductListActivity
import com.bogareksa.ui.penjual.uploadImage.UploadImageActivity


@SuppressLint("SuspiciousIndentation")
@Composable
fun SellerMainPage() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val navBackStakEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStakEntry?.destination?.route


    val activityResultLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            // Handle the result if needed
            if (result.resultCode == Activity.RESULT_OK) {
                // Handle success
            } else {
                // Handle failure or canceled
            }
        }


        NavHost(navController = navController, startDestination = Screen.HomePageSeller.route ){
            composable(Screen.HomePageSeller.route){
                HomePageSeller(
                    getAddPageRoute = {
                        navController.navigate(Screen.AddProductSeller.route)
                    },
                    toTheDetail = {
                        navController.navigate(Screen.DetailProductSeller.route)
                    },
                    toTheListProduct = {
//                        navController.navigate(Screen.ListSellerProduct.route)
                        activityResultLauncher.launch(
                            Intent(context, ProductListActivity::class.java)
                        )
                    }
                )
            }

            composable(Screen.AddProductSeller.route){
                AddProductPageSeller(
                    navBack = {navController.navigateUp()},
                    toTheGetImg = {
                        activityResultLauncher.launch(
                            Intent(context, UploadImageActivity::class.java)
                        )
                    }
                )
            }

            composable(Screen.getImageSeller.route){
                GetImgPage(
                    navBack = {navController.navigateUp()}
                )
            }


            composable(Screen.DetailProductSeller.route){
                DetailProductSellerPage(
                    navBack = {navController.navigateUp()}
                )
            }

            composable(Screen.EditDetailProduct.route){
                EditDetailProduct()
            }

            composable(Screen.ListSellerProduct.route){
                ListSellerProductPage(
                    navBack = {navController.navigateUp()}
                )
            }

            activity(Screen.UploadImage.route){
//                UploadImageActivity()
            }

            activity(Screen.ListProduct.route){
                ProductListActivity()
            }



    }
}





