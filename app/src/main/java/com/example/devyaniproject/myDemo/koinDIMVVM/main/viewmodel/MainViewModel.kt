package com.example.devyaniproject.myDemo.koinDIMVVM.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devyaniproject.myDemo.koinDIMVVM.data.model.User
import com.example.devyaniproject.myDemo.koinDIMVVM.data.repository.MainRepository
import com.example.devyaniproject.myDemo.koinDIMVVM.utils.NetworkHelper
import com.example.devyaniproject.myDemo.koinDIMVVM.utils.Resource
import kotlinx.coroutines.launch


public class MainViewModel(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _users = MutableLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>>
        get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.success(it.body()))
                    } else _users.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _users.postValue(Resource.error("No internet connection", null))
        }
    }
}