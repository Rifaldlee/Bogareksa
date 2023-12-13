package com.bogareksa.ui.pembeli.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bogareksa.ui.pembeli.CustomerRepository
import com.bogareksa.ui.pembeli.state.UiState
import com.bogareksa.ui.pembeli.data.OrderProduct
import com.bogareksa.ui.pembeli.data.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val repository: CustomerRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<OrderProduct>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OrderProduct>>
        get() = _uiState

    fun getProductById(productId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderProductById(productId))
        }
    }
    fun addToCart(product: Product) {
        viewModelScope.launch {
            repository.addToCart(product.id).collect{
                repository.getAddedOrderProduct().collect { updatedOrderProduct -> }
            }
        }
    }
}
