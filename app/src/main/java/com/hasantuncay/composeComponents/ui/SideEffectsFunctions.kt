package com.hasantuncay.composeComponents.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import com.hasantuncay.composeComponents.MyViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *
 *  Jetpack Compose'da kullanılan çeşitli yan etki (side effect) işlevlerine dair örnekler aşağıda verilmiştir:
 *
 * 1. LaunchedEffect
 *
 *
 * */
@Composable
fun LaunchedEffectExample() {
    val scope = rememberCoroutineScope()
    var text by remember { mutableStateOf("Başlatılmadı") }

    LaunchedEffect(Unit) {
        scope.launch {
            delay(2000) // 2 saniye bekle
            text = "Başlatıldı"
        }
    }

    Text(text)
}

/**
 *
 *
 *
 * 2- UI etkileşimlerine yanıt olarak coroutine başlatmak için kullanılır.
 *
 *
 * */
@Composable
fun RememberCoroutineScopeExample() {
    val scope = rememberCoroutineScope()
    var count by remember { mutableStateOf(0) }

    Button(onClick = {
        scope.launch {
            count++
        }
    }) {
        Text("Artır: $count")
    }
}


/**
3. DisposableEffect
Kaynakları temizlemek için kullanılır.
 */
@Composable
fun DisposableEffectExample(myService: MyService) {
    val listener = object : ExampleListener {
        override fun onEventOccurred() {
            // Event olduğunda yapılacak işlem
        }
    }

    DisposableEffect(Unit) {
        myService.registerListener(listener)
        onDispose {
            myService.unregisterListener(listener)
        }
    }

    // UI Components
}

interface ExampleListener {
    fun onEventOccurred()
}

class MyService {
    fun registerListener(listener: ExampleListener) {
        // Listener'ı kaydet
    }

    fun unregisterListener(listener: ExampleListener) {
        // Listener'ı kayıttan çıkar
    }
}


/**
4. SideEffect
Composable dışı bir API ile durum senkronizasyonu yapmak için kullanılır.
 */
@Composable
fun SideEffectExample(systemUiController: System, color: Color) {
    SideEffect {
        System.console().readLine()
    }
}


/**
 *

5. produceState
Asenkron veri akışını state'e dönüştürmek için kullanılır.
 */

//
//@Composable
//fun ProduceStateExample(viewModel: MyViewModel) {
//    val state by produceState() {
//        viewModel.dataFlow.collect { value ->
//            value = it
//        }
//    }
//
//
//}
/**
 * 6. derivedStateOf
 * Diğer state'lerden türetilen bir state oluşturmak için kullanılır.
 * */
@Composable
fun DerivedStateOfExample() {
    val count = remember { mutableStateOf(0) }
    val isEven = remember {
        derivedStateOf { count.value % 2 == 0 }
    }

    // UI using isEven
}

/**
 * 7. snapshotFlow
 * Compose state'ini Flow'a dönüştürmek için kullanılır.
 */



@Composable
fun SnapshotFlowExample(viewModel: MyViewModel) {
    val count = remember { mutableStateOf(0) }

    LaunchedEffect(count) {
        snapshotFlow { count.value }
            .collect { viewModel.updateCount(it) }
    }

    // UI Components
}

