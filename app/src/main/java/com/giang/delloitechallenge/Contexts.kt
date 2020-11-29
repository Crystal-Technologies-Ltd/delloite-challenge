package com.giang.delloitechallenge

import android.content.Context
import android.util.DisplayMetrics

fun Context.dpToPixel(dp: Float) =
  dp * (resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)