package com.github.lincolnstuart.desafiointegradorapimarvel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.github.lincolnstuart.desafiointegradorapimarvel.api.ResponseApi
import com.github.lincolnstuart.desafiointegradorapimarvel.model.character.ResponseMarvelApiCharacters
import com.github.lincolnstuart.desafiointegradorapimarvel.model.character.business.CharacterBusiness
import kotlinx.coroutines.launch

class ComicDetailViewModel : ViewModel() {
    private val business = CharacterBusiness()
    var resultLiveData: MutableLiveData<ResponseMarvelApiCharacters> = MutableLiveData()
    var messageLiveData: MutableLiveData<String> = MutableLiveData()

    fun getCharacters(comicId: Int) {
        viewModelScope.launch {
            when (val response = business.getCharacters(comicId)) {
                is ResponseApi.Success -> {
                    resultLiveData.postValue(response.data as ResponseMarvelApiCharacters)
                }
                is ResponseApi.Error -> {
                    messageLiveData.postValue(response.message)
                }
            }
        }
    }
}