package com.github.lincolnstuart.desafiointegradorapimarvel.model.character.repository

import android.util.Log
import com.github.lincolnstuart.desafiointegradorapimarvel.api.ApiService
import com.github.lincolnstuart.desafiointegradorapimarvel.api.ResponseApi

class CharacterRepository {

    suspend fun getCharacters(comicId: Int): ResponseApi {
        return try {
            val response = ApiService.marvelApi.characters(comicId)
            if (response.isSuccessful) {
                ResponseApi.Success(response.body())
            } else {
                ResponseApi.Error(":(")
            }
        } catch (exception: Exception) {
            Log.i("CHARACTERS", "getCharacters: ${exception.toString()}")
            ResponseApi.Error(":(")
        }
    }
}