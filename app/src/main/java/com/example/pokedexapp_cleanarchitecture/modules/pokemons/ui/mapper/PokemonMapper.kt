package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.mapper

import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.model.ResponseModel as DataModel
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.model.Response as UIModel

fun DataModel.toUIModel(): UIModel = UIModel(count, next, previous, results.map {
    val splitedUrl = it.url.split("/")

    UIModel.Pokemon(
        it.name.orEmpty(),
        it.url.orEmpty(),
        splitedUrl[splitedUrl.size - 2].toInt()
    )
} ?: emptyList())
