package com.example.dailyhunt_clone.UI.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dailyhunt_clone.Data.NewsResponseDTO
import kotlinx.android.synthetic.main.news_item.view.*

class NewsViewHolder (private val view : View) : RecyclerView.ViewHolder(view){

    fun setData(responseDTO: NewsResponseDTO) {
        view.apply {

            tvnewsHeading.text = responseDTO.title;
            Glide.with(view).load(responseDTO.imageurl).into(ivnewsMedia)

        }
    }
}