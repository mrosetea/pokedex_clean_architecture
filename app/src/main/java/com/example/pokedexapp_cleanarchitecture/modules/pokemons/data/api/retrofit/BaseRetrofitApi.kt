package com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.api.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseRetrofitApi {
    private val baseUrl = "https://pokeapi.co/api/v2/";
    fun create(): PokemonApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(PokemonApi::class.java)
    }

}