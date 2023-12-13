package com.bogareksa.ui.pembeli

import com.bogareksa.ui.pembeli.data.FakeDataSource
import com.bogareksa.ui.pembeli.data.OrderProduct
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class CustomerRepository {
    private val orderProduct = mutableListOf<OrderProduct>()

    init{
        if (orderProduct.isEmpty()){
            FakeDataSource.productData.forEach{
                orderProduct.add(OrderProduct(it, 0))
            }
        }
    }

    fun getAllProduct(): Flow<List<OrderProduct>> {
        return flowOf(orderProduct)
    }

    fun getOrderProductById(productId: Long): OrderProduct {
        return orderProduct.first {
            it.product.id == productId
        }
    }

    fun getAddedOrderProduct(): Flow<List<OrderProduct>> {
        return getAllProduct().map {
                orderProduct -> orderProduct.filter {
                orderProduct -> orderProduct.amount != 0
        }
        }
    }

    fun searchProduct(query: String): List<OrderProduct> {
        return FakeDataSource.productData.filter {
            it.name.contains(query, ignoreCase = true)
        }.map { OrderProduct(it, 0) }
    }

    fun addToCart(productId: Long): Flow<Boolean> {
        return flow {
            val existingIndex = orderProduct.indexOfFirst { it.product.id == productId }

            if (existingIndex != -1) {
                val existingProduct = orderProduct[existingIndex]
                val updatedProduct = existingProduct.copy(amount = existingProduct.amount + 1)
                orderProduct[existingIndex] = updatedProduct
            } else {
                val productToAdd = FakeDataSource.productData.firstOrNull { it.id == productId }
                if (productToAdd != null) {
                    orderProduct.add(OrderProduct(productToAdd, 1))
                }
            }
            emit(true)
        }
    }

    fun updateOrderProduct(productId: Long, newAmountValue: Int): Flow<Boolean> {
        val index = orderProduct.indexOfFirst { it.product.id == productId }
        val result = if (index >= 0) {
            val updatedOrderProduct = orderProduct[index].copy(amount = newAmountValue)
            orderProduct[index] = updatedOrderProduct
            true
        } else {
            false
        }
        return flowOf(result)
    }

    companion object {
        @Volatile
        private var instance: CustomerRepository? = null

        fun getInstance(): CustomerRepository =
            instance ?: synchronized(this) {
                CustomerRepository().apply {
                    instance = this
                }
            }
    }
}