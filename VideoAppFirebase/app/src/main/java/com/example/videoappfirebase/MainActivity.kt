package com.example.videoappfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun register_btn(view: View) {

        startActivity(Intent(this@MainActivity,Register_activity::class.java))



    }
    fun login_btn(view: View) {
        startActivity(Intent(this@MainActivity,Login_activity::class.java))
    }
    fun jump_btn(view: View) {
        startActivity(Intent(this@MainActivity,DashBoard::class.java))
    }
}