package com.hasantuncay.composeComponents

sealed class Screen(
    val route: String
) {
    object StringScreen : Screen("string_screen")
    object ButtonScreen : Screen("button_screen")
}
