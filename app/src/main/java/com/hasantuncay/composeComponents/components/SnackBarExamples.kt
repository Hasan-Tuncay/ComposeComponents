package com.hasantuncay.composeComponents.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Snackbar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SnackbasExample(){
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show snackbar") },
                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                onClick = {
                    scope.launch {
                        val result = snackbarHostState
                            .showSnackbar(
                                message = "Snackbar",
                                actionLabel = "Action",
                                // Defaults to SnackbarDuration.Short
                                duration = SnackbarDuration.Indefinite
                            )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                /* Handle snackbar action performed */
                            }
                            SnackbarResult.Dismissed -> {
                                /* Handle snackbar dismissed */
                            }
                        }
                    }
                }
            )
        }
    ) { contentPadding ->
     Column(Modifier.padding(contentPadding).fillMaxSize()) {

     }
    }
}
@Composable
fun CustomSnackbar(
    snackbarHostState: androidx.compose.material.SnackbarHostState,
    message: String, // Snackbar mesajı için yeni parametre
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null
) {
    Box(
        modifier = Modifier.fillMaxSize(), // Ekranın tamamını kaplar ve üstten boşluk bırakır
        contentAlignment = Alignment.BottomCenter // İçeriği üst ortada hizalar
    ) {
        androidx.compose.material.SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(color = Color.White),

            ) { data ->
            // Snackbar'ın kendisi
            Snackbar(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .background(color = Color.White),
                action = {
                    if (actionLabel != null && onActionClick != null) {
                        // Eylem metni için Modifier.clickable ve renk ayarı
                        androidx.compose.material.Text(
                            actionLabel,
                            modifier = Modifier.clickable { onActionClick() },
                            color = Color.Red // Eylem metni rengi
                        )
                    }
                },
                backgroundColor = Color.White, // Snackbar arka plan rengi
                contentColor = Color.Red // Snackbar içerik rengi (metin)
            ) {

                androidx.compose.material.Text(
                    text = data.message,
                    Modifier.fillMaxWidth(),
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun SnackBarPreview(){
    SnackbasExample()
}
