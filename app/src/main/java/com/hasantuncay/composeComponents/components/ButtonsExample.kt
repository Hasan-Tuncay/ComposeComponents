package com.hasantuncay.composeComponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FilledButtonExample(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text("Filled")
    }
}
@Composable
fun FilledTonalButtonExample(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick() }) {
        Text("Tonal")
    }
}
@Composable
fun OutlinedButtonExample(onClick: () -> Unit) {
    OutlinedButton(onClick = { onClick() }) {
        Text("Outlined")
    }
}
@Composable
fun ElevatedButtonExample(onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        Text("Elevated")
    }
}
@Composable
fun TextButtonExample(onClick: () -> Unit) {
    TextButton(
        onClick = { onClick() }
    ) {
        Text("Text Button")
    }
}
@Composable
fun ButtonsExample(){
    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {

            FilledButtonExample {

            }
            FilledTonalButtonExample {

            }
            OutlinedButtonExample {

            }
            ElevatedButtonExample {

            }
            TextButtonExample{}


    }
}
@Preview
@Composable
fun ButtonsPreview(){
    ButtonsExample()}