package com.devfptpoly.admin.kotlinmvvmrecyclerview.data.repositories

import com.devfptpoly.admin.kotlinmvvmrecyclerview.data.network.MoviesApi

class MoviesRepository(
    private val api: MoviesApi
) : SafeApiRequest() {
    suspend fun getMovies() = apiRequest { api.getMovies() }
}