package com.example.catalog.Fragments.MainActivity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.findFragment
import com.example.catalog.MainActivity
import com.example.catalog.MenuActivity
import com.example.catalog.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {
    private lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        // Inflate the layout for this fragment
        var loginBtn = view.findViewById<AppCompatButton>(R.id.loginBtn)
        val emailTxt : EditText = view.findViewById(R.id.emailTxt)
        val passwordTxt : EditText = view.findViewById(R.id.passwordTxt)

        val email = emailTxt.text.toString()
        val password = passwordTxt.text.toString()

        auth = Firebase.auth

        loginBtn.setOnClickListener {
            auth.signInWithEmailAndPassword(emailTxt.text.toString(),passwordTxt.text.toString()).addOnCompleteListener(MainActivity()){
                if(it.isSuccessful){
                    Toast.makeText(context,"Berhasil login",Toast.LENGTH_SHORT).show()
                    val intent = Intent (activity, MenuActivity::class.java).also{
                        it.putExtra("email",email)
                        it.putExtra("password",password)
                        val user = auth.currentUser
                    }
                    startActivity(intent)
                }else{
                    Toast.makeText(context,"Gagal coy",Toast.LENGTH_SHORT).show()
                }
            }

        }
        return view
    }

}