package com.example.dailyhunt_clone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.example.dailyhunt_clone.Fragment.ViewPager.ViewPagerFragmentAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout

class VideoActivity : AppCompatActivity() {
    private lateinit var pagerAdapter: ViewPagerFragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        setViewPagerAdapter()
        val video = findViewById<ImageView>(R.id.camera)
        video.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        initViews()
    }

    private fun initViews() {
        val more = findViewById<ImageView>(R.id.ivSettings)
        more.setOnClickListener {
            moreBottomSheetDialog()
        }
    }
    private fun moreBottomSheetDialog() {

        val bottomSheetDialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
        val view = LayoutInflater.from(this).inflate(
            R.layout.more_bottom_sheet_layout, findViewById(R.id.llBottomConatainer)
        )
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.setCanceledOnTouchOutside(true)
        bottomSheetDialog.show()
        val Browse = bottomSheetDialog.findViewById<Button>(R.id.browsebtn)
        val discover = bottomSheetDialog.findViewById<Button>(R.id.discoverbtn)

        Browse?.setOnClickListener {
            val intent = Intent(applicationContext, BrowseActivity::class.java)
            startActivity(intent)
        }
        discover?.setOnClickListener {
            val intent = Intent(applicationContext, DiscoveryActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setViewPagerAdapter() {
        pagerAdapter = ViewPagerFragmentAdapter(supportFragmentManager)
        val homeViewPage = findViewById<ViewPager>(R.id.home_viewPager)
        homeViewPage.setAdapter(pagerAdapter)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(homeViewPage)
    }
}