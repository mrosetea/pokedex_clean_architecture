package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedexapp_cleanarchitecture.databinding.ActivityPokemonBinding

class PokemonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPokemonBinding.inflate(layoutInflater);
        setContentView(binding.root)
    }
}