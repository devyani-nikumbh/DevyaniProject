package com.example.devyaniproject.myDemo.koinDIMVVM.main.view


import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devyaniproject.R
import com.example.devyaniproject.databinding.ActivityHiltDiBinding
import com.example.devyaniproject.myDemo.koinDIMVVM.data.model.User
import com.example.devyaniproject.myDemo.koinDIMVVM.main.adapter.MainAdapter
import com.example.devyaniproject.myDemo.koinDIMVVM.main.viewmodel.MainViewModel
import com.example.devyaniproject.myDemo.koinDIMVVM.utils.Status


class ActivityKoin : AppCompatActivity() {

    val mB by lazy { ActivityHiltDiBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var adapter: MainAdapter

    /* private var recyclerView: RecyclerView? = null
     private var progressBar: ProgressBar? = null
 */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mB.root)

        /*  recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
          progressBar = findViewById<View>(R.id.progressBar) as ProgressBar
  */
        setupUI()
        setupObserver()

    }

    private fun setupUI() {
        mB.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        mB.recyclerView.addItemDecoration(
            DividerItemDecoration(
                mB.recyclerView.context,
                (mB.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        mB.recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.users.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    mB.progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    mB.recyclerView.visibility = View.VISIBLE
                }

                Status.LOADING -> {
                    mB.progressBar.visibility = View.VISIBLE
                    mB.recyclerView.visibility = View.GONE
                }

                Status.ERROR -> {
                    //Handle Error
                    mB.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }
}
