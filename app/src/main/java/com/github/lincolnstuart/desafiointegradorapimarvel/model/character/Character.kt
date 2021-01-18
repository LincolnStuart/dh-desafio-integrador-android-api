package com.github.lincolnstuart.desafiointegradorapimarvel.model.character

data class Character(
    val description: String,
    val id: Int,
    val modified: String,
    val name: String,
    val thumbnail: Thumbnail
)