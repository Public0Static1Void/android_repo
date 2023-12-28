package com.example.android// com.example.android.MainActivity.kt

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RiotGamesAPI {
    @GET("/lol/summoner/v4/summoners/by-name/{summonerName}")
    fun getSummonerByName(
        @Path("summonerName") summonerName: String,
        @Query("api_key") apiKey: String // Parámetro para la clave de API
    ): Call<Summoner>
    // Define más llamadas a la API según tus necesidades
}


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)


/*
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.start_toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = null // Hace que no aparezca el título del proyecto en la toolbar
        }

        val menu_button: ImageView = findViewById(R.id.btn_menu)
        menu_button.setOnClickListener { view ->
            showPopupMenu(view)
        }

 */

        RestoreMenuButtons()
    }

    private fun SetProfile(nombre: String){
        setContentView(R.layout.profile_layout)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/") // URL base de la API de Riot Games
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val riotGamesAPI = retrofit.create(RiotGamesAPI::class.java)

        val text: TextView = findViewById(R.id.user_name)
        val level: TextView = findViewById(R.id.user_level)

        val call = riotGamesAPI.getSummonerByName(nombre, "RGAPI-9df185aa-7420-4cba-b1b8-c8aaf29ae216")

        call.enqueue(object : Callback<Summoner> {
            override fun onResponse(call: Call<Summoner>, response: Response<Summoner>) {

                if (response.isSuccessful) {
                    val summoner = response.body()
                    // Haz algo con los datos del invocador aquí
                    if (summoner != null) {
                        text.text = summoner.name
                        level.text = summoner.summonerLevel
                    }
                } else {
                    // Manejar errores si la solicitud no fue exitosa
                    text.text= "Usuario no encontrado"
                }
            }

            override fun onFailure(call: Call<Summoner>, t: Throwable) {
                // Manejar errores de conexión u otros errores aquí
                text.text= "c"
            }
        })
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
        setContentView(R.layout.start_screen)
        RestoreMenuButtons()
    }

    private fun RestoreMenuButtons(){
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.start_toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = null // Hace que no aparezca el título del proyecto en la toolbar
        }

        val menu_button: ImageView = findViewById(R.id.btn_menu)
        menu_button.setOnClickListener { view ->
            showPopupMenu(view)
        }

        val menu_search: SearchView = findViewById(R.id.search_view)
        menu_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // Realizar la búsqueda cuando se presiona Enter o se confirma la búsqueda
                SetProfile(query)
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
    }
}