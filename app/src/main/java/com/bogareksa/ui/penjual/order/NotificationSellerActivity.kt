package com.bogareksa.ui.penjual.order

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.bogareksa.MainActivity
import com.bogareksa.ui.auth.LoginActivity
import com.bogareksa.ui.penjual.addProductPage.AddProductActivity
import com.bogareksa.ui.penjual.homePage.component.CustomButton
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
    val activityResultLauncher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        // Handle the result if needed
        if (result.resultCode == Activity.RESULT_OK) {
            // Handle success
        } else {
            // Handle failure or canceled
        }
    }
    val ctx = LocalContext.current
    Scaffold(
        topBar = {
            AppbarImgBackground(navBack = { navBack()}, title = "Settings")
        }
    ){
        Column(modifier = Modifier
            .padding(it)
            .fillMaxWidth()){
          Button(
              colors = ButtonColors(containerColor = Color(0xff00698C), disabledContentColor = Color(0xff00698C), contentColor = Color.White, disabledContainerColor = Color(0xff00698C)),
              shape = MaterialTheme.shapes.medium,
              modifier = Modifier.fillMaxWidth().padding(20.dp)
              ,onClick = {
              activityResultLauncher.launch(
                  Intent(ctx, LoginActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
              )
          }) {
              Text(text = "LogOut ->")
          }

        }
    }
}
