package com.greedygames.assignment.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.greedygames.assignment.model.ChildrenModel
import com.greedygames.assignment.model.ImagesModel
import com.greedygames.assignment.network.Retrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * Created by ak93.droid@gmail.com on 08,July,2020
 */

class MainFragmentViewModel() : ViewModel() {

    private val _images = MutableLiveData<ImagesModel>()
    val images: LiveData<ImagesModel>
        get() = _images

    private val _navigateToSelectedImage = MutableLiveData<ChildrenModel>()
    val navigateToSelectedImage: LiveData<ChildrenModel>
        get() = _navigateToSelectedImage

    private val _showLoader = MutableLiveData<Boolean>()
    val showLoader : LiveData<Boolean>
    get() = _showLoader

    fun displayImageDetails(children: ChildrenModel){
        _navigateToSelectedImage.value = children
    }


    //co-routine
    private val viewModelJob = Job()

    //co-routine scope
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun getAllImagesFromApi() {
        _showLoader.value = true
        coroutineScope.launch {
            val getAllImages = Retrofit.apiService.getImages()
            try {
                val imagesResponse = getAllImages.await()
                _images.value =imagesResponse
                _showLoader.value = false
            }catch (exception: Exception){
                _showLoader.value = false
                Log.e("responseFrom:", "${exception.message}")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}