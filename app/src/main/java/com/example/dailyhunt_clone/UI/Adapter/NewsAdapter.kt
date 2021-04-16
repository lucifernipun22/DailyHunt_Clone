package com.example.dailyhunt_clone.UI.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyhunt_clone.Data.NewsResponseDTO
import com.example.dailyhunt_clone.R
import com.example.dailyhunt_clone.UI.ViewHolder.NewsViewHolder

class NewsAdapter (private var responseList : List<NewsResponseDTO>) : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        val data = responseList[position]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    fun updateData(responseList: List<NewsResponseDTO> ){
        this.responseList = responseList
        notifyDataSetChanged()
    }
}