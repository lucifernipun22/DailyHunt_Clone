package com.example.dailyhunt_clone.Fragment.ViewPager


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.dailyhunt_clone.Fragment.*


class ViewPagerFragmentAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return ForYouFragment.newInstance()
            1 -> return NewsFragment.newInstance()
            2 -> return CricketLeagueFragment.newInstance()
            3 -> return CoronaVirusFragment.newInstance()
            4 -> return AssemblyElectionFragment.newInstance()
            5 -> return BetwaySportsFragment.newInstance()
            6 -> return FollowingFragment.newInstance()
            7 -> return EntertainmentFragment.newInstance()
            8 -> return BusinessFinanceFragment.newInstance()

        }
        return ForYouFragment.newInstance()
    }

    override fun getCount(): Int {
        return 9
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var tabTitle: String = ""
        when (position) {
            0 -> tabTitle = "For You"
            1 -> tabTitle = "News"
            2 -> tabTitle = "Cricket League"
            3 -> tabTitle = "Coronavirus"
            4 -> tabTitle = "Assembly Elections"
            5 -> tabTitle = "Betway Sports"
            6 -> tabTitle = "Following"
            7 -> tabTitle = "Entertainment"
            8 -> tabTitle = "Business & Finance"
        }
        return tabTitle
    }
}