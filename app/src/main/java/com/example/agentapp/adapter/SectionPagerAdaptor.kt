package com.example.agentapp.adapter

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.agentapp.fragments.AddDetailRoomFragment
import com.example.agentapp.fragments.AddNewCondoFragment
import com.example.agentapp.fragments.AddRentARoomFragment

class SectionPagerAdaptor(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {AddNewCondoFragment()}
            1 -> {AddDetailRoomFragment()}
            2 -> {AddRentARoomFragment()}
            else -> {throw Resources.NotFoundException("Position Not Found")}
        }
    }
}