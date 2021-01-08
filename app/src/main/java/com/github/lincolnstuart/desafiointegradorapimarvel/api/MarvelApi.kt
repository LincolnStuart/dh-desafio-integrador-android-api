package com.github.lincolnstuart.desafiointegradorapimarvel.api

import com.github.lincolnstuart.desafiointegradorapimarvel.model.MarvelResponse
import retrofit2.Response
import retrofit2.http.GET


interface MarvelApi {

    @GET("characters")
    suspend fun characters(): Response<MarvelResponse>
}