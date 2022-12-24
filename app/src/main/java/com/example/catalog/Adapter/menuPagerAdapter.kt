package com.example.catalog.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.catalog.Fragments.MenuActivity.CartFragment
import com.example.catalog.Fragments.MenuActivity.HomeFragment
import com.example.catalog.Fragments.MenuActivity.ProfileFragment

class menuPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return HomeFragment()
            1 -> return CartFragment()
            else -> return ProfileFragment()
        }
    }
}