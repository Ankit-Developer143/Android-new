package com.example.videoappfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.core.view.View

class Login_activity : AppCompatActivity() {

    private var user_email_editText: EditText? = null
    private  var user_password_editText: EditText?=null
    private var firebaseAuth: FirebaseAuth? = null
    private var login_btn:Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activity)

        user_email_editText = findViewById(R.id.user_email)
        user_password_editText = findViewById(R.id.user_password)
        firebaseAuth = FirebaseAuth.getInstance()
        login_btn = findViewById(R.id.login_btn)

        login_btn?.setOnClickListener {
            Login()
        }

    }

    private fun Login() {
        var email = user_email_editText?.text.toString().trim()
        var password = user_password_editText?.text.toString().trim()

        if (TextUtils.isEmpty(email)){
            Toast.makeText(applicationContext,"Required Text", Toast.LENGTH_SHORT).show()
        }
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(applicationContext,"Required Text", Toast.LENGTH_SHORT).show()

        }
        else{
            firebaseAuth?.signInWithEmailAndPassword(email,password)?.addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                override fun onComplete(task: Task<AuthResult>) {
                    if (task.isSuccessful){
                        Toast.makeText(applicationContext,"Succefully login ..", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        var error = task.exception?.message
                        Toast.makeText(applicationContext,"Error"+error, Toast.LENGTH_SHORT).show()
                    }

                }

            })
        }
    }
    }

