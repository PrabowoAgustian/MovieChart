package com.moviechart.searchresult

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.moviechart.databinding.ActivitySearchResultBinding

class SearchResultActivity : AppCompatActivity() {

    private lateinit var searchResultActivity: ActivitySearchResultBinding

    companion object {
        const val EXTRA_SEARCH = "extra_search"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchResultActivity = ActivitySearchResultBinding.inflate(layoutInflater)
        setContentView(searchResultActivity.root)

        val query = intent.getStringExtra(EXTRA_SEARCH).toString()
        val bundle = Bundle()
        bundle.putString(EXTRA_SEARCH,query)


        val sectionsPagerAdapter = SearchSectionsPagerAdapter(this,supportFragmentManager)
        sectionsPagerAdapter.setBundle(bundle)
        searchResultActivity.viewPager.adapter = sectionsPagerAdapter
        searchResultActivity.tabs.setupWithViewPager(searchResultActivity.viewPager)

        searchResultActivity.tvShowingResults.text = "Showing results for \"${query}\""

        searchResultActivity.toolbarSearchResults.backButton.setOnClickListener{
            finish()
        }
    }
}