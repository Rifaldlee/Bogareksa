package com.bogareksa.ui.pembeli.navigation

sealed class Screen(val route: String) {
    object ProductList : Screen("home")
    object CartList : Screen("cart")
    object Profile : Screen("profile")
    object Transaction : Screen("transaction")
    object ProductDetail : Screen("detail/{productId}/{productImage}/{productName}/{productPrice}/{productDesc}") {
        fun createRoute(productId: String?,
                        productImage: String,
                        productName:String,
                        productPrice:Int,
                        productDesc: String
        ) = "detail/$productId/$productImage/$productName/$productPrice/$productDesc"
    }
}
