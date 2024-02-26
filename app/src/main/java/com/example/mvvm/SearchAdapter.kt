package com.example.mvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.model.Item
import com.squareup.picasso.Picasso

private const val TAG = "SearchAdapter"
class SearchHolder(v: View) : RecyclerView.ViewHolder(v) {
  var titleTextView: TextView = v.findViewById(R.id.title_textview)
  var overviewTextView: TextView = v.findViewById(R.id.overview_overview)
  var releaseDateTextView: TextView = v.findViewById(R.id.release_date_textview)
  var imageView: ImageView = v.findViewById(R.id.movie_imageview)
}

class SearchAdapter(var list: List<Item>): RecyclerView.Adapter<SearchHolder>() {

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): SearchHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_details, parent, false)
    val viewHolder = SearchHolder(view)
    view.setOnClickListener {
      Toast.makeText(
        parent.context,
        "Click ${viewHolder.releaseDateTextView.text}",
        Toast.LENGTH_LONG)
        .show()
    }
    return viewHolder
  }

  override fun onBindViewHolder(holder: SearchHolder, position: Int) {
    val item = list[position]
    holder.titleTextView.text = item.Title
    holder.releaseDateTextView.text = item.Year
    holder.overviewTextView.text = item.Type

    if (list[position].Poster != "N/A") {
      Picasso.get().load(item.Poster).into(holder.imageView)
    }
  }

  override fun getItemCount(): Int {
    return list.size
  }

  fun getItemAtPosition(pos: Int): Item {
    return list[pos]
  }

}
