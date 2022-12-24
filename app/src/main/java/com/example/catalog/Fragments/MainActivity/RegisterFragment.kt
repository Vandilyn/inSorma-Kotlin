package com.example.catalog.Fragments.MainActivity

import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.net.toUri
import com.example.catalog.MainActivity
import com.example.catalog.MenuActivity
import com.example.catalog.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import java.security.AccessController.getContext


class RegisterFragment : Fragment() {

    private lateinit var auth : FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        var registerBtn: AppCompatButton = view.findViewById(R.id.registerBtn)
        var usernameTxt : EditText = view.findViewById(R.id.usernameTxt)
        var passwordTxt : EditText = view.findViewById(R.id.passwordTxt)
        var emailTxt : EditText = view.findViewById(R.id.emailTxt)
        var pictureTxt : EditText = view.findViewById(R.id.pictureTxt)

        auth = Firebase.auth

        registerBtn.setOnClickListener{
            if(usernameTxt.text.toString().isEmpty()){
                usernameTxt.error = "Username tidak boleh kosong!"
                usernameTxt.requestFocus()
                return@setOnClickListener
            }
            if(passwordTxt.text.toString().isEmpty()){
                passwordTxt.error = "Password tidak boleh kosong!"
                passwordTxt.requestFocus()
                return@setOnClickListener
            }
            if(emailTxt.text.toString().isEmpty()){
                emailTxt.error = "Email tidak boleh kosong!"
                emailTxt.requestFocus()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(emailTxt.text.toString(),passwordTxt.text.toString())
                .addOnCompleteListener(MainActivity()){
                task ->
                if(task.isSuccessful){
                    Toast.makeText(activity,"Akun berhasil dibuat silahkan login!",Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser
                    user?.updateProfile(userProfileChangeRequest {
                        if(!pictureTxt.text.toString().isEmpty()){
                            setPhotoUri(pictureTxt.text.toString().toUri())
                        }
                        setDisplayName(usernameTxt.text.toString())
                    })
                }else{
                    Toast.makeText(activity,"Gagal cuy",Toast.LENGTH_SHORT).show()
                }
            }
        }
        return view
    }
}