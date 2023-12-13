package com.bogareksa.ui.pembeli.di

import com.bogareksa.ui.pembeli.CustomerRepository

object Injection {
    fun provideRepository(): CustomerRepository {
        return CustomerRepository.getInstance()
    }
}