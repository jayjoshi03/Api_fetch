package com.example.pokemonapi.modal

import com.google.gson.annotations.SerializedName

data class PokemonList(
    @SerializedName("is_hidden")
    var isHidden:Boolean,
    var pokemon:Pokemon,
    var slot: Int
)
