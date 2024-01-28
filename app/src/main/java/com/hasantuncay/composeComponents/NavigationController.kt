package com.hasantuncay.composeComponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationController(
    viewModel: MyViewModel,
    modifier: Modifier=Modifier


    ) {

val navController= rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.ButtonScreen.route, // Burada başlangıç rotasını belirtiyorsunuz
        modifier = modifier
    ) {
        composable(Screen.StringScreen.route) {
            StringScreen( navController=navController  )
        }
        composable(Screen.ButtonScreen.route) {
            ButtonScreen(  navController=navController  )
        }

    }
}
