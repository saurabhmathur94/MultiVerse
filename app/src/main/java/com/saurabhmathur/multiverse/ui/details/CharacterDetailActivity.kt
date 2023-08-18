package com.saurabhmathur.multiverse.ui.details

import android.os.Bundle
import coil.load
import com.saurabhmathur.multiverse.data.model.Character
import com.saurabhmathur.multiverse.databinding.ActivityCharacterDetailBinding
import com.saurabhmathur.multiverse.ui.base.BaseActivity
import com.saurabhmathur.multiverse.utils.viewModelOf
import kotlinx.android.synthetic.main.activity_character_detail.view.*
import kotlinx.android.synthetic.main.character_item.view.*

class CharacterDetailActivity : BaseActivity<CharacterDetailsViewModel, ActivityCharacterDetailBinding>() {

    private lateinit var character: Character

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)
    }

    override fun getViewBinding(): ActivityCharacterDetailBinding = ActivityCharacterDetailBinding.inflate(layoutInflater)

    override fun getViewModel() = viewModelOf<CharacterDetailsViewModel>(mViewModelProvider)

    override fun setupView(savedInstanceState: Bundle?) {
        val characterId = intent.extras?.getInt("characterId")
            ?: throw IllegalArgumentException("characterId must be non-null")

        initCharacter(characterId)
    }

    private fun initCharacter(characterId: Int) {
        mViewModel.getCharacter(characterId).observe(this) { character ->
            mViewBinding.characterContent.apply {
                this@CharacterDetailActivity.character = character

                println(character)
                character_title.text = character.name
                character_detail_origin.text = character.origin.name
                character_species.text = character.species
            }
            mViewBinding.characterImg.load(character.image)
        }

    }
}