package com.github.lincolnstuart.desafiointegradorapimarvel.model.business

import com.github.lincolnstuart.desafiointegradorapimarvel.api.ResponseApi
import com.github.lincolnstuart.desafiointegradorapimarvel.model.repository.ComicRepository

class ComicBusiness {

    private val repo by lazy { ComicRepository() }

    suspend fun getComics(): ResponseApi {
        return repo.getComics()
    }

}