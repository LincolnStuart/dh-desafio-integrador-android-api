package com.github.lincolnstuart.desafiointegradorapimarvel.model.character

import com.github.lincolnstuart.desafiointegradorapimarvel.util.Constants

data class Thumbnail(
    val extension: String,
    val path: String
) {
    fun fullPath() = "${path}/${Constants.MarvelApi.IMAGE_PATH}.${extension}"
}