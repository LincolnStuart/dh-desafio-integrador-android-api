package com.github.lincolnstuart.desafiointegradorapimarvel.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.github.lincolnstuart.desafiointegradorapimarvel.R
import com.github.lincolnstuart.desafiointegradorapimarvel.databinding.ActivityComicDetailBinding
import com.github.lincolnstuart.desafiointegradorapimarvel.model.comic.Comic
import com.github.lincolnstuart.desafiointegradorapimarvel.view.activity.ComicListActivity.Companion.COMIC_KEY
import com.github.lincolnstuart.desafiointegradorapimarvel.viewmodel.ComicDetailViewModel

class ComicDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicDetailBinding
    private lateinit var viewModel: ComicDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicDetailBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
        initComponents()
    }

    private fun initComponents() {
        viewModel = ViewModelProvider(this).get(ComicDetailViewModel::class.java)
        val comic = intent.getParcelableExtra<Comic>(COMIC_KEY)
        comic?.let {
            setupObservables(it)
            viewModel.getCharacters(it.id)
            bindValues(it)
        }
    }

    private fun setupObservables(comic: Comic) {
        viewModel.resultLiveData.observe(this) {
            val image =
                it.data.results.firstOrNull()?.thumbnail?.fullPath()
                ?: comic.thumbnail.fullPath()
            Glide.with(this@ComicDetailActivity)
                .load(image)
                .into(binding.ivComicDetailCharacter)
        }
    }

    private fun bindValues(it: Comic) {
        binding.apply {
            Glide.with(this@ComicDetailActivity)
                .load(it.thumbnail.fullPath())
                .into(ivComicDetailComic)
            tvComicDetailDescription.text = it.description ?: ""
            tvComicDetailTitle.text = it.title
            tvComicDetailReleaseDateData.text = it.dates.firstOrNull()?.formatted() ?: ""
            tvComicDetailPriceData.text =
                getString(R.string.price_pattern, it.prices.firstOrNull()?.price ?: "")
            tvComicDetailPagesData.text = it.pageCount.toString()
        }
    }
}