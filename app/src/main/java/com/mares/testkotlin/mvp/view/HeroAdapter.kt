package com.mares.testkotlin.mvp.view


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.mares.testkotlin.R
import com.mares.testkotlin.mvp.model.SuperHeroe
import com.squareup.picasso.Picasso

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    lateinit var context : Context
    lateinit var models : List<SuperHeroe>
    lateinit var listener: HeroListener

    fun HeroAdapter (listener : HeroListener, models : List<SuperHeroe>, context : Context){
        this.context = context
        this.models = models
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.hero_item, parent, false))
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = models.get(position)
        holder.bind(item, context)
        holder.container.setOnClickListener{ listener.onClick(item) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nameHero =  view.findViewById(R.id.nameHero) as TextView
        val imageHero =  view.findViewById(R.id.imageHero) as ImageView
        val container = view.findViewById(R.id.hero_container) as ConstraintLayout

        fun bind (superhero : SuperHeroe, context : Context){
            nameHero.text = superhero.name
            imageHero.loadUrl(superhero.photo)
        }

        fun ImageView.loadUrl ( url : String){
            Picasso.with(context).load(url).into(this)
        }
    }

    interface HeroListener{
        fun onClick(hero : SuperHeroe)
    }
}