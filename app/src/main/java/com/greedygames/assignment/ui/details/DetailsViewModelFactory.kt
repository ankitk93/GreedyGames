package com.greedygames.assignment.ui.details

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.greedygames.assignment.model.ChildrenModel
import java.lang.IllegalArgumentException

class DetailsViewModelFactory(private val children: ChildrenModel,
                              private val app: Application) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsFragmentViewModel::class.java)){
            return DetailsFragmentViewModel(children, app) as T
        }
        throw IllegalArgumentException("Unknown view model class")
    }
}