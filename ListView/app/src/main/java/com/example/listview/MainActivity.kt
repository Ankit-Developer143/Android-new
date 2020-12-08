package com.example.listview

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



        val items = ArrayList<CustomItemClass>()
        items.add(CustomItemClass("java developer","Learn Java from Scratch",R.drawable.library))
        items.add(CustomItemClass("Android  developer","Learn Androidfrom Scratch",R.drawable.library1))
        items.add(CustomItemClass("Dbms Learner","Learn Dbmsfrom Scratch",R.drawable.library2))
        items.add(CustomItemClass("Javascript Learner","Learn Java from Scratch",R.drawable.library3))



        //send data to CustomAdapter
        val adapter = CustomAdapter(this@MainActivity,items)


        val  list = findViewById<ListView>(R.id.list_view)

        //In list save items
        list.adapter = adapter
           list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
               val alert = Dialog(this@MainActivity)
               alert.setContentView(R.layout.custom_alert)
               val title = alert.findViewById<TextView>(R.id.alert_title)
               val desc = alert.findViewById<TextView>(R.id.alert_desc)
               val image = alert.findViewById<ImageView>(R.id.alert_image)
               val hide = alert.findViewById<Button>(R.id.alert_hide)

               //sync item to  adapter
               val item = adapter.getItem(position)
               title.text = item!!.title
               desc.text=item!!.desc
               image.setImageResource(item.image)
               alert.show()
               hide.setOnClickListener{
                   alert.dismiss()
               }
           }
    }
}