package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.model

class Response(
    val count: Int,
    val next: String? = null,
    val previous: String? = null,
    val results: List<Pokemon>
) {
    class Pokemon(
        val name: String,
        val url: String,
        val id: Int,
        val urlImage: String
    )
}