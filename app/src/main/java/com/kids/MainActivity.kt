package com.kids

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.kids.common.base.BaseActivity
import com.kids.common.base.adapter.ViewPagerAdapter
import com.kids.databinding.ActivityMainBinding
import com.kids.ui.bookmark.BookmarkFragment
import com.kids.ui.main.DaycareCenterFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var pagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pagerAdapter = ViewPagerAdapter(
            listOf(DaycareCenterFragment(), BookmarkFragment()), this
        )
        binding.viewpager.offscreenPageLimit = 2
        binding.viewpager.adapter = pagerAdapter
        val tabLayout = binding.tabLayout
        val tabTitleList =
            listOf(getString(R.string.title_daycare_center), getString(R.string.title_bookmark))
        TabLayoutMediator(tabLayout, binding.viewpager) { tab, position ->
            tab.text = tabTitleList[position]
        }.attach()

        binding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 1) {
                    (pagerAdapter.list[1] as BookmarkFragment).initBookmarkList()
                }
            }
        })
    }

}
