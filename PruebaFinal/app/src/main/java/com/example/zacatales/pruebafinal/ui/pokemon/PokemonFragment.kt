package com.example.zacatales.pruebafinal.ui.pokemon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.zacatales.pruebafinal.R
import com.example.zacatales.pruebafinal.databinding.FragmentPokemonBinding
import com.example.zacatales.pruebafinal.ui.pokemon.billboard.recyclerview.PokemonRecyclerViewAdapter
import com.example.zacatales.pruebafinal.ui.pokemon.viewmodel.PokemonViewModel


class PokemonFragment : Fragment() {

    private val pokemonViewModel: PokemonViewModel by activityViewModels {
        PokemonViewModel.Factory
    }
    private lateinit var binding: FragmentPokemonBinding

    private lateinit var adapter: PokemonRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }
    private fun setViewModel(){
        binding.namePokemon
        binding.viewmodel = pokemonViewModel
    }

}