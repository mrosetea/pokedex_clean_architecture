package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexapp_cleanarchitecture.R
import com.example.pokedexapp_cleanarchitecture.databinding.ItemPokemonBinding
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.model.Response
import com.example.pokedexapp_cleanarchitecture.util.loadImage

class HomeAdapter(private val listener: (id: Int, name: String) -> Unit) :
    RecyclerView.Adapter<HomeViewHolder>() {

    val items: MutableList<Response.Pokemon> = mutableListOf();

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        val binding = ItemPokemonBinding.bind(view);
        return HomeViewHolder(binding, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun updateItems(items: List<Response.Pokemon>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}

class HomeViewHolder(
    private val binding: ItemPokemonBinding,
    private val listener: (id: Int, name: String) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Response.Pokemon) {
        binding.pokemonName.text = item.name
        binding.pokemonNumber.text = generatePokemonNumber(item.id)
        binding.pokemonImage.loadImage(generateUrlResource(item.id))
        itemView.setOnClickListener{
            listener(item.id, item.name)
        }
    }

    private fun generateUrlResource(id: Int): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/${id}.png";
    }

    private fun generatePokemonNumber(id: Int): String {
        return "#${id.toString()}";
    }
}