package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyCardAdapter(private val commanderlist : ArrayList<commander>) :
    RecyclerView.Adapter<MyCardAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCardAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_item_layout,
            parent, false)
        return MyCardAdapter.MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return commanderlist.size
    }

    override fun onBindViewHolder(holder: MyCardAdapter.MyViewHolder, position: Int) {

        val cItem = commanderlist[position]
        holder.vImage.setImageResource(cItem.img)
        holder.vNama.text = cItem.nama
        holder.vDesc.text = cItem.deskripsi
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val vImage : ShapeableImageView = itemView.findViewById(R.id.imageCard)
        val vNama : TextView = itemView.findViewById(R.id.nameCard)
        val vDesc : TextView = itemView.findViewById(R.id.descCard)

    }

}