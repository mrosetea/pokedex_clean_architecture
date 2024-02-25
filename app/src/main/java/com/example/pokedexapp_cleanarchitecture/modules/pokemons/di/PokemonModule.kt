package com.example.pokedexapp_cleanarchitecture.modules.pokemons.di

import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.gateway.PokemonGateway
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.gateway.PokemonGatewayImpl
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pokemonModule = module {
    single <PokemonGateway> { PokemonGatewayImpl() }
    viewModel { HomeViewModel(get()) }
}