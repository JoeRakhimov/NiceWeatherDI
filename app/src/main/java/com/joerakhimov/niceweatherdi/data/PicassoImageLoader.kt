package com.joerakhimov.niceweatherdi.data

import android.widget.ImageView
import com.squareup.picasso.Picasso

class PicassoImageLoader: ImageLoader {
    override fun loadImage(view: ImageView, url: String?) {
        Picasso.get().load(url).into(view)
    }
}