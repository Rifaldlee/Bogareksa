package com.bogareksa.ui.penjual

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bogareksa.ui.navigation.Screen
import com.bogareksa.ui.penjual.addProductPage.AddProductPageSeller
import com.bogareksa.ui.penjual.homePage.HomePageSeller





@Composable
fun SellerMainPage() {
    val navController = rememberNavController()

    Scaffold(

    ){paddingval ->
        NavHost(navController = navController, startDestination = Screen.HomePageSeller.route, modifier = Modifier.padding(paddingval) ){
            composable(Screen.HomePageSeller.route){
                HomePageSeller(
                    getAddPageRoute = {
                        navController.navigate(Screen.AddProductSeller.route)
                    }
                )
            }

            composable(Screen.AddProductSeller.route){
                AddProductPageSeller()
            }
        }
    }
}