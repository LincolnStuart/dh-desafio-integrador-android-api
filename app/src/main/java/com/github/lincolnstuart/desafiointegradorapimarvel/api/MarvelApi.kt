package com.github.lincolnstuart.desafiointegradorapimarvel.api

import com.github.lincolnstuart.desafiointegradorapimarvel.model.character.ResponseMarvelApiCharacters
import com.github.lincolnstuart.desafiointegradorapimarvel.model.comic.ResponseMarvelApiComics
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


interface MarvelApi {

    @GET("comics")
    suspend fun comics(@Query("orderBy") orderBy: String = "-modified"): Response<ResponseMarvelApiComics>

    @GET("comics/{comicId}/characters")
    suspend fun characters(@Path("comicId") comicId: Int): Response<ResponseMarvelApiCharacters>
}