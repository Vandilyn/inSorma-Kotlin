package com.example.catalog.Fragments.MenuActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.catalog.MainActivity
import com.example.catalog.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso

class ProfileFragment : Fragment() {
    private lateinit var auth : FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val username : EditText = view.findViewById(R.id.usernameTxt)
        val logoutBtn : Button = view.findViewById(R.id.LogoutBtn)
        val deleteBtn : Button = view.findViewById(R.id.deleteAccount)
        auth = Firebase.auth
        val image : de.hdodenhof.circleimageview.CircleImageView = view.findViewById(R.id.userImage)
        username.setText(auth.currentUser?.displayName.toString())
        if(!auth.currentUser?.photoUrl.toString().isEmpty()){
            Picasso.get().load(auth.currentUser?.photoUrl).into(image)
        }
        logoutBtn.setOnClickListener{
            auth.signOut()
            startActivity(Intent(context,MainActivity::class.java))
        }

        deleteBtn.setOnClickListener{
            auth.currentUser?.delete()?.addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(context,"Akun berhasil dihapus!",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(context,MainActivity::class.java))
                }
            }
        }
        return view
    }

}