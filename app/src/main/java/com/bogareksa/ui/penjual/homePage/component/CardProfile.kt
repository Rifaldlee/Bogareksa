package com.bogareksa.ui.penjual.homePage.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bogareksa.R


@Composable
fun CardProfile(modifier: Modifier = Modifier){
    Row(
        modifier.height(50.dp)
    ){
        Image( modifier = modifier
            .size(50.dp)
            .clip(CircleShape),painter = painterResource(id = R.drawable.food), contentDescription = "avatar")
        Column(modifier.padding(5.dp)){
            Text(text = "Seller Name", style = MaterialTheme.typography.titleMedium.copy(fontSize = 12.sp))
            Spacer(modifier = modifier.weight(1f))
            Text(text = "Seller Email@gmail.com", style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp, fontWeight = FontWeight.ExtraLight))
        }
        Image(imageVector = Icons.Default.Notifications,modifier = modifier.size(15.dp),contentDescription = "notification")
    }
}


@Composable
@Preview(showBackground = true)
fun Preview(){
    CardProfile()
}