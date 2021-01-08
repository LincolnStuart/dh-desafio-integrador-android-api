package com.github.lincolnstuart.desafiointegradorapimarvel.model

data class MarvelResponse(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val data: Data,
    val etag: String,
    val status: String
)