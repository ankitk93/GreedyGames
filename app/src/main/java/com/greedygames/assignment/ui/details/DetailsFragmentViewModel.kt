package com.greedygames.assignment.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.greedygames.assignment.model.ChildrenModel

class DetailsFragmentViewModel(children: ChildrenModel, app: Application): AndroidViewModel(app) {

    val _selectedImage = MutableLiveData<ChildrenModel>()
    val selectedImage: LiveData<ChildrenModel>
        get() = _selectedImage

    init {
        _selectedImage.value = children
    }
}