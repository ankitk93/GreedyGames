package com.greedygames.assignment.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModel(@Json(name = "modhash") val modhash: String?,
                     @Json(name = "dist") val dist: Int,
                     @Json(name = "children") val  children: List<ChildrenModel>,
                     @Json(name = "after") val after: String) : Parcelable{
}