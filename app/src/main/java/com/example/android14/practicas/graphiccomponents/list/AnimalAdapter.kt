package com.example.android14.practicas.graphiccomponents.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ExpandedMenuView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.android14.R
import com.squareup.picasso.Picasso

class AnimalAdapter(val list : List<AnimalEntity>) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>(){

    var onItemSelected : ((AnimalEntity) -> Unit)? = null

    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val ivAnimal = view.findViewById<ImageView>(R.id.ivAnimal)
        val cardAnimal = view.findViewById<CardView>(R.id.cardAnimal)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = view.findViewById<TextView>(R.id.tvDescription)

        fun render(animalEntity: AnimalEntity, onItemSelected:((AnimalEntity) -> Unit)? = null){
            tvTitle.text = animalEntity.name
            tvDescription.text = animalEntity.color
            Picasso.get().load(animalEntity.image)
                .placeholder(R.drawable.img_placeholder)
                .error(R.drawable.outline_delete_24)
                .into(ivAnimal)

            cardAnimal.setOnClickListener {
                onItemSelected?.invoke(animalEntity)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(
        holder: AnimalViewHolder,
        position: Int
    ) {
        holder.render(list[position], onItemSelected)
    }


}