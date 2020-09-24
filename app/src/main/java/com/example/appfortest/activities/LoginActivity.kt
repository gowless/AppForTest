package com.example.appfortest.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.appfortest.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    val TAG: String = "LOG"


    //buttons declare

    //textviews declare

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)
        //instance of auth
        auth = Firebase.auth
        //buttons init
        val loginButton: Button? = findViewById(R.id.button)
        val registerButton: Button? = findViewById(R.id.btnReg)
        //TextViews init
        val emailText: TextInputEditText? = findViewById(R.id.emailText)
        val passwordText: TextInputEditText? = findViewById(R.id.passwordText)



        //login button handle
        loginButton?.setOnClickListener{
            //checking on symbols
            if(emailText?.text.toString() == ""){
                Toast.makeText(baseContext, "Please input valid email!",
                    Toast.LENGTH_SHORT).show()
            } else if(passwordText?.text.toString() == ""){
                Toast.makeText(baseContext, "Please input valid password!",
                    Toast.LENGTH_SHORT).show()
            } else {
                signInUser(emailText?.text.toString(), passwordText?.text.toString())
            }

        }

        //register button handle
        registerButton?.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }




    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null){
            Toast.makeText(this, "You're already logged in!", Toast.LENGTH_LONG).show()
            openMainPage()
        }

    }

    private fun signInUser(email: String, password:String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    openMainPage()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                    // ...
                }

                // ...
            }
    }

    private fun openMainPage(){
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
    }



}