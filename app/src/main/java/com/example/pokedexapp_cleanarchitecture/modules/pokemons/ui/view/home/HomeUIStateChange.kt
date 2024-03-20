package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.home

import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.model.ResponseModel

sealed interface HomeUIStateChange {

    fun toUiState(previousState: HomeUIState): HomeUIState

    class AddHomeLoading(
        val isPokemonListLoading: Boolean = true,
    ): HomeUIStateChange {
        override fun toUiState(previousState: HomeUIState): HomeUIState
        = previousState.copy(
            isPokemonListLoading = this.isPokemonListLoading,
        )
    }

    class RemoveHomeLoading(
        val isPokemonListLoading: Boolean = false
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
        ): HomeUIStateChange {
        override fun toUiState(previousState: HomeUIState): HomeUIState
        = previousState.copy(
            pokemons = this.pokemons,
        )
    }

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

    class None: HomeUIStateChange {
        override fun toUiState(previousState: HomeUIState): HomeUIState
        = previousState
    }

}