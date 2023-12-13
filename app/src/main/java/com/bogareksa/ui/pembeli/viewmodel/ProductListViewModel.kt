package com.bogareksa.ui.pembeli.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bogareksa.ui.pembeli.CustomerRepository
import com.bogareksa.ui.pembeli.data.OrderProduct
import com.bogareksa.ui.pembeli.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ProductListViewModel (private val repository: CustomerRepository): ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<OrderProduct>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderProduct>>>
        get() = _uiState

    fun getProducts(){
        viewModelScope.launch {
            repository.getAllProduct()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect{ orderProduct ->
                    _uiState.value = UiState.Success(orderProduct)
                }
        }
    }

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        val searchResult = repository.searchProduct(_query.value)
            .sortedBy { it.product.name }
        _uiState.value = UiState.Success(searchResult)
    }
}