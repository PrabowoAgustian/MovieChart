package com.moviechart.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.moviechart.R
import com.moviechart.databinding.ActivityHomeBinding
import com.moviechart.profile.ProfileActivity
import com.moviechart.searchresult.SearchResultActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val profPic = activityHomeBinding.toolbarHome.profilePicture
        profPic.setOnClickListener{
            val intent = Intent(this@HomeActivity, ProfileActivity::class.java)
            startActivity(intent)
        }

        val sectionsPagerAdapter = SectionsPagerAdapter(this,supportFragmentManager)
        activityHomeBinding.viewPager.adapter = sectionsPagerAdapter
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager)

        activityHomeBinding.btnSearch.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_search -> {
                val searchText = activityHomeBinding.editTextSearch.text.toString().trim()
                if (searchText == ""){
                    activityHomeBinding.editTextSearch.error = "Field cannot be empty"
                } else {
                    val intent = Intent(this@HomeActivity, SearchResultActivity::class.java)
                    intent.putExtra(SearchResultActivity.EXTRA_SEARCH,searchText)
                    startActivity(intent)
                }
            }
        }
    }
}