package com.example.mvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.model.Item
import com.squareup.picasso.Picasso


class SearchHolder(v: View) : RecyclerView.ViewHolder(v) {
  var titleTextView: TextView = v.findViewById(R.id.title_textview)
  var overviewTextView: TextView = v.findViewById(R.id.overview_overview)
  var releaseDateTextView: TextView = v.findViewById(R.id.release_date_textview)
  var imageView: ImageView = v.findViewById(R.id.movie_imageview)
  /*
      init {
        v.setOnClickListener { v: View ->
          listener.onItemClick(v, adapterPosition)
    }
  }*/
}
class SearchAdapter(var list: List<Item>): RecyclerView.Adapter<SearchHolder>() {

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): SearchHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_details, parent, false)
    val viewHolder = SearchHolder(view)
    //view.setOnClickListener { v -> listener.onItemClick(v, viewHolder.adapterPosition) }
    return viewHolder
  }

  override fun onBindViewHolder(holder: SearchHolder, position: Int) {
    holder.titleTextView.text = list[position].Title
    holder.releaseDateTextView.text = list[position].Year
    holder.overviewTextView.text = list[position].Type

    if (list[position].Poster != "N/A") {
      //Picasso.get().load("https://image.tmdb.org/t/p/w500/" + movieList[position].posterPath).into(holder.movieImageView)
      Picasso.get().load(list[position].Poster).into(holder.imageView)
      //https://m.media-amazon.com/images/M/
    }
  }

  override fun getItemCount(): Int {
    return list.size
  }

  fun getItemAtPosition(pos: Int): Item {
    return list[pos]
  }

}
