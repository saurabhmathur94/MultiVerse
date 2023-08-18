package com.saurabhmathur.multiverse.ui.main

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.saurabhmathur.multiverse.R
import com.saurabhmathur.multiverse.data.model.Character
import com.saurabhmathur.multiverse.databinding.CharacterItemBinding

class CharacterViewHolder(private val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Character, onItemClickListener: CharacterListAdapter.OnItemClickListener? = null){
        binding.characterName.text = character.name
        binding.characterOrigin.text = character.origin.name
        binding.characterImage.load(character.image) {
            placeholder(R.drawable.ic_photo)
            error(R.drawable.ic_broken_image)
        }

        onItemClickListener?.let { listener ->
            binding.root.setOnClickListener {
                listener.onItemClicked(character, binding.characterImage)
            }
        }
    }



}
