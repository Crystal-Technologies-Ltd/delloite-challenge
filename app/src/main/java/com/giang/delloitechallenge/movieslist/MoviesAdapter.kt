package com.giang.delloitechallenge.movieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.giang.delloitechallenge.R
import com.giang.delloitechallenge.databinding.RcvitemMovieBinding
import com.giang.delloitechallenge.movieslist.dto.Search

class MoviesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
  private var dataList: ArrayList<Search> = arrayListOf()
  private val TYPE_ITEM = 1
  private val TYPE_DECORATE = 2

  inner class DecorateItemVH(itemView: View) : RecyclerView.ViewHolder(itemView) {}

  inner class MovieItemVH(private val binding: RcvitemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindData(item: Search) {
      with(binding) {
        movieData = item
        executePendingBindings()
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return when (viewType) {
      TYPE_ITEM -> MovieItemVH(
        DataBindingUtil.inflate(
          LayoutInflater.from(parent.context),
          R.layout.rcvitem_movie,
          parent,
          false
        )
      )
      else -> return DecorateItemVH(
        LayoutInflater
          .from(parent.context)
          .inflate(R.layout.rcvitem_decorate, parent, false)
      )
    }
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if (getItemViewType(position) == TYPE_ITEM)
      (holder as MovieItemVH).bindData(getItem(position))
  }

  private fun getItem(position: Int): Search = dataList[position]

  override fun getItemCount(): Int = dataList.size

  override fun getItemViewType(position: Int): Int {
    return if (dataList[position].decorateItem == null
      || dataList[position].decorateItem == false
    ) return TYPE_ITEM
    else TYPE_DECORATE
  }

  fun setData(list: ArrayList<Search>) {
    dataList.clear()
    dataList = ArrayList(list).also {
      it.add(
        Search(decorateItem = true)
      )
    }
    notifyDataSetChanged()
  }
}
