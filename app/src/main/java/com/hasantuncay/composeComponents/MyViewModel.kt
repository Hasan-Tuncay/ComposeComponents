package com.hasantuncay.composeComponents

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyViewModel(): ViewModel() {
    private var _dataFlow = MutableStateFlow<Int>(0)
    val dataFlow : StateFlow<Int> = _dataFlow.asStateFlow()
    fun updateCount(count: Int){
        _dataFlow.value=count
    }
}