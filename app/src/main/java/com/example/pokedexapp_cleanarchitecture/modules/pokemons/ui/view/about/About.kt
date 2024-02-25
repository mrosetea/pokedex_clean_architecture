package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.about

import android.app.Activity
import android.os.Bundle
import com.example.pokedexapp_cleanarchitecture.databinding.ActivityAboutBinding

class About : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val aboutBinding: ActivityAboutBinding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(aboutBinding.root)
    }
}