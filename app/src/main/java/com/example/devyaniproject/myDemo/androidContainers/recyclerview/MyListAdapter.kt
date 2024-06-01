package com.example.devyaniproject.myDemo.androidContainers.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.devyaniproject.R


class MyListAdapter // RecyclerView recyclerView;
    (private val listdata: Array<MyListData>) : RecyclerView.Adapter<MyListAdapter.ViewHolder>() {

        override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyListAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.list_recycler_item, parent, false)
        return MyListAdapter.ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyListAdapter.ViewHolder, position: Int) {
        val myListData = listdata[position]
        holder.textView.setText(listdata[position].description)
        holder.imageView.setImageResource(listdata[position].imgId)
        holder.relativeLayout.setOnClickListener(View.OnClickListener { view ->
            Toast.makeText(
                view.context,
                "click on item: " + myListData.description,
                Toast.LENGTH_LONG
            ).show()
        })
    }

    override fun getItemCount(): Int {
        return listdata.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: AppCompatImageView
        var textView: AppCompatTextView
        var relativeLayout: RelativeLayout

        init {
            imageView = itemView.findViewById<View>(R.id.imageView) as AppCompatImageView
            textView = itemView.findViewById<View>(R.id.textView) as AppCompatTextView
            relativeLayout = itemView.findViewById<View>(R.id.relativeLayout) as RelativeLayout
        }
    }
}