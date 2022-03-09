package com.example.dv_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(1200)
        setTheme(R.style.Theme_DV_android)
        setContentView(R.layout.activity_main)
    }
}