package com.example.zacatales.pruebafinal.ui.pokemon.billboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zacatales.pruebafinal.data.model.PokemonModel
import com.example.zacatales.pruebafinal.databinding.PokemonItemBinding

class PokemonRecyclerViewAdapter( private  val clickListener: (PokemonModel) -> Unit): RecyclerView.Adapter<PokemonRecyclerViewHolder>(){
    private val pokemones = ArrayList<PokemonModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonRecyclerViewHolder {
        val binding = PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonRecyclerViewHolder, position: Int) {
        val pokemon = pokemones[position]
        holder.bin(pokemon, clickListener)
    }

    override fun getItemCount(): Int {
        return pokemones.size
    }

    fun setData(pokemonList: List<PokemonModel>){
        pokemones.clear()
        pokemones.addAll(pokemonList)
    }
}
