package com.example.videos

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView

class single_video : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_video)


        var pause_btn = findViewById<Button>(R.id.pause_btn)
        var play_btn = findViewById<Button>(R.id.play_btn)

        var single_videos =findViewById<VideoView>(R.id.videos_view)


//Path for Videos
        var videos_uri = Uri.parse("android.resource://"+ packageName + "/" + R.raw.vid)

        single_videos.setVideoURI(videos_uri)

        play_btn.setOnClickListener {
            single_videos.start()
        }


        pause_btn.setOnClickListener {
            single_videos.pause()
        }


    }
}