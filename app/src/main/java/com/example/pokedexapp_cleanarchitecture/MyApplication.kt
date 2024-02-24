package com.example.pokedexapp_cleanarchitecture

import android.app.Application
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.di.pokemonModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(pokemonModule)
        }
    }

}