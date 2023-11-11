
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    val annotatedString = buildAnnotatedString {
                        redBlackGradientText("Hello Apple")
                        append("\n")
                        append("\n")
                        greenBlackGradientText("This is Android")
                    }
                    
                    Text(text = annotatedString)
                }
            }
        }
    }

    @OptIn(ExperimentalTextApi::class)
    private fun AnnotatedString.Builder.redBlackGradientText(text : String) {
        withStyle(
            style = SpanStyle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Red,
                        Color.Black
                    )
                ),
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )
        ) {
            append(text)
        }
    }


    @OptIn(ExperimentalTextApi::class)
    private fun AnnotatedString.Builder.greenBlackGradientText(text : String) {
        withStyle(
            style = SpanStyle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Green,
                        Color.Black
                    )
                ),
                fontSize = 50.sp,
                fontWeight = FontWeight.ExtraLight
            )
        ) {
            append(text)
        }
    }
}


