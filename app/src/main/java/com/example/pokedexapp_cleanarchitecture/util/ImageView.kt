package com.example.pokedexapp_cleanarchitecture.util

import android.widget.ImageView
import com.bumptech.glide.Glide

internal fun ImageView.loadImage(src: String) {
    Glide.with(this).load(src).into(this)
}