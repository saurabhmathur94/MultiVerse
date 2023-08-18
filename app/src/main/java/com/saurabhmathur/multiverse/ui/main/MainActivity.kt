package com.saurabhmathur.multiverse.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.saurabhmathur.multiverse.data.model.Character
import com.saurabhmathur.multiverse.databinding.ActivityMainBinding
import com.saurabhmathur.multiverse.ui.base.BaseActivity
import com.saurabhmathur.multiverse.ui.details.CharacterDetailActivity
import com.saurabhmathur.multiverse.utils.State
import com.saurabhmathur.multiverse.utils.showToast
import com.saurabhmathur.multiverse.utils.viewModelOf
import kotlinx.android.synthetic.main.activity_character_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<CharacterViewModel, ActivityMainBinding>(),
    CharacterListAdapter.OnItemClickListener {

    private val mAdapter: CharacterListAdapter by lazy { CharacterListAdapter(onItemClickListener = this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)
        setupObserver()
    }

    override fun setupView(savedInstanceState: Bundle?) {
        // Initialize RecyclerView
        mViewBinding.charactersRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }
    }

    private fun getCharacters() {
        mViewModel.fetchCharacters()
    }

    private fun initCharacters() {
        mViewModel.getCharacters().observe(this) { state ->
            when (state) {
                is State.Loading -> showLoading(true)
                is State.Success -> {
                    if (state.data.isNotEmpty()) {
                        mAdapter.submitList(state.data.toMutableList())
                        showLoading(false)
                    }
                }
                is State.Error -> {
                    showToast(state.message)
                    println(state.message)
                    showLoading(false)
                }
            }

        }
    }

    private fun setupObserver() {
        initCharacters()

        mViewBinding.swipeRefreshLayout.setOnRefreshListener {
            getCharacters()
        }

        if(mViewModel.getCharacters().value !is State.Success) {
            getCharacters()
        }
    }

    private fun showLoading(isLoading: Boolean) {
        mViewBinding.swipeRefreshLayout.isRefreshing = isLoading
    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun getViewModel() = viewModelOf<CharacterViewModel>(mViewModelProvider)

    override fun onItemClicked(character: Character, imageView: ImageView) {
        val intent = Intent(this, CharacterDetailActivity::class.java)
        intent.putExtra("characterId",character.id)

        val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this,
            imageView,
            imageView.transitionName
        )

        startActivity(intent, optionsCompat.toBundle())

    }
}