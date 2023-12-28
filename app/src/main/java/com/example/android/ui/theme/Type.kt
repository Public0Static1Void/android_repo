package com.example.android.ui.theme

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.android.R
import com.example.android.SecondScreen

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

// Set of Material typography styles to start with
val Typography = Typography(
        bodyLarge = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
        )
        /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)



class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContent{
                        setContentView(R.layout.start_screen)
                }
                /*
                        // Referencia a la Toolbar en el diseño
                        val toolbar: Toolbar = findViewById(R.id.my_toolbar)

                        // Configurar la Toolbar como la Action Bar de la actividad
                        setSupportActionBar(toolbar)

                        // Opcional: Personalizar la Action Bar
                        supportActionBar?.apply {
                            title = "Mi App" // Cambiar el título de la Action Bar
                            // Más configuraciones de la Action Bar, como iconos de navegación, etc.
                        }
                        */
        }
}
