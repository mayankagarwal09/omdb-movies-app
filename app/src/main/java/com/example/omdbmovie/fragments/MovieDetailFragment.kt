package com.example.omdbmovie.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.omdbmovie.databinding.FragmentMovieDetailBinding
import com.example.omdbmovie.viewModels.MainViewModel

class MovieDetailFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMovieDetailBinding.inflate(layoutInflater, container, false)

        mainViewModel.movieDetails.observe(viewLifecycleOwner, {
            it?.let { binding.movie = it }
        })

        mainViewModel.loadMovieDetails(args.imdbID)

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainViewModel.resetMovieDetail()
    }
}