package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.model.Response

class HomePagingSource: PagingSource<Int, Response.Pokemon>() {
    override fun getRefreshKey(state: PagingState<Int, Response.Pokemon>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Response.Pokemon> {
        TODO("Not yet implemented")
    }
}