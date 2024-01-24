package com.hasantuncay.composeComponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
@Composable
fun IndeterminateCircularIndicator(loading: Boolean) {


    if (!loading) return

    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = MaterialTheme.colorScheme.secondary,
        strokeWidth = 5.dp,
    )
}
@Composable
fun IndeterminateLinearIndicator(loading: Boolean) {


    if (!loading) return

    LinearProgressIndicator(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
        color = MaterialTheme.colorScheme.secondary,
         
    )
}
@Composable
fun LinearDeterminateIndicator(loading: Boolean, currentProgress: Float) {



    Column(

        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier.fillMaxWidth()
    ) {


        if (loading) {
            LinearProgressIndicator(
                progress =   currentProgress  ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
            )
        }
    }
}

@Composable
fun ProgressIndicatorsExample(){
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var loading by remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope() // Create a coroutine scope
        var currentProgress by remember { mutableStateOf(0f) }
       
         Button(onClick = {
        loading = true
        scope.launch {
            loadProgress { progress ->
                currentProgress = progress
            }
            loading = false // Reset loading when the coroutine finishes
        }
    }, enabled = !loading) {
        Text("Start loading")
    }
        IndeterminateLinearIndicator(loading = loading)
        IndeterminateCircularIndicator(loading) 
        Spacer(modifier = Modifier.padding(vertical = 100.dp))
        LinearDeterminateIndicator(loading,currentProgress)


    }

}
/** Iterate the progress value */
suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(100)
    }
}
@Preview(showBackground = true)
@Composable
fun LinearDeterminateIndicatorPreview(){
    ProgressIndicatorsExample()
}
