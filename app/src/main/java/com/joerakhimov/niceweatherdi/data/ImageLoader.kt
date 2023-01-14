package com.joerakhimov.niceweatherdi.data

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(view: ImageView, url: String?)
}