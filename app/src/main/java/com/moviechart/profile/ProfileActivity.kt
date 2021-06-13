package com.moviechart.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.moviechart.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        val backButton = binding.toolbarProfile.backButton
        setContentView(binding.root)

        backButton.setOnClickListener{
            finish()
        }

        val sectionsPagerAdapter = FavoriteSectionsPagerAdapter(this,supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabFav.setupWithViewPager(binding.viewPager)
    }
}