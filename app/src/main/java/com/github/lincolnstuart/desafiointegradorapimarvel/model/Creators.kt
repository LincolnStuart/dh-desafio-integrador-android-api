package com.github.lincolnstuart.desafiointegradorapimarvel.model

data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)