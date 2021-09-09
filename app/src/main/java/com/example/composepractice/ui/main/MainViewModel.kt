package com.example.composepractice.ui.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    // var data = mutableStateOf("")
    var data = mutableStateOf(listOf(String()))
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    private var error = false

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            isLoading.value = true
            delay(3000)

            isLoading.value = false
            if (!error)
                data.value = listOf("hi" , "this" , "is" , "sample" , "string","hi" , "this" , "is" , "sample" , "string","hi" , "this" , "is" , "sample" , "string")
            else
                loadError.value = "some error"
        }
    }
}