package com.example.routetask.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.routetask.R
import com.example.routetask.databinding.PhotoItemBinding

class PhotoAdapter(val photos:List<Photo>):RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {


    class PhotoViewHolder(val binding:PhotoItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(photo:Photo){
            Glide
                .with(binding.root)
                .load(photo.photoUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.ivPhoto)
           }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
            val binding = PhotoItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

            return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
            holder.bind(photos[position])
    }

    override fun getItemCount() = photos.size
}