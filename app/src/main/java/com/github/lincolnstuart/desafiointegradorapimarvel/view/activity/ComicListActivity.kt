package com.github.lincolnstuart.desafiointegradorapimarvel.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.github.lincolnstuart.desafiointegradorapimarvel.R
import com.github.lincolnstuart.desafiointegradorapimarvel.databinding.ActivityComicListBinding
import com.github.lincolnstuart.desafiointegradorapimarvel.model.comic.ResponseMarvelApiComics
import com.github.lincolnstuart.desafiointegradorapimarvel.model.comic.Comic
import com.github.lincolnstuart.desafiointegradorapimarvel.view.adapter.ComicListAdapter
import com.github.lincolnstuart.desafiointegradorapimarvel.viewmodel.ComicListViewModel

class ComicListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicListBinding
    private lateinit var viewmodel: ComicListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponents()
    }

    private fun alterFontFamilyActionBar() {
        val view = TextView(this)
        view.text = supportActionBar?.title
        view.typeface = ResourcesCompat.getFont(this, R.font.marvel)
        supportActionBar?.customView = view
    }

    private fun initComponents() {
        alterFontFamilyActionBar()
        viewmodel = ViewModelProvider(this).get(ComicListViewModel::class.java)
        setupObservers()
        viewmodel.getComics()
    }

    private fun setupObservers() {
        viewmodel.resultLiveData.observe(this) {
            it?.let {
                configureAdapter(it)
            }
        }
    }

    private fun configureAdapter(it: ResponseMarvelApiComics) {
        binding.rvComicListItems.apply {
            layoutManager = GridLayoutManager(this@ComicListActivity, 3)
            adapter = ComicListAdapter(it.data.results) {
                onClickComic(it)
            }
        }
    }

    private fun onClickComic(comic: Comic) {
        val intent = Intent(this@ComicListActivity, ComicDetailActivity::class.java)
        intent.putExtra(COMIC_KEY, comic)
        startActivity(intent)
    }

    companion object {
        const val COMIC_KEY = "comic"
    }

}