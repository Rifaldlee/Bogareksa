package com.bogareksa.ui.pembeli

import android.app.Application
import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bogareksa.ui.pembeli.data.FakeDataSource
import com.bogareksa.ui.pembeli.data.OrderProduct
//import com.bogareksa.ui.pembeli.data.local.CartDao
//import com.bogareksa.ui.pembeli.data.local.CartDatabase
//import com.bogareksa.ui.pembeli.data.local.CartEntity
import com.bogareksa.ui.pembeli.data.remote.ApiConfig
import com.bogareksa.ui.pembeli.data.remote.ApiService
import com.bogareksa.ui.pembeli.data.remote.ProductResponse
import com.bogareksa.ui.pembeli.data.remote.ProductsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CustomerRepository(application: Application) {
    private val apiService: ApiService
//    private val cartDao: CartDao
    private val orderProduct = mutableListOf<OrderProduct>()

    init{
        if (orderProduct.isEmpty()){
            FakeDataSource.productData.forEach{
                orderProduct.add(OrderProduct(it, 0))
            }
        }
//        val db = CartDatabase.getInstance(application)
//        cartDao = db.cartDAO()
        apiService = ApiConfig.getApiService()
    }

    fun getAllProduct(): LiveData<List<ProductsItem>> {
        val liveData = MutableLiveData<List<ProductsItem>>()

        apiService.getProducts().enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                if (response.isSuccessful) {
                    liveData.value = response.body()?.productList ?: emptyList()
                }
            }
            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return liveData
    }

    fun searchProduct(query: String): LiveData<List<ProductResponse>> {
        val liveData = MutableLiveData<List<ProductResponse>>()

        apiService.getProducts().enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                if (response.isSuccessful) {
                    val filteredList = response.body()?.productList
                        ?.filter { it.name?.contains(query, ignoreCase = true) == true }
                    liveData.value = listOf(ProductResponse(productList = filteredList))
                }
            }
            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return liveData
    }

    fun getProductById(productId: String): LiveData<ProductResponse> {
        val liveData = MutableLiveData<ProductResponse>()

        apiService.getProductById(productId).enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                if (response.isSuccessful) {
                    liveData.value = response.body()
                }
            }
            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
            }
        })

        return liveData
    }

//    fun getAddedOrderProduct(): Flow<List<CartEntity>> {
//        return cartDao.getAllCartItems()
//    }
//

//
//    suspend fun addToCart(productId: Long) {
//        val existingOrderProduct = cartDao.getOrderProductById(productId)
//
//        if (existingOrderProduct != null) {
//            val updatedProduct = existingOrderProduct.copy(amount = existingOrderProduct.amount + 1)
//            cartDao.addToCart(updatedProduct)
//        } else {
//            val productToAdd = FakeDataSource.productData.firstOrNull { it.id == productId }
//            if (productToAdd != null) {
//                val orderProductEntity = CartEntity(0, productToAdd, 1)
//                cartDao.addToCart(orderProductEntity)
//            }
//        }
//    }
//
//    fun updateOrderProduct(productId: Long, newAmountValue: Int): Flow<Boolean> {
//        val index = orderProduct.indexOfFirst { it.product.id == productId }
//        val result = if (index >= 0) {
//            val updatedOrderProduct = orderProduct[index].copy(amount = newAmountValue)
//            orderProduct[index] = updatedOrderProduct
//            true
//        } else {
//            false
//        }
//        return flowOf(result)
//    }

    companion object {
        @Volatile
        private var instance: CustomerRepository? = null

        fun getInstance(application: Application): CustomerRepository =
            instance ?: synchronized(this) {
                CustomerRepository(application).apply {
                    instance = this
                }
            }
    }
}