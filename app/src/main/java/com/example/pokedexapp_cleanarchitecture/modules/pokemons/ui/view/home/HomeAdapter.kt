package com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexapp_cleanarchitecture.R
import com.example.pokedexapp_cleanarchitecture.databinding.ItemPokemonBinding
import com.example.pokedexapp_cleanarchitecture.modules.pokemons.ui.model.Response

class HomeAdapter(private val listener: (id: Int, name: String) -> Unit) :
    PagingDataAdapter<Response.Pokemon, HomeViewHolder>(DIFF_CALLBACK) {

    val items: MutableList<Response.Pokemon> = mutableListOf();

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Response.Pokemon>() {
            override fun areItemsTheSame(oldItem: Response.Pokemon, newItem: Response.Pokemon): Boolean {
                return false
            }

            override fun areContentsTheSame(oldItem: Response.Pokemon, newItem: Response.Pokemon): Boolean {
                return false
            }
        }
    }

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
        binding.pokemon = item
        binding.executePendingBindings()
        itemView.setOnClickListener{
            listener(item.id, item.name)
        }
    }
}

