package com.example.catalog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.catalog.Adapter.menuPagerAdapter
import com.example.catalog.Models.Cart
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var title = arrayOf("Home","Cart","Profile")
        var viewpager = findViewById<ViewPager2>(R.id.viewPager2)
        var tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewpager.adapter = menuPagerAdapter(supportFragmentManager,lifecycle)

        TabLayoutMediator(tabLayout, viewpager){
            tab, position -> tab.text = title[position]
        }.attach()
    }
}