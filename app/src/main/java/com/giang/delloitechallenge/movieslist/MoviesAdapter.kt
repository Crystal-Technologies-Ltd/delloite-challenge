package com.giang.delloitechallenge.movieslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.giang.delloitechallenge.R
import com.giang.delloitechallenge.databinding.RcvitemMovieBinding
import com.giang.delloitechallenge.movieslist.dto.Search

class MoviesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
  private var dataList: ArrayList<Search> = arrayListOf()

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
    return MovieItemVH(
      DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.rcvitem_movie,
        parent,
        false
      )
    )
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    (holder as MovieItemVH).bindData(getItem(position))
  }

  private fun getItem(position: Int): Search = dataList[position]

  override fun getItemCount(): Int = dataList.size

  fun setData(list: ArrayList<Search>) {
    dataList.clear()
    dataList = ArrayList(list)
    notifyDataSetChanged()
  }
}
