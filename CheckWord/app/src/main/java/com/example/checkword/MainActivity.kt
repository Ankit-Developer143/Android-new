package com.example.checkword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {

    //Declare Empty Variable
    lateinit var question_word:TextView
    lateinit var right_answer_textview:TextView
    lateinit var user_answer:TextView
    lateinit var check_answer:Button
    lateinit var change_word:Button
    lateinit var show_answer:Button
    lateinit var day:String
    lateinit var random:Random

    internal var Days = arrayOf("Sunday","Monday","Tuesday","Wednesday","Thursday","FriDay","Saturday")







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        question_word = findViewById(R.id.question_word)
        right_answer_textview = findViewById(R.id.right_answer)
        user_answer = findViewById(R.id.user_answer)
        change_word = findViewById(R.id.change_word)
        check_answer = findViewById(R.id.check_answer)
        show_answer = findViewById(R.id.show_answer)
        random = Random()



        }
    private fun PlayQuiz(){
        day = Days[random.nextInt(Days.size)]
        question_word.text = Mixletters(day)



    }



    fun Mixletters(word:String):String{
        val words = Arrays.asList<String>(*word.split("".toRegex()).dropLastWhile( {it.isEmpty() }).toTypedArray())
        var mixes = ""
        for (i in words){
            mixes += i
        }
        return mixes

    }
}