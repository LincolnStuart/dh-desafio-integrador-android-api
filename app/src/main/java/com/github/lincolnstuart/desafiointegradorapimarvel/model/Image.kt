package com.github.lincolnstuart.desafiointegradorapimarvel.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    val extension: String,
    val path: String
): Parcelable