package com.example.audio

import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var layout = findViewById<LinearLayout>(R.id.parent_layout)

        var animation = layout.background as AnimationDrawable?
        animation?.setEnterFadeDuration(3000)
        animation?.setExitFadeDuration(1000)
        animation?.start()




    }

    fun play(view: View){
        //include all button inside sound
        val sound  =view as Button
        val mediaPlayer = MediaPlayer.create(this@MainActivity,resources.getIdentifier(sound.tag as String,"raw",packageName))
        mediaPlayer.start()

        if (mediaPlayer.isPlaying){
            sound.setBackgroundColor(Color.RED)

            mediaPlayer.setOnCompletionListener {
                sound.setBackgroundColor(Color.CYAN)
            }


        }


            }



    }




