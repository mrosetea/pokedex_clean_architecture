package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.gateway.PokemonGateway
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.model.ResponseModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val pokemonGateway: PokemonGateway) : ViewModel() {


    private var uiState = HomeUIState(
        pokemons = ResponseModel(
            0,
        null,
            null,
            emptyList()
        ),
        isPokemonListLoading = false,
        error = null
    )
    private val initialState = ResponseModel(0, null, null, emptyList())
    private val _uiStateChange = MutableStateFlow<HomeUIStateChange>(HomeUIStateChange.None())
    val uiStateChange = _uiStateChange.asStateFlow()

    private fun updateUiState(uiStateChange: HomeUIStateChange){
        uiState = uiStateChange.toUiState(uiState)
        _uiStateChange.update {
            uiStateChange
        }
    }

    init {
        viewModelScope.launch {
            updateUiState(HomeUIStateChange.AddHomeLoading())
            val result = pokemonGateway.getPokemons()
            updateUiState(HomeUIStateChange.RemoveHomeLoading())
            result.onSuccess {
                updateUiState(HomeUIStateChange.AddHomePokemonsList(pokemons = it))
            }
            result.onFailure {
                updateUiState(HomeUIStateChange.RemoveHomeLoading())
                updateUiState(HomeUIStateChange.AddHomeError(
                    error = "Error al cargar los datos"
                ))
            }
        }
    }

}