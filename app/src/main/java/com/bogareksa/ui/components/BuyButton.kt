package com.bogareksa.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BuyButton(
    text: String,
          modifier: Modifier = Modifier,
          enabled: Boolean = true,
          onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = (Color(0xFF00698C))),
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp)
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.CenterVertically)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun OrderButtonPreview() {
    MaterialTheme {
        BuyButton(
            text = "Order",
            onClick = {}
        )
    }
}