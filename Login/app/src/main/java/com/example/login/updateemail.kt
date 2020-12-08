package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class updateemail : AppCompatActivity() {

    var user_email:EditText? = null
    var password:EditText?= null
    var new_email:EditText? = null
    var update_btn:Button? = null
    var firebaseauth:FirebaseAuth? = null
    var user:FirebaseUser? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updateemail)

        user_email = findViewById(R.id.oldemail)
        password= findViewById(R.id.password)
        new_email = findViewById(R.id.newemail)
        update_btn = findViewById(R.id.update)

        update_btn!!.setOnClickListener {
            UpdateEmail()
        }






    }

    private fun UpdateEmail() {
        var old_email_text = user_email?.text.toString().trim()
        var user_password = password?.text.toString().trim()
        var new_email_text = new_email?.text.toString().trim()
        if (TextUtils.isEmpty(old_email_text)) {
            Toast.makeText(applicationContext, "This field is Required", Toast.LENGTH_SHORT).show()
        } else if (TextUtils.isEmpty(user_password)) {
            Toast.makeText(applicationContext, "This Field is Required", Toast.LENGTH_SHORT).show()

        } else {

            //Update Email

            var userInfo = EmailAuthProvider.getCredential(old_email_text, user_password)

            user?.reauthenticate(userInfo)
                ?.addOnCompleteListener(object : OnCompleteListener<Void> {
                    override fun onComplete(p0: Task<Void>) {
                        user!!.updateEmail(new_email_text)
                            .addOnCompleteListener(object : OnCompleteListener<Void> {
                                override fun onComplete(task: Task<Void>) {

                                    if (task.isSuccessful) {
                                        Toast.makeText(
                                            applicationContext,
                                            "Email Sussefully Changed..",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        var error = task.exception?.message
                                        Toast.makeText(
                                            applicationContext,
                                            "Error:" + error,
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }

                                }

                            })
                    }

                })

        }
    }
}