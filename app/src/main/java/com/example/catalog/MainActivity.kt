package com.example.catalog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.catalog.Adapter.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tabTitle = arrayOf("Login","Register")
        var viewPager = findViewById<ViewPager2>(R.id.viewPager2);
        var tabLayout = findViewById<TabLayout>(R.id.tabLayout);

        auth = FirebaseAuth.getInstance()

        viewPager.adapter = PagerAdapter(supportFragmentManager,lifecycle)

        TabLayoutMediator(tabLayout, viewPager){
            tab, position -> tab.text = tabTitle[position]
        }.attach()
    }
}