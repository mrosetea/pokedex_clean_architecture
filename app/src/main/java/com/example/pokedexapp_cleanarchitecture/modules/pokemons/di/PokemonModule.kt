package com.example.pokedexapp_cleanarchitecture.modules.pokemons.di

import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.gateway.PokemonGateway
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.gateway.PokemonGatewayImpl
import org.koin.dsl.module

val pokemonModule = module {
    single <PokemonGateway> {
        PokemonGatewayImpl()
    }
}