package com.bogareksa.ui.pembeli.state

import com.bogareksa.ui.pembeli.data.OrderProduct

data class CartState(
    val orderProduct: List<OrderProduct>,
    val totalPrice: Int,
)