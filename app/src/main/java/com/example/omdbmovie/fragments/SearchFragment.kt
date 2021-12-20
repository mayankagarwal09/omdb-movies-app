package com.example.omdbmovie.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.omdbmovie.databinding.FragmentSearchBinding
import com.example.omdbmovie.viewModels.MainViewModel


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)

        binding.searchBtn.setOnClickListener {
            val search = binding.searchEt.text
            search?.let {
                mainViewModel.loadMovieList(search.toString())
                view?.findNavController()
                    ?.navigate(SearchFragmentDirections.actionSearchFragmentToMovieDest())
            }
        }
        return binding.root
    }

}