package com.example.android// com.example.android.MainActivity.kt
import android.os.Bundle
import android.view.View
import android.view.View.OnLayoutChangeListener
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.android.R

class MainActivity : AppCompatActivity() {

    val menu_button: ImageView by lazy { findViewById<ImageView>(R.id.btn_menu) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.start_toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = null // Hace que no aparezca el título del proyecto en la toolbar
        }

        val menu_button: ImageView = findViewById(R.id.btn_menu)
        menu_button.setOnClickListener { view ->
            showPopupMenu(view)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean("buttonEnabled", menu_button.isEnabled)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val isButtonEnabled = savedInstanceState.getBoolean("buttonEnabled")
        menu_button.isEnabled = isButtonEnabled
    }


    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.menu_settings)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_settings -> {
                    // Lógica cuando se selecciona la opción del menú
                    Toast.makeText(this, "Configuración seleccionada", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.action_profile -> {
                    setContentView(R.layout.profile_layout)
                    true
                }
                // Otras opciones
                else -> false
            }
        }

        popupMenu.show()
    }

    override fun onBackPressed() {
        onSaveInstanceState(this)
        setContentView(R.layout.start_screen)
    }
}