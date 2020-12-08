package com.example.listview2

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Design The List Item
        //Create a class that need you Want to show
        //Create an Adapter
        //Fill the list view in our Activity



        val items = ArrayList<CustomClass>()
        items.add(CustomClass("java developer","Learn Java from Scratch",R.drawable.library,R.drawable.word))
        items.add(CustomClass("Android  developer","Learn Androidfrom Scratch",R.drawable.library1,R.drawable.word2))
        items.add(CustomClass("Dbms Learner","Learn Dbms from Scratch",R.drawable.library2,R.drawable.bulb))
        items.add(CustomClass("Javascript Learner","Learn Java from Scratch",R.drawable.library3,R.drawable.coffee))
        items.add(CustomClass("Javascript Learner","Learn Mysql from Scratch",R.drawable.coffeeandbook,R.drawable.samsungpd))

        val adapter = ListAdapter(this@MainActivity,items)

        var list = findViewById<ListView>(R.id.list_view)
        list.adapter = adapter

        list.onItemClickListener = AdapterView.OnItemClickListener{
            parent, view, position, id ->
            val alert = Dialog(this@MainActivity)
            alert.setContentView(R.layout.custom_alert)
            val title = alert.findViewById<TextView>(R.id.alert_title)
            val desc = alert.findViewById<TextView>(R.id.alert_desc)
            val image_one = alert.findViewById<ImageView>(R.id.alert_img_one)
            val image_two = alert.findViewById<ImageView>(R.id.alert_img_two)
            val hide = alert.findViewById<Button>(R.id.alert_btn)

            //sync
            val item = adapter.getItem(position)
            title.text= item!!.item_title
            desc.text = item!!.item_desc
            image_one.setImageResource(item.image_one)
            image_two.setImageResource(item.image_two)
            alert.show()
            hide.setOnClickListener{
                alert.dismiss()
            }

        }



    }
}