package com.example.pokedexapp_cleanarchitecture.util

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
    Log.d("DEBUGGG", url)
    Glide.with(view.context).load(url).into(view)
}