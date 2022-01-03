package com.example.juniortest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.juniortest.R
import com.example.juniortest.databinding.ListItemResultBinding
import com.example.juniortest.glide_module.GlideApp
import com.example.juniortest.model.Item

class ResultsAdapter(private var resultsList: List<Item?>) :
    RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResultsViewHolder {
        val binding =
            ListItemResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultsViewHolder(
            binding
        )
    }

    fun setResultsList(resultsList: List<Item?>) {
        this.resultsList = resultsList
        notifyDataSetChanged()
    }

    class ResultsViewHolder(binding: ListItemResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var thumbnail: ImageView = binding.ivThumbnail
        var link: TextView = binding.tvLink
        var displayLink: TextView = binding.tvDisplayLink
    }

    override fun getItemCount(): Int {
        return resultsList.size
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        holder.displayLink.text = resultsList[position]?.displayLink
        holder.link.text = resultsList[position]?.link
        GlideApp.with(holder.itemView.context)
            .load(resultsList[position]?.pagemap?.cseImage?.get(0)?.src)
            .placeholder(R.drawable.ic_baseline_image_24).into(holder.thumbnail)
    }
}