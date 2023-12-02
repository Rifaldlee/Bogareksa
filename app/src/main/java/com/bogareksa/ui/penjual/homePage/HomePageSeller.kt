package com.bogareksa.ui.penjual.homePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bogareksa.R
import com.bogareksa.ui.penjual.homePage.component.BoxData
import com.bogareksa.ui.penjual.homePage.component.CardItem
import com.bogareksa.ui.penjual.homePage.component.CardProfile
import com.bogareksa.ui.penjual.mainSellerComponent.VerticalSpace


@Composable
fun HomePageSeller(getAddPageRoute : () -> Unit,toTheDetail : () -> Unit){
    Box(modifier = Modifier){
        HomePageContent(getAddPageRoute = getAddPageRoute, toDetailPage = toTheDetail)
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageContent(modifier: Modifier = Modifier,toDetailPage : () -> Unit,getAddPageRoute : () -> Unit){

    val scrollState = rememberScrollState()
    Scaffold(
       topBar = {
           TopAppBar(
               actions = {
                   Image(imageVector = Icons.Default.Notifications,modifier = modifier.size(25.dp),contentDescription = "notification")
               },
               navigationIcon = {
                  
               },
               title = {
               Text(text = "Hello Seller")

           },)
       }
    ){
        Column(
            modifier
                .fillMaxWidth()
                .padding(paddingValues = it)
                .padding(15.dp)
                .verticalScroll(state = scrollState)
                .height(950.dp)
                ){
            CardProfile(sellerName = "Reihan Wudd H", sellerEmail = "wudd404@gmail.com")
VerticalSpace()
            HorizontalDivider()
            VerticalSpace()
            LazyVerticalGrid(


                columns = GridCells.Adaptive(140.dp),
              contentPadding = PaddingValues(bottom = 15.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                for (i in 1..4){
                    item {
                       BoxData()
                    }
                }
            }
            VerticalSpace()


            Row(modifier = modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically){
                Text(text = stringResource(id = R.string.product_title), style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick =
                    getAddPageRoute
                ) {
                    Text(text = "Add")
                }
            }

            VerticalSpace()

            LazyColumn{
                for (x in 1..5){
                    item {
                        CardItem(toDetail = toDetailPage)
                        HorizontalDivider()
                    }
                }
            }

            VerticalSpace()
            Button( modifier =modifier.fillMaxWidth(),onClick = { /*TODO*/ }) {
                Text(text = "See All Product")
            }
        }
    }
}



@Composable
@Preview(showBackground = true)
fun preview(){

}