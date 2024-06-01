package com.example.devyaniproject.myDemo.livedata.livedatawithretrofit


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devyaniproject.R
import com.example.devyaniproject.myDemo.livedata.livedatamvvm.LoginViewModel
import javax.annotation.Nullable


class ActivityLiveDataWithRetrofit : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    var adapter: HeroesAdapter? = null

    var heroList: List<Hero>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata_recyclerview)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.setLayoutManager(LinearLayoutManager(this))


        val model: HeroesViewModel = ViewModelProvider(this)[HeroesViewModel::class.java]

        model.heroes.observe(this, object : Observer<List<Hero?>?> {
            override fun onChanged(@Nullable heroList: List<Hero?>?) {
                adapter = HeroesAdapter(this@ActivityLiveDataWithRetrofit, heroList as List<Hero>)
                recyclerView?.setAdapter(adapter)
            }
        })

    }

}