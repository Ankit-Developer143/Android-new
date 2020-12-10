package com.example.videoappfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

       var lession1 = "https://firebasestorage.googleapis.com/v0/b/videoappfirebase-283eb.appspot.com/o/1.%20Install%20The%20IDE%20for%20Learn%20Kotlin.mp4?alt=media&token=0060b771-9814-4aa0-ba05-711af394517d"

        var items = ArrayList<Lession>()
        items.add(Lession("Android Development","Learn Android From Zero To Hero",lession1))

        val list = findViewById<RecyclerView>(R.id.videos_list)
        val adapter = Adapter(items,applicationContext)
        list.layoutManager = GridLayoutManager(applicationContext,1)
        list.adapter = adapter


    }
}