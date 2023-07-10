package com.example.tugas_sesi_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.tugas_sesi_4.fragments.FragmentA
import com.example.tugas_sesi_4.fragments.FragmentB
import com.example.tugas_sesi_4.fragments.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpTabs()
    }

    private fun setUpTabs() {
        val viewPager : ViewPager = findViewById(R.id.viewPagerUser)
        val tabLayoutUser : TabLayout = findViewById(R.id.tabLayoutUser)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentA(), "Peserta A")
        adapter.addFragment(FragmentB(), "Peserta B")
        viewPager.adapter = adapter
        tabLayoutUser.setupWithViewPager(viewPager)
    }
}