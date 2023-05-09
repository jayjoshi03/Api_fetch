package com.example.pokemonapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.pokemonapi.adapter.PokemonAdapter
import com.example.pokemonapi.databinding.ActivityMainBinding
import com.example.pokemonapi.modal.PokemonList
import com.example.pokemonapi.modal.PokemonListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var listAdapter: PokemonAdapter
    var userList = mutableListOf<PokemonList>()
    private lateinit var retrofit:Retrofit
    lateinit var service:ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ApiService::class.java)

        listAdapter = PokemonAdapter(this,userList)
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = listAdapter

        loadPetList()

    }

    private fun loadPetList() {

        service.getUserList().enqueue(object : Callback<PokemonListResponse>{
            override fun onResponse(
                call: Call<PokemonListResponse>,
                response: Response<PokemonListResponse>
            ) {
                if (response.isSuccessful){
                    var res = response.body()

                    userList = res!!.pokemonListValue
                    listAdapter.setItems(userList)

                }
            }

            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Fail!", Toast.LENGTH_SHORT).show()
            }

        })
    }
}