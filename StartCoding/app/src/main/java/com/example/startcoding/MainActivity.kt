package com.example.startcoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AutoCompleteTextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var user_code:AutoCompleteTextView
    lateinit var  run_btn:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user_code = findViewById(R.id.user_code)
        run_btn  =  findViewById(R.id.run_btn)




        run_btn.setOnClickListener {
         //call the run function
            Run()
        }






    }

    private fun Run(){
        val intent  = Intent(this@MainActivity,code_activity::class.java)

        intent.putExtra("code",user_code.text.toString())

        startActivity(intent)


    }


    //set menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu,menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//all data of menu are automatic store in item
        when (item?.itemId) {
            R.id.run_menu -> {
                Run()
                return true
            }
            R.id.add_html_code -> {
                user_code.setText(
                    "<!DOCTYPE html>\n" +
                            "<html>\n" +
                            "<head>\n" +
                            "<title>Page Title</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "\n" +
                            "<h1>This is a Heading</h1>\n" +
                            "<p>This is a paragraph.</p>\n" +
                            "\n" +
                            "</body>\n" +
                            "</html>"
                )
                return true

            }
            R.id.clear -> {
                user_code.setText(" ")
                return true

            }
            R.id.close -> {
                finish()
                return true


            }




        }



        return super.onOptionsItemSelected(item)
    }


}