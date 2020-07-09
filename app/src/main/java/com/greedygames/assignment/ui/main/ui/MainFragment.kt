package com.greedygames.assignment.ui.main.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.greedygames.assignment.ui.MainActivity
import com.greedygames.assignment.databinding.MainFragmentBinding
import com.greedygames.assignment.ui.details.ui.DetailsFragment
import com.greedygames.assignment.ui.main.MainFragmentViewModel
import com.greedygames.assignment.ui.main.MainFragmentViewModelFactory
import com.greedygames.assignment.ui.main.adapter.ImageAdapter

class MainFragment : Fragment() {
    lateinit var adapter: ImageAdapter

    private val viewModelFactory = MainFragmentViewModelFactory()

    private var viewModel : MainFragmentViewModel ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MainFragmentBinding.inflate(inflater)
        if( viewModel == null ) {
            viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(MainFragmentViewModel::class.java)

            binding.viewModel = viewModel

            viewModel?.getAllImagesFromApi()
            Log.e("mainFragment", "onCreate")
            adapter = ImageAdapter(mutableListOf(), requireContext(), ImageAdapter.OnClickListener {
                viewModel?.displayImageDetails(it)
            })
            binding.rvImages.adapter = adapter

            viewModel?.images?.observe(this, Observer {
                adapter.childItem = it.data.children
                adapter.notifyDataSetChanged()
            })

            viewModel?.navigateToSelectedImage?.observe(this, Observer { childrenModel ->
                activity?.let {
                    (it as MainActivity).fragmentTransaction(DetailsFragment(childrenModel), "")
                }
            })

            viewModel?.showLoader?.observe(this, Observer {
                when(it){
                    true -> binding.progressBar.visibility = View.VISIBLE
                    else -> binding.progressBar.visibility = View.GONE
                }
            })
        }
        return binding.root
    }
}