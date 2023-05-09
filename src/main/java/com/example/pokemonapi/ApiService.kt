package com.example.pokemonapi

import com.example.pokemonapi.modal.PokemonListResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("v2/ability/31/")
    fun getUserList(): Call<PokemonListResponse>
}