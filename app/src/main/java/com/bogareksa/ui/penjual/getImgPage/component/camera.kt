package com.bogareksa.ui.penjual.getImgPage.component

import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import com.bogareksa.ui.penjual.detailProductPage.Preview

@Composable
fun openCamera(

){
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraControll = remember {
        LifecycleCameraController(context)
    }

    Scaffold(modifier = Modifier.fillMaxSize()){
        AndroidView(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            factory = {
                PreviewView(context).apply {
                    layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                    setBackgroundColor(0x000000)
                    scaleType = PreviewView.ScaleType.FILL_START
                }.also {
                    it.controller = cameraControll
                    cameraControll.bindToLifecycle(lifecycleOwner)
                }
            })
    }
}