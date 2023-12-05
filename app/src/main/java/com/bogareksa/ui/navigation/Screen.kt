package com.bogareksa.ui.navigation

sealed class Screen(val route: String){
    object AddProductSeller : Screen("addProductSeller")
    object HomePageSeller : Screen("homePageSeller")
    object getImageSeller : Screen("getImageSeller")
    object DetailProductSeller : Screen("detailProductSeller")
    object EditDetailProduct : Screen("detailDetailProduct")
    object ListSellerProduct : Screen("ListSellerProduct")

    object UploadImage : Screen("UploadImageActivity")

}