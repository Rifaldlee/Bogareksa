package com.bogareksa.ui.pembeli.data

data class Product(
    val id: Long,
    val image: Int,
    val name: String,
    val desc: String,
    val price: Int,
    val expired: String
)