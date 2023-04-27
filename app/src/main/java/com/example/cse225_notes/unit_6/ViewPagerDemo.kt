package com.example.cse225_notes.unit_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.cse225_notes.R
import com.google.android.material.tabs.TabLayout

class ViewPagerDemo : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    var viewPagerAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_demo)

        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tabs)
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        // It is used to join TabLayout with ViewPager.
        tabLayout.setupWithViewPager(viewPager)

    }
}