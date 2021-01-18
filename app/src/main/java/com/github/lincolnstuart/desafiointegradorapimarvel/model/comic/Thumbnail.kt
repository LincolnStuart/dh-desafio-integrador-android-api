package com.github.lincolnstuart.desafiointegradorapimarvel.model.comic

import android.os.Parcelable
import com.github.lincolnstuart.desafiointegradorapimarvel.util.Constants
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Thumbnail(
    val extension: String,
    val path: String
): Parcelable {
    fun fullPath() = "${path}/${Constants.MarvelApi.IMAGE_PATH}.${extension}"
}