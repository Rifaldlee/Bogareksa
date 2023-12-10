package com.bogareksa.ui.penjual.listProductPage

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bogareksa.R
import com.bogareksa.io.response.MyProductsItem
import com.bogareksa.sessions.LoginSession
import com.bogareksa.ui.auth.LoginActivity
import com.bogareksa.ui.auth.component.LoginViewModel
import com.bogareksa.ui.penjual.listProductPage.component.ItemCard
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

//create the session and get the product token
        session = LoginSession(this)
        var user: HashMap<String,String> = session.getUserProduct()

        runOnUiThread{
            viewModel.listProducts.observe(this, Observer {
                setContent {
                    ProductList(products = it)
                }

            })
        }

        setContent {
                Box(modifier = Modifier.fillMaxSize()){
                    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        CircularProgressIndicator()
                    }
                }
        }



//        Log.d("session string" , "Bearer ${user.toString()}")
        val token = user.toString()

        val result = token.substringAfter("{token=").substringBefore("}")
        viewModel.findProducts(result)

    }
}



@Composable
fun ProductList(products: List<MyProductsItem>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(140.dp),
        contentPadding = PaddingValues(15.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.spacedBy(17.dp)
    ){
        items(products){
                productData ->
            Log.d("data from listsellerproduct","the data list is not null")
            ItemCard(image = productData.imageUrl.toString(), title = productData.name.toString(), price = productData.price!!.toInt(), rate = 5)
        }
    }

}


