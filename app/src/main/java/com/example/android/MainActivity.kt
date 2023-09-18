package com.example.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.ui.theme.AndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    PrintOnScreen("b", "null")
                }
            }
        }
    }
}

@Composable
fun PrintOnScreen(name: String?, name2: String?, modifier: Modifier = Modifier) {

    var xDDDDDDD = "mátame por favor"

    val name = name ?: run {
        Log.e("null", "Name is null")
        return
    }
    val name2 = name2 ?: run {
        Log.e("null", "Name is null")
        return
    }

    Text(
        text = "Hello ${name.uppercase()}" + "$xDDDDDDD"
    )
}