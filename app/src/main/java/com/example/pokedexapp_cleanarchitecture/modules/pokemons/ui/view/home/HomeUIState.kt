package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.home

import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.model.ResponseModel

data class HomeUIState (
    val pokemons: ResponseModel,
    val isPokemonListLoading: Boolean,
    val error: String?,
)