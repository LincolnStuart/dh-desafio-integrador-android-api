package com.github.lincolnstuart.desafiointegradorapimarvel.model.comic

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comic(
    val dates: List<Date>,
    val description: String?,
    val digitalId: Int,
    val ean: String,
    val id: Int,
    val images: List<Image>,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val prices: List<Price>,
    val thumbnail: Thumbnail,
    val title: String,
): Parcelable