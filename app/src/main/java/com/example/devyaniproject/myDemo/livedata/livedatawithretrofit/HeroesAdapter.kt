package com.example.devyaniproject.myDemo.livedata.livedatawithretrofit


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.devyaniproject.R


class HeroesAdapter(var mCtx: Context, var heroList: List<Hero>) :
    RecyclerView.Adapter<HeroesAdapter.HeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view: View =
            LayoutInflater.from(mCtx).inflate(R.layout.item_heros, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroList[position]
        Glide.with(mCtx)
            .load(hero.imageurl)
            .into(holder.imageView)
        holder.textView.text = hero.name
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    inner class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var textView: TextView

        init {
            imageView = itemView.findViewById<ImageView>(R.id.imageView)
            textView = itemView.findViewById<TextView>(R.id.textView)
        }
    }
}