package com.github.lincolnstuart.desafiointegradorapimarvel.util

import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class Constants {
    object MarvelApi{
        const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"
        //const val PRIVATE_KEY = "e563b4f746ec60e9b9b97b5cd4d83341849a9850"
        const val PRIVATE_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f"
        //const val PUBLIC_KEY = "ad2817938e3a1987089127bdd96bcb09"
        const val PUBLIC_KEY = "6eb7e8896ec5850c52515a8a23ee97f0"
        const val IMAGE_PATH = "portrait_xlarge"
    }

    object Pattern{
        const val JSON_INPUT_DATE = "yyyy-MM-dd"
        const val OUTPUT_DATE = "MMMM dd, yyyy"
    }
}