package com.github.lincolnstuart.desafiointegradorapimarvel.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.github.lincolnstuart.desafiointegradorapimarvel.databinding.ActivityComicDetailBinding
import com.github.lincolnstuart.desafiointegradorapimarvel.model.Result
import com.github.lincolnstuart.desafiointegradorapimarvel.util.Constants
import com.github.lincolnstuart.desafiointegradorapimarvel.view.activity.ComicListActivity.Companion.COMIC_KEY

class ComicDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicDetailBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
        initComponents()
    }

    private fun initComponents() {
        val comic = intent.getParcelableExtra<Result>(COMIC_KEY)
        comic?.let {
            bindValues(it)
        }
    }

    private fun bindValues(it: Result ) {
        binding.apply {
            Glide.with(this@ComicDetailActivity)
                .load("${it.thumbnail.path}/${Constants.MarvelApi.IMAGE_PATH}.${it.thumbnail.extension}")
                .into(ivComicDetailComic)
            Glide.with(this@ComicDetailActivity)
                .load("${it.thumbnail.path}/${Constants.MarvelApi.IMAGE_PATH}.${it.thumbnail.extension}")
                .into(ivComicDetailCharacter)
            tvComicDetailDescription.text = it.description ?: ""
            tvComicDetailTitle.text = it.title
        }
    }
}