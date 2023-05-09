package com.example.pokemonapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapi.databinding.LayoutCardViewBinding
import com.example.pokemonapi.modal.PokemonList

class PokemonAdapter(var context:Context, var pokeList:MutableList<PokemonList>) : RecyclerView.Adapter<PokemonAdapter.MyViewHolder>() {

    lateinit var binding:LayoutCardViewBinding

    class MyViewHolder(var binding: LayoutCardViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = LayoutCardViewBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pokeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var petList = pokeList[position]
        holder.binding.tvName.text = "Pokemon Name: ${petList.pokemon.name}"
        holder.binding.tvSlot.text = "${petList.slot}"
        holder.binding.tvUrl.text = "Url: ${petList.pokemon.url}"
    }

    fun setItems(pokeList: MutableList<PokemonList>){
        this.pokeList = pokeList
        notifyDataSetChanged()
    }
}