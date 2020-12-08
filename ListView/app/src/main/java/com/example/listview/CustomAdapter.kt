package com.example.listview

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


//ArrayList Hold All The Value of CustomItemClass and its override the ArrayAdapter Method and pass 3 Arguments (context,resource,data)
class CustomAdapter(context:Context,data:ArrayList<CustomItemClass>) :ArrayAdapter<CustomItemClass>(context,0,data){

 //convertView Takes All the Value and Layout
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView = convertView

     //Layout come from custom_list_item and data come from context
        itemView = LayoutInflater.from(context).inflate(R.layout.custom_list_item,parent,false)

     //take care of every item position
        val item = getItem(position)

     //fetching the id
     val title =  itemView!!.findViewById<TextView>(R.id.item_title)

     //in this title = set the item and item store the title value that come from CustomItemClass
        title.text = item!!.title


        val desc = itemView!!.findViewById<TextView>(R.id.item_desc)
        desc.text = item!!.desc

        val image = itemView!!.findViewById<ImageView>(R.id.item_image)
        image.setImageResource(item.image)


        return itemView








    }





}
