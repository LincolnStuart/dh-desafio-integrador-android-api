package com.github.lincolnstuart.desafiointegradorapimarvel.model.character.business

import com.github.lincolnstuart.desafiointegradorapimarvel.model.character.repository.CharacterRepository

class CharacterBusiness {

    private val repo by lazy{
        CharacterRepository()
    }

    suspend fun getCharacters(comicId: Int) = repo.getCharacters(comicId)

}