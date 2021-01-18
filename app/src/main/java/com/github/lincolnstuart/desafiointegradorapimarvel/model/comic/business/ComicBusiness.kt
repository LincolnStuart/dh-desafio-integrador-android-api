package com.github.lincolnstuart.desafiointegradorapimarvel.model.comic.business

import com.github.lincolnstuart.desafiointegradorapimarvel.api.ResponseApi
import com.github.lincolnstuart.desafiointegradorapimarvel.model.comic.repository.ComicRepository

class ComicBusiness {

    private val repo by lazy { ComicRepository() }

    suspend fun getComics() = repo.getComics()

}