package com.example.dailyhunt_clone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.ViewPager
import com.example.dailyhunt_clone.Fragment.ViewPager.ViewPagerFragmentAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout
import de.hdodenhof.circleimageview.CircleImageView

class HomeActivity : AppCompatActivity() {
    private lateinit var pagerAdapter: ViewPagerFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homes)
        setViewPagerAdapter()
        val video = findViewById<ImageView>(R.id.gallery)
        video.setOnClickListener {
            val intent = Intent(this, VideoActivity::class.java)
            startActivity(intent)
        }
        initViews()
    }


    private fun initViews() {
        val more = findViewById<ImageView>(R.id.ivSettings)
        more.setOnClickListener {
            moreBottomSheetDialog()
        }
        val createPost = findViewById<CardView>(R.id.createPost)
        createPost.setOnClickListener {
            val intent =Intent(this, CreatePostActivity::class.java)
            startActivity(intent)
        }

        val btn = findViewById<CircleImageView>(R.id.profile_image)
        btn.setOnClickListener {
            val intent = Intent(this, ActivityProfile::class.java)
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


}