package com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.api.factory
import com.example.myapplication.core.util.Result
open class Factory <R> () {
    fun create(): Result<R, Exception> {
        return Result.failure(
            Exception("Error al obtener la lista de Pokemon.")
        )
    }
}