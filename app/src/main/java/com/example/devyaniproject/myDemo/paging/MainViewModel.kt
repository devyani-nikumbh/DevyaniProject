package com.example.devyaniproject.myDemo.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn


class MainViewModel(private val apiService: APIService) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 6)) {
        PostDataSource(apiService)
    }.flow.cachedIn(viewModelScope)
}