package com.example.camera

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val capture_btn = findViewById<Button>(R.id.btn_click)

        capture_btn.setOnClickListener {

            //Capture Images
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,111)
        }
    }
//All image Store in data
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    if(requestCode == 111){
        val image = data!!.extras?.get("data") as Bitmap

        val image_view = findViewById<ImageView>(R.id.img)
        image_view.setImageBitmap(image)

    }

    }
}