package com.example.color_animation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var main_layout = findViewById<RelativeLayout>(R.id.main_layout)
        var animation = main_layout.background as AnimationDrawable?
        animation?.setEnterFadeDuration(3000)
        animation?.setExitFadeDuration(1000)
        animation?.start()


    }
}