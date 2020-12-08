package com.example.recylerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //create the Adapter (Normal Class)
        //The adapter Needs the ViewHolder (Another Class)
        //Create the Constrator
        //Fetch Layout Inflater
        //Add the Method that we Need
        //finish job inSide our method




        //Create Adapter
        //Create class ViewHolder
        //override onCreateViewHolder
        //override onBindViewHolder
        //getItemCount


        val items = ArrayList<CustomClass>()
        items.add(CustomClass("Android App",R.drawable.word))
        items.add(CustomClass("Android App",R.drawable.word))
        items.add(CustomClass("Android App",R.drawable.word))
        items.add(CustomClass("Android App",R.drawable.word))
        items.add(CustomClass("Android App",R.drawable.word))
        items.add(CustomClass("Android App",R.drawable.word))
        items.add(CustomClass("Android App",R.drawable.word))
        items.add(CustomClass("Android App",R.drawable.word))
        items.add(CustomClass("Android App",R.drawable.word))
        items.add(CustomClass("Android App",R.drawable.word))

        val recycler = findViewById<RecyclerView>(R.id.recycle_data)
        val adapter = RecyclerAdapter(items,applicationContext)

        recycler.layoutManager = GridLayoutManager(applicationContext,3)
        recycler.adapter=adapter





    }
}