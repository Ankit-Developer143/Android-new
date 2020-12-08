package com.example.addvideosusinguri

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var videos_url = "https://developers.google.com/training/images/tacoma_narrows.mp4"

        val video_uri = Uri.parse(videos_url)
        var video = findViewById<VideoView>(R.id.video)
        video.setVideoURI(video_uri)
        video.start()

    }
}