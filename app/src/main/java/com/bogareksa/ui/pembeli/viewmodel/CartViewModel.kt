package com.bogareksa.ui.pembeli.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bogareksa.ui.pembeli.CustomerRepository
import com.bogareksa.ui.pembeli.state.CartState
import com.bogareksa.ui.pembeli.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel ( private val repository: CustomerRepository): ViewModel(){
    private val _uiState: MutableStateFlow<UiState<CartState>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<CartState>>
        get() = _uiState

    fun getAddedOrederProduct() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.getAddedOrderProduct()
                .collect { orderProduct ->
                    val totalPrice =
                        orderProduct.sumOf { it.product.price * it.amount }
                    _uiState.value = UiState.Success(CartState(orderProduct, totalPrice))
                }
        }
    }
    fun updateOrderProduct(productId: Long, amount: Int) {
        viewModelScope.launch {
            repository.updateOrderProduct(productId, amount)
                .collect { isUpdated ->
                    if (isUpdated) {
                        getAddedOrederProduct()
                    }
                }
        }
    }
}