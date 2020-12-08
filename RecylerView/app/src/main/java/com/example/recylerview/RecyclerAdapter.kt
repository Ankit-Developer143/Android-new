package com.example.recylerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Array

//1st Steps
class RecyclerAdapter(data:ArrayList<CustomClass>,internal var context: Context):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>( ){


    //3rd Steps
    //Constractor
    internal var data: List<CustomClass>

    init {
        this.data= data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.custom_item_list,parent,false)
        return ViewHolder(layout)

    }
//4th steps
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text =data[position].item_title
        holder.image.setImageResource(data[position].item_image)

    }

    //5th steps Size
    override fun getItemCount(): Int {
        return data.size

    }

//Second Steps
//normal Class hold all The Layout View
    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){


    //variable
        internal var title:TextView
        internal var image:ImageView


        //Initialize the Variable
        //item View Hold The Variable
        init {
            title = itemView.findViewById(R.id.item_title)
            image= itemView.findViewById(R.id.item_image)
        }


    }


}