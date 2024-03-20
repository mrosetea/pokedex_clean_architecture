package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedexapp_cleanarchitecture.R
import com.example.pokedexapp_cleanarchitecture.databinding.FragmentHomeBinding
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.mapper.toUIModel
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.about.About
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private val viewModel: HomeViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        homeAdapter = HomeAdapter { id, name ->
            findNavController().navigate(
                R.id.action_from_home_to_detail,
                bundleOf("id" to id, "name" to name)
            )
        };
        binding.logoContentText.setOnClickListener {
            val intent = Intent(context, About::class.java)
            startActivity(intent)
        }
        binding.customButton.setOnClickListener {
            val intent = Intent(context, About::class.java)
            startActivity(intent)
        }
        binding.recyclerView.adapter = homeAdapter
        viewLifecycleOwner.lifecycleScope.launch {
            with(viewModel) {
                uiStateChange.collect {
                    onUiStateChangeCollected(it)
                }
            }

        }

    }

    private fun onUiStateChangeCollected(uiState: HomeUIStateChange){
        when(uiState) {
            is HomeUIStateChange.AddHomeLoading -> onAddHomeLoadingCollected(uiState)
            is HomeUIStateChange.RemoveHomeLoading -> onRemoveHomeLoadingCollected(uiState)
            is HomeUIStateChange.AddHomePokemonsList -> onAddHomePokemonListCollected(uiState)
            is HomeUIStateChange.AddHomeError -> onAddHomeErrorCollected(uiState)
            else -> {}
        }
    }

    private fun onAddHomeLoadingCollected(uiState: HomeUIStateChange){}
    private fun onRemoveHomeLoadingCollected(uiState: HomeUIStateChange){}
    private fun onAddHomePokemonListCollected(uiState: HomeUIStateChange.AddHomePokemonsList){
        uiState.pokemons.toUIModel().let {
            homeAdapter.updateItems(it.results)
        }
    }
    private fun onAddHomeErrorCollected(uiState: HomeUIStateChange){}


}