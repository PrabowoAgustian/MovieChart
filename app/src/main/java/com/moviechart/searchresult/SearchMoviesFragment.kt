package com.moviechart.searchresult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.moviechart.databinding.FragmentSearchMoviesBinding
import com.moviechart.viewmodel.ViewModelFactory

class SearchMoviesFragment : Fragment() {

    private lateinit var searchMoviesFragmentBinding: FragmentSearchMoviesBinding
    private var query: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        query = arguments?.getString(SearchResultActivity.EXTRA_SEARCH)
        searchMoviesFragmentBinding = FragmentSearchMoviesBinding.inflate(layoutInflater,container,false)
        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(requireActivity(),factory)[SearchResultViewModel::class.java]
        val rvMovies = searchMoviesFragmentBinding.rvMovies
        rvMovies.layoutManager = LinearLayoutManager(context)
        val listMovieAdapter = ListSearchMoviesAdapter()
        viewModel.getMovies(query!!).observe(this,{movies ->
            listMovieAdapter.setData(movies)
            rvMovies.adapter = listMovieAdapter
            if (movies.isEmpty()){
                searchMoviesFragmentBinding.noResults.visibility = View.VISIBLE
            } else {
                searchMoviesFragmentBinding.noResults.visibility = View.GONE
            }
        })
        viewModel.getStatusMovies().observe(this,{status ->
            if (status){
                searchMoviesFragmentBinding.progressBar.visibility = View.VISIBLE
            } else {
                searchMoviesFragmentBinding.progressBar.visibility = View.GONE
            }
        })
        return searchMoviesFragmentBinding.root
    }

}