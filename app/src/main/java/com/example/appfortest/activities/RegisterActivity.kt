package com.example.appfortest.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.appfortest.R
import com.example.roomapp.data.User
import com.example.roomapp.data.UserViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    val TAG: String = "LOG"
    //buttons init

    private var auth: FirebaseAuth = Firebase.auth

    lateinit var mUserViewModel : UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mUserViewModel = ViewModelProvider(this@RegisterActivity).get(UserViewModel(application)::class.java)
        val phoneText : TextInputEditText = findViewById(R.id.phoneText)


        val passwordText : TextInputEditText = findViewById(R.id.passwordText)
        val emailText : TextInputEditText = findViewById(R.id.emailText)
        val buttonRegister : Button = findViewById(R.id.btnReg)
        buttonRegister.setOnClickListener {
            //val intent = Intent(this,)


            //checking symbols in fields
            if(emailText.text.toString() == ""){
                Toast.makeText(baseContext, "Please input valid email!",
                    Toast.LENGTH_SHORT).show()
            } else if(passwordText.text.toString() == ""){
                Toast.makeText(baseContext, "Please input valid password!",
                    Toast.LENGTH_SHORT).show()
            } else {
                registerUser(emailText.text.toString(), passwordText.text.toString())
            }
        }

    }


    private fun registerUser(email : String, password : String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    insertDataToDatabase()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }

                // ...
            }
    }


    private fun insertDataToDatabase() {
        val password = passwordText.text.toString()
        val email = emailText.text.toString()
        val phone = phoneText.text.toString()

        if(inputCheck(email, password, phone)){
            // Create User Object
            val user = User(
                0,
                email,
                password,
                Integer.parseInt(phone.toString())
            )
            // Add Data to Database
            mUserViewModel.addUser(user)
            Toast.makeText(this, "Successfully added!", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, phone: String): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && phone.isEmpty())
    }

    private fun openMainActivity(){
        val intent = Intent(this@RegisterActivity, RegisterActivity::class.java)
        startActivity(intent)
    }


}