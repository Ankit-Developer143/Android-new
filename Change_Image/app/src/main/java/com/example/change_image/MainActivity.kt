package com.example.change_image

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    var Images = intArrayOf(R.drawable.fox,R.drawable.deer,R.drawable.tiger)

    var index = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//in attribute set onClick
    fun ChangeImage(view: View){

        var image_view = findViewById(R.id.image_view) as ImageView

        image_view.setImageResource(Images[index])
        index ++

        if (index == Images.size){
            index = 0
        }


    }




}