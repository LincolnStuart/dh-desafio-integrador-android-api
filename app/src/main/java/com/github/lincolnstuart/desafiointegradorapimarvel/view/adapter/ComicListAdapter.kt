package com.github.lincolnstuart.desafiointegradorapimarvel.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.lincolnstuart.desafiointegradorapimarvel.databinding.ItemComicBinding
import com.github.lincolnstuart.desafiointegradorapimarvel.model.Result
import com.github.lincolnstuart.desafiointegradorapimarvel.util.Constants

class ComicListAdapter(
    private val comics: List<Result>,
    private val onClickComic: (comic: Result) -> Unit
) : RecyclerView.Adapter<ComicListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemComicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(comics[position], onClickComic)
    }

    override fun getItemCount(): Int {
        return comics.size
    }

    class ViewHolder(private val binding: ItemComicBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(comic: Result, onClickComic: (comic: Result) -> Unit) = with(binding) {
            Glide.with(itemView)
                .load("${comic.thumbnail.path}/${Constants.MarvelApi.IMAGE_PATH}.${comic.thumbnail.extension}")
                .into(ivItemComicPoster)
            Log.i("BINDING", "bind: ${comic.thumbnail.path}/${Constants.MarvelApi.IMAGE_PATH}.${comic.thumbnail.extension}")
            tvItemComicSerieNumber.text = comic.id.toString()
            itemView.setOnClickListener {
                onClickComic(comic)
            }
        }
    }
}