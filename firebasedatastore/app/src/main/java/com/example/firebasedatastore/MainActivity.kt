package com.example.firebasedatastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    var user_firstName:EditText? = null
    var user_lastName:EditText? = null
    var userName:EditText? = null
    var update_btn:Button? = null
    var firebaseAuth:FirebaseAuth? = null
    var firebaseDatabase:DatabaseReference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user_firstName = findViewById(R.id.user_firstname)
        user_lastName = findViewById(R.id.user_lastname)
        userName = findViewById(R.id.user_username)
        update_btn = findViewById(R.id.update)
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseAuth?.currentUser!!.uid)


        update_btn?.setOnClickListener {
            saveUserInfo()
        }

    }

    private fun saveUserInfo() {


        var first_name = user_firstName?.text.toString().trim()
        var last_name = user_lastName?.text.toString().trim()
        var username = userName?.text.toString().trim()



        if (TextUtils.isEmpty(first_name)){
            Toast.makeText(applicationContext,"This field is Required..",Toast.LENGTH_SHORT).show()
        }
        else if (TextUtils.isEmpty(last_name)){
            Toast.makeText(applicationContext,"This field is Required..",Toast.LENGTH_SHORT).show()

        }
        else if (TextUtils.isEmpty(username)){
            Toast.makeText(applicationContext,"This field is Required..",Toast.LENGTH_SHORT).show()
        }
        else{
            val userinfo = HashMap<String,Any>()
            userinfo.put("firstName",first_name)
            userinfo.put("lastName",last_name)
            userinfo.put("userName",username)

            //push
            firebaseDatabase?.updateChildren(userinfo)?.addOnCompleteListener(object :OnCompleteListener<Void>{
                override fun onComplete(task: Task<Void>) {
                    if(task.isSuccessful){
                        Toast.makeText(applicationContext,"Succefully Update..",Toast.LENGTH_SHORT).show()
                    }else{
                        var error = task.exception?.message
                        Toast.makeText(applicationContext,"Error.."+error,Toast.LENGTH_SHORT).show()

                    }

                }

            })
        }


    }
}