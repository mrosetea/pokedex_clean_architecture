package com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.api.retrofit
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.api.model.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {
    @GET("pokemon")
    suspend fun getPokemons(): Response<PokemonResponse>
}