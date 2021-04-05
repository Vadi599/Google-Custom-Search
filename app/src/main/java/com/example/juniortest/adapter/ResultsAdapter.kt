package com.example.juniortest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.juniortest.R
import com.example.juniortest.model.Results

class ResultsAdapter(private var resultsList: List<Results.Item>) :
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

    fun getResultsList(): List<Results.Item> {
        return resultsList
    }

    fun setResultsList(resultsList: List<Results.Item>) {
        this.resultsList = resultsList
        notifyDataSetChanged()
    }

    class ResultsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbnail: ImageView = itemView.findViewById<View>(R.id.ivThumbnail) as ImageView
        var link: TextView = itemView.findViewById<View>(R.id.tvLink) as TextView
        var displayLink: TextView = itemView.findViewById<View>(R.id.tvDisplay_link) as TextView
    }

    override fun getItemCount(): Int {
        return resultsList.size
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        val resultsOfSearch=getResultsList()[position]
        holder.displayLink.text = resultsOfSearch.displayLink
        holder.link.text = resultsOfSearch.link
        /* holder.thumbnail.setImageResource(items[position].pagemap.cseThumbnail[0].src.toInt())*/
        Glide.with(holder.itemView.context).load(resultsOfSearch.pagemap.cseThumbnail[0].src)
            .into(holder.thumbnail)
    }
}