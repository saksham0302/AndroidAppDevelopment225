package com.example.cse225_notes.unit_6

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        if (position == 0)
            fragment = ViewPagerFragmentOne()
        else if (position == 1)
            fragment = ViewPagerFragmentTwo()
        else if (position == 2)
            fragment = ViewPagerFragmentThree()
        return fragment!!
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String? = null
        if (position == 0)
            title = "Maldives"
        else if (position == 1)
            title = "Shaningan"
        else if (position == 2)
            title = "Sunset"
        return title
    }
}