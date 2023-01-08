package com.example.androidtutorial.roomdb

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun setPaddingLeft(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).into(imageView)
}
