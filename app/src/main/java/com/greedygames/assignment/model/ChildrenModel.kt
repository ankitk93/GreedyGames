package com.greedygames.assignment.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChildrenModel(@Json(name = "kind")val kind: String,
                         @Json(name = "data") val data: ChildrenDataModel): Parcelable{
}