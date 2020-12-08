package com.example.opencontact

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val call = findViewById<ImageView>(R.id.img)
        val btn = findViewById<Button>(R.id.btn_click)
        val msg_btn = findViewById<Button>(R.id.btn_msg)


        btn.setOnClickListener {

            //Add the code for the phone call
            startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel","11111111",null)))


        }

        msg_btn.setOnClickListener {

            //Only Contact One-Way
           // startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("sms:" + 8369562147)))

           var intent =(Intent(Intent.ACTION_VIEW,Uri.parse("sms:" + 8369562147)))
            intent.putExtra("sms_body","Hello")
            startActivity(intent)


        }
        var rate_btn = findViewById<Button>(R.id.rate_btn)

        rate_btn.setOnClickListener {

            try {
                startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("market//details?id=$packageName")))
            }
            catch (error:android.content.ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
            }

        }




    }
}