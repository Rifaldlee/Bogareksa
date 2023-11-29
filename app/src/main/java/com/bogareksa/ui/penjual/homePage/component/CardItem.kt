package com.bogareksa.ui.penjual.homePage.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bogareksa.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardItem(modifier: Modifier = Modifier){
    Card(onClick = { /*TODO*/ }, modifier = modifier
        .height(100.dp)
        .fillMaxWidth().padding(10.dp).background(color = Color.White)) {
        Row(modifier.background(color = Color.White)){
            Image(painter = painterResource(id = R.drawable.testing_image), modifier = Modifier.size(100.dp),contentDescription = "test")

            HorizontalSpace()
            Column {
                Text(text = "nama barang", style = MaterialTheme.typography.bodySmall)
                Text(text = "stock", style = MaterialTheme.typography.bodyLarge)
                Text(text = "harga", style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = modifier.weight(1f))
            Icon(imageVector = Icons.Default.Edit, contentDescription = "edit product" )

        }
    }
}



@Composable
@Preview(showBackground = true)
fun preview(){
    CardItem()
}