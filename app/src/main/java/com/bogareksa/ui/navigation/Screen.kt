package com.bogareksa.ui.navigation

sealed class Screen(val route: String){
    object AddProductSeller : Screen("addProductSeller")
    object HomePageSeller : Screen("homePageSeller")

    object getImageSeller : Screen("getImageSeller")

}