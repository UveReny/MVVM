package com.example.mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.databinding.ItemListBinding
import com.example.mvvm.model.Item
import com.squareup.picasso.Picasso

class SearchHolder(
  val binding:ItemListBinding
) : RecyclerView.ViewHolder(binding.root) {
}

class SearchAdapter(
  private val list: List<Item>
): RecyclerView.Adapter<SearchHolder>() {

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): SearchHolder {
    val binding = ItemListBinding
      .inflate(LayoutInflater.from(parent.context), parent, false)
    //val searchHolder = SearchHolder(binding)
    return SearchHolder(binding)
  }

  override fun onBindViewHolder(holder: SearchHolder, position: Int) {
    holder.binding.apply {
      titleTextview.text = list[position].Title
      releaseDateTextview.text = list[position].Year
      overviewTextview.text = list[position].Type

      if (list[position].Poster != "N/A") {
        Picasso.get().load(list[position].Poster).into(movieImageview)
      }
    }
  }

  override fun getItemCount(): Int {
    return list.size
  }

  fun getItemAtPosition(pos: Int): Item {
    return list[pos]
  }

}
