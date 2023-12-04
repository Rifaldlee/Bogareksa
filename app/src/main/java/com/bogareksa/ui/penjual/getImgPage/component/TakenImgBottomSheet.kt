package com.bogareksa.ui.penjual.getImgPage.component

import android.graphics.Bitmap
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun TakeImgBottomSheet(
    getListImg : List<Bitmap>
    ,modifier: Modifier = Modifier
){
    if(getListImg.isEmpty()){
        Text(text = "don't have any image")
    }else{
        Text(text = "we have image")
    }
}