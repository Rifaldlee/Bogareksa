package com.bogareksa.ui.penjual.addProductPage

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore.Images
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.bogareksa.R
import com.bogareksa.sessions.LoginSession
import com.bogareksa.ui.penjual.addProductPage.component.AddProductViewModel
import com.bogareksa.ui.penjual.addProductPage.component.InputAddForm
import com.bogareksa.ui.penjual.addProductPage.component.InputAddFormDesk
import com.bogareksa.ui.penjual.mainSellerComponent.AppbarImgBackground
import com.bogareksa.ui.penjual.mainSellerComponent.VerticalSpace
import com.bogareksa.ui.penjual.uploadImage.UploadImageActivity
import java.io.File


class AddProductActivity : ComponentActivity() {
    private lateinit var viewModel :AddProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[AddProductViewModel::class.java]
        val img = intent.getStringExtra("img")
        Log.d("recive img from upload",img.toString())

        //TOKEN
        val session = LoginSession(ctx = this)
        var user: HashMap<String,String> = session.getUserProduct()
        val castToTxt = user.toString()
        val theToken = castToTxt.substringAfter("{token=").substringBefore("}")
        setContent {
            AddProductSellerContent(
                token = theToken,
                vm = viewModel,
                getImgPage = {
                    val int =Intent(this,UploadImageActivity::class.java)
                    startActivity(int)
                },
                navBack = {
                    onBackPressed()
                },
                imgPath = img.toString()
            )
        }
    }
}


//@Composable
//fun AddProductPageSeller(token: String,vm:AddProductViewModel,navBack : () -> Unit,toTheGetImg : () -> Unit){
//    AddProductSellerContent(token = token,vm = vm, navBack = navBack, getImgPage = toTheGetImg)
//}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AddProductSellerContent(imgPath:String,token: String,vm: AddProductViewModel,getImgPage: () -> Unit,navBack: () -> Unit,modifier: Modifier = Modifier){
    val scrollState = rememberScrollState()
    val imgExists = false
    val ctx = LocalContext.current

    val fixImgPath = imgPath.removePrefix("file://")

    var txt by remember {
      mutableStateOf("")
    }

    var txtPrice by remember {
        mutableStateOf("")
    }

    var txtDesk by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            AppbarImgBackground(navBack = { navBack() }, title ="Add Product" )

        }
    ){
        Column(
            modifier
                .padding(paddingValues = it)
                .padding(top = 5.dp)
                .verticalScroll(scrollState), verticalArrangement = Arrangement.Top){
            if(imgExists){
                Image(painter = painterResource(id = R.drawable.testing_image),modifier = modifier
                    .fillMaxWidth()
                    .height(400.dp),contentDescription = "photo image")
            }else{

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .background(color = Color.Gray)){
                    Image(painter = painterResource(id = R.drawable.camera),modifier = Modifier
                        .size(50.dp)
                        .align(alignment = Alignment.Center)
                        .clickable {
                            getImgPage()
                        }, contentDescription ="add image" )
                }
            }
            Column (modifier.padding(start = 10.dp, end = 10.dp)){
                VerticalSpace()
                InputAddForm(hint = "insert text", title = "Product Name", txt = txt, onChage = {value ->
                    txt =value
                })
                VerticalSpace()
                InputAddForm(hint = "insert text", title = "Product Price", txt = txtPrice, onChage = {value ->
                    txtPrice = value
                })
                VerticalSpace()
                InputAddFormDesk(txt = txtDesk, hint = "masukkan Deskripsi", title = "Product Detail", onChage = {value ->
                    txtDesk = value
                })
                VerticalSpace()
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(
                            RoundedCornerShape(10.dp)
                        )
                        .background(color = Color(0xff00698C))
                        .clickable {
                            vm.uploadProduct(
                                token = token,
                                name = txt,
                                price = txtPrice.toInt(),
                                uploaded = File(fixImgPath)
                            )
                        }
                        .padding(bottom = 10.dp)
                ){
                    Text(text = "Upload", modifier = Modifier.align(Alignment.Center), style = MaterialTheme.typography.bodyLarge.copy(color = Color.White))
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun preview(){
    val navController = rememberNavController()
}