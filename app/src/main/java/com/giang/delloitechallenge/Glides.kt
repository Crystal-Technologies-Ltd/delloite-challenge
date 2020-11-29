package com.giang.delloitechallenge

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition

object Glides {
  fun addImage(context: Context, imageView: ImageView, imageUrl: String?) {
    Glide
      .with(context)
      .load(imageUrl)
      .into(object : CustomViewTarget<ImageView, Drawable>(imageView) {
        override fun onLoadFailed(errorDrawable: Drawable?) {}

        override fun onResourceCleared(placeholder: Drawable?) {}

        override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
          imageView.setImageDrawable(resource)
        }

      })

  }
}