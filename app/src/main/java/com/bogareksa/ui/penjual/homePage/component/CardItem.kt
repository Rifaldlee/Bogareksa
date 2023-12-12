package com.bogareksa.ui.penjual.homePage.component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bogareksa.R
import com.bogareksa.io.response.MyProductsItem
import com.bogareksa.ui.penjual.mainSellerComponent.HorizontalSpace

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardItem(data: MyProductsItem,modifier: Modifier = Modifier,toDetail : () -> Unit){
    Card(onClick = {
        Log.d("msg","yes it's to the detail")
        toDetail()
    }, modifier = modifier
        .height(90.dp)
        .fillMaxWidth().padding(bottom = 10.dp).background(color = Color.White)) {
        Row(modifier.background(color = Color.White)){
//            Image(painter = painterResource(id = R.drawable.testing_image), modifier = Modifier.size(90.dp),contentDescription = "test")
            AsyncImage(model = data.imageUrl,  contentDescription = data.name.toString(), modifier = modifier.size(90.dp),contentScale = ContentScale.Crop,)

            HorizontalSpace()
            Column {
                Text(text = data.name.toString(), style = MaterialTheme.typography.bodySmall)
//                Text(text = data..toString(), style = MaterialTheme.typography.bodyLarge)
                Text(text = data.price.toString(), style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = modifier.weight(1f))
            Icon(imageVector = Icons.Default.Edit, contentDescription = "edit product" )

        }
    }
}



@Composable
@Preview(showBackground = true)
fun preview(){
//    CardItem(toDetail = {})
}