package com.carousell.news.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.carousell.common_utils.Utils
import com.carousell.domain.model.NewsArticle
import com.carousell.news.R
import com.carousell.news.databinding.ItemNewsArticleBinding

class NewsAdapter(val callback: AdapterToActivityCallback) : Adapter<NewsAdapter.NewsViewHolder>() {

    private var list = listOf<NewsArticle>()

    fun setData(data: List<NewsArticle>) {
        this.list = data
        notifyItemRangeChanged(0, list.size)
    }

    private lateinit var ctx: Context

    inner class NewsViewHolder(val itemBinding: ItemNewsArticleBinding) :
        ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        ctx = parent.context
        val itemBinder =
            ItemNewsArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(itemBinder)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val data = this.list[position]
        holder.itemBinding.tvTitle.text = data.title
        holder.itemBinding.tvDescription.text = data.description

        holder.itemBinding.tvTime.text = Utils.getTimeAgo(data.time_created?.toLong()!!)

        Glide.with(ctx)
            .load(data.banner_url)
            .fallback(R.drawable.no_image_error)
            .placeholder(R.drawable.no_image_error)
            .centerCrop()
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.itemBinding.ivImage)

        holder.itemView.setOnClickListener {
            callback.onItemClick(data)
        }
    }

    override fun getItemCount(): Int {
        return this.list.size
    }


}