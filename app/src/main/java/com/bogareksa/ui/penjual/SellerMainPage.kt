package com.bogareksa.ui.penjual

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bogareksa.ui.navigation.Screen
import com.bogareksa.ui.penjual.addProductPage.AddProductPageSeller
import com.bogareksa.ui.penjual.homePage.HomePageSeller





@SuppressLint("SuspiciousIndentation")
@Composable
fun SellerMainPage() {
    val navController = rememberNavController()

    val navBackStakEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStakEntry?.destination?.route


        NavHost(navController = navController, startDestination = Screen.HomePageSeller.route ){
            composable(Screen.HomePageSeller.route){
                HomePageSeller(
                    getAddPageRoute = {
                        navController.navigate(Screen.AddProductSeller.route)
                    }
                )
            }

            composable(Screen.AddProductSeller.route){
                AddProductPageSeller(
                    navBack = {navController.navigateUp()}
                )
            }

    }
}