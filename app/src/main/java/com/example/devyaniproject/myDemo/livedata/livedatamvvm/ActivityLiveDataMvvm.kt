package com.example.devyaniproject.myDemo.livedata.livedatamvvm


import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.devyaniproject.R
import com.example.devyaniproject.databinding.ActivityLivedataMvvmBinding
import com.example.devyaniproject.myDemo.livedata.simplelivedata.ViewModelLiveData
import java.util.Objects
import javax.annotation.Nullable


class ActivityLiveDataMvvm : AppCompatActivity() {

    private var loginViewModel: LoginViewModel? = null

    private var binding: ActivityLivedataMvvmBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding = DataBindingUtil.setContentView(this, R.layout.activity_livedata_mvvm)
        binding?.lifecycleOwner = this
        binding?.setLoginViewModel(loginViewModel)

        loginViewModel?.user?.observe(
            this
        ) { loginUser ->
            binding?.lblEmailAnswer?.text = loginUser?.strEmailAddress
            binding?.lblPasswordAnswer?.text = loginUser?.strPassword
        }
    }
}