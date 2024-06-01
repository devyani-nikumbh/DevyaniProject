package com.example.devyaniproject.myDemo.databinding.bindingwithrecycler

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.devyaniproject.R


@BindingAdapter("load_image")
fun bindImageUrl(view: ImageView, url: String?) {
    val requestOption: RequestOptions = RequestOptions()
        .centerCrop()
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)

    Glide.with(view)
        .load(url)
        .apply(requestOption)
        .into(view)
}

@BindingAdapter("load_fit_center_image")
fun bindFitCenterImageUrl(view: ImageView, url: String?) {
    val requestOption: RequestOptions = RequestOptions()
        .fitCenter()
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)

    Glide.with(view)
        .load(url)
        .apply(requestOption)
        .into(view)
}


@BindingAdapter("strikeThrough")
fun strikeThrough(textView: TextView, strikeThrough: Boolean) {
    if (strikeThrough) {
        textView.paintFlags = textView.paintFlags or STRIKE_THRU_TEXT_FLAG
    } else {
        textView.paintFlags = textView.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
    }
}