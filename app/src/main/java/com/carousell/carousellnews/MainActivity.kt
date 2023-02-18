package com.carousell.carousellnews

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.carousell.carousellnews.databinding.ActivityMainBinding
import com.carousell.news.ui.NewsActivity

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // get the binding for this activity
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, NewsActivity::class.java)
        startActivity(intent)
        finish()
    }
}