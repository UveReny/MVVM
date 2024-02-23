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

  fun bind(item: Item){
    binding.apply {
      titleTextview.text = item.Title
      releaseDateTextview.text = item.Year
      overviewTextview.text = item.Type

      if (item.Poster != "N/A") {
        Picasso.get().load(item.Poster).into(movieImageview)
      }
    }
  }
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
    val item = list[position]
    holder.bind(item)
/*    holder.binding.apply {
      titleTextview.text = item.Title
      releaseDateTextview.text = item.Year
      overviewTextview.text = item.Type

      if (list[position].Poster != "N/A") {
        Picasso.get().load(list[position].Poster).into(movieImageview)
      }
    }*/
  }

  override fun getItemCount(): Int {
    return list.size
  }

  fun getItemAtPosition(pos: Int): Item {
    return list[pos]
  }

}
