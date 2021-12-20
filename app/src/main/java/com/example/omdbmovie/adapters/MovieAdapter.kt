package com.example.omdbmovie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.omdbmovie.databinding.MovieItemRowBinding
import com.example.omdbmovie.fragments.OnClickListener
import com.example.omdbmovie.models.Movie

class MovieAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Movie, MovieAdapter.MovieViewHolder>(MovieDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(item.imdbID)
        }
        holder.bind(item)
    }


    class MovieViewHolder private constructor(private val binding: MovieItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movie = movie
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MovieViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MovieItemRowBinding.inflate(layoutInflater, parent, false)
                return MovieViewHolder(binding)
            }
        }
    }
}

class MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldMovie: Movie, newMovie: Movie): Boolean {
        return oldMovie === newMovie
    }

    override fun areContentsTheSame(oldMovie: Movie, newMovie: Movie): Boolean {
        return oldMovie == newMovie
    }

}