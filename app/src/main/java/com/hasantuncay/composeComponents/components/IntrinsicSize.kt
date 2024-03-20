package com.hasantuncay.composeComponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IntrinsicSizeMinExample() {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .width(IntrinsicSize.Min)
            .border(1.dp, Color.Black)
            .background(Color.LightGray),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "IntrinsicSize.Min  aca",
            modifier = Modifier
                .background(Color.Blue)
                .height(60.dp)


                  // IntrinsicSize.Min kullanımı
        )
        Text(
            text = "IntrinsicSize.Min kisa oldu bu",
            modifier = Modifier
                .background(Color.Blue)
                .height(90.dp)

            // IntrinsicSize.Min kullanımı
        )
    }
}

@Composable
fun IntrinsicSizeMaxExample() {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Max)
            .width(IntrinsicSize.Max)
            .border(1.dp, Color.Black)
            .background(Color.LightGray)
    ) {

        Text(
            text = "IntrinsicSize.Max",
            modifier = Modifier
                .background(Color.Red)
                .height(60.dp)

                 // IntrinsicSize.Max kullanımı
        )
        Text(
            text = "IntrinsicSize.Max uzun oldu bu",
            modifier = Modifier
                .background(Color.Red)
                .height(90.dp)

            // IntrinsicSize.Max kullanımı
        )
    }
}

@Preview
@Composable
fun IntrinsicPreview(){
     Column(modifier = Modifier.fillMaxSize()) {
         IntrinsicSizeMaxExample()
         IntrinsicSizeMinExample()
     }
}