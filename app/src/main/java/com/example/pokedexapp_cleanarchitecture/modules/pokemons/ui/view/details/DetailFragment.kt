package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokedexapp_cleanarchitecture.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentDetailBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemonId = arguments?.getInt("id")
        val bundle = Bundle().apply {
            putInt("id", pokemonId ?: 0)
        }
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val detailImageFragment = DetailImageFragment()
        detailImageFragment.arguments = bundle
        fragmentTransaction.replace(binding.detailImageFragment.id, detailImageFragment)
        fragmentTransaction.commit()
    }
}