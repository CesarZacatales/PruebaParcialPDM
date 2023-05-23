package com.example.zacatales.pruebafinal.ui.pokemon.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.zacatales.pruebafinal.data.model.PokemonModel
import com.example.zacatales.pruebafinal.databinding.PokemonItemBinding

class PokemonRecyclerViewHolder(private val binding: PokemonItemBinding):RecyclerView.ViewHolder(binding.root) {

    fun bin(pokemon: PokemonModel, clickListener: (PokemonModel) -> Unit){
        binding.textNamePokemon.text = pokemon.name
        binding.textRatingPokemon.text = pokemon.rating
        binding.textType.text = pokemon.category

        binding.pokemonItemCard.setOnClickListener{
            clickListener(pokemon)
        }
    }
}