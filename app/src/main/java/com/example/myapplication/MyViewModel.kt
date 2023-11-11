package com.example.myapplication

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val state = mutableStateOf(MyScreenState())

    fun updateText(newText :String){
        state.value = state.value.copy(text = newText)
    }

    fun updateNameList (){
        val currentList = state.value.namesList
        currentList.add(state.value.text)
        state.value = state.value.copy(text = "", namesList = currentList)
    }

}