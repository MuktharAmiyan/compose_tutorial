@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        super.onCreate(savedInstanceState)
        setContent {

            val state = viewModel.state.value

            MyApplicationTheme {
               Column (
                   modifier = Modifier
                       .fillMaxSize()
               ) {



                   LazyColumn(
                       modifier = Modifier
                           .fillMaxWidth()
                           .weight(1f)
                   ){
                       items(state.namesList.size){
                           Text(text = state.namesList[it])
                       }
                   }

                    MyTextField(value = state.text, onValueChanged = {
                       viewModel.updateText(it)
                    }, onAddClick = {
                        viewModel.updateNameList()
                    },)
               }
            }
        }
    }
}

@Composable
fun MyTextField(

    value:String,
    onValueChanged :(String) -> Unit,
    onAddClick : () -> Unit
){
    TextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = {
            IconButton(onClick = onAddClick
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    )
}

