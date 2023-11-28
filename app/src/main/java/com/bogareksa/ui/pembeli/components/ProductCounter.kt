package com.bogareksa.ui.pembeli.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bogareksa.R

@Composable
fun ProductCounter(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.plus),
            contentDescription = "increase",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .height(24.dp)
                .clickable{}
        )
        Text(
            text = "10",
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = modifier
                .width(64.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.minus),
            contentDescription = "increase",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .height(24.dp)
                .clickable{}
        )
    }
}

@Preview
@Composable
fun ProductCounterPreview() {
    MaterialTheme{
        ProductCounter()
    }
}