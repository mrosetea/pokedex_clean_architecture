package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.home

import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.model.ResponseModel
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.model.Response

sealed interface HomeUIStateChange {

    fun toUiState(previousState: HomeUIState): HomeUIState

    class AddHomeError(
        val error: String,
        private val isPokemonListLoading: Boolean = false,
        private val pokemons: ResponseModel = ResponseModel(
            0,
            null,
            previous = null,
            results = emptyList()
        )
    ): HomeUIStateChange{
        override fun toUiState(previousState: HomeUIState): HomeUIState
        = previousState.copy(
            error = this.error,
            isPokemonListLoading = this.isPokemonListLoading,
            pokemons = this.pokemons
        )
    }

    class AddHomeLoading(
        private val isPokemonListLoading: Boolean = true,
        private val pokemons: ResponseModel = ResponseModel(
            0,
            null,
            previous = null,
            results = emptyList()
        )
    ): HomeUIStateChange {
        override fun toUiState(previousState: HomeUIState): HomeUIState
        = previousState.copy(
            isPokemonListLoading = this.isPokemonListLoading,
            error = null,
            pokemons = this.pokemons
        )
    }

    class RemoveHomeLoading(
        private val isPokemonListLoading: Boolean = false
    ): HomeUIStateChange {
        override fun toUiState(previousState: HomeUIState): HomeUIState
                = previousState.copy(
            isPokemonListLoading = this.isPokemonListLoading,
        )
    }

    class AddHomePokemonsList(
        val pokemons: ResponseModel = ResponseModel(
            0,
            null,
            previous = null,
            results = emptyList()
        ),
        private val isPokemonListLoading: Boolean = false,
        ): HomeUIStateChange {
        override fun toUiState(previousState: HomeUIState): HomeUIState
        = previousState.copy(
            isPokemonListLoading = this.isPokemonListLoading,
            pokemons = this.pokemons,
            error = null,
        )
    }

    class None: HomeUIStateChange {
        override fun toUiState(previousState: HomeUIState): HomeUIState
        = previousState
    }

}