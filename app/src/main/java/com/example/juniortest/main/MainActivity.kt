package com.example.juniortest.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.juniortest.R
import com.example.juniortest.databinding.ActivityMainBinding
import com.example.juniortest.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.layoutToolbar.toolbar
        val fragment = SearchFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, fragment)
        transaction.commit()
    }
}

