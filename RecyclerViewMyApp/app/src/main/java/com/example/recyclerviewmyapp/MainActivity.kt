package com.example.recyclerviewmyapp

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


        val items= ArrayList<CustomClass>()

        items.add(CustomClass("Ankit",R.drawable.img2))
        items.add(CustomClass("Ramesh",R.drawable.img3))
        items.add(CustomClass("Mahesh",R.drawable.img4))
        items.add(CustomClass("Dinesh",R.drawable.img5))
        items.add(CustomClass("Kuldeep",R.drawable.img6))
        items.add(CustomClass("Ranvijay",R.drawable.img7))
        items.add(CustomClass("Prathamesh Maali",R.drawable.img8))
        items.add(CustomClass("Bablu",R.drawable.img9))
        items.add(CustomClass("Aditya",R.drawable.img10))
        items.add(CustomClass("Ravi",R.drawable.img12))

        val recycler = findViewById<RecyclerView>(R.id.recycler_code)
        val adapter = RecyclerAdapter(items,applicationContext)


        recycler.layoutManager = GridLayoutManager(applicationContext,2)
        recycler.adapter = adapter








    }
}