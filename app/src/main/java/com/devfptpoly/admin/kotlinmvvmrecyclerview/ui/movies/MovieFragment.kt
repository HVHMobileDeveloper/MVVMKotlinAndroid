package com.devfptpoly.admin.kotlinmvvmrecyclerview.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devfptpoly.admin.kotlinmvvmrecyclerview.R
import com.devfptpoly.admin.kotlinmvvmrecyclerview.data.models.Movie
import com.devfptpoly.admin.kotlinmvvmrecyclerview.data.network.MoviesApi
import com.devfptpoly.admin.kotlinmvvmrecyclerview.data.repositories.MoviesRepository
import kotlinx.android.synthetic.main.movie_fragment.*

class MovieFragment : Fragment(), RecyclerViewListenner {

    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api =
            MoviesApi()
        val repository =
            MoviesRepository(
                api
            )

        factory =
            MoviesViewModelFactory(
                repository
            )
        viewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            recycler_view_movies.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter =
                    MovieAdapter(
                        movies,
                        this
                    )
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, movie: Movie) {
        when (view.id) {
            R.id.itemRoot -> {
                Toast.makeText(requireContext(), "GAU", Toast.LENGTH_LONG).show()
            }
        }
    }
}