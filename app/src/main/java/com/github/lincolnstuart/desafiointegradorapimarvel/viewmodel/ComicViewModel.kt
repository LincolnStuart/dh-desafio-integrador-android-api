package com.github.lincolnstuart.desafiointegradorapimarvel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.lincolnstuart.desafiointegradorapimarvel.api.ResponseApi
import com.github.lincolnstuart.desafiointegradorapimarvel.model.ResponseMarvelApiComics
import com.github.lincolnstuart.desafiointegradorapimarvel.model.business.ComicBusiness
import kotlinx.coroutines.launch
import java.lang.Error

class ComicViewModel : ViewModel() {

    private val business = ComicBusiness()
    var resultLiveData: MutableLiveData<ResponseMarvelApiComics> = MutableLiveData()
    var messageLiveData: MutableLiveData<String> = MutableLiveData()

    fun getComics() {
        viewModelScope.launch {
            when (val response = business.getComics()) {
                is ResponseApi.Success -> {
                    resultLiveData.postValue(response.data as ResponseMarvelApiComics)
                }
                is ResponseApi.Error -> {
                    messageLiveData.postValue(response.message)
                }
            }
        }
    }

}