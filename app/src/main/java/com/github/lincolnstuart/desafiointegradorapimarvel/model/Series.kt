package com.github.lincolnstuart.desafiointegradorapimarvel.model

data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: Int
)