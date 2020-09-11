package com.apolis.wenzhao.rxjavamock.helper

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.apolis.wenzhao.rxjavamock.R
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun ImageView.loadImage(image: String){
    Glide.with(this)
            .load(image)
            .placeholder(R.drawable.place_holder)
            .into(this)
}