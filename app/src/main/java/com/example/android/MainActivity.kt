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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.ui.theme.AndroidTheme

class MainActivity : ComponentActivity() {

    enum class Colors(val text:String, val number:Int, val color:Color) {
        Red("Rojo", 0, Color(255,0,25)),
        Blue("Azul", 1, Color(0,100,255)),
        Green("Verde", 2, Color(0, 255,50));

        fun WithAlpha(alpha: Float) : Color {
            return this.color.copy(alpha = alpha)
        }
    }
    enum class Operation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column(){
                        PrintOnScreen(name = "aa", color = Colors.Green)

                        var mathFunction: Operations = Operations.Add
                        var result = mathFunction.operation(2,5)

                        PrintOnScreen(name = result.toString(), color = Colors.Red)
                    }
                }
            }
        }
    }
}

class bt(){
    var listeners: MutableList<(bt) -> Unit> = mutableListOf()
    fun AddOnClickListener(OnCLickListenner: (bt) -> Unit){
        listeners.add(OnCLickListenner)
    }
    fun Click(){
        for (listener in listeners) {
            listener(this);
        }
    }
}
enum class Operations (val operation: (Int, Int) -> Int){
    Add({a, b -> a + b}),
    Substract({a,b -> a - b})
}

@Composable
fun PrintOnScreen(name: String?, color: MainActivity.Colors, modifier: Modifier = Modifier) {

    var xDDDDDDD = "mátame por favor"

    val name = name ?: run {
        Log.e("null", "Name is null")
        return
    }

    Text(
        text = "Hello ${name.uppercase()}" + "$xDDDDDDD",
        color = color.WithAlpha(0.6f),
        modifier = modifier
    )
}