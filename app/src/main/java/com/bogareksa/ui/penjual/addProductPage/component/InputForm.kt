package com.bogareksa.ui.penjual.addProductPage.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bogareksa.ui.penjual.mainSellerComponent.VerticalSpace

@Composable
fun InputAddForm(hint:String,title:String){
    var txt by remember{ mutableStateOf("") }
    var valid by remember{ mutableStateOf(true) }


    Column {
        Text(text = title, style = MaterialTheme.typography.bodyLarge)
        VerticalSpace()
        TextField(
            modifier = Modifier.fillMaxWidth()
            ,value = txt,
            onValueChange ={
                txt = it
                valid = it.isNotEmpty()
            } ,
            label = { Text(text = "enter text")},

            )

        if(!valid){
            Text(text = "please enter a text")
        }
    }
}

@Composable
@Preview
fun preview(){
    InputAddForm(hint = "insert text", title = "test")
}