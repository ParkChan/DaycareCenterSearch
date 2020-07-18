package com.kids

import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.kids.common.ViewPagerAdapter
import com.kids.common.base.BaseActivity
import com.kids.databinding.ActivityMainBinding
import com.kids.ui.bookmark.BookmarkFragment
import com.kids.ui.main.DaycareCenterFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fragmentList = listOf(DaycareCenterFragment(), BookmarkFragment())
        val pagerAdapter = ViewPagerAdapter(fragmentList, this)

        binding.viewpager.offscreenPageLimit = 2
        binding.viewpager.adapter = pagerAdapter
        val tabLayout = binding.tabLayout
        val tabTitleList =
            listOf(getString(R.string.title_daycare_center), getString(R.string.title_bookmark))
        TabLayoutMediator(tabLayout, binding.viewpager) { tab, position ->
            tab.text = tabTitleList[position]
        }.attach()
    }

}
