package com.example.android

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
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

    class ButtonsRow(var linearLayout: LinearLayout, val context: Context){
        var buttons: MutableList<Button> = mutableListOf()

        fun AddButtonToRow(text: String) : Button {
            var bt = Button(context)
            bt.text = text
            bt.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT, 1.0f
            )

            linearLayout.addView(bt)
            buttons.add(bt)

            return bt
        }
    }

    class ButtonsGrid(var parent: LinearLayout, val context: Context){
        val baseLinearLayout: LinearLayout
        private var rows: MutableList<ButtonsRow> = mutableListOf()

        fun GetRow(index: Int) : ButtonsRow? {
            if (index >= rows.count() || index < 0){
                return null
            }

            return rows[index]
        }

        init{
            baseLinearLayout = LinearLayout(context)
            baseLinearLayout.orientation = LinearLayout.VERTICAL

            parent.addView(baseLinearLayout)
        }
        fun AddNewRow(){
            val linearLayout = LinearLayout(context)

            baseLinearLayout.addView(linearLayout)
            rows.add(ButtonsRow(linearLayout, context))
        }
    }

    val result: TextView by lazy { findViewById(R.id.result) }
    val buttons_container : LinearLayout by lazy { findViewById(R.id.buttons_container) }
    var buttonsGrid: MutableList<LinearLayout> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)
        /*
        val bt = Button(this)
        bt.text = "Creado"
        //bt.layoutParams.width = LayoutParams.WRAP_CONTENT
        bt.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        */
        result.text = "0"

        //buttons_container.addView(bt)

        val btGrid = ButtonsGrid(buttons_container, this)
        /*
        btGrid.AddNewRow()

        val bt1 = btGrid.GetRow(0)?.AddButtonToRow("Bt1")
        bt1?.setOnClickListener{
            result.text = "1"
        }
        val bt2 = btGrid.GetRow(0)?.AddButtonToRow("Bt2")
        bt2?.setOnClickListener{
            result.text = "2"
        }
 */

        var names: MutableList<MutableList<String>> = mutableListOf()
        names.add(mutableListOf("AC", "()", "%", "/"))
        names.add(mutableListOf("7", "8", "9", "x"))
        names.add(mutableListOf("4", "5", "6", "-"))
        names.add(mutableListOf("1", "2", "3", "+"))
        names.add(mutableListOf("0", ".", "<-", "="))
        for (i in names.indices){
            btGrid.AddNewRow()

            var row : ButtonsRow? = btGrid.GetRow(i)

            for (j in names[i].indices){
                row?.AddButtonToRow(names[i][j])
            }
        }
    }
}