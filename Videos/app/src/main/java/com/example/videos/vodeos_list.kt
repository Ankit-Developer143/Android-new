package com.example.videos

import android.app.Dialog
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.VideoView

class vodeos_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vodeos_list)
    }
    fun img_video_check(view:View){

        //all id store in imageView Folder
        val imageView = findViewById<ImageView>(view.id)



        //alert show videos on vodeos_activity page
        val alert = Dialog(this@vodeos_list)

        //alert take a videos from activity_custom_video_alert Page and store in alert
        alert.setContentView(R.layout.activity_custom_video_alert)



        //fetch The id-videos that are available on activity_custom_video_alert
        val videos = alert.findViewById<VideoView>(R.id.video_alert)

        //fetch the button id and store in alert using (.)
        val play= alert.findViewById<Button>(R.id.play)



        val pause = alert.findViewById<Button>(R.id.pause)



        val resume = alert.findViewById<Button>(R.id.resume)


        when(imageView.id){
            R.id.img_one->{
                val video_uri = Uri.parse( "android.resource://" + packageName + "/" + R.raw.vid)
                videos.setVideoURI(video_uri)

                alert.show()

                play.setOnClickListener {
                    videos.start()
                }
                pause.setOnClickListener {
                    videos.pause()
                }
                resume.setOnClickListener {
                    videos.resume()
                }


            }
            R.id.img_two->{
                val video_uri = Uri.parse( "android.resource://" + packageName + "/" + R.raw.mummy)
                videos.setVideoURI(video_uri)
                alert.show()
                play.setOnClickListener {
                    videos.start()
                }
                pause.setOnClickListener {
                    videos.pause()
                }
                resume.setOnClickListener {
                    videos.resume()
                }
            }
            R.id.img_three->{
                val video_uri = Uri.parse( "android.resource://" + packageName + "/" + R.raw.jab)
                videos.setVideoURI(video_uri)
                alert.show()
                play.setOnClickListener {
                    videos.start()
                }
                pause.setOnClickListener {
                    videos.pause()
                }
                resume.setOnClickListener {
                    videos.resume()
                }
            }
            R.id.img_four->{
                val video_uri = Uri.parse( "android.resource://" + packageName + "/" + R.raw.main)
                videos.setVideoURI(video_uri)
                alert.show()
                play.setOnClickListener {
                    videos.start()
                }
                pause.setOnClickListener {
                    videos.pause()
                }
                resume.setOnClickListener {
                    videos.resume()
                }
            }
            R.id.img_five->{
                val video_uri = Uri.parse( "android.resource://" + packageName + "/" + R.raw.tum)
                videos.setVideoURI(video_uri)
                alert.show()
                play.setOnClickListener {
                    videos.start()
                }
                pause.setOnClickListener {
                    videos.pause()
                }
                resume.setOnClickListener {
                    videos.resume()
                }
            }
        }










    }


}