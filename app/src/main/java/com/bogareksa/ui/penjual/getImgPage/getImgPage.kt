package com.bogareksa.ui.penjual.getImgPage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun GetImgPage(){
    Text(text = "get image")
}



@Composable
fun GetImgPageContent(){
    Column {
        Box {
            Column {
                Text(text = "Nice")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun preview(){
    GetImgPageContent()
}