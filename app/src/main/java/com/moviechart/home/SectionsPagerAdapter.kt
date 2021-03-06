package com.moviechart.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.moviechart.R
import com.moviechart.movies.MoviesFragment
import com.moviechart.tvshow.TvShowFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager):FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies,R.string.tv_shows)
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> MoviesFragment()
            1 -> TvShowFragment()
            else -> Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLES[position])
    }


}
