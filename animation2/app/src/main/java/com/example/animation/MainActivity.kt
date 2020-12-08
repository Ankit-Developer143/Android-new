package com.example.animation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myImage = findViewById<ImageView>(R.id.image_view)

        var animation  =  myImage.background as AnimationDrawable?
        animation?.setEnterFadeDuration(3000)
        animation?.setExitFadeDuration(1000)
        animation?.start()




    }
}