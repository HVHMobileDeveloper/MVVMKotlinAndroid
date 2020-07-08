package com.devfptpoly.admin.kotlinmvvmrecyclerview.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.devfptpoly.admin.kotlinmvvmrecyclerview.R
import com.devfptpoly.admin.kotlinmvvmrecyclerview.data.models.Movie
import com.devfptpoly.admin.kotlinmvvmrecyclerview.databinding.RecyclerViewMovieBinding

class MovieAdapter(
    private val movies: List<Movie>,
    private val listener: RecyclerViewListenner
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    override fun getItemCount(): Int = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recycler_view_movie,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.recyclerViewMovieBinding.movie = movies[position]
        holder.recyclerViewMovieBinding.itemRoot.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerViewMovieBinding.itemRoot, movies[position])
        }
    }

    inner class MovieViewHolder(
        val recyclerViewMovieBinding: RecyclerViewMovieBinding
    ) : RecyclerView.ViewHolder(recyclerViewMovieBinding.root)


}