package com.hasantuncay.composeComponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.Button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetDefaults
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
/**
 *   implementation("androidx.compose.material:material:1.6.0")
 *   bunun implementde edilmesi gerek kullanmak icin BOM da kontrol bir ara neden yok bu
 *  */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetExamples(){
    val scope = rememberCoroutineScope()
    val bottomSheetState =
        rememberModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden,
            skipHalfExpanded = true
        )
    val localDensity = LocalDensity.current
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val bottomSheetHeight = localDensity.run { screenHeight * 0.7f }

    ModalBottomSheetLayout(

        sheetContent = {


        },
        modifier = Modifier.fillMaxSize(),
        sheetState = bottomSheetState,
        sheetGesturesEnabled = true,
        sheetShape = RoundedCornerShape(24.dp),
        sheetElevation = bottomSheetHeight,
        sheetBackgroundColor = Color.White,
        sheetContentColor = contentColorFor(Color.Green),
        scrimColor = Color(0xAA000000).also {
            Modifier.clickable(onClick = {
                scope.launch {
                    bottomSheetState.hide()

                }
            })
        },
        content = {
            Button(onClick = { scope.launch { bottomSheetState.show() } }) {
                Text(text = "Open Bottom Sheet")
            }

        }
    )


}
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScaffoldExample() {
    val localDensity = LocalDensity.current
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val bottomSheetHeight = localDensity.run { screenHeight * 0.7f }
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        sheetContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(bottomSheetHeight)
                    .background(Color.Yellow)
            ) {
                // Bottom Sheet içeriği buraya
                Text(text = "Bottom Sheet Content", modifier = Modifier.padding(16.dp))
            }
        },
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetPeekHeight = 0.dp, // Alt sayfanın başlangıçta gösterilen yüksekliği

        // Diğer Scaffold özellikleri...
    ) {
        // Ana ekran içeriği
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                scope.launch {
                    if (bottomSheetScaffoldState.bottomSheetState.isVisible) {
                        bottomSheetScaffoldState.bottomSheetState.expand()
                    } else {
                        bottomSheetScaffoldState.bottomSheetState.hide()
                    }
                }
            }) {
                Text(text = "Toggle Bottom Sheet")
            }
        }
    }
}


@Preview
@Composable
fun BottomSheetExamplesPreview(){
  //  BottomSheetExamples()
    BottomSheetScaffoldExample()
}
