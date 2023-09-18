package com.example.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.ui.theme.AndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column(){
                        val names = listOf("a","b","c")

                        Spacer(modifier = Modifier.height(16.dp))
                        for (i in 1 .. 5){
                            PrintOnScreen("b", "null")
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        for (i in names){
                            PrintOnScreen("b" + i, "null")
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        names.forEach{name ->
                            PrintOnScreen(name)
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        names.forEachIndexed{index, name ->
                            PrintOnScreen(name + " " + index.toString())
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PrintOnScreen(name: String?, name2: String? = "sale solo", modifier: Modifier = Modifier) {

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