package com.bogareksa.ui.penjual.getImgPage.component

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.StateFlow


@Composable
fun PreviewImage(img:Bitmap, listImg: List<Bitmap>){

    val convertImg: ImageBitmap = remember(img.hashCode()) { img.asImageBitmap() }

    TakeImgBottomSheet(
        getListImg = listImg
    )
    Box(modifier = Modifier
        .width(100.dp)
        .height(100.dp)){
        Image(bitmap = convertImg, modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .clickable {
            }, contentScale = ContentScale.Crop,contentDescription = "img preview")
    }
}