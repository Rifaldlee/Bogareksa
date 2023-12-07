package com.bogareksa.ui.pembeli.navigation

sealed class Screen(val route: String) {
    object ProductList : Screen("home")
    object CartList : Screen("cart")
    object CustomerProfile : Screen("profile")
    object ProductDetail : Screen("home/{productId}") {
        fun createRoute(productId: Long) = "home/$productId"
    }
}
