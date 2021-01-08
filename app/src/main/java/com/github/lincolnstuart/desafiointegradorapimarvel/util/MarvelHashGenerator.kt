package com.github.lincolnstuart.desafiointegradorapimarvel.util

import com.github.lincolnstuart.desafiointegradorapimarvel.util.Constants.MarvelApi.PRIVATE_KEY
import com.github.lincolnstuart.desafiointegradorapimarvel.util.Constants.MarvelApi.PUBLIC_KEY
import com.github.lincolnstuart.desafiointegradorapimarvel.util.extension.md5

class MarvelHashGenerator {

    companion object{
        fun get(timestamp: String): String{
            val message = "$timestamp$PRIVATE_KEY$PUBLIC_KEY"
            return message.md5()
        }
    }

}