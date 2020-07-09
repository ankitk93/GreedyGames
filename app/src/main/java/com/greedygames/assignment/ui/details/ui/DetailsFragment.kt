package com.greedygames.assignment.ui.details.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.greedygames.assignment.databinding.DetailsFragmentBinding
import com.greedygames.assignment.ui.details.DetailsFragmentViewModel
import com.greedygames.assignment.ui.details.DetailsViewModelFactory
import com.greedygames.assignment.model.ChildrenModel
import com.greedygames.imageloader.ImageLoader

class DetailsFragment(private val children: ChildrenModel) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DetailsFragmentBinding.inflate(inflater)

        val application = requireNotNull(activity).application
        binding.setLifecycleOwner(this)

        val viewModelFactory = DetailsViewModelFactory(children, application)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailsFragmentViewModel::class.java)
        binding.vm = viewModel

        binding.ivBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        ImageLoader.with(application).load(binding.ivImage, children.data.url,null)

        return binding.root
    }
}