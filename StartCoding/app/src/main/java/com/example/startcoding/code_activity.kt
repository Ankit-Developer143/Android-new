package com.example.startcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView

class code_activity : AppCompatActivity() {

    lateinit var web_browser:WebView







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_activity)

        web_browser= findViewById(R.id.web_browser)

        intent.getStringExtra("code")?.let { web_browser.loadData(it,"text/html; charset = utf-8",null) }



    }
    //set menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.code_menu,menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//all data of menu are automatic store in item
        when(item?.itemId){
            R.id.enable_id -> {

                web_browser.settings.javaScriptEnabled
                return true
            }



        }



        return super.onOptionsItemSelected(item)
    }

}