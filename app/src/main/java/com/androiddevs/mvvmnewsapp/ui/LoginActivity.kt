package com.androiddevs.mvvmnewsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.androiddevs.mvvmnewsapp.R
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var tvRedirectSignUp: TextView
    lateinit var etEmail: EditText
    private lateinit var etPass: EditText
    lateinit var btnLogin: Button

    // Creating firebaseAuth object
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        // View Binding
        tvRedirectSignUp = findViewById(R.id.Text)
        btnLogin = findViewById(R.id.Tombol)
        etEmail = findViewById(R.id.Name)
        etPass = findViewById(R.id.PW2)


        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            login()
        }

        tvRedirectSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }
    }
    private fun login() {
        val email = etEmail.text.toString()
        val pass = etPass.text.toString()
        // calling signInWithEmailAndPassword(email, pass)
        // function using Firebase auth object
        // On successful response Display a Toast
        if (email.isBlank() || pass.isBlank()) {
            Toast.makeText(this, "Email dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            return
        }

        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(this, "Successfully Log In", Toast.LENGTH_SHORT).show()
                val intent= Intent(this,NewsActivity::class.java)
                startActivity(intent)
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(this, "Log In Failed!", Toast.LENGTH_SHORT).show()
//            Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }
}