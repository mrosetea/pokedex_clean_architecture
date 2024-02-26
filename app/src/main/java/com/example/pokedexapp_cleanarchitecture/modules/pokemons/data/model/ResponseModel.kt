package com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.model

class ResponseModel(
    val count: Int,
    val next: String? = null,
    val previous: String? = null,
    val results: List<PokemonItem>,
) {
    class PokemonItem(
        val name: String,
        val url: String,
    )
}