package com.example.omdbmovie.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.omdbmovie.adapters.MovieAdapter
import com.example.omdbmovie.databinding.FragmentMovieListBinding
import com.example.omdbmovie.viewModels.MainViewModel


class MovieListFragment : Fragment() {

    private lateinit var binding: FragmentMovieListBinding

    private val mainViewModel: MainViewModel by activityViewModels()
    val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMovieListBinding.inflate(layoutInflater, container, false)

        val adapter = MovieAdapter(OnClickListener {
            findNavController().navigate(
                MovieListFragmentDirections.actionMovieDestToMovieDetailDest(
                    it
                )
            )
        })
        binding.movieRecyclerView.adapter = adapter

        mainViewModel.movieList.observe(viewLifecycleOwner, {
            it?.let { adapter.submitList(it) }
        })

        return binding.root
    }

}

class OnClickListener(val clickListener: (imdbId: String) -> Unit) {
    fun onClick(imdbId: String) = clickListener(imdbId)
}