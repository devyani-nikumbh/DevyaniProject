package com.example.devyaniproject.myDemo.mvvm.viewmodelwithbaseobservable


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.example.devyaniproject.R
import com.example.devyaniproject.databinding.ActivityViewmodelWithBaseobservableBinding


class ActivityViewModelWithBaseObservable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewModel updates the Model
        // after observing changes in the View

        // model will also update the view
        // via the ViewModel
        val activityMainBinding: ActivityViewmodelWithBaseobservableBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_viewmodel_with_baseobservable
        )
        activityMainBinding.setViewModel(
            AppViewModel()
        )
        activityMainBinding.executePendingBindings()
    }
}


// any change in toastMessage attribute
// defined on the Button with bind prefix
// invokes this method
@BindingAdapter("toastMessage")
fun runMe(view: View, message: String?) {
    if (message != null) Toast
        .makeText(
            view.context, message,
            Toast.LENGTH_SHORT
        )
        .show()
}

