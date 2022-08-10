package com.manorgass.android.android_common_ux

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.manorgass.android.android_common_ux.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val fragmentBank = listOf(
        HomeFragment(),
        FavoriteFragment(),
        MoreFragment()
    )

    private val menuItemIdBank = listOf(
        R.id.home,
        R.id.favorite,
        R.id.more
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        with(binding) {
            pager.initPager()
            bottomNavigationView.initBottomNavigation()
        }
    }

    private fun ViewPager2.initPager() {
        adapter = PagerAdapter(this@MainActivity)
        registerOnPageChangeCallback(PageChangeCallbackExt())
    }

    private fun BottomNavigationView.initBottomNavigation() {
        setOnItemSelectedListener {
            binding.pager.currentItem = menuItemIdBank.indexOf(it.itemId)
            true
        }
    }

    private inner class PagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = fragmentBank.size
        override fun createFragment(position: Int): Fragment = fragmentBank[position]
    }

    private inner class PageChangeCallbackExt : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            binding.bottomNavigationView.menu.getItem(position).isChecked = true
        }
    }
}