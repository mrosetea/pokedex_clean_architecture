package com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.api.factory

import com.example.myapplication.core.util.Result
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.api.model.PokemonResponse
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.model.ResponseModel
import retrofit2.Response
import java.lang.Exception

class PokemonFactory: Factory<ResponseModel>() {
    fun create(response: Response<PokemonResponse>): Result<ResponseModel, Exception>{
        if(!response.isSuccessful){
            return create()
        }
        val body = response.body()
        body?.let {
            if(it.isDataValid()) {
                return Result.success(it.toDataModel())
            }
            return create()
        }
        return create()
    }
}

private fun PokemonResponse.isDataValid(): Boolean {
    return !results.isNullOrEmpty()
}

private fun PokemonResponse.toDataModel(): ResponseModel {
    return ResponseModel(
        count = count ?: 0,
        next.orEmpty(),
        previous.orEmpty(),
        results = results?.map {
            ResponseModel.PokemonItem(
                it.name.orEmpty(),
                it.url.orEmpty(),
            )
        } ?: emptyList()
    )
}