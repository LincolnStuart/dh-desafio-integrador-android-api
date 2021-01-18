package com.github.lincolnstuart.desafiointegradorapimarvel.model.comic

import android.os.Parcelable
import com.github.lincolnstuart.desafiointegradorapimarvel.model.comic.Data
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseMarvelApiComics(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val data: Data,
    val etag: String,
    val status: String
): Parcelable