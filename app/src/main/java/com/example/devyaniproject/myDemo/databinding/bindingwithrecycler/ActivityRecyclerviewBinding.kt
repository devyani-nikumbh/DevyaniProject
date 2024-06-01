package com.example.devyaniproject.myDemo.databinding.bindingwithrecycler


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.devyaniproject.R
import com.example.devyaniproject.databinding.ActivityRecyclerviewDatabidingBinding


class ActivityRecyclerviewBinding : AppCompatActivity() {
    private var binding: ActivityRecyclerviewDatabidingBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recyclerview_databiding)
        populateData()
    }

    private fun populateData() {
        val dataModelList: MutableList<DataModel> = ArrayList()
        dataModelList.add(DataModel(0,"Android Oreo", "8.1","https://i.imgur.com/DvpvklR.png"))
        dataModelList.add(DataModel(0,"Android Pie", "9.0","https://i.imgur.com/DvpvklR.png"))
        dataModelList.add(DataModel(1,"Android Nougat", "7.0",""))
        dataModelList.add(DataModel(1,"Android Marshmallow", "6.0",""))
        val myRecyclerViewAdapter = MyRecyclerViewAdapter(dataModelList, this)
        binding?.setMyAdapter(myRecyclerViewAdapter)
    }
}