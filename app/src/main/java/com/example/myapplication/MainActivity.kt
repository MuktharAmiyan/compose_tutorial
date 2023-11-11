
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Black.copy(0.8f)),
                    contentAlignment = Alignment.Center
                ){
                    MyCustomCard(
                        modifier = Modifier.fillMaxWidth(0.8f),
                        image = R.drawable.image,
                        title = "Basketball Shoes for the Win!",
                        text = "Find your game-changing pair of basketball shoes. Score big on the court with style and performance. Explore our top picks now!",
                        publisher = Publisher(name = "Mukthar", job = "Software Engineer" , image = R.drawable.person)
                    )
                }
            }
        }
    }


}


