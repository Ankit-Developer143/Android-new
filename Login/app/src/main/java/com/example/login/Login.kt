package com.example.login

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

class Login : AppCompatActivity() {
    private var login_btn: Button? = null
    private var user_email_editText: EditText? = null
    private var user_password_editText: EditText? = null
    private var signup_btn: Button? = null
    private var firebaseAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login_btn = findViewById(R.id.login_btn)
        signup_btn = findViewById(R.id.signup_btn)

        user_email_editText = findViewById(R.id.user_email)
        user_password_editText = findViewById(R.id.user_password)
        firebaseAuth = FirebaseAuth.getInstance()

        login_btn?.setOnClickListener {
            Login()
        }

    }

    private fun Login() {
        var email = user_email_editText?.text.toString().trim()
        var password = user_password_editText?.text.toString().trim()

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(applicationContext, "this field is Required", Toast.LENGTH_SHORT).show()
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(applicationContext, "This Field is Required", Toast.LENGTH_SHORT).show()
        } else {
            firebaseAuth?.signInWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                    override fun onComplete(task: Task<AuthResult>) = if (task.isSuccessful) {
                        Toast.makeText(
                            applicationContext,
                            "Login Succefully..",
                            Toast.LENGTH_SHORT
                        ).show()



                        //Email Verified
                        var user = firebaseAuth?.currentUser!!

                        if (user.isEmailVerified){
                            Toast.makeText(applicationContext,"You are Logined succefully...",Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(applicationContext,"Account Not Verified...",Toast.LENGTH_SHORT).show()

                        }



                    } else {
                        var error = task.exception?.message
                        Toast.makeText(applicationContext, "Error:" + error, Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}