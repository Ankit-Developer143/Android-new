package com.example.videoappfirebase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

class  Adapter(data:ArrayList<Lession>,var context: Context):RecyclerView.Adapter<Adapter.ViewHolder>(){

//constructor
    var data:List<Lession>
    init {
        this.data = data

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.video_item,parent,false)
        return ViewHolder(layout)
    }
    override fun onBindViewHolder(holder:ViewHolder , position: Int) {

        val videoItem = data[position]

        holder.title.text = videoItem.title
        holder.title.text = videoItem.desc
        holder.video.setVideoPath(videoItem.videoUrl)

    }

    override fun getItemCount(): Int {
        return data.size

    }






    class ViewHolder(item:View):RecyclerView.ViewHolder(item){
        var title:TextView
        var desc:TextView
        var video:VideoView

        init {
            title = item.findViewById(R.id.vdo_title)
            desc = item.findViewById(R.id.vdo_desc)
            video = item.findViewById(R.id.lession_video)


        }
    }




}