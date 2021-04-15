package com.example.dailyhunt_clone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class IntroductionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)
        val btn = findViewById<Button>(R.id.button_get_started)
        btn.setOnClickListener {
            val intent = Intent(this,ActivityUserRegister::class.java)
            startActivity(intent)
        }
    }
}