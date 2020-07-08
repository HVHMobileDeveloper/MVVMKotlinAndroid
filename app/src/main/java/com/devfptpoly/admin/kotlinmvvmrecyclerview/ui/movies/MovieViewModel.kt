package com.devfptpoly.admin.kotlinmvvmrecyclerview.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devfptpoly.admin.kotlinmvvmrecyclerview.util.Coroutines
import com.devfptpoly.admin.kotlinmvvmrecyclerview.data.models.Movie
import com.devfptpoly.admin.kotlinmvvmrecyclerview.data.repositories.MoviesRepository
import kotlinx.coroutines.Job

class MovieViewModel(
    private val repository: MoviesRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _movies = MutableLiveData<List<Movie>>()

    val movies: LiveData<List<Movie>>
        get() = _movies

    fun getMovies() {
        job = Coroutines.ioThenMain(
            { repository.getMovies() },
            { _movies.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized){
            job.cancel()
        }
    }
}