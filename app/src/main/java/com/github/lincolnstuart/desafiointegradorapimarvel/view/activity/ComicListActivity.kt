package com.github.lincolnstuart.desafiointegradorapimarvel.view.activity

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.github.lincolnstuart.desafiointegradorapimarvel.R
import com.github.lincolnstuart.desafiointegradorapimarvel.databinding.ActivityComicListBinding
import com.github.lincolnstuart.desafiointegradorapimarvel.model.ResponseMarvelApiComics
import com.github.lincolnstuart.desafiointegradorapimarvel.view.adapter.ComicListAdapter
import com.github.lincolnstuart.desafiointegradorapimarvel.viewmodel.ComicViewModel

class ComicListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicListBinding
    private lateinit var viewmodel: ComicViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponents()
    }

    private fun alterFontFamilyActionBar() {
        val view = TextView(this)
        view.text = supportActionBar?.title
        view.typeface = ResourcesCompat.getFont(this, R.font.marvel);
        supportActionBar?.customView = view
    }

    private fun initComponents() {
        alterFontFamilyActionBar()
        viewmodel = ViewModelProvider(this).get(ComicViewModel::class.java)
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
                Toast.makeText(this@ComicListActivity, it.title, Toast.LENGTH_LONG).show()
            }
        }
    }
}