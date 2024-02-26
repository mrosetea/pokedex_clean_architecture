package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.pokedexapp_cleanarchitecture.databinding.FragmentDetailTextBinding
import com.example.pokedexapp_cleanarchitecture.util.loadImage

class DetailTextFragment : Fragment() {
    private lateinit var binding: FragmentDetailTextBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentDetailTextBinding.inflate(layoutInflater)
        arguments?.getString("name").let {
            binding.webview.settings.javaScriptEnabled = true
            binding.webview.webViewClient = WebViewClient()
            binding.webview.loadUrl(generateWebViewUrl(it.orEmpty()))
        }
        return binding.root
    }

    private fun generateWebViewUrl(name: String): String = "https://www.pokemon.com/us/pokedex/${name}"
}