package com.github.lincolnstuart.desafiointegradorapimarvel.api

import android.util.Log
import com.github.lincolnstuart.desafiointegradorapimarvel.util.Constants.MarvelApi.BASE_URL
import com.github.lincolnstuart.desafiointegradorapimarvel.util.Constants.MarvelApi.PUBLIC_KEY
import com.github.lincolnstuart.desafiointegradorapimarvel.util.MarvelHashGenerator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiService {

    fun getMarvelApi() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getClient())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private fun getClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(getAuthorizationInterceptor())
        return interceptor.build()
    }

    private fun getAuthorizationInterceptor(): Interceptor {
        return Interceptor { chain ->
            val ts = System.currentTimeMillis().toString()
            val hash = MarvelHashGenerator.get(ts)
            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("ts", ts)
                .addQueryParameter("apiKey", PUBLIC_KEY)
                .addQueryParameter("hash", hash)
                .build()
            Log.i("URL INTERCEPTOR", "getAuthorizationInterceptor: $url")
            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()
            return@Interceptor chain.proceed(request)
        }
    }

}