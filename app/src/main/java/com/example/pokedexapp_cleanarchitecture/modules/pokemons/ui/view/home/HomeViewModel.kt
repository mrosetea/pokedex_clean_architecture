package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.home

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.gateway.PokemonGateway
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.data.model.ResponseModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val pokemonGateway: PokemonGateway) : ViewModel() {

    private val initialState = ResponseModel(0, null, null, emptyList())
    private val _response = MutableStateFlow(initialState)
    val response: StateFlow<ResponseModel> = _response

    init {
        viewModelScope.launch {
            val result = pokemonGateway.getPokemons()
            result.onSuccess {
                _response.value = it
            }
            result.onFailure {
                Log.e("ERROR", "Error al consumir servicio")
            }
        }
    }

}