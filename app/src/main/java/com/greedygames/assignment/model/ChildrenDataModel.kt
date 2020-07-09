package com.greedygames.assignment.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ChildrenDataModel(@Json(name = "thumbnail") val thumbnail: String,
                             @Json(name = "url") val url: String): Parcelable{
}