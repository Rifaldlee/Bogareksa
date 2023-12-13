package com.bogareksa.ui.pembeli.navigation

sealed class Screen(val route: String) {
    object ProductList : Screen("home")
    object CartList : Screen("cart")
    object Profile : Screen("profile")
    object Transaction : Screen("transaction")
    object ProductDetail : Screen("home/{productId}") {
        fun createRoute(productId: Long) = "home/$productId"
    }
}
