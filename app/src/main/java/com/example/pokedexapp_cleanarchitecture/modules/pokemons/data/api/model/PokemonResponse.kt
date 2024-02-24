package com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.api.model

class PokemonResponse(
    val count: Int? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<PokemonItem>? = null,
) {
    class PokemonItem(
        val name: String? = null,
        val url: String? = null,
    )
}

