package com.bogareksa.ui.penjual.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bogareksa.ui.penjual.mainSellerComponent.AppbarImgBackground



class NotificationSellerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContent {
            NotificationSellerContent(navBack = {onBackPressed()})
       }
    }
}



@Composable
fun NotificationSellerContent(navBack : () -> Unit){
    Scaffold(
        topBar = {
            AppbarImgBackground(navBack = { navBack()}, title = "Notification")
        }
    ){
        Column(modifier = Modifier
            .padding(it)
            .fillMaxWidth()){
            Text(text = "Don't have any notification!!")
        }
    }
}
