package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedexapp_cleanarchitecture.databinding.FragmentHomeBinding
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.mapper.toUIModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private val viewModel: HomeViewModel by sharedViewModel()
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
        homeAdapter = HomeAdapter();
        binding.recyclerView.adapter = homeAdapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.response.collect {
                it.toUIModel().let {
                    homeAdapter.updateItems(it.results)
                }
            }
        }

    }
}