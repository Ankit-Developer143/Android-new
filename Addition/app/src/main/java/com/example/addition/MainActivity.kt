package com.example.addition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var textview_user = findViewById(R.id.Result)as TextView
        var  user_input1 = findViewById(R.id.input_user1) as EditText
        var  user_input2 = findViewById(R.id.input_user2) as EditText
        var btn_click = findViewById(R.id.btn_click) as Button

        btn_click.setOnClickListener {

            var number =Integer.parseInt(user_input1.text.toString())+Integer.parseInt(user_input2.text.toString())


            textview_user.text = number.toString()



        }



    }
}