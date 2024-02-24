package com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.gateway

import com.example.myapplication.core.util.Result
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.model.ResponseModel
import java.lang.Exception

interface PokemonGateway {
    suspend fun getPokemons(): Result<ResponseModel, Exception>
}