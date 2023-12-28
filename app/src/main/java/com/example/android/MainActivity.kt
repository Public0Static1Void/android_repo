package com.example.android// com.example.android.MainActivity.kt
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)
    }
}
