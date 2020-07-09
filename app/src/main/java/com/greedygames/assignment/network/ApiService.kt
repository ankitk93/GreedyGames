package com.greedygames.assignment.network

import com.greedygames.assignment.model.ImagesModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService{

    @GET("/r/images/hot.json")
    fun getImages(): Deferred<ImagesModel>
}