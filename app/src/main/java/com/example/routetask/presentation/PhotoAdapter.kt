package com.example.routetask.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.routetask.R
import com.example.routetask.databinding.PhotoItemBinding
import com.example.routetask.domain.model.Photo

class PhotoAdapter(var photos:Photo):RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {


    class PhotoViewHolder(val binding:PhotoItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(photo:String){
            Glide
                .with(binding.root)
                .load(photo)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.ivPhoto)
           }
    }

    fun setData( photo:Photo){
        photos= photo
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
            val binding = PhotoItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

            return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        photos.photoUrlList?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount() = photos.photoUrlList?.size ?:0
}