package com.greedygames.assignment.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImagesModel(@Json(name = "kind") val kind:String,
                       @Json(name = "data")val data: DataModel): Parcelable{}