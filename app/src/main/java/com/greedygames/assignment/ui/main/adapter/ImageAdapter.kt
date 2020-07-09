package com.greedygames.assignment.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.greedygames.assignment.R
import com.greedygames.assignment.databinding.SingleItemBinding
import com.greedygames.assignment.model.ChildrenModel
import com.greedygames.imageloader.ImageLoader

class ImageAdapter(var childItem : List<ChildrenModel>,
                   private val context:Context,
                   private val onClickListener: OnClickListener): RecyclerView.Adapter<ImageAdapter.ImageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val binding = DataBindingUtil.inflate<SingleItemBinding>(LayoutInflater.from(parent.context), R.layout.single_item, parent, false)
        return ImageHolder(binding)
    }

    override fun getItemCount(): Int = childItem.size

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        val children = childItem[position]
        ImageLoader.with(context).load(holder.binding.ivSingleItem, children.data.thumbnail, null)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(children)
        }
    }

    class ImageHolder(val binding: SingleItemBinding): RecyclerView.ViewHolder(binding.root) {
    }

    class OnClickListener(val clickListener: (children: ChildrenModel) -> Unit){
        fun onClick(children: ChildrenModel) = clickListener(children)
    }
}