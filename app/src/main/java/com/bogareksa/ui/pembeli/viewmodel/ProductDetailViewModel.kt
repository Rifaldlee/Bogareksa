package com.bogareksa.ui.pembeli.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bogareksa.ui.pembeli.CustomerRepository
import com.bogareksa.ui.pembeli.data.remote.ProductsItem
import kotlinx.coroutines.launch

class ProductDetailViewModel(private val repository: CustomerRepository) : ViewModel() {

    private val _productDetail = MutableLiveData<ProductsItem>()
    var productDetail: LiveData<ProductsItem> = _productDetail

    fun getProductById(productId: String) {
        viewModelScope.launch {
            val product = repository.getProductById(productId)
            _productDetail.value
        }
    }
//    fun addToCart(product: Product) {
//        viewModelScope.launch {
//            repository.addToCart(product.id)
//            repository.getAddedOrderProduct().collect { updatedOrderProduct ->
//            }
//        }
//    }
}
