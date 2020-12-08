package com.example.login

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

class profile_activity : AppCompatActivity() {

    var user_firstName:EditText? = null
    var user_lastName:EditText? = null
    var userName:EditText?= null
    var update_btn:Button? = null
    var firebaseauth:FirebaseAuth? = null
    var firebaseDatabase:DatabaseReference? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_activity)

        user_firstName = findViewById(R.id.user_first_name)
        user_lastName = findViewById(R.id.user_last_name)
        userName = findViewById(R.id.user_username)
        update_btn = findViewById(R.id.userinfo_btn)


        //user for access for current userid
        firebaseauth = FirebaseAuth.getInstance()


        //first create Users and then UserId
        firebaseDatabase = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseauth?.currentUser!!.uid)

        update_btn.setOnClickListener {
            SaveUserInfo()
        }
    }
    private fun SaveUserInfo(){
        var  firstname = user_firstName?.text.toString()
        var lastname=user_lastName?.text.toString()
        var username=userName?.text.toString()
        if (TextUtils.isEmpty(firstname)){
            Toast.makeText(applicationContext,"This field is Required..",Toast.LENGTH_SHORT).show()
        }
        else if (TextUtils.isEmpty(lastname)){
            Toast.makeText(applicationContext,"This field is Required..",Toast.LENGTH_SHORT).show()

        }
        else if (TextUtils.isEmpty(username)){
            Toast.makeText(applicationContext,"This field is Required..",Toast.LENGTH_SHORT).show()
        }
        else{
            val userinfo = HashMap<String,Any>()
            userinfo.put("firstName",firstname)
            userinfo.put("lastName",lastname)
            userinfo.put("userName",username)
            firebaseDatabase?.updateChildren(userinfo)?.addOnCompleteListener(object :OnCompleteListener<Void>{
                override fun onComplete(task: Task<Void>) {

                    if (task.isSuccessful){
                        Toast.makeText(applicationContext,"Save Succefully....",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        var error = task.exception?.message
                        Toast.makeText(applicationContext,"Error:"+error,Toast.LENGTH_SHORT).show()

                    }

                }

            })

        }

    }
}