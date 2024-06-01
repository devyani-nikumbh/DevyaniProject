/*
package com.example.devyaniproject.myDemo.hiltDI.main.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devyaniproject.R
import com.example.devyaniproject.myDemo.hiltDI.data.model.User
import com.example.devyaniproject.myDemo.hiltDI.main.adapter.MainAdapter
import com.example.devyaniproject.myDemo.hiltDI.main.viewmodel.MainViewModel
import com.example.devyaniproject.myDemo.hiltDI.utils.Status
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ActivityHiltDI : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var adapter: MainAdapter

    private var recyclerView: RecyclerView? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt_di)

        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        progressBar = findViewById<View>(R.id.progressBar) as ProgressBar

        setupUI()
        setupObserver()

    }

    private fun setupUI() {
        recyclerView?.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView?.addItemDecoration(
            DividerItemDecoration(
                recyclerView?.context,
                (recyclerView?.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView?.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.users.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar?.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    recyclerView?.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar?.visibility = View.VISIBLE
                    recyclerView?.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar?.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }
}*/
