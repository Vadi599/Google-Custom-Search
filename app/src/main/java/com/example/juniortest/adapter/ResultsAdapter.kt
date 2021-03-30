package com.example.juniortest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.juniortest.R
import com.example.juniortest.model.Results

class ResultsAdapter(var items: List<Results.Item>) :
    RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResultsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_result, parent, false)
        return ResultsViewHolder(
            itemView
        )
    }

    fun setResultsList(items: List<Results.Item>) {
        this.items = items
        notifyDataSetChanged()
    }

    class ResultsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var thumbnail: ImageView = itemView.findViewById<View>(R.id.ivThumbnail) as ImageView
        var link: TextView = itemView.findViewById<View>(R.id.tvLink) as TextView
        var displayLink: TextView = itemView.findViewById<View>(R.id.tvDisplay_link) as TextView
    }

    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        holder.link.text = items[position].link
        holder.displayLink.text = items[position].displayLink
        holder.thumbnail.setImageResource(items[position].)
    }
}