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
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private var signup_btn:Button? = null
    private var user_email_editText:EditText? = null
    private  var user_password_editText:EditText?=null
    private var firebaseAuth: FirebaseAuth? = null







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signup_btn = findViewById(R.id.signup_btn)
        user_email_editText = findViewById(R.id.user_email)
        user_password_editText = findViewById(R.id.user_password)
        firebaseAuth = FirebaseAuth.getInstance()

        signup_btn?.setOnClickListener {
            signup()
        }




    }
    private fun signup() {
        var email = user_email_editText?.text.toString().trim()
        var password = user_password_editText?.text.toString().trim()

        if (TextUtils.isEmpty(email)){
            Toast.makeText(applicationContext,"this field is Required",Toast.LENGTH_SHORT).show()
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(applicationContext,"This Field is Required",Toast.LENGTH_SHORT).show()
        }else{
            firebaseAuth?.createUserWithEmailAndPassword(email,password)?.addOnCompleteListener(object : OnCompleteListener<AuthResult>{
                override fun onComplete(task: Task<AuthResult>) {
                    if(task.isSuccessful){
                        Toast.makeText(applicationContext,"Signup Succefully..",Toast.LENGTH_SHORT).show()

                        //Email Verification
                        var user = firebaseAuth!!.currentUser!!

                        user.sendEmailVerification().addOnCompleteListener(object :OnCompleteListener<Void>{
                            override fun onComplete(task: Task<Void>) {
                                if(task.isSuccessful){
                                    Toast.makeText(applicationContext,"Check Your Email",Toast.LENGTH_SHORT).show()
                                }
                                else{
                                    var error = task.exception?.message
                                    Toast.makeText(applicationContext,"Error"+error,Toast.LENGTH_SHORT).show()
                                    startActivity(Intent(this@MainActivity,Login::class.java))
                                }

                            }
                        })

                    }
                    else{
                        var error = task.exception?.message
                        Toast.makeText(applicationContext,"error:"+error,Toast.LENGTH_SHORT).show()
                    }

                }
            })
        }


    }

    //Going To Activity
    fun Login(view: View) {
        startActivity(Intent(this@MainActivity,Login::class.java))
    }

    fun Reset(view: View) {
        startActivity(Intent(this@MainActivity,Reset::class.java))
    }

    fun Redirect_EmptyPage(view: View) {
        startActivity(Intent(this@MainActivity,EmptyActivity::class.java))
    }
}


