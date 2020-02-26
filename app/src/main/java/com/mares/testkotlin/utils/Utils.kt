package com.mares.testkotlin.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class Utils {

    companion object {
        @BindingAdapter("app:urlImage")
        @JvmStatic
        fun loadImage(view : ImageView, url : String){
            Picasso.with(view.context).load(url).into(view)
        }
    }

}