package com.giang.delloitechallenge
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class MarginDecorator(
  var left: Int = 0,
  var right: Int = 0,
  var top: Int = 0,
  var bottom: Int = 0
) : RecyclerView.ItemDecoration() {
  override fun getItemOffsets(
    outRect: Rect,
    view: View,
    parent: RecyclerView,
    state: RecyclerView.State
  ) {
    super.getItemOffsets(outRect, view, parent, state)
    setupRect(outRect)
  }

  private fun setupRect(outRect: Rect) {
    outRect.left = left
    outRect.right = right
    outRect.top = top
    outRect.bottom = bottom
  }
}

