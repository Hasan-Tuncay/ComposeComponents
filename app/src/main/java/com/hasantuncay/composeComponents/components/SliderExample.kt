package com.hasantuncay.composeComponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SliderMinimalExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(modifier=
            Modifier.padding(horizontal = 20.dp),
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun SliderAdvancedExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(
            modifier=
            Modifier.padding(horizontal = 20.dp),
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = 234,
            valueRange = 0f..500f
        )
        Text(text = sliderPosition.toString())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RangeSliderExample() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    Column {
        RangeSlider(
            modifier=
            Modifier.padding(horizontal = 20.dp),
            value = sliderPosition,
            steps = 5,
            onValueChange = { range -> sliderPosition = range },
            valueRange = 0f..100f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
        )
        Text(text = sliderPosition.toString())
    }
}
@Composable
fun Sliders(){
    Column(Modifier.fillMaxSize(),verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        SliderMinimalExample()
        RangeSliderExample()
      SliderAdvancedExample()
    }
}
@Preview
@Composable
fun SlidersPreview(){
    Sliders()
}