package com.example.agentapp.activities

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.agentapp.R
import com.example.agentapp.adapter.SectionPagerAdaptor
import com.example.agentapp.fragments.ListsOfRentFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_lists_of_rent.*

private lateinit var tabLayout: TabLayout
private lateinit var viewPager: ViewPager2

class AddDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_detail)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = SectionPagerAdaptor(this)
        TabLayoutMediator(tabLayout, viewPager){ tab, index ->
            tab.text = when(index){
                0 -> {"New condo"}
                1 -> {"Detail room"}
                2 -> {"Rent a room"}
                else -> {throw Resources.NotFoundException("Position Not Found")}
            }
        }.attach()


    }
}