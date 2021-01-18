package com.github.lincolnstuart.desafiointegradorapimarvel.model.character

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Character>,
    val total: Int
)