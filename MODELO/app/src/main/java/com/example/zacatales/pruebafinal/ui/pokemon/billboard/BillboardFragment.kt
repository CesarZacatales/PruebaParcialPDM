package com.example.zacatales.pruebafinal.ui.pokemon.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zacatales.pruebafinal.R
import com.example.zacatales.pruebafinal.data.model.PokemonModel
import com.example.zacatales.pruebafinal.databinding.FragmentBillboardBinding
import com.example.zacatales.pruebafinal.databinding.FragmentNewPokemonBinding
import com.example.zacatales.pruebafinal.ui.pokemon.billboard.recyclerview.PokemonRecyclerViewAdapter
import com.example.zacatales.pruebafinal.ui.pokemon.viewmodel.PokemonViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {

    private val pokemonViewModel: PokemonViewModel by activityViewModels {
        PokemonViewModel.Factory
    }
    private lateinit var binding: FragmentBillboardBinding

    private lateinit var adapter: PokemonRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.NewPokemonBtn.setOnClickListener {
            pokemonViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newPokemonFragment)
        }
    }

    private fun setRecyclerView(view: View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = PokemonRecyclerViewAdapter { selectedPokemon ->
            showSelectedItem(selectedPokemon)
        }
        binding.recyclerView.adapter = adapter
        displayPokemon()
    }

    private fun displayPokemon(){
        adapter.setData(pokemonViewModel.getPokemones())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedItem(pokemon: PokemonModel){
        pokemonViewModel.setSelectedPokemon(pokemon)
        findNavController().navigate(R.id.action_billboardFragment_to_pokemonFragment)
    }
}