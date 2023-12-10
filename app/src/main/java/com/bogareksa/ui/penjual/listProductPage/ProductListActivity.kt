package com.bogareksa.ui.penjual.listProductPage

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bogareksa.R
import com.bogareksa.io.response.MyProductsItem
import com.bogareksa.sessions.LoginSession
import com.bogareksa.ui.auth.LoginActivity
import com.bogareksa.ui.auth.component.LoginViewModel
import com.bogareksa.ui.penjual.listProductPage.component.ProductSellerViewModel
import com.bogareksa.ui.theme.MyJetpackAppsTheme

class ProductListActivity : AppCompatActivity() {


    private lateinit var viewModel: ProductSellerViewModel
    private lateinit var viewauth : LoginViewModel
    lateinit var session : LoginSession


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_product_list)
        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(ProductSellerViewModel::class.java)
        viewauth = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[LoginViewModel::class.java]
        val theText: TextView = findViewById(R.id.testingResult)
        session = LoginSession(this)
        var user: HashMap<String,String> = session.getUserProduct()
        runOnUiThread{
            viewModel.listProducts.observe(this, Observer {
                theText.text = it[0].name.toString()
                Log.d("result number 0",it[0].name.toString())

            })
        }
        Log.d("session string" , "Bearer ${user.toString()}")
        val token = user.toString()

        val result = token.substringAfter("{token=").substringBefore("}")
        viewModel.findProducts(result)


        viewauth.authData.observe(this){
            Log.d("the token from prroduct",it.apiToken.toString())
        }


    }
}



@Composable
fun ProductList(products: List<MyProductsItem>) {
    Text(text = "this is a list products")
    LazyColumn {
        items(items = products) { product ->
            // Menampilkan data product di sini
            Text(text = product.name.toString())
        }
    }
}