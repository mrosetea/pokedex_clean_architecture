package com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.gateway

import com.example.myapplication.core.util.Result
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.api.factory.PokemonFactory
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.api.retrofit.BaseRetrofitApi
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.model.ResponseModel

class PokemonGatewayImpl : PokemonGateway {
    val pokemonApi = BaseRetrofitApi().create()
    override suspend fun getPokemons(): Result<ResponseModel, Exception> {
        val pokemonFactory = PokemonFactory()
        return try {
            val response = pokemonApi.getPokemons()
            pokemonFactory.create(response)
        } catch (e: Exception) {
            pokemonFactory.create()
        }
    }
}