package com.example.videos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var list_btn = findViewById<Button>(R.id.list_btn)
        var videos_btn = findViewById<Button>(R.id.videos_btn)

        list_btn.setOnClickListener {

            var intent = Intent(this@MainActivity,vodeos_list::class.java)
            startActivity(intent)

        }

        videos_btn.setOnClickListener {
            var intent = Intent(this@MainActivity,single_video::class.java)
            startActivity(intent)

        }







    }
}