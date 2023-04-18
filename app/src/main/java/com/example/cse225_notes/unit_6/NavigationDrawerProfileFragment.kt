package com.example.cse225_notes.unit_6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cse225_notes.R

class NavigationDrawerProfileFragment : Fragment() {

    lateinit var v: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_navigation_drawer_profile, container, false)
        // Inflate the layout for this fragment
        return v
    }

}