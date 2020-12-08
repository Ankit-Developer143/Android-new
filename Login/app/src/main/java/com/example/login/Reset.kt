package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth

class Reset : AppCompatActivity() {

    private var user_email:EditText?= null
    private var button_reset:Button? = null
    private var firebase:FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset)

        user_email = findViewById(R.id.user_email_reset)
        button_reset= findViewById(R.id.button_reset)
        firebase = FirebaseAuth.getInstance()

        button_reset?.setOnClickListener {
            ResetPassword()
        }



    }
    private fun ResetPassword(){
        val email = user_email?.text.toString().trim()

        if (TextUtils.isEmpty(email)){
            Toast.makeText(applicationContext,"This Field is Required",Toast.LENGTH_SHORT).show()
        }
        else{
            firebase?.sendPasswordResetEmail(email)?.addOnCompleteListener(object :OnCompleteListener<Void>{
                override fun onComplete(task: Task<Void>) {
                    if(task.isSuccessful){
                        Toast.makeText(applicationContext,"Message Send To your Email id",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        var error = task.exception?.message
                        Toast.makeText(applicationContext,"Error"+error,Toast.LENGTH_SHORT).show()
                    }

                }
            })
        }


    }

    fun Login(view: View) {
        startActivity(Intent(this@Reset,MainActivity::class.java))
    }
}