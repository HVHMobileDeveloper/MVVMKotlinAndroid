package com.devfptpoly.admin.kotlinmvvmrecyclerview.ui.movies

import android.view.View
import com.devfptpoly.admin.kotlinmvvmrecyclerview.data.models.Movie

interface RecyclerViewListenner {
    fun onRecyclerViewItemClick(view: View, movie: Movie)
}