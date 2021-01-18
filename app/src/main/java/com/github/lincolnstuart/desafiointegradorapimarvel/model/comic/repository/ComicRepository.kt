package com.github.lincolnstuart.desafiointegradorapimarvel.model.comic.repository

import com.github.lincolnstuart.desafiointegradorapimarvel.api.ApiService
import com.github.lincolnstuart.desafiointegradorapimarvel.api.ResponseApi
import java.lang.Exception

class ComicRepository {

    suspend fun getComics(): ResponseApi {
        return try {
            val response = ApiService.marvelApi.comics()
            if (response.isSuccessful) {
                ResponseApi.Success(response.body())
            } else {
                ResponseApi.Error(":(")
            }
        } catch (exception: Exception) {
            ResponseApi.Error(":(")
        }
    }
}