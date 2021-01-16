package com.github.lincolnstuart.desafiointegradorapimarvel.api

import com.github.lincolnstuart.desafiointegradorapimarvel.model.ResponseMarvelApiComics
import retrofit2.Response
import retrofit2.http.GET


interface MarvelApi {

    @GET("comics")
    suspend fun comics(): Response<ResponseMarvelApiComics>
}