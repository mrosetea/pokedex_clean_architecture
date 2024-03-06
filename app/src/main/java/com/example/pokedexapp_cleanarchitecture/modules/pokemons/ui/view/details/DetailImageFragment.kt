package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokedexapp_cleanarchitecture.databinding.FragmentDetailImageBinding

class DetailImageFragment : Fragment() {

    private lateinit var binding: FragmentDetailImageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentDetailImageBinding.inflate(layoutInflater)
        val id = arguments?.getInt("id")
        //binding.pokemonImage.loadImage("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/${id}.png")
        return binding.root
    }

}