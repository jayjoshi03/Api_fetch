package com.example.pokemonapi.modal

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    @SerializedName("pokemon")
    var pokemonListValue: MutableList<PokemonList>
)
