package com.github.lincolnstuart.desafiointegradorapimarvel.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.lincolnstuart.desafiointegradorapimarvel.R
import com.github.lincolnstuart.desafiointegradorapimarvel.databinding.ItemComicBinding
import com.github.lincolnstuart.desafiointegradorapimarvel.model.comic.Comic

class ComicListAdapter(
    private val comics: List<Comic>,
    private val onClickComic: (comic: Comic) -> Unit
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
        fun bind(comic: Comic, onClickComic: (comic: Comic) -> Unit) = with(binding) {
            Glide.with(itemView)
                .load(comic.thumbnail.fullPath())
                .into(ivItemComicPoster)
            tvItemComicSerieNumber.text = root.resources.getString(R.string.comic_number_pattern, comic.issueNumber.toString())
            itemView.setOnClickListener {
                onClickComic(comic)
            }
        }
    }
}