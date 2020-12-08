package com.example.fade_in_out

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Imageview = findViewById<ImageView>(R.id.image_view)
        val fade_in = findViewById<Button>(R.id.fade_in)
        val fade_out = findViewById<Button>(R.id.fade_out)


        fade_in.setOnClickListener {


            val animation = AnimationUtils.loadAnimation(this@MainActivity,R.anim.scale)
            Imageview.startAnimation(animation)


        }

        fade_out.setOnClickListener {


            val animation = AnimationUtils.loadAnimation(this@MainActivity,R.anim.alpha)

            Imageview.startAnimation(animation)



        }



    }
}