package com.example.omdbmovie.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, posterUrl: String?) {
    posterUrl?.let {
        Picasso.get().load(posterUrl)
            .into(view)
    }
}