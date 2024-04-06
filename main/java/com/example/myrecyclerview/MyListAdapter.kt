package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyListAdapter(private val commanderlist : ArrayList<commander>) :
        RecyclerView.Adapter<MyListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_layout,
            parent, false)
        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return commanderlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val cItem = commanderlist[position]
        holder.vImage.setImageResource(cItem.img)
        holder.vNama.text = cItem.nama
        holder.vDesc.text = cItem.deskripsi
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val vImage : ShapeableImageView = itemView.findViewById(R.id.image)
        val vNama : TextView = itemView.findViewById(R.id.name)
        val vDesc : TextView = itemView.findViewById(R.id.desc)

    }
}