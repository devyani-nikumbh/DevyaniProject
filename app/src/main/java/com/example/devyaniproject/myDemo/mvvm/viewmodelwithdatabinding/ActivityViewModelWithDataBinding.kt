package com.example.devyaniproject.myDemo.mvvm.viewmodelwithdatabinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.devyaniproject.R
import com.example.devyaniproject.databinding.ActivityViewmodelWithDatabindingBinding

class ActivityViewModelWithDataBinding : AppCompatActivity() {

    lateinit var binding: ActivityViewmodelWithDatabindingBinding
    lateinit var viewModelWithDataBinding: ViewModelWithDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_viewmodel_with_databinding)

        viewModelWithDataBinding = ViewModelWithDataBinding()

        binding.mainViewModel = viewModelWithDataBinding

        binding.lifecycleOwner=this
    }
}